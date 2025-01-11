<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Home Page</title>
<style>
    body {
        font-family: Arial, sans-serif;
        background-color: #f2f2f2;
        margin: 0;
        padding: 0;
    }

    header {
        font-size: 24px;
        font-weight: bold;
        text-align: center;
        margin: 20px 0;
    }

    nav {
        display: flex;
        justify-content: center;
        background-color: #808080;
        padding: 10px;
    }

    nav a {
        margin: 0 15px;
        text-decoration: none;
        color: white;
        font-weight: bold;
        transition: color 0.3s;
    }

    nav a:hover {
        color: #d4d4d4;
    }
</style>
</head>
<body>
 	<header>Employee Management System</header>
    <nav>
    	<a href="home.jsp">Home</a>
        <a href="insert.jsp">Add Employee</a>
        <a href="ViewController">View Employee</a>
        
    </nav>
</body>
</html>