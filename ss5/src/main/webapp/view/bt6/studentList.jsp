<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>log out</title>
</head>
<body>
<p>Xin chào, <%= session.getAttribute("user") %>!</p>
<a href="/logout">Đăng xuất</a>
</body>
</html>
