<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>productList</title>
</head>
<body>
<h1>Product List</h1>
<table border="1">
    <tr>
        <th>Product ID</th>
        <th>Product Name</th>
        <th>Price</th>
    </tr>
    <c:forEach var="product" items="${listProduct}">
        <tr>
            <td>${product.id}</td>
            <td>${product.name}</td>
            <td>${product.price}</td>
        </tr>
    </c:forEach>
</body>
</html>
