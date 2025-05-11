<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html><body>
<h2><c:if test="${contact != null}">Chỉnh sửa liên hệ</c:if><c:if test="${contact == null}">Thêm liên hệ</c:if></h2>
<form action="contacts" method="post">
  <input type="hidden" name="action" value="${contact != null ? 'update' : 'create'}"/>
  <c:if test="${contact != null}">
    <input type="hidden" name="id" value="${contact.id}"/>
  </c:if>
  Họ: <input type="text" name="firstName" value="${contact.firstName}"/><br/>
  Tên: <input type="text" name="lastName" value="${contact.lastName}"/><br/>
  Email: <input type="email" name="email" value="${contact.email}"/><br/>
  SĐT: <input type="text" name="phone" value="${contact.phone}"/><br/>
  <input type="submit" value="${contact != null ? 'Cập nhật' : 'Thêm mới'}"/>
</form>
</body></html>
