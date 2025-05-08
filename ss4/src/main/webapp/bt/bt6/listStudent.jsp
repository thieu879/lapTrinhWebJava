<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <table border="1">
        <tr>
            <th>id</th>
            <th>name</th>
            <th>Điểm</th>
            <th>Địa chỉ</th>
        </tr>
        <c:forEach items="${studentList}" var="student">
            <tr>
                <td>${student.id}</td>
                <td>${student.name}</td>
                <td>${student.point}</td>
                <td>${student.address}</td>
            </tr>
        </c:forEach>
    </table>
<h1>Tổng số sinh viên có số điểm trung bình lớn hơn 7.0 là: ${count}</h1>
</body>
</html>
