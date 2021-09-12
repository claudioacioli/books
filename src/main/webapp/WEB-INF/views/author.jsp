<%--
  Created by IntelliJ IDEA.
  User: claudio
  Date: 12/09/2021
  Time: 11:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Books::Author's list</title>
</head>
<body>
    <h1>Author's list</h1>
    <hr>
    <table border="1">
        <thead>
            <tr>
                <th>Name</th>
                <th>Email</th>
                <th>Birthday</th>
            </tr>
        </thead>
        <tbody>

            <jsp:useBean id="authors" scope="request" type="java.util.List"/>
            <c:forEach items="${authors}" var="author" >
                <tr>
                    <td>${author.name}</td>
                    <td>${author.email}</td>
                    <td>${author.birthday}</td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</body>
</html>
