<%@ include file="header.jsp" %>
<%@ page import="java.util.List" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.model.EmployeeModel" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Employee List</title>
</head>
<body>
    <h1>Employee List</h1>
    ${msg }
    <%
        List<EmployeeModel> employees = (List<EmployeeModel>) request.getAttribute("employees");
        String msg = (String) request.getAttribute("msg");
    %>
    <% if (employees != null && !employees.isEmpty()) { %>
        <table border="1">
            <tr>
                <th>Employee ID</th>
                <th>First Name</th>
                <th>Last Name</th>
                <th>Email</th>
                <th>Mobile</th>
                <th>Address</th>
                <th>Gender</th>
                <th>Password</th>
                <th>Action</th>
            </tr>
            
            <% 
                for (EmployeeModel emp : employees) 
                { 
            %>
            <tr>
                <td><%= emp.getEmployeeid() %></td>
                <td><%= emp.getFirstname() %></td>
                <td><%= emp.getLastname() %></td>
                <td><%= emp.getEmail() %></td>
                <td><%= emp.getMobile() %></td>
                <td><%= emp.getAddress() %></td>
                <td><%= emp.getGender() %></td>
                <td><%= emp.getPassword() %></td>
                <td>
                	<a href="EditController?id=<%= emp.getEmployeeid() %>">Edit</a>
                	<a href="DeleteController?id=<%= emp.getEmployeeid() %>">Delete</a>
                </td>
            </tr>
            <% } %>
        </table>
    <% } else { %>
        <p><%= msg != null ? msg : "No employees found." %></p>
    <% } %>
    
</body>
</html>
