<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Add Book</title>
</head>
<body>
<h1>Add New Book</h1>
<form action="<c:url value='/books'/>" method="post">
  <input type="hidden" name="action" value="create"/>
  <label>Book Code:</label>
  <input type="text" name="bookCode" required/><br/>
  <label>Title:</label>
  <input type="text" name="title" required/><br/>
  <label>Author:</label>
  <input type="text" name="author"/><br/>
  <label>Category:</label>
  <input type="text" name="category"/><br/>
  <label>Quantity:</label>
  <input type="number" name="quantity" required/><br/>
  <input type="submit" value="Add Book"/>
  <a href="<c:url value='/books'/>">Cancel</a>
</form>
</body>
</html>