<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
  <title>Warehouse</title>
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
    .links {
      display: flex;
      justify-content: center;
      gap: 20px;
      margin-top: 20px;
    }
    .links a {
      text-decoration: none;
      color: #4CAF50;
      font-size: 16px;
    }
  </style>
</head>
<body>
<h1>Your Warehouse</h1>
<table>
  <tr>
    <th>Seed Name</th>
    <th>Quantity</th>
    <th>Price</th>
  </tr>
  <c:forEach var="item" items="${warehouse}">
    <tr>
      <td>${item.seed.seedsName}</td>
      <td>${item.quantity}</td>
      <td>${item.seed.price}</td>
    </tr>
  </c:forEach>
</table>

<div class="links">
  <a href="${pageContext.request.contextPath}/GameController/shop">Go to Shop</a>
  <a href="${pageContext.request.contextPath}/GameController/farm">Go to Farm</a>
</div>
</body>
</html>
