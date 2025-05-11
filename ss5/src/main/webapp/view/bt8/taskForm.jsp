<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head><title>Thêm/Sửa Công Việc</title></head>
<body>
<h2>${task != null ? "Sửa công việc" : "Thêm công việc"}</h2>
<form action="tasks" method="post">
  <input type="hidden" name="action" value="${task != null ? 'update' : 'create'}" />
  <c:if test="${task != null}">
    <input type="hidden" name="id" value="${task.id}" />
  </c:if>
  Mô tả: <input type="text" name="description" value="${task.description}" required /><br/>
  Hạn: <input type="text" name="dueDate" value="${task.dueDate}" required /><br/>
  <c:if test="${task != null}">
    Hoàn thành: <input type="checkbox" name="completed" ${task.completed ? "checked" : ""} /><br/>
  </c:if>
  <input type="submit" value="${task != null ? 'Cập nhật' : 'Thêm'}" />
</form>
<a href="tasks">Quay lại danh sách</a>
</body>
</html>
