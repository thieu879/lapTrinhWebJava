<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Thêm sản phẩm</title>
</head>
<body>
<h2>Thêm sản phẩm mới</h2>
<c:if test="${not empty error}">
    <div style="color:red">${error}</div>
</c:if>
<form method="post" enctype="multipart/form-data" action="/products/add">
    Tên sản phẩm: <input type="text" name="productName" value="${product.productName}"/><br>
    Giá: <input type="number" name="price" value="${product.price}"/><br>
    Mô tả: <textarea name="description">${product.description}</textarea><br>
    Ảnh: <input type="file" name="imageFile"/><br>
    Trạng thái:
    <select name="status">
        <option value="">--Chọn trạng thái--</option>
        <option value="AVAILABLE" ${product.status == 'AVAILABLE'?'selected':''}>Có sẵn</option>
        <option value="NOT_AVAILABLE" ${product.status == 'NOT_AVAILABLE'?'selected':''}>Không còn</option>
    </select>
    <br>
    <button type="submit">Lưu</button>
</form>
</body>
</html>