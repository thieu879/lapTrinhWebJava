<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.example.ss1.bt8.Task" %>
<%@ page import="java.util.List" %>
<html>
<head>
  <title>To-Do List</title>
  <style>
    body { font-family: Arial, sans-serif; margin: 0; }
    .navbar { background-color: #4B0082; padding: 10px; }
    .navbar a { color: white; margin: 0 15px; text-decoration: none; }
    .navbar a:hover { text-decoration: underline; }
    .container { margin: 20px; }
    .form-group { margin-bottom: 20px; }
    input[type="text"] { padding: 5px; width: 300px; }
    input[type="submit"] { padding: 5px 15px; background: #4B0082; color: white; border: none; cursor: pointer; }
    input[type="submit"]:hover { background: #6A0DAD; }
    table { width: 100%; border-collapse: collapse; }
    th, td { border: 1px solid #ddd; padding: 8px; text-align: left; }
    th { background-color: #4B0082; color: white; }
    tr:nth-child(even) { background-color: #f9f9f9; }
    tr.doing { background-color: #FFFF99; }
    .status-btn { padding: 5px; background: #FFFF99; border: none; cursor: pointer; }
    .status-btn:hover { background: #FFD700; }
  </style>
</head>
<body>
<div class="navbar">
  <a href="#">Trang chủ</a>
  <a href="#">Liên hệ</a>
  <a href="#">Giỏ hàng</a>
  <a href="#">Tài khoản</a>
</div>
<div class="container">
  <div class="form-group">
    <form action="todo" method="post">
      <input type="text" name="jobName" placeholder="Enter new job" required>
      <input type="hidden" name="action" value="add">
      <input type="submit" value="Add">
    </form>
  </div>
  <table>
    <tr>
      <th>ID</th>
      <th>Job Name</th>
      <th>Status</th>
      <th>Action</th>
    </tr>
    <%
      List<Task> taskList = (List<Task>) request.getAttribute("taskList");
      if (taskList != null) {
        for (Task task : taskList) {
          String rowClass = "Doing".equals(task.getStatus()) ? "doing" : "";
    %>
    <tr class="<%= rowClass %>">
      <td><%= task.getId() %></td>
      <td><%= task.getJobName() %></td>
      <td><%= task.getStatus() %></td>
      <td>
        <form action="todo" method="post" style="display:inline;">
          <input type="hidden" name="action" value="changeStatus">
          <input type="hidden" name="taskId" value="<%= task.getId() %>">
          <input type="submit" value="Change status" class="status-btn">
        </form>
      </td>
    </tr>
    <%
        }
      }
    %>
  </table>
</div>
</body>
</html>