<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<jsp:include page="header.jsp"/>
<h2>Đăng nhập</h2>
<form>
  <label>username: </label>
  <input type="text" name="username" required>
  <br>
  <label>password: </label>
  <input type="password" name="password" required>
  <br>
  <input type="submit" value="Đăng nhập">
</form>
</body>
</html>
