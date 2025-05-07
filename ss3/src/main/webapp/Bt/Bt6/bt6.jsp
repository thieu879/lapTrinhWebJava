<%@ page import="com.example.ss3.bt6.Product" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    response.setContentType("text/html");
    request.setCharacterEncoding("UTF-8");

    List<Product> productList = (List<Product>) session.getAttribute("productList");
    if (productList == null) {
        productList = new ArrayList<>();
    }

    String id = request.getParameter("id");
    String name = request.getParameter("name");
    String price = request.getParameter("price");
    String description = request.getParameter("description");
    String quantity = request.getParameter("quantity");

    if(id != null && name != null && price != null && description != null && quantity != null) {
        int stock = Integer.parseInt(quantity);
        String status = stock > 0 ? "Còn hàng" : "Hết hàng";
        Product product = new Product(Integer.parseInt(id), name, Double.parseDouble(price), description, stock, status);
        productList.add(product);
        session.setAttribute("productList", productList);
    }
%>
<html>
<head>
    <title>Quản Lý Sản Phẩm</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 30px;
        }

        h1, h2 {
            text-align: center;
        }

        form {
            margin-bottom: 30px;
        }

        input[type="text"], input[type="number"] {
            width: 300px;
            padding: 8px;
            margin: 5px 0;
            display: block;
        }

        input[type="submit"] {
            padding: 10px 20px;
            margin-top: 10px;
        }

        table {
            width: 100%;
            border-collapse: collapse;
            margin-top: 20px;
        }

        table, th, td {
            border: 1px solid black;
        }

        th, td {
            padding: 8px;
            text-align: center;
        }

    </style>
</head>
<body>
<h1>Quản Lý Sản Phẩm</h1>

<h2>Thêm Sản Phẩm</h2>
<form method="post">
    <label>ID</label>
    <input type="text" name="id">

    <label>Tên sản phẩm</label>
    <input type="text" name="name">

    <label>Giá</label>
    <input type="number" name="price">

    <label>Mô tả</label>
    <input type="text" name="description">

    <label>Số lượng</label>
    <input type="number" name="quantity">

    <input type="submit" value="Thêm sản phẩm">
</form>

<h2>Danh sách sản phẩm đã thêm:</h2>
<table>
    <tr>
        <th>ID</th>
        <th>Tên sản phẩm</th>
        <th>Giá</th>
        <th>Mô tả</th>
        <th>Số lượng</th>
        <th>Trạng thái</th>
    </tr>
    <% for (Product product : productList) { %>
    <tr>
        <td><%= product.getId() %></td>
        <td><%= product.getName() %></td>
        <td><%= product.getPrice() %></td>
        <td><%= product.getDescription() %></td>
        <td><%= product.getStock() %></td>
        <td><%= product.getStatus() %></td>
    </tr>
    <% } %>
</table>
</body>
</html>
