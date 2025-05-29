<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Thêm sản phẩm</title>
    <style>
        .error {color:red;}
    </style>
</head>
<body>
<h2>Thêm sản phẩm mới</h2>

<form:form method="post" modelAttribute="product">
    Tên SP: <form:input path="name" />
    <form:errors path="name" cssClass="error" /><br/>

    Giá: <form:input path="price" />
    <form:errors path="price" cssClass="error" /><br/>

    <input type="submit" value="Thêm sản phẩm" />
</form:form>

<a href="<c:url value='/product/list' />">Xem danh sách sản phẩm</a>

</body>
</html>
