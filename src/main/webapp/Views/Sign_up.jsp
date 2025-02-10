<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Sign Up</title>
    <style>
        * {
            margin: 0;
            padding: 0;
            box-sizing: border-box;
            font-family: Arial, sans-serif;
        }
        body {
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            background: #f4f4f4;
        }
        .container {
            width: 350px;
            padding: 20px;
            background: white;
            border-radius: 8px;
            box-shadow: 0px 0px 10px rgba(0, 0, 0, 0.1);
            text-align: center;
        }
        h2 {
            margin-bottom: 20px;
            color: #333;
        }
        .input-group {
            text-align: left;
            margin-bottom: 15px;
        }
        label {
            display: block;
            font-weight: bold;
            margin-bottom: 5px;
        }
        input {
            width: 100%;
            padding: 10px;
            border: 1px solid #ccc;
            border-radius: 5px;
        }
        button {
            width: 100%;
            padding: 10px;
            border: none;
            background: #28a745;
            color: white;
            font-size: 16px;
            border-radius: 5px;
            cursor: pointer;
            margin-top: 10px;
        }
        button:hover {
            background: #218838;
        }
        .unit-btn {
            display: block;
            width: 100%;
            padding: 10px;
            text-align: center;
            background: #007bff;
            color: white;
            font-size: 16px;
            font-weight: bold;
            border-radius: 5px;
            text-decoration: none;
            margin-top: 10px;
        }
        .unit-btn:hover {
            background: #0056b3;
        }
        p {
            margin-top: 10px;
        }
        a {
            color: #007bff;
            text-decoration: none;
        }
        a:hover {
            text-decoration: underline;
        }
    </style>
</head>
<body>
    <div class="container">
        <h2>Sign Up</h2>
        <form action="wait" method="post">
            <div class="input-group">
                <label for="name">Full Name</label>
                <input type="text" id="name" name="name" placeholder="Enter your company" required>
            </div>
            <div class="input-group">
                <label for="email">Email</label>
                <input type="email" id="email" name="email" placeholder="Enter your company email" required>
            </div>
            <div class="input-group">
                <label for="password">Password</label>
                <input type="password" id="password" name="password" placeholder="Create a password" required>
            </div>
            <div class="input-group">
				<label for="caddress">Enter Company Wallet Address:</label>
									<input type="text" id="caddress" name="caddress" placeholder="Enter your MetaMask address" 
									       required pattern="^0x[a-fA-F0-9]{40}$" title="Enter a valid Ethereum address (starts with 0x and has 40 characters)">
									       
            </div>
            <button type="submit">Sign Up</button>
        </form>

        <!-- Manufacturing Unit Button -->
        <a href="manufacturing_signup" class="unit-btn">Manufacturing Unit Sign-Up</a>

        <p>Already have an account? <a href="/Sign_in">Sign In</a></p>
    </div>
</body>
</html>
