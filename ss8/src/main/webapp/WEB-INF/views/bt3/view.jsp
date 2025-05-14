<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
  <title>Thông tin sản phẩm</title>
</head>
<body>
<h2>Thông tin sản phẩm vừa thêm</h2>

<p>ID: ${product.id}</p>
<p>Tên sản phẩm: ${product.name}</p>
<p>Số lượng: ${product.quantity}</p>
<p>Giá: ${product.price} VND</p>

</body>
</html>

