package com.demo;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;
@Controller
public class  Qrcode{
	

    @Autowired
    private CompanyService companyService;
	
	
	//blockchainfunctions
	 @GetMapping("send")
	    public RedirectView redirectToFrontend() {
		 
	        return new RedirectView("http://localhost:5173/");
	    }
	

	    @RequestMapping("check")
	    public ModelAndView check(@RequestParam("email") String email, @RequestParam("password") String password) {
	        ModelAndView mv = new ModelAndView();
	        
	        try {
	            // Database Connection
	            Class.forName("com.mysql.cj.jdbc.Driver");  // Ensure MySQL Driver is loaded
	            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/company", "root", "3105");

	            // Query to check credentials
	            String query = "SELECT * FROM  companydetails  WHERE email = ? AND password = ?";
	            PreparedStatement stmt = con.prepareStatement(query);
	            stmt.setString(1, email);
	            stmt.setString(2, password);
	            ResultSet rs = stmt.executeQuery();

	            if (rs.next()) {
	                // If credentials are correct, redirect to index
	                mv.setViewName("index");
	            } else {
	                // If incorrect, return error message
	                mv.setViewName("sign_in");
	                mv.addObject("message", "Invalid email or password!");
	            }

	            con.close();
	        } catch (Exception e) {
	            e.printStackTrace();
	            mv.setViewName("error");
	            mv.addObject("message", "Database error occurred!");
	        }

	        return mv;
	    }
	  @RequestMapping("/")
	    public String start() {
		  
		 // return "admin_login";
	       return "Sign_up";  // Fix: Ensure it matches "sign-in.jsp"
	    }
	  @PostMapping("/adminLogin")
	  public String adminLogin(@RequestParam String email, 
	                           @RequestParam String password, 
	                           @RequestParam String hashaddress) {
	      System.out.println("Admin Login Attempt: " + email + ", " + hashaddress);
	      System.out.println(password);

	      if (email.equals("dinesh.official1305@gmail.com") && 
	          password.equals("3105") && 
	          hashaddress.equals("0xC9C1a710298ad9f18A56897504faBD6f80EF21bf")) {
	          return "admin_dashboard"; // Ensure admin_dashboard.jsp exists
	      }
	      
	      return "admin_login"; // Redirect to login if credentials are incorrect
	  }


	  @RequestMapping("adminLogin")
	  public String admin()
	  {
		  return "admin_login";
		  
	  }
	  
	  
	  @RequestMapping("admin_login")
	  public String adminside()
	  {
		  return "admin_login";
	  }
	  
	  
	  @RequestMapping("Sign_up")
	    public String sign() {
		  
	        return "Sign_up";  // Fix: Ensure it matches "sign-in.jsp"
	    }
	  

	    @RequestMapping("/Sign_in")
	    public String showSignUpPage() {
	        return "Sign_in";  // Ensure "sign-up.jsp" exists
	    }
	
	    @RequestMapping("manufacturing_signup")
	    public String index()
	    {
	    	return "index";
	    }
	    
	    
	
	    @PostMapping("/wait")
	    public String addCompany(@RequestParam String name, 
	                             @RequestParam String email, 
	                             @RequestParam String password, 
	                             @RequestParam String caddress) {
	        System.out.println("Received: " + name + ", " + email + ", " + password + ", " + caddress);
	        
	        companyService.saveCompany(name, email, password, caddress);
	        return "about_us"; // Ensure about_us.jsp exists
	    }

	@RequestMapping("add1")
	public ModelAndView add(@RequestParam("productname") String pname, 
	                        @RequestParam("productid") String pid, 
	                        @RequestParam("md") String md, 
	                        @RequestParam("ed") String ed,
	                        @RequestParam("caddress") String companyaddress) throws NoSuchAlgorithmException {

	    // Generate hash for the product
	    String address = ProductHashExample.generateProductHash(pname, pid, md, ed);
	    
	    // Combine details for QR Code
	    String details = "Name: " + pname + "\nProduct ID: " + pid + "\nManufacturing Date: " + md + 
	                     "\nExpired Date: " + ed + "\nCompany Address: " + companyaddress + "\nHash: " + address;
	    
	    String fileName = "qrcode.png";
	    String filePath = "src/main/webapp/images/" + fileName; // Ensure this directory exists
	    int width = 300;
	    int height = 300;

	    try {
	        QRCodeWriter qrCodeWriter = new QRCodeWriter();
	        Map<EncodeHintType, Object> hints = new HashMap<>();
	        hints.put(EncodeHintType.CHARACTER_SET, "UTF-8");

	        BitMatrix bitMatrix = qrCodeWriter.encode(details, BarcodeFormat.QR_CODE, width, height, hints);
	        Path path = new File(filePath).toPath();
	        MatrixToImageWriter.writeToPath(bitMatrix, "PNG", path);

	        System.out.println("\nQR Code generated successfully: " + filePath);
	    } catch (WriterException | IOException e) {
	        e.printStackTrace();
	    }

	    ModelAndView mv = new ModelAndView("details");
	    mv.addObject("qrCodePath", "images/" + fileName);  // Path to access the QR code in JSP
	    mv.addObject("companyAddress", companyaddress);  // Pass company address
	    mv.addObject("productHash", address);  // Pass the generated hash
	    return mv;
	}

}
