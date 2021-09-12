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
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<body class="container pt-4">
    <h1>Book Authors</h1>
    <hr>
    <main class="row">
        <section class="col-4">
            <div class="card">
                <div class="card-header">
                    Register an Author
                </div>
                <div class="card-body">
                    <form method="post">
                        <div class="mb-3">
                            <label class="form-label" for="name">Name:</label>
                            <input class="form-control" type="text" name="name" id="name">
                            <div id="nameHelp" class="form-text">Please inform the author's name</div>
                        </div>
                        <div class="mb-3">
                            <label class="form-label" for="email">E-mail:</label>
                            <input class="form-control" type="email" name="email" id="email">
                            <div id="emailHelp" class="form-text">Please inform the public author's email</div>
                        </div>
                        <div class="mb-3">
                            <label class="form-label" for="birthday">Birthday:</label>
                            <input class="form-control" type="date" name="birthday" id="birthday">
                            <div id="birthdayHelp" class="form-text">Please inform Author's birthday</div>
                        </div>
                        <div class="mb-3">
                            <label class="form-label" for="resume">Resume:</label>
                            <textarea class="form-control" name="resume" id="resume"></textarea>
                            <div id="resumeHelp" class="form-text">Please inform Author's resume</div>
                        </div>
                        <div class="mb-3">
                            <button class="btn btn-dark" type="submit">Register</button>
                        </div>
                    </form>
                </div>
            </div>
        </section>
        <section class="col-8">
            <div class="card">
                <div class="card-header">
                    Author's list
                </div>
                <div class="card-body">
                    <table class="table">
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
                </div>
            </div>
        </section>
    </main>
</body>
</html>
