<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Danh sách sản phẩm</title>
</head>
<body>
<h2>Danh sách sản phẩm</h2>
<table border="1" cellpadding="5" cellspacing="0">
  <tr>
    <th>Tên sản phẩm</th>
    <th>Giá</th>
  </tr>
  <c:forEach items="${products}" var="p">
    <tr>
      <td>${p.name}</td>
      <td>${p.price}</td>
    </tr>
  </c:forEach>
</table>
<br/>
<a href="<c:url value='/product/add' />">Thêm sản phẩm mới</a>
</body>
</html>
