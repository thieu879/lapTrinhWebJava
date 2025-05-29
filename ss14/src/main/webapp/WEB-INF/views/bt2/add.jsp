<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form:form method="post" modelAttribute="product">
  Mã SP: <form:input path="id" /><br>
  Tên SP: <form:input path="name" /><br>
  Giá: <form:input path="price" /><br>
  <input type="submit" value="Thêm sản phẩm" />
</form:form>
</body>
</html>
