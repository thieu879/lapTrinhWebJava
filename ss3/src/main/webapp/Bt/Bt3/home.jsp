<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
  if ("post".equalsIgnoreCase(request.getMethod())) {
    response.sendRedirect("welcome.jsp");
    return;
  }
%>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form method="post">
      <input type="submit">
    </form>
</body>
</html>
