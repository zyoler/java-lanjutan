<%@page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>

<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Login</title>
    <style>
        body{
            background-color: lightblue;
        }
        .tengah{
            text-align: center;
        }
    </style>
</head>
<body class="tengah">
<h1>Registrasi Pelanggan</h1>
<form:form id="regis" action="/doLogin" modelAttribute="login" method="POST">
    <table>
        <tr>
            <td>Username :</td>
            <td>
                <form:input path="username" type="text" placeholder="Masukan Username"/>
            </td>
        </tr>
        <tr>
            <td>Password</td>
            <td>
                <form:input path="password" type="text" placeholder="Masukan Password"/>
            </td>
        </tr>
        <tr>
            <td colspan="2">
                <form:button type="submit" id="save">Simpan</form:button>
            </td>
        </tr>
    </table>
</form:form>
</body>
</html>