<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Thêm sản phẩm</title>
</head>
<body>
<h2>Form thêm sản phẩm</h2>

<form:form method="post" action="/products/add" modelAttribute="product">
    <p>ID: <form:input path="id" type="number"/></p>
    <p>Tên sản phẩm: <form:input path="name"/></p>
    <p>Số lượng: <form:input path="quantity" type="number"/></p>
    <p>Giá: <form:input path="price" type="number" step="0.01"/></p>
    <p><input type="submit" value="Thêm sản phẩm"/></p>
</form:form>

</body>
</html>


