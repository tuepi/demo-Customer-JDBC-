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
    <title>View</title>
</head>
<body>
<table border="1">
    <h3>Customer Detail</h3>
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Email</th>
        <th>Address</th>
    </tr>
    <tr>
        <td>${customerView.id}</td>
        <td>${customerView.name}</td>
        <td>${customerView.email}</td>
        <td>${customerView.address}</td>
    </tr>
</table>
</body>
</html>
