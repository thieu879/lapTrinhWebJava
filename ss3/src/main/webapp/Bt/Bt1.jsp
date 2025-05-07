<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%!
    String userInfor(String name, String email) {
        return "Name: " + name + ", Email: " + email;
    }
%>
<html>
<head>
    <title>Bt1</title>
</head>
<body>
    <h1>Thông tin ngươời dùng</h1>
    <p> <%= userInfor("Thiều", "nguyenthieu1102@gmail.com")%> </p>
</body>
</html>
