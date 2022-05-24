<%--
  Created by IntelliJ IDEA.
  User: hongh
  Date: 23/05/2022
  Time: 2:10 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit</title>
</head>
<body>
<form method="post">
    <h2>Edit Customer</h2>
    ID = ${customerEdit.id}
    <input type="text" name="name" value='${customerEdit.name}'>
    <input type="email" name="email" value='${customerEdit.email}'>
    <input type="text" name="address" value='${customerEdit.address}'>
    <button>EDIT</button>
</form>
</body>
</html>
