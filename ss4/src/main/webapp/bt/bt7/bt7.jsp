<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Product Details</title>
    <style>
        body {
            background-color: #1a2a3a;
            color: white;
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
            text-align: center;
            padding: 50px;
        }

        h1 {
            font-size: 36px;
            margin-bottom: 30px;
        }

        input[type="text"] {
            padding: 10px;
            width: 200px;
            border: none;
            border-radius: 5px;
            margin: 5px;
        }

        button {
            padding: 10px 20px;
            background-color: #2196F3;
            border: none;
            color: white;
            border-radius: 5px;
            cursor: pointer;
        }

        hr {
            margin: 40px auto;
            width: 50%;
            border: 0;
            border-top: 1px solid #ccc;
        }

        .label-row {
            display: flex;
            justify-content: center;
            gap: 60px;
            font-weight: bold;
            margin-bottom: 40px;
        }

        .not-found {
            font-size: 28px;
            font-weight: bold;
            color: #ddd;
            margin-bottom: 10px;
        }

        .suggestion {
            color: #bbb;
        }
    </style>
</head>
<body>

<h1>Product Details</h1>

<form method="get" action="Bt7Servlet">
    <input type="text" name="search" placeholder="Enter product name"/>
    <br/>
    <input type="text" name="minPrice" placeholder="Min price"/>
    <input type="text" name="maxPrice" placeholder="Max price"/>
    <br/>
    <button type="submit">Search</button>
</form>

<hr>

<c:choose>
    <c:when test="${hasResults}">
        <div class="label-row">
            <table border="1" cellpadding="10" style="color: white;">
                <tr>
                    <th>ID</th>
                    <th>Product Name</th>
                    <th>Price</th>
                    <th>Description</th>
                </tr>
                <c:forEach items="${products}" var="product">
                    <tr>
                        <td>${product.id}</td>
                        <td>${product.productName}</td>
                        <td>${product.price}</td>
                        <td>${product.description}</td>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </c:when>
    <c:otherwise>
        <div class="not-found">Không có sản phẩm nào trong khoảng giá này</div>
        <div class="suggestion">Vui lòng kiểm tra lại từ khóa hoặc khoảng giá</div>
    </c:otherwise>
</c:choose>

</body>
</html>
