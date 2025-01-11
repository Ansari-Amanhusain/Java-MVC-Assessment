<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Registration Page</title>
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
        max-width: 470px;
        box-sizing: border-box;
        text-align: center;
    }

    .form-group {
        display: flex;
        align-items: center;
        margin-bottom: 20px; /* Increased margin-bottom to make the table longer */
    }

    .form-group label {
        flex: 1;
        margin-right: 10px;
        font-weight: bold;
    }

    .form-group input {
        flex: 2;
        padding: 9px; /* Increased padding for input fields */
        border: 1px solid #ccc;
        border-radius: 4px;
        box-sizing: border-box;
    }

    .button-group {
        display: flex;
        justify-content: space-between;
        margin-top: 20px;
    }

    button {
        padding: 10px;
        font-size: 14px; /* Reduced font-size */
        color: white;
        background-color: blue;
        border: none;
        cursor: pointer;
        transition: background-color 0.3s;
        border-radius: 4px;
        width: 100px; /* Fixed width for buttons */
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
</style>
</head>
<body>
<form method="post" action="RegisterController">
    <div class="msg">${msg}</div>
    <div class="form-group">
        <label for="firstname">Enter FirstName:</label>
        <input type="text" name="firstname" id="firstname">
    </div>
    <div class="form-group">
        <label for="lastname">Enter LastName:</label>
        <input type="text" name="lastname" id="lastname">
    </div>
    <div class="form-group">
        <label for="username">Enter UserName:</label>
        <input type="text" name="username" id="username">
    </div>
    <div class="form-group">
        <label for="password">Enter Password:</label>
        <input type="password" name="password" id="password">
    </div>
    <div class="button-group">
        <button type="button" onclick="location.href='login.jsp'">Back</button>
        <button type="submit">Sign Up</button>
    </div>
</form>
</body>
</html>
