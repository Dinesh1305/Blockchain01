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
    </style>
</head>
<body>
    <header>
        <nav>
            <ul>
            </ul>
        </nav>
    </header>
    <main>
        <section id="home">
            <h1>Welcome to My Website</h1>
      
            <form action="add1">
                ENTER PRDUCT NAME:<input type="text" name="productname" placeholder="Enter product name"><br>
                ENTER PRODUCT NUMBER:<input type="text"  name="productid" placeholder="Enter product number"><br>
                ENTER MANUFACTURING DATE:<input type="text"   name="md" placeholder="Enter manufacturing date"><br>
				ENTER EXPIRED DATE:<input type="text"  name="ed" placeholder="Enter expired date"><br>
                <input type="submit">
            </form>
        </section>
    </main>
    <footer>
        <p>&copy; 2025 My Website. All rights reserved.</p>
    </footer>
</body>
</html>