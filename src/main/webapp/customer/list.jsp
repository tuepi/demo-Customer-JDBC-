<%--
  Created by IntelliJ IDEA.
  User: hongh
  Date: 22/05/2022
  Time: 11:02 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Customer List</title>
</head>
<body>
<h1>Customers</h1>
<p>
    <a href="/customers?action=creat">Create new customer</a>
</p>
<table border="1">
    <tr>
        <th>Name</th>
        <th>Address</th>
        <th>Edit</th>
        <th>Delete</th>
    </tr>
    <c:forEach items='${customers}' var="customer">
        <tr>
            <td><a href="/customers?action=view&id=${customer.getId()}">${customer.getName()}</a></td>
            <td>${customer.getAddress()}</td>
            <td><a href="/customers?action=edit&id=${customer.getId()}">edit</a></td>
            <td><a href="/customers?action=remove&id=${customer.getId()}">delete</a></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
