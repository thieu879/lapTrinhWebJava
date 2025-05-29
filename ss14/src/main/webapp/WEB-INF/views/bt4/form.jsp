<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/add" method="post">
    Tên sản phẩm: <input type="text" name="name" required/>
    Số lượng: <input type="number" name="quantity" required/>
    <input type="submit" value="Thêm vào giỏ hàng"/>
</form>

<h3>Sản phẩm đã lưu trong Cookie:</h3>
<ul>
    <c:forEach var="p" items="${cookieProducts}">
        <li>${p.name} - ${p.quantity}</li>
    </c:forEach>
</ul>
</body>
</html>
