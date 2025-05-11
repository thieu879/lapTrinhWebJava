<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html><body>
<h2>Danh sách liên hệ</h2>
<a href="contacts?action=add">Thêm liên hệ mới</a>
<table border="1">
    <tr><th>Họ</th><th>Tên</th><th>Email</th><th>Điện thoại</th><th>Hành động</th></tr>
    <c:forEach var="c" items="${contacts}">
        <tr>
            <td>${c.firstName}</td>
            <td>${c.lastName}</td>
            <td>${c.email}</td>
            <td>${c.phone}</td>
            <td>
                <a href="contacts?action=edit&id=${c.id}">Sửa</a>
                <form action="contacts" method="post" style="display:inline;">
                    <input type="hidden" name="action" value="delete"/>
                    <input type="hidden" name="id" value="${c.id}"/>
                    <input type="submit" value="Xóa" onclick="return confirm('Bạn có chắc muốn xóa?');"/>
                </form>
            </td>
        </tr>
    </c:forEach>
</table>
</body></html>
