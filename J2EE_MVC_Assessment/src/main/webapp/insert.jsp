<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Employee Management System</title>
<style type="text/css">
	form {
	    width: 100%;
	    max-width: 500px;
	    margin: 20px auto;
	    padding: 20px;
	    border: 1px solid #ddd;
	    border-radius: 5px;
	    box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
	    background-color: #f9f9f9;
	    font-family: Arial, sans-serif;
	}
	
	/* Table styling */
	table {
	    width: 100%;
	    border-collapse: collapse;
	    margin: 10px 0;
	}
	
	td {
	    padding: 10px 5px;
	    vertical-align: middle;
	}
	
	label {
	    font-weight: bold;
	    display: inline-block;
	    margin-bottom: 5px;
	}
	
	input[type="text"],
	input[type="email"],
	input[type="password"],
	textarea {
	    width: 100%;
	    padding: 8px;
	    margin-bottom: 10px;
	    border: 1px solid #ccc;
	    border-radius: 4px;
	    box-sizing: border-box;
	}
	
	textarea {
	    resize: none;
	}
	
	input[type="radio"] {
	    margin-right: 5px;
	}
	
	/* Adjust spacing between radio buttons and labels */
	label[for="male"],
	label[for="female"],
	label[for="other"] {
	    margin-right: 15px;
	}
	
		/* Styling for buttons */
	button {
	    padding: 10px 20px;
	    border: none;
	    border-radius: 4px;
	    cursor: pointer;
	    font-size: 16px;
	    background-color: #007bff;
	    color: white;
	    margin-right: 10px;
	}
	
	button:active {
	    font-weight: bold;
	}
	
	button[type="submit"] {
	    float: right;
	}
	
	/* Responsive Design */
	@media (max-width: 600px) {
	    form {
	        padding: 10px;
	    }
	
	    td {
	        display: block;
	        width: 100%;
	    }
	
	    label {
	        margin-bottom: 10px;
	    }
	}
</style>
</head>
<body>
${msg }
	<form  method="post" action="InsertController">
		<table>
			<tr>
				<td>
					<label for="firstname">Enter your FirstName :</label>
				    <input type="text" name="firstname" id="firstname" placeholder="Firstname">
				</td>
			</tr>
			<tr>
				<td>
					<label for="lastname">Enter your LastName :</label>
				    <input type="text" name="lastname" id="lastname"placeholder="Lastname">
				</td>
			</tr>
			<tr>
				<td>
					<label for="email">Enter your E-mail :</label>
				    <input type="email" name="email" id="email"placeholder="Email">
				</td>
			</tr>
			<tr>
				<td>
					<label for="mobile">Enter your Mobile No. :</label>
				    <input type="text" name="mobile" id="mobile"placeholder="Mobile no">
				</td>
			</tr>
			<tr>
				<td>
					<label for="address">Enter your Address :</label>
				    <textarea rows="3" cols="3" name="address"placeholder="Address" id="address"></textarea>
				</td>
			</tr>
			<tr>
				<td>
					<label for="gender">Gender :</label>
					<input type="radio" name="gender" id="male" value="Male">
                    <label for="male">Male</label>
                    <input type="radio" name="gender" id="female" value="Female">
                    <label for="female">Female</label>
                    <input type="radio" name="gender" id="other" value="other">
                    <label for="other">Other</label>
				</td>
			</tr>
			<tr>
	            <td>
	                <label for="password">Enter Password :</label>
	                <input type="password" name="password" id="password">
	            </td>
	        </tr>
	        <tr>
	            <td>
	                <label for="confirmpassword">Enter Confirm Password :</label>
	                <input type="password" name="confirmpassword" id="confirmpassword">
	            </td>
	        </tr>
	        <tr>
	            <td>
	                <button type="button" onclick="location.href='index.jsp'">Back</button>
	                <button type="submit">Submit</button>
	            </td>
	        </tr>
		</table>
	</form>

</body>
</html>