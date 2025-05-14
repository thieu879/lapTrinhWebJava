<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
  <title>Thêm nhân viên</title>
</head>
<body>
<h2>Thêm nhân viên mới</h2>

<form action="${pageContext.request.contextPath}/employees" method="post">
  <label>Tên:</label><br>
  <input type="text" name="name" required><br><br>

  <label>Email:</label><br>
  <input type="email" name="email" required><br><br>

  <label>Vị trí:</label><br>
  <input type="text" name="position" required><br><br>

  <button type="submit">Thêm</button>
</form>

<p><a href="${pageContext.request.contextPath}/employees">Quay lại danh sách</a></p>
</body>
</html>
