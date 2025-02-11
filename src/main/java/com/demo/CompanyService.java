package com.demo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

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
}
