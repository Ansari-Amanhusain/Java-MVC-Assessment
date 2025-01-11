<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login Page</title>
<style>
    body {
        font-family: Arial, sans-serif;
        background-color: #f2f2f2;
        margin: 0;
        padding: 0;
        display: flex;
        justify-content: center;
        align-items: center;
        height: 100vh;
    }
    form {
        background-color: white;
        padding: 20px;
        border-radius: 8px;
        box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        width: 100%;
        max-width: 400px;
        box-sizing: border-box;
        text-align: center;
    }
    .form-group {
        display: flex;
        align-items: center;
        margin-bottom: 10px;
    }
    .form-group label {
        flex: 1;
        margin-right: 10px;
        font-weight: bold;
    }
    .form-group input {
        flex: 2;
        padding: 8px;
        border: 1px solid #ccc;
        border-radius: 4px;
        box-sizing: border-box;
    }
    button {
        width: 100%;
        padding: 10px;
        font-size: 16px;
        color: white;
        background-color: blue;
        border: none;
        cursor: pointer;
        transition: background-color 0.3s;
        border-radius: 4px;
    }
    button:hover {
        font-weight: bold;
    }
    a {
        text-decoration: none;
        color: blue;
    }
    a:hover {
        font-weight: bold;
    }
    .msg {
        color: red;
        font-weight: bold;
        margin-bottom: 10px;
    }
    .small-text {
        font-size: 12px;
        margin-top: 10px;
        display: block;
        text-align: center;
    }
</style>
</head>
<body>
<form method="post" action="LoginController">
    <div class="msg">${msg}</div>
    <div class="form-group">
        <label for="username">UserName:</label>
        <input type="text" name="username" id="username">
    </div>
    <div class="form-group">
        <label for="password">Password:</label>
        <input type="password" name="password" id="password">
    </div>
    <button type="submit">Login</button>
    <div class="small-text">
        If User not Exist then <a href="register.jsp">Register new account?</a>
    </div>
</form>
</body>
</html>