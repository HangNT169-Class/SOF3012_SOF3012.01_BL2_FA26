<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<select>
    <c:forEach items="${listLoaiPhieu}" var="loaiPhieu">
        <option>${loaiPhieu.ten}</option>
    </c:forEach>
</select>
<table>
    <thead>
    <tr>
        <th>STT</th>
        <th>Ma phieu</th>
        <th>Ten phieu</th>
        <th>So luong</th>
        <th>Loai giam</th>
        <th>Ma loai phieu</th>
        <th>Ten loai phieu</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${listPhieu}" var="phieu" varStatus="i">
        <tr>
            <td>${i.index}</td>
            <td>${phieu.ma}</td>
            <td>${phieu.ten}</td>
            <td>${phieu.soLuong}</td>
            <td>${phieu.loaiGiam}</td>
            <td>${phieu.loaiPhieu.ma}</td>
            <td>${phieu.loaiPhieu.ten}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
