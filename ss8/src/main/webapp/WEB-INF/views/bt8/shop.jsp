<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Shop</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 20px;
        }
        h1 {
            text-align: center;
            color: #4CAF50;
        }
        table {
            width: 100%;
            border-collapse: collapse;
            margin-top: 20px;
        }
        th, td {
            padding: 12px;
            text-align: center;
            border: 1px solid #ddd;
        }
        th {
            background-color: #4CAF50;
            color: white;
        }
        tr:nth-child(even) {
            background-color: #f2f2f2;
        }
        td img {
            width: 50px;
            height: auto;
        }
        .form-container {
            text-align: center;
        }
        .form-container input {
            padding: 8px;
            margin: 5px;
        }
        .form-container button {
            padding: 10px;
            background-color: #4CAF50;
            color: white;
            border: none;
            cursor: pointer;
        }
        .form-container button:hover {
            background-color: #45a049;
        }
    </style>
</head>
<body>
<h1>Shop</h1>
<table>
    <tr>
        <th>Name</th>
        <th>Price</th>
        <th>Image</th>
        <th>Action</th>
    </tr>
    <c:forEach var="seed" items="${seeds}">
        <tr>
            <td>${seed.seedsName}</td>
            <td>${seed.price}</td>
            <td><img src="${seed.imageUrl}" alt="${seed.seedsName}"></td>
            <td>
                <form action="${pageContext.request.contextPath}/GameController/buySeed" method="post" class="form-container">
                    <input type="hidden" name="seedId" value="${seed.id}">
                    <input type="number" name="quantity" min="1" max="10" value="1" required>
                    <button type="submit">Buy</button>
                </form>
            </td>
        </tr>
    </c:forEach>
</table>

<div class="links">
    <a href="${pageContext.request.contextPath}/GameController/farm">Go to Farm</a>
    <a href="${pageContext.request.contextPath}/GameController/warehouse">Go to Warehouse</a>
</div>
</body>
</html>
