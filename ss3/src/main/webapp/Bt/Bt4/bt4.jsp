<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
  int number1 = request.getParameter("number1") != null ? Integer.parseInt(request.getParameter("number1")) : 0;
    int number2 = request.getParameter("number2") != null ? Integer.parseInt(request.getParameter("number2")) : 0;
    int sum = number1 + number2;
%>
<html>
<head>
    <title>Tính toán phép cộng</title>
</head>
<body>
    <form method="post">
        <label for="number1">Số thứ nhất:</label>
        <input type="text" id="number1" name="number1"><br><br>

        <label for="number2">Số thứ hai:</label>
        <input type="text" id="number2" name="number2"><br><br>

        <input type="submit" value="Tính tổng">
    </form>
    <h2>Kết quả:</h2>
    <p><%= number1 %> + <%= number2 %> = <%= sum %></p>
</body>
</html>
