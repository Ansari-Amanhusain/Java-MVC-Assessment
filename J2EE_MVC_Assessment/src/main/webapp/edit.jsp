<%@ include file="header.jsp" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.model.EmployeeModel" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Edit Employee</title>
    <style>
        .container {
            background-color: white;
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            width: 100%;
            max-width: 600px;
            margin: auto;
            box-sizing: border-box;
        }

        h1 {
            text-align: center;
            color: #333;
        }

        form {
            display: flex;
            flex-direction: column;
        }

        label {
            margin: 10px 0 5px;
            font-weight: bold;
        }

        input[type="text"], input[type="password"] {
            padding: 10px;
            border: 1px solid #ddd;
            border-radius: 4px;
            margin-bottom: 10px;
        }

        button {
            padding: 10px;
            font-size: 14px;
            color: white;
            background-color: blue;
            border: none;
            cursor: pointer;
            transition: background-color 0.3s;
            border-radius: 4px;
            margin-top: 10px;
        }

        button:hover {
            font-weight: bold;
            background-color: darkblue;
        }
    </style>
</head>
<body>
    <div class="container">
        <h1>Edit Employee</h1>
        <%
            EmployeeModel emp = (EmployeeModel) request.getAttribute("employee");
            if (emp != null) {
        %>
        <form method="post" action="EditController">
            <input type="hidden" name="employeeid" value="<%= emp.getEmployeeid() %>">
            <label for="firstname">First Name:</label>
            <input type="text" id="firstname" name="firstname" value="<%= emp.getFirstname() %>">
            <label for="lastname">Last Name:</label>
            <input type="text" id="lastname" name="lastname" value="<%= emp.getLastname() %>">
            <label for="email">Email:</label>
            <input type="text" id="email" name="email" value="<%= emp.getEmail() %>">
            <label for="mobile">Mobile:</label>
            <input type="text" id="mobile" name="mobile" value="<%= emp.getMobile() %>">
            <label for="address">Address:</label>
            <input type="text" id="address" name="address" value="<%= emp.getAddress() %>">
            <label for="gender">Gender:</label>
            <input type="text" id="gender" name="gender" value="<%= emp.getGender() %>">
            <label for="password">Password:</label>
            <input type="password" id="password" name="password" value="<%= emp.getPassword() %>">
            <button type="submit">Update</button>
        </form>
        <% } else { %>
        <p>Employee not found. Please <a href="view.jsp">go back</a> and try again.</p>
        <% } %>
    </div>
</body>
</html>
