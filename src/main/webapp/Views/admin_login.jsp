<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Admin Login</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
            text-align: center;
            background-color: #f4f4f4;
        }
        header, footer {
            background-color: #333;
            color: white;
            padding: 15px 0;
        }
        section {
            padding: 20px;
        }
        .form-container {
            display: inline-block;
            text-align: left;
            background: white;
            padding: 25px;
            border-radius: 8px;
            box-shadow: 0px 0px 10px rgba(0, 0, 0, 0.1);
            width: 350px;
        }
        label {
            font-weight: bold;
            display: block;
            margin-top: 10px;
        }
        input[type="email"],
        input[type="password"],
        input[type="text"] {
            width: 100%;
            padding: 10px;
            margin: 5px 0;
            border: 1px solid #ccc;
            border-radius: 4px;
        }
        input[type="submit"] {
            width: 100%;
            padding: 12px;
            background: #28a745;
            color: white;
            border: none;
            font-size: 16px;
            border-radius: 4px;
            cursor: pointer;
            margin-top: 15px;
        }
        input[type="submit"]:hover {
            background: #218838;
        }
    </style>
</head>
<body>
    <header>
        <h2>Admin Login</h2>
    </header>

    <main>
        <section id="admin-login-form">
            <div class="form-container">
                <form action="adminLogin" method="post">
                    
                    <label for="email">Email:</label>
                    <input type="email" id="email" name="email" placeholder="Enter admin email" required>
                    
                    <label for="password">Password:</label>
                    <input type="password" id="password" name="password" placeholder="Enter password" required>

                    <label for="hashaddress">Hash Address:</label>
                    <input type="text" id="hashaddress" name="hashaddress" placeholder="Enter admin hash address" 
                           required pattern="^0x[a-fA-F0-9]{40}$" 
                           title="Enter a valid Ethereum address (starts with 0x and has 40 characters)">
                    
                    <input type="submit" value="Login">
                </form>
            </div>
        </section>
    </main>

    <footer>
        <p>&copy; 2025 My Website. All rights reserved.</p>
    </footer>
</body>
</html>
