<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title></title>
</head>
<body>

<form method="get" action="">
  <select name="lang" onchange="this.form.submit()">
    <option value="vi" ${cookie.lang.value == 'vi' ? 'selected' : ''}>Tiếng Việt</option>
    <option value="en" ${cookie.lang.value == 'en' ? 'selected' : ''}>English</option>
  </select>
</form>
</body>
</html>
