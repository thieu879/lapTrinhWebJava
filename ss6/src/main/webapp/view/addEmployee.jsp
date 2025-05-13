<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add Employee</title>
</head>
<body>
<h1>Add New Employee</h1>
<form action="EmployeeController" method="post">
    <input type="hidden" name="action" value="add"/>
    <label>Name:</label>
    <input type="text" name="name" required/><br/>
    <label>Birthday:</label>
    <input type="date" name="birthday" required/><br/>
    <label>Phone:</label>
    <input type="text" name="phone"/><br/>
    <label>Email:</label>
    <input type="email" name="email"/><br/>
    <label>Salary:</label>
    <input type="number" name="salary" step="0.01" required/><br/>
    <label>Position:</label>
    <input type="text" name="position"/><br/>
    <input type="submit" value="Add Employee"/>
    <a href="EmployeeController">Cancel</a>
</form>
</body>
</html>