<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Edit Book</title>
</head>
<body>
<h1>Edit Book</h1>
<form action="<c:url value='/books'/>" method="post">
  <input type="hidden" name="action" value="update"/>
  <input type="hidden" name="bookCode" value="${book.bookCode}"/>
  <label>Book Code:</label>
  <input type="text" name="bookCode" value="${book.bookCode}" disabled/><br/>
  <label>Title:</label>
  <input type="text" name="title" value="${book.title}" required/><br/>
  <label>Author:</label>
  <input type="text" name="author" value="${book.author}"/><br/>
  <label>Category:</label>
  <input type="text" name="category" value="${book.category}"/><br/>
  <label>Quantity:</label>
  <input type="number" name="quantity" value="${book.quantity}" required/><br/>
  <input type="submit" value="Update Book"/>
  <a href="<c:url value='/books'/>">Cancel</a>
</form>
</body>
</html>