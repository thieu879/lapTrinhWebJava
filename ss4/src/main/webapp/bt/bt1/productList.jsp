<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>List Product</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #fdfdfd;
        }
        h2 {
            text-align: center;
            font-size: 28px;
        }
        table {
            width: 80%;
            margin: 0 auto;
            border-collapse: collapse;
        }
        th, td {
            border: 1px solid black;
            padding: 8px 12px;
            text-align: center;
        }
        th {
            background-color: #f2f2f2;
        }
    </style>
</head>
<body>

<h2>Danh sách sản phẩm</h2>

<table>
    <tr>
        <th>ID</th>
        <th>Product Name</th>
        <th>Price</th>
        <th>Description</th>
    </tr>
    <c:forEach items="${productList}" var="product">
        <tr>
            <td>${product.id}</td>
            <td>${product.productName}</td>
            <td>${product.price}</td>
            <td>${product.description}</td>
        </tr>
    </c:forEach>
</table>

</body>
</html>
