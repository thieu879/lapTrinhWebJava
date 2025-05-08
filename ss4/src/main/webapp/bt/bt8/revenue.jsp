<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html>
<head>
    <title>Thống Kê Doanh Thu</title>
    <style>
        body {
            background-color: #f4f4f4;
            font-family: Arial, sans-serif;
            text-align: center;
            padding: 50px;
        }

        table {
            margin: 0 auto;
            border-collapse: collapse;
            width: 60%;
        }

        th, td {
            border: 1px solid #ccc;
            padding: 12px;
        }

        th {
            background-color: #2196F3;
            color: white;
        }

        tr:nth-child(even) {
            background-color: #f2f2f2;
        }

        .summary {
            font-size: 20px;
            margin-top: 30px;
        }

        .success {
            color: green;
        }

        .warning {
            color: red;
        }
    </style>
</head>
<body>

<h1>Thống Kê Doanh Thu Theo Tháng</h1>

<table>
    <tr>
        <th>Tháng</th>
        <th>Doanh Thu</th>
    </tr>
    <c:forEach var="r" items="${revenues}">
        <tr>
            <td>${r.month}</td>
            <td>${r.amount}</td>
        </tr>
    </c:forEach>
</table>

<div class="summary">
    Tổng doanh thu: <strong>${totalRevenue}</strong>
</div>

<div class="summary">
    <c:choose>
        <c:when test="${totalRevenue > 10000}">
            <span class="success">Tình hình tài chính tốt</span>
        </c:when>
        <c:otherwise>
            <span class="warning">Cần cải thiện doanh thu</span>
        </c:otherwise>
    </c:choose>
</div>

</body>
</html>
