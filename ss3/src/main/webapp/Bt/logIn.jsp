<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String username = request.getParameter("username");
    String password = request.getParameter("password");
    String age = request.getParameter("age");


    if(username != null && password != null && age != null) {
        application.setAttribute("username", username);
        application.setAttribute("password", password);
        application.setAttribute("age", age);
    }
%>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form action="login" method="post">
        <label for="username">Username:</label>
        <input type="text" id="username" name="username"><br><br>

        <label for="password">Password:</label>
        <input type="password" id="password" name="password"><br><br>

        <label for="age">Age:</label>
        <input type="text" id="age" name="age"><br><br>

        <input type="submit" value="Login">
    </form>
</body>
</html>
