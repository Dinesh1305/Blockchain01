package com.demo;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.stereotype.Service;

@Service
public class CompanyService {

    private static final String URL = "jdbc:mysql://localhost:3306/company";
    private static final String USER = "root"; // Replace with your MySQL username
    private static final String PASSWORD = "3105"; // Replace with your MySQL password

    public void saveCompany(String name, String email, String password, String hash) {
        String sql = "INSERT INTO companydetails (name, email, password, hash) VALUES (?, ?, ?, ?)";

        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, name);
            pstmt.setString(2, email);
            pstmt.setString(3, password);
            pstmt.setString(4, hash);

            pstmt.executeUpdate();
            System.out.println("Company details saved successfully!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void add(String email) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            // Load MySQL Driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establish Connection
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/company", "root", "3105");

            // Query to check if the email exists
            String query = "SELECT name, email, password, hash FROM companydetails WHERE email = ?";
            stmt = conn.prepareStatement(query);
            stmt.setString(1, email);
            rs = stmt.executeQuery();

            // If the email exists, perform an action
            if (rs.next()) {
                String name = rs.getString("name");
                String userEmail = rs.getString("email");
                String password = rs.getString("password");
                String hash = rs.getString("hash");

                System.out.println("✅ Email found! Company Details:");
                System.out.println("Name: " + name);
                System.out.println("Email: " + userEmail);
                System.out.println("Password: " + password);
                System.out.println("Hash: " + hash);

                // Example Action: Send an email
                CompanyService.add( name,userEmail,password, hash);
            } else {
                System.out.println("❌ No company found with email: " + email);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Close Resources
            try {
                if (rs != null) rs.close();
                if (stmt != null) stmt.close();
                if (conn != null) conn.close();
            } catch (SQLException ignored) {}
        }
    }
    
    public static void add(String name, String email, String password, String hash) {
        String sql = "INSERT INTO blockchain (name, email, password, hash) VALUES (?, ?, ?, ?)";

        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, name);
            pstmt.setString(2, email);
            pstmt.setString(3, password);
            pstmt.setString(4, hash);

            pstmt.executeUpdate();
            System.out.println("Company details saved successfully!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}
