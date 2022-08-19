<%@page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>

<html>
<head>
    <meta charset="ISO-8859-1">
    <title>User</title>

    <link rel="stylesheet" type="text/css" href="${contexPath}/css/login.css">
</head>
<body>
<div class="container">
    <h1>SIGN IN</h1>
<form:form id="user" action="/saveUser" modelAttribute="userDto" method="POST">
                <Label>Username</Label>
                <form:input path="username" type="text" placeholder="Masukan Username"/>
                <Label>Password</Label>
                <form:input path="password" type="text" placeholder="Masukan Password"/>
                <Label>Email</Label>
                <form:input path="email" type="text" placeholder="Masukan email"/>
                <form:button type="submit" id="save">Sign in</form:button>
</form:form>
</div>
</body>
</html>
