<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Basic Index Page</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
            text-align: center;
        }
        nav ul {
            list-style-type: none;
            padding: 0;
            background-color: #333;
            overflow: hidden;
        }
        nav ul li {
            display: inline;
            padding: 10px 20px;
        }
        nav ul li a {
            color: white;
            text-decoration: none;
        }
        header, footer {
            background-color: #333;
            color: white;
            padding: 10px 0;
        }
        section {
            padding: 20px;
        }
        .form-container {
            display: inline-block;
            text-align: left;
            background: #f9f9f9;
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0px 0px 10px rgba(0, 0, 0, 0.1);
        }
        input[type="text"] {
            width: 100%;
            padding: 8px;
            margin: 10px 0;
            border: 1px solid #ccc;
            border-radius: 4px;
        }
        input[type="submit"] {
            width: 100%;
            padding: 10px;
            background: #28a745;
            color: white;
            border: none;
            font-size: 16px;
            border-radius: 4px;
            cursor: pointer;
        }
        input[type="submit"]:hover {
            background: #218838;
        }
    </style>
</head>
<body>
    <header>
        <nav>
            <ul>
                <!-- Add navigation links here if needed -->
            </ul>
        </nav>
    </header>
    
    <main>
        <section id="home">
            <h1>Welcome to My Website</h1>
            
            <div class="form-container">
                <form action="add1">
                    <label for="productname">Enter Product Name:</label>
                    <input type="text" id="productname" name="productname" placeholder="Enter product name" required>
                    
                    <label for="productid">Enter Product Number:</label>
                    <input type="text" id="productid" name="productid" placeholder="Enter product number" required>
                    
                    <label for="md">Enter Manufacturing Date:</label>
                    <input type="text" id="md" name="md" placeholder="Enter manufacturing date" required>
                    
                    <label for="ed">Enter Expiry Date:</label>
                    <input type="text" id="ed" name="ed" placeholder="Enter expiry date" required>
                    
                    <label for="caddress">Enter Company Address:</label>
                    <input type="text" id="caddress" name="caddress" placeholder="Enter the company address" required>
                    
                    <input type="submit" value="Submit">
                </form>
            </div>
        </section>
    </main>

    <footer>
        <p>&copy; 2025 My Website. All rights reserved.</p>
    </footer>
</body>
</html>
