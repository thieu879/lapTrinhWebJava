<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Employee List</title>
  <style>
    table {
      border-collapse: collapse;
      width: 100%;
    }
    th, td {
      border: 1px solid black;
      padding: 8px;
      text-align: left;
    }
    th {
      background-color: #f2f2f2;
    }
    .pagination {
      margin-top: 20px;
    }
    .pagination a {
      margin: 0 5px;
      text-decoration: none;
    }
  </style>
</head>
<body>
<h1>Employee List</h1>
<a href="EmployeeController?action=add">Add New Employee</a>
<form action="EmployeeController" method="post">
  <input type="hidden" name="action" value="search"/>
  <input type="text" name="searchTerm" value="${searchTerm}" placeholder="Search by name or ID"/>
  <input type="submit" value="Search"/>
</form>
<table>
  <thead>
  <tr>
    <th><a href="EmployeeController?sortField=id&sortOrder=${sortField == 'id' && sortOrder == 'ASC' ? 'DESC' : 'ASC'}">ID</a></th>
    <th><a href="EmployeeController?sortField=name&sortOrder=${sortField == 'name' && sortOrder == 'ASC' ? 'DESC' : 'ASC'}">Name</a></th>
    <th><a href="EmployeeController?sortField=birthday&sortOrder=${sortField == 'birthday' && sortOrder == 'ASC' ? 'DESC' : 'ASC'}">Birthday</a></th>
    <th><a href="EmployeeController?sortField=phone&sortOrder=${sortField == 'phone' && sortOrder == 'ASC' ? 'DESC' : 'ASC'}">Phone</a></th>
    <th><a href="EmployeeController?sortField=email&sortOrder=${sortField == 'email' && sortOrder == 'ASC' ? 'DESC' : 'ASC'}">Email</a></th>
    <th><a href="EmployeeController?sortField=salary&sortOrder=${sortField == 'salary' && sortOrder == 'ASC' ? 'DESC' : 'ASC'}">Salary</a></th>
    <th><a href="EmployeeController?sortField=position&sortOrder=${sortField == 'position' && sortOrder == 'ASC' ? 'DESC' : 'ASC'}">Position</a></th>
    <th>Actions</th>
  </tr>
  </thead>
  <tbody>
  <c:forEach var="employee" items="${employees}">
    <tr>
      <td>${employee.id}</td>
      <td>${employee.name}</td>
      <td>${employee.birthday}</td>
      <td>${employee.phone}</td>
      <td>${employee.email}</td>
      <td>${employee.salary}</td>
      <td>${employee.position}</td>
      <td>
        <a href="EmployeeController?action=edit&id=${employee.id}">Edit</a>
        <a href="EmployeeController?action=delete&id=${employee.id}" onclick="return confirm('Are you sure?')">Delete</a>
      </td>
    </tr>
  </c:forEach>
  </tbody>
</table>
<div class="pagination">
  <c:if test="${currentPage > 1}">
    <a href="EmployeeController?page=${currentPage - 1}&sortField=${sortField}&sortOrder=${sortOrder}&searchTerm=${searchTerm}">Previous</a>
  </c:if>
  <c:forEach begin="1" end="${totalPages}" var="i">
    <a href="EmployeeController?page=${i}&sortField=${sortField}&sortOrder=${sortOrder}&searchTerm=${searchTerm}" ${i == currentPage ? 'style="font-weight:bold"' : ''}>${i}</a>
  </c:forEach>
  <c:if test="${currentPage < totalPages}">
    <a href="EmployeeController?page=${currentPage + 1}&sortField=${sortField}&sortOrder=${sortOrder}&searchTerm=${searchTerm}">Next</a>
  </c:if>
</div>
</body>
</html>