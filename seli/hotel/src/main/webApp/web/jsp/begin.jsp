<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<!DOCTYPE html>

<html>
<head>
    <meta charset="ISO-8859-1">
    <link rel="stylesheet" type="text/css" href="${contexPath}/css/style.css">
    <link rel="stylesheet" type="text/css" href="${contexPath}/css/table.css">
    <title>begin</title>
</head>
<body id="body">
<div class="navbar">
    <div class="dropdown">
        <button class="dropbtn">Login
            <i class="fa fa-caret-down"></i>
        </button>
        <div class="dropdown-content">
            <c:url var="login" value="/masuk">
            </c:url>
            <a href="${login}">
                Admin
            </a>
            <c:url var="loginUser" value="/masukUser">
            </c:url>
            <a href="${loginUser}">User</a>
        </div>
    </div>
    <c:url var="insert" value="/insertUser">
    </c:url>
    <a href="${insert}">
        Sign-in
    </a>
    <a href="/begin" id="judul">Hotellope</a>
</div>
<div>

</div>
<div>

</div>
<div align="center" id="div">
<BR><BR><BR><BR><BR><BR><BR><BR><BR><BR>
    <h1>Selamat Datang di Aplikasi Sederhana Hotellope</h1>
</div>

</body>
</html>