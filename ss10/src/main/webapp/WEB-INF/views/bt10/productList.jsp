<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
  <title>Product List</title>
</head>
<body>
<h2>Product List</h2>
<a href="${pageContext.request.contextPath}/products/add">Add New Product</a>
<table border="1" cellpadding="5" cellspacing="0">
  <thead>
  <tr>
    <th>ID</th><th>Name</th><th>Price</th><th>Stock</th><th>Image</th><th>Actions</th>
  </tr>
  </thead>
  <tbody>
  <c:forEach var="p" items="${products}">
    <tr>
      <td>${p.id}</td>
      <td>${p.name}</td>
      <td>${p.price}</td>
      <td>${p.stock}</td>
      <td><img src="${p.image}" width="100"/></td>
      <td>
        <a href="${pageContext.request.contextPath}/products/edit/${p.id}">Edit</a> |
        <a href="${pageContext.request.contextPath}/products/delete/${p.id}"
           onclick="return confirm('Are you sure?')">Delete</a>
      </td>
    </tr>
  </c:forEach>
  </tbody>
</table>
</body>
</html>

