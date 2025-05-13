<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Product List</title>
</head>
<body>
<h1>Product List</h1>
<table border="1">
    <thead>
    <tr>
        <th>Name</th>
        <th>Price</th>
        <th>Image</th>
        <th>Action</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="product" items="${products}">
        <tr>
            <td>${product.name}</td>
            <td>${product.price}</td>
            <td><img src="${product.imageUrl}" alt="${product.name}" width="100"/></td>
            <td>
                <form action="ProductController" method="post">
                    <input type="hidden" name="userId" value="1"/> <!-- Hardcoded for demo; replace with session-based userId -->
                    <input type="hidden" name="productId" value="${product.id}"/>
                    <input type="number" name="quantity" value="1" min="1"/>
                    <input type="submit" value="Add to Cart"/>
                </form>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<a href="CartController?userId=1">View Cart</a> <!-- Hardcoded userId for demo -->
</body>
</html>