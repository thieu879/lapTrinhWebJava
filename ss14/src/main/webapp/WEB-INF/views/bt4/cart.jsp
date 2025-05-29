<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>Giỏ hàng hiện tại</h2>
<table border="1">
  <tr><th>Tên sản phẩm</th><th>Số lượng</th><th>Thao tác</th></tr>
  <c:forEach var="p" items="${cart}">
    <tr>
      <td>${p.name}</td>
      <td>${p.quantity}</td>
      <td><a href="remove?name=${p.name}">Xóa</a></td>
    </tr>
  </c:forEach>
</table>
</body>
</html>
