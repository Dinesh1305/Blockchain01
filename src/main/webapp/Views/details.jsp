<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Product Details</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            text-align: center;
            margin: 20px;
        }
        .container {
            max-width: 500px;
            margin: auto;
            padding: 20px;
            background: #f9f9f9;
            border-radius: 8px;
            box-shadow: 0px 0px 10px rgba(0, 0, 0, 0.1);
        }
        img {
            width: 250px;
            height: 250px;
            margin-top: 15px;
        }
        .info {
            margin-top: 10px;
            padding: 10px;
            background: #ffffff;
            border-radius: 5px;
            box-shadow: 0px 0px 5px rgba(0, 0, 0, 0.1);
        }
        .info p {
            margin: 5px 0;
            font-size: 16px;
            font-weight: bold;
        }
        .btn {
            display: inline-block;
            margin-top: 20px;
            padding: 12px 20px;
            font-size: 16px;
            font-weight: bold;
            background: #007bff;
            color: white;
            border: none;
            border-radius: 6px;
            cursor: pointer;
            text-decoration: none;
            transition: 0.3s;
        }
        .btn:hover {
            background: #0056b3;
        }
    </style>
</head>
<body>
    <div class="container">
        <h1>Product QR Code</h1>
        <img src="${qrCodePath}" alt="QR Code">
        
        <div class="info">
            <p><strong>Company Address:</strong> ${companyAddress}</p>
            <p><strong>Hash:</strong> ${productHash}</p>
        </div>

        <!-- Add Product Button -->
        <a href="http://localhost:5173/manufacturing" class="btn">Add Product</a>
    </div>
</body>
</html>
