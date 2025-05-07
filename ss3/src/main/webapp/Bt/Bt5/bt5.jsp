<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String username = request.getParameter("username");
    String password = request.getParameter("password");
    String email = request.getParameter("email");
    boolean isPost = false;
    if(username != null && password != null && email != null) {
        application.setAttribute("username", username);
        application.setAttribute("password", password);
        application.setAttribute("email", email);
        isPost = true;
    }
%>
<html>
<head>
    <title>Đăng ký</title>
</head>
<body>
    <h1>Đăng ký tài khoản</h1>
    <form method="post">
        <label for="username">Tên đăng nhập:</label>
        <input type="text" id="username" name="username" required><br><br>

        <label for="password">Mật khẩu:</label>
        <input type="password" id="password" name="password" required><br><br>

        <label for="email">Email:</label>
        <input type="email" id="email" name="email" required><br><br>

        <input type="submit" value="Đăng ký">
    </form>
    <% if (isPost) { %>
    <h3>Đăng ký thành công!</h3>
    <% } %>
</body>
</html>
