<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head><title>Task List</title></head>
<body>
<h2>Danh sách công việc</h2>
<a href="tasks?action=add">Thêm công việc</a>
<table border="1">
  <tr>
    <th>ID</th><th>Mô tả</th><th>Hạn</th><th>Hoàn thành</th><th>Hành động</th>
  </tr>
  <c:forEach var="task" items="${tasks}">
    <tr>
      <td>${task.id}</td>
      <td>${task.description}</td>
      <td>${task.dueDate}</td>
      <td>${task.completed ? "v" : "x"}</td>
      <td>
        <a href="tasks?action=edit&id=${task.id}">Sửa</a>
        <form action="tasks?action=delete" method="post" style="display:inline;">
          <input type="hidden" name="id" value="${task.id}">
          <input type="submit" value="Xóa">
        </form>
      </td>
    </tr>
  </c:forEach>
</table>
</body>
</html>
