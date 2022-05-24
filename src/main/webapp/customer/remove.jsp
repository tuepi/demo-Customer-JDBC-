<%--
  Created by IntelliJ IDEA.
  User: hongh
  Date: 23/05/2022
  Time: 1:36 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Delete</title>
</head>
<body>
<form method="post">
    <table border="1">
        <h3>Customer Detail</h3>
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Email</th>
            <th>Address</th>
        </tr>
        <tr>
            <td>${customerRemove.id}</td>
            <td>${customerRemove.name}</td>
            <td>${customerRemove.email}</td>
            <td>${customerRemove.address}</td>
        </tr>
    </table>
    <button>DELETE</button>
</form>
<form action="/customers">
    <button>CANCEL</button>
</form>
</body>
</html>
