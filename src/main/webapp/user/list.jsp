<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>User Management Application</title>
</head>
<body>
<center>
    <h1>User Management</h1>
</center>
<div align="center">
    <form>
        <table border="1" cellpadding="5">
            <caption><h2>List of Users</h2></caption>
            <tr>
                <th>Id</th>
                <th>Name</th>
                <th>Province</th>
            </tr>
            <c:forEach var="user" items="${requestScope.users}">
                <tr>
                    <td><c:out value="${user.id}"/></td>
                    <td><c:out value="${user.name}"/></td>
                    <td><c:out value="${user.province.name}"/></td>
                </tr>
            </c:forEach>
        </table>
    </form>
</div>
</body>
</html>
