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
<form:form id="regis" action="/doRegis" modelAttribute="registrasi" method="POST">
    <table>
        <tr>
            <td>Nama : </td>
            <td>
                <form:input path="nama" type="text" placeholder="Masukan Nama"/>
            </td>
        </tr>
        <tr>
            <td>Alamat :</td>
            <td>
                <form:input path="alamat" type="text" placeholder="Masukan Alamat"/>
            </td>
        </tr>
        <tr>
            <td>No hp :</td>
            <td>
                <form:input path="nohp" type="text" placeholder="11-13 angka"/>
            </td>
        </tr>
        <tr>
            <td>Email :</td>
            <td>
                <form:input path="email" type="email" placeholder="Masukan Email"/>
            </td>
        </tr>
        <tr>
            <td>Username :</td>
            <td>
                <form:input path="username" type="text" placeholder="Masukan Username"/>
            </td>
        </tr>
        <tr>
            <td>Password :</td>
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