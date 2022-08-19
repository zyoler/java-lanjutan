<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<!DOCTYPE html>

<html>
<head>
    <meta charset="ISO-8859-1">
    <link rel="stylesheet" type="text/css" href="${contexPath}/css/style.css">
    <title>begin</title>
</head>
<body>
<div class="navbar">
    <c:url var="pengunjung" value="/pengunjung">
    </c:url>
    <a href="${pengunjung}">
        Data Pengunjung
    </a>
    <c:url var="kamar" value="/kamar">
    </c:url>
    <a href="${kamar}">
        Data Kamar
    </a>
    <c:url var="checkIn" value="/checkIn">
    </c:url>
    <a href="${checkIn}">
        Data Checkin
    </a>
    <c:url var="admin" value="/admin">
    </c:url>
    <a href="${admin}">
        Data Admin
    </a>
    <c:url var="karyawan" value="/karyawan">
    </c:url>
    <a href="${karyawan}">
        Data Karyawan
    </a>
    <a href="/begin" id="judul">Hotellope</a>
</div>
<div align="center" id="div">
    <BR><BR><BR><BR><BR><BR><BR><BR><BR><BR>
    <h1>Selamat Datang Admin.. <BR> Yuk CRUD data </h1>
</div>

</body>
</html>