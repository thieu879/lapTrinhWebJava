<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Update Employee</title>
</head>
<body>
<h1>Update Employee</h1>
<form action="EmployeeController" method="post">
  <input type="hidden" name="action" value="update"/>
  <input type="hidden" name="id" value="${employee.id}"/>
  <label>Name:</label>
  <input type="text" name="name" value="${employee.name}" required/><br/>
  <label>Birthday:</label>
  <input type="date" name="birthday" value="${employee.birthday}" required/><br/>
  <label>Phone:</label>
  <input type="text" name="phone" value="${employee.phone}"/><br/>
  <label>Email:</label>
  <input type="email" name="email" value="${employee.email}"/><br/>
  <label>Salary:</label>
  <input type="number" name="salary" step="0.01" value="${employee.salary}" required/><br/>
  <label>Position:</label>
  <input type="text" name="position" value="${employee.position}"/><br/>
  <input type="submit" value="Update Employee"/>
  <a href="EmployeeController">Cancel</a>
</form>
</body>
</html>