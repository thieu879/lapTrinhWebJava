<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
  <title>Danh sách nhân viên</title>
</head>
<body>
<h2>Danh sách nhân viên</h2>

<c:if test="${not empty message}">
  <p style="color: green;">${message}</p>
</c:if>

<a href="${pageContext.request.contextPath}/employees/add">Thêm nhân viên mới</a>

<table border="1" cellpadding="10">
  <tr>
    <th>Tên</th>
    <th>Email</th>
    <th>Vị trí</th>
  </tr>
  <c:forEach var="employee" items="${employees}">
    <tr>
      <td>${employee.name}</td>
      <td>${employee.email}</td>
      <td>${employee.position}</td>
    </tr>
  </c:forEach>
</table>
</body>
</html>

