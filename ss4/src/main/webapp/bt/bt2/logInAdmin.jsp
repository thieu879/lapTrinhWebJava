<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Log In</title>
</head>
<body>
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
    <c:if test="${not empty param.username}">
        <c:choose>
            <c:when test="${param.username == 'admin' && param.password == '123456'}">
                <h3>Đăng nhập thành công</h3>
                <p>Xin chào <b>${param.username}!</b></p>
            </c:when>
            <c:otherwise>
                <h3>Đăng nhập thất bại</h3>
                <p>Vui lòng kiểm tra lại thông tin đăng nhập.</p>
            </c:otherwise>
        </c:choose>
    </c:if>
</body>
</html>
