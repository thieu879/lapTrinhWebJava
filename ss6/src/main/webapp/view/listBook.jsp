<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Book List</title>
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
  </style>
</head>
<body>
<h1>Book List</h1>
<a href="<c:url value='/books?action=add'/>">Add New Book</a>
<form action="<c:url value='/books'/>" method="get">
  <input type="text" name="searchTerm" placeholder="Search by title or code"/>
  <input type="submit" value="Search"/>
</form>
<table>
  <thead>
  <tr>
    <th>Code</th>
    <th>Title</th>
    <th>Author</th>
    <th>Category</th>
    <th>Quantity</th>
    <th>Actions</th>
  </tr>
  </thead>
  <tbody>
  <c:forEach var="book" items="${books}">
    <tr>
      <td><c:out value="${book.bookCode}"/></td>
      <td><c:out value="${book.title}"/></td>
      <td><c:out value="${book.author}"/></td>
      <td><c:out value="${book.category}"/></td>
      <td><c:out value="${book.quantity}"/></td>
      <td>
        <a href="<c:url value='/books?action=edit&bookCode=${book.bookCode}'/>">Edit</a>
        <form action="<c:url value='/books'/>" method="post" style="display:inline;">
          <input type="hidden" name="action" value="delete"/>
          <input type="hidden" name="bookCode" value="${book.bookCode}"/>
          <input type="submit" value="Delete" onclick="return confirm('Are you sure?')"/>
        </form>
      </td>
    </tr>
  </c:forEach>
  </tbody>
</table>
</body>
</html>