<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Shopping Cart</title>
</head>
<body>
<h1>Your Cart</h1>
<table border="1">
    <thead>
    <tr>
        <th>Name</th>
        <th>Price</th>
        <th>Quantity</th>
        <th>Image</th>
        <th>Action</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="item" items="${cartItems}">
        <tr>
            <td>${item.name}</td>
            <td>${item.price}</td>
            <td>${item.quantity}</td>
            <td><img src="${item.imageUrl}" alt="${item.name}" width="100"/></td>
            <td>
                <form action="CartController" method="post">
                    <input type="hidden" name="userId" value="1"/> <!-- Hardcoded for demo -->
                    <input type="hidden" name="productId" value="${item.productId}"/>
                    <input type="submit" value="Remove"/>
                </form>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<h3>Total: ${total}</h3>
<a href="ProductController">Continue Shopping</a>
</body>
</html>