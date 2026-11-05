<%--
  Created by IntelliJ IDEA.
  User: hangnt
  Date: 4/11/26
  Time: 19:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%--Muon truyen du lieu => BAT BUOC PHAI DAT FORM --%>
<form method="POST" action="/ket-qua">
    <label>MSSV</label>
    <input type="text" name="mssv"> <br>
    <label>Ten</label>
    <input type="text" name="ten"> <br>
    <label>Tuoi</label>
    <input type="number" name="tuoi"> <br>
    <label>GioiTinh</label>
    <input type="radio" name="gioiTinh" value="male"> nam
    <input type="radio" name="gioiTinh" value="female"> nu
    <br>
    <label>Chuyen Nganh</label>
    <select name="chuyenNganh">
        <option value="udpm">ung dung phan mem</option>
        <option value="qtkd">quan tri kinh doanh</option>
        <option value="tkdh">thiet ke do hoa</option>
    </select>
    <br>
    <button type="submit">Dang Ki</button>
</form>
</body>
</html>
