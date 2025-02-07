package com.demo;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class ProductHashExample {
 

    public static String generateProductHash(String pname, String pid, String md, String ed) throws NoSuchAlgorithmException {
        // Concatenate all fields into a single string
        String productDetails = pname + pid + md + ed;
     System.out.println(productDetails);
        // Get keccak256 (SHA3-256) hash of the product details
        MessageDigest digest = MessageDigest.getInstance("SHA3-256");
        byte[] hashBytes = digest.digest(productDetails.getBytes());

        // Convert byte array to hex string
        StringBuilder hexString = new StringBuilder();
        for (byte b : hashBytes) {
            hexString.append(String.format("%02x", b));
        }
       System.out.println(hexString.toString());
        return hexString.toString();
    }
}
