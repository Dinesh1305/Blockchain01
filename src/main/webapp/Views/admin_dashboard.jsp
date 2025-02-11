<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.sql.*, java.util.*" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Admin Dashboard</title>
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
        main {
            padding: 20px;
        }
        .container {
            width: 80%;
            margin: auto;
            background: white;
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0px 0px 10px rgba(0, 0, 0, 0.1);
        }
        table {
            width: 100%;
            border-collapse: collapse;
            margin-top: 20px;
        }
        th, td {
            padding: 12px;
            border: 1px solid #ddd;
            text-align: left;
        }
        th {
            background-color: #28a745;
            color: white;
        }
        tr:nth-child(even) {
            background-color: #f2f2f2;
        }
        .logout-btn, .owner-btn, .remove-btn {
            display: inline-block;
            padding: 10px 15px;
            margin-top: 10px;
            text-decoration: none;
            border-radius: 5px;
            color: white;
            cursor: pointer;
            border: none;
        }
        .logout-btn {
            background-color: #dc3545;
        }
        .logout-btn:hover {
            background-color: #c82333;
        }
        .owner-btn {
            background-color: #007bff;
        }
        .owner-btn:hover {
            background-color: #0056b3;
        }
        .remove-btn {
            background-color: #ff0000;
        }
        .remove-btn:hover {
            background-color: #cc0000;
        }
    </style>
</head>
<body>

<header>
    <h2>Admin Dashboard</h2>
</header>

<main>
    <div class="container">
        <h3>Registered Companies</h3>
        <table>
            <tr>
                <th>Name</th>
                <th>Email</th>
                <th>Hash Address</th>
                <th>Action</th>
            </tr>

            <%
                Connection conn = null;
                Statement stmt = null;
                ResultSet rs = null;
                try {
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/company", "root", "3105");
                    stmt = conn.createStatement();
                    rs = stmt.executeQuery("SELECT name, email, hash FROM companydetails");

                    while (rs.next()) {
                        String companyEmail = rs.getString("email");
            %>
                        <tr>
                            <td><%= rs.getString("name") %></td>
                            <td><%= companyEmail %></td>
                            <td><%= rs.getString("hash") %></td>
                            <td>
                                <form action="remover" method="post">
                                    <input type="hidden" name="email" value="<%= companyEmail %>">
                                    <button type="submit" class="remove-btn">Remove</button>
                                </form>
                            </td>
                        </tr>
            <%
                    }
                } catch (Exception e) {
                    e.printStackTrace();
            %>
                    <tr>
                        <td colspan="4" style="color: red; text-align: center;">Error fetching data!</td>
                    </tr>
            <%
                } finally {
                    if (rs != null) try { rs.close(); } catch (SQLException ignore) {}
                    if (stmt != null) try { stmt.close(); } catch (SQLException ignore) {}
                    if (conn != null) try { conn.close(); } catch (SQLException ignore) {}
                }
            %>
        </table>

        <a href="http://localhost:5173/owner" class="owner-btn">Go to Owner Page</a>
        <a href="admin_login" class="logout-btn">Logout</a>
    </div>
</main>

<footer>
    <p>&copy; 2025 My Website. All rights reserved.</p>
</footer>

</body>
</html>
