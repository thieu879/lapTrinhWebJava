<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Kết quả đăng ký</title>
</head>
<body>
<h2>Kết quả đăng ký vé xe</h2>

<%
    Boolean isSuccess = (Boolean) request.getAttribute("isSuccess");
    if (isSuccess == null) {
%>
<p>Lỗi hệ thống. Vui lòng thử lại!</p>
<%
} else if (isSuccess) {
%>
<p>Đăng ký thành công!</p>
<p>Họ và tên: <%= request.getAttribute("fullName") %></p>
<p>Lớp: <%= request.getAttribute("studentClass") %></p>
<p>Loại xe: <%= request.getAttribute("vehicleType") %></p>
<p>Biển số xe: <%= request.getAttribute("licensePlate") %></p>
<%
} else {
%>
<p>Đăng ký thất bại. Vui lòng kiểm tra lại thông tin!</p>
<%
    }
%>

<a href="/Bt6">Quay lại form</a>
</body>
</html>