<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head><title>Đăng ký</title></head>
<body>
<h2>Form đăng ký</h2>
<form action="/register" method="post">
    Tên: <input type="text" name="name" value="${user.name}"/> <br/>
    <span style="color:red"><c:out value="${errors.name}"/></span><br/>

    Email: <input type="text" name="email" value="${user.email}"/> <br/>
    <span style="color:red"><c:out value="${errors.email}"/></span><br/>

    Số điện thoại: <input type="text" name="phone" value="${user.phone}"/> <br/>
    <span style="color:red"><c:out value="${errors.phone}"/></span><br/>

    <input type="submit" value="Đăng ký"/>
</form>
</body>
</html>

