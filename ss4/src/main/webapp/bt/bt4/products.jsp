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
    <c:choose>
        <c:when test="${not empty products}">
            <c:forEach var="product" items="${products}">
                <tr>
                    <td>${product.id}</td>
                    <td>${product.productName}</td>
                    <td>${product.price}</td>
                    <td>${product.description}</td>
                </tr>
            </c:forEach>
        </c:when>
        <c:otherwise>
            <tr>
                <td colspan="4">Không có sản phẩm nào.</td>
            </tr>
        </c:otherwise>
    </c:choose>
</table>

</body>
</html>
