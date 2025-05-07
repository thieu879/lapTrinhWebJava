<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    response.setContentType("text/html");
    request.setCharacterEncoding("UTF-8");
    String name = request.getParameter("name");
    String email = request.getParameter("email");
    if (email != null && name != null) {
        application.setAttribute("name", name);
        application.setAttribute("email", email);
    }

    String storedName = (String) application.getAttribute("name");
    String storedEmail = (String) application.getAttribute("email");

%>
<html>
<head>
    <title>Viết thông tin</title>
</head>
<body>
    <form method="post">
        <label for="name">Tên:</label>
        <input type="text" id="name" name="name"><br><br>

        <label for="email">Email:</label>
        <input type="email" id="email" name="email"><br><br>

        <input type="submit" value="Gửi">
    </form>
    <h2>Thông tin đã lưu:</h2>
    <p>Tên: <%= storedName != null ? storedName : "Chưa có thông tin" %></p>
    <p>Email: <%= storedEmail != null ? storedEmail : "Chưa có thông tin" %></p>
</body>
</html>
