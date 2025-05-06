<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Đăng ký vé xe</title>
</head>
<body>
<h2>Form Đăng Ký Vé Xe</h2>
<form action="Bt6" method="post">
    <label>Họ và tên:</label><br>
    <input type="text" name="fullName" required><br><br>

    <label>Lớp:</label><br>
    <input type="text" name="studentClass" required><br><br>

    <label>Loại xe:</label><br>
    <input type="text" name="vehicleType" required><br><br>

    <label>Biển số xe:</label><br>
    <input type="text" name="licensePlate" required><br><br>

    <input type="submit" value="Đăng ký">
</form>
</body>
</html>
