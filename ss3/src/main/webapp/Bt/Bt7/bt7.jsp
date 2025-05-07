<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.*, java.io.*" %>
<%
    List<Map<String, Object>> orders = (List<Map<String, Object>>) session.getAttribute("orders");
    if (orders == null) {
        orders = new ArrayList<>();
        session.setAttribute("orders", orders);
    }

    String nameProduct = request.getParameter("nameProduct");
    String quantityStr = request.getParameter("quantity");
    String priceStr = request.getParameter("price");

    String errorMsg = null;
    if (nameProduct != null && quantityStr != null && priceStr != null &&
            !nameProduct.isEmpty() && !quantityStr.isEmpty() && !priceStr.isEmpty()) {
        try {
            int quantity = Integer.parseInt(quantityStr);
            double price = Double.parseDouble(priceStr);
            double totalPrice = quantity * price;

            Map<String, Object> order = new HashMap<>();
            order.put("nameProduct", nameProduct);
            order.put("quantity", quantity);
            order.put("price", price);
            order.put("totalPrice", totalPrice);
            orders.add(order);

        } catch (NumberFormatException e) {
            errorMsg = "Vui lòng nhập đúng định dạng cho số lượng và giá.";
        }
    }
%>
<html>
<head>
    <title>Order Form</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            display: flex;
            flex-direction: column;
            align-items: center;
            padding: 20px;
        }

        .order-form {
            width: 50%;
            margin-bottom: 30px;
            text-align: center;
        }

        table {
            width: 80%;
            margin-top: 20px;
            border-collapse: collapse;
        }

        table, th, td {
            border: 1px solid #ddd;
            text-align: left;
            padding: 8px;
        }

        th {
            background-color: #f2f2f2;
        }

        input[type="number"], input[type="text"] {
            padding: 8px;
            margin: 10px;
            width: 50%;
        }

        button {
            padding: 10px 20px;
            background-color: #007bff;
            color: white;
            border: none;
            cursor: pointer;
        }

        button:hover {
            background-color: #0056b3;
        }

        .error {
            color: red;
        }
    </style>
</head>
<body>
<div class="order-form">
    <h1>Order Form</h1>
    <% if (errorMsg != null) { %>
    <p class="error"><%= errorMsg %></p>
    <% } %>
    <form method="post">
        <div>
            <label for="nameProduct">Product:</label>
            <input id="nameProduct" name="nameProduct" type="text" value="<%= nameProduct != null ? nameProduct : "" %>">
        </div>
        <div>
            <label for="quantity">Quantity:</label>
            <input type="number" id="quantity" name="quantity" min="0" value="<%= quantityStr != null ? quantityStr : "0" %>">
        </div>
        <div>
            <label for="price">Price:</label>
            <input type="number" id="price" name="price" step="0.01" min="0" value="<%= priceStr != null ? priceStr : "0" %>">
        </div>
        <button type="submit">Submit</button>
    </form>
</div>

<table>
    <tr>
        <th>Product</th>
        <th>Quantity</th>
        <th>Price</th>
        <th>Total Price</th>
    </tr>
    <% for (Map<String, Object> order : orders) { %>
    <tr>
        <td><%= order.get("nameProduct") %></td>
        <td><%= order.get("quantity") %></td>
        <td><%= order.get("price") %></td>
        <td><%= order.get("totalPrice") %></td>
    </tr>
    <% } %>
</table>
</body>
</html>
