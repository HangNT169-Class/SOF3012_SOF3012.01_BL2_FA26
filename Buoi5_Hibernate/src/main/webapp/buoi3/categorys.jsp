<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/category/search" method="GET">
    Tên: <input name="ten"/>
    <button type="submit">Search</button>
</form>
<br/>
<button><a href="/category/view-add">Add Cate</a></button>
<table>
    <thead>
    <tr>
        <th>STT</th>
        <th>Ma</th>
        <th>Ten</th>
        <th>Hanh dong</th>
    </tr>
    </thead>
    <tbody>
    <%-- items: dai dien 1 mang
    var: 1 doi tuong => for(doi tuong: mang)
    varStatus: vi tri -> for int i = 0
       --%>
    <c:forEach items="${list1}" var="cate" varStatus="i">
        <tr>
            <td>${i.index}</td>
            <td>${cate.categoryCode}</td>
            <td>${cate.categoryName}</td>
            <td>
                <a href="/category/delete?id1=${cate.id}">Delete</a>
                <a href="/category/detail?a=${cate.id}">Detail</a>
                <a href="/category/view-update?b=${cate.id}">View update</a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
