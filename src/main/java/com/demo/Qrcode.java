package com.demo;




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


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;
@Controller
public class  Qrcode{
	
	//blockchainfunctions
	 @GetMapping("send")
	    public RedirectView redirectToFrontend() {
		 
	        return new RedirectView("http://localhost:5173/");
	    }
	
	
	  @RequestMapping("/")
	    public String start() {
	        return "index";  // Fix: Ensure it matches "sign-in.jsp"
	    }

	    @RequestMapping("/Sign_up")
	    public String showSignUpPage() {
	        return "Sign_up";  // Ensure "sign-up.jsp" exists
	    }
	
	    
	    
	    
	
	@RequestMapping("wait")
	public String addCompany(@RequestParam()String  name,@RequestParam() String email,@RequestParam()String password,@RequestParam()String hash)
	{
		System.out.println(name+email+password+hash);
		
		return "about_us";
	
	}
	@RequestMapping("add1")
	public ModelAndView add(@RequestParam("productname") String pname, 
	                        @RequestParam("productid") String pid, 
	                        @RequestParam("md") String md, 
	                        @RequestParam("ed") String ed,@RequestParam("caddress") String companyaddress) throws NoSuchAlgorithmException {

		
		
	String address=	ProductHashExample.generateProductHash(pname, pid, md, ed);
	    String details = "Name: " + pname + "\nProduct ID: " + pid + "\nManufacturing Date: " + md + "\nExpired Date: " + ed+"\n Company address:"+companyaddress;
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
	    mv.addObject("qrCodePath", "images/" + fileName); // Path to access the QR code from JSP
	    return mv;
	}
}
