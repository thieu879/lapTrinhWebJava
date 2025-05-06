<%@ page import="com.example.ss2.bt6.Product" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Danh Sách Sản Phẩm</title>
    <style>
        .container {
            text-align: center;
            margin: 20px;
        }
        .form-box {
            border: 1px solid black;
            padding: 20px;
            display: inline-block;
        }
        .form-group {
            margin: 10px 0;
        }
        table {
            margin-top: 20px;
            border-collapse: collapse;
            width: 50%;
            margin-left: auto;
            margin-right: auto;
        }
        th, td {
            border: 1px solid black;
            padding: 8px;
            text-align: left;
        }
        th {
            background-color: #f2f2f2;
        }
    </style>
</head>
<body>
<div class="container">
    <h2>Danh Sách Sản Phẩm</h2>
    <div class="form-box">
        <h3>Thêm Sản Phẩm</h3>
        <form action="ProductServlet" method="post">
            <input type="hidden" name="action" value="add">
            <div class="form-group">
                <label>Tên:</label><br>
                <input type="text" name="name">
            </div>
            <div class="form-group">
                <label>Giá:</label><br>
                <input type="text" name="price">
            </div>
            <input type="submit" value="Thêm">
        </form>
    </div>
    <table>
        <tr>
            <th>ID</th>
            <th>Tên Sản Phẩm</th>
            <th>Giá</th>
            <th>Hành động</th>
        </tr>
        <%
            List<Product> productList = (List<Product>) request.getAttribute("productList");
            if (productList != null) {
                for (Product product : productList) {
        %>
        <tr>
            <td><%= product.getId() %></td>
            <td><%= product.getName() %></td>
            <td><%= product.getPrice() %></td>
            <td>
                <form action="ProductServlet" method="post" style="display:inline;">
                    <input type="hidden" name="action" value="delete">
                    <input type="hidden" name="id" value="<%= product.getId() %>">
                    <input type="submit" value="Xóa">
                </form>
                <form action="ProductServlet" method="post" style="display:inline;">
                    <input type="hidden" name="action" value="edit">
                    <input type="hidden" name="id" value="<%= product.getId() %>">
                    <input type="text" name="name" value="<%= product.getName() %>" size="10">
                    <input type="text" name="price" value="<%= product.getPrice() %>" size="10">
                    <input type="submit" value="Giá trị sửa">
                </form>
            </td>
        </tr>
        <%
                }
            }
        %>
    </table>
</div>
</body>
</html>