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
    <c:url var="menuUser" value="/insertCheckInUser">
    </c:url>
    <a href="${menuUser}">
        CheckIn
    </a>
    <a href="/begin" id="judul">Hotellope</a>
</div>
<div align="center" id="div">
    <BR><BR><BR><BR><BR><BR><BR><BR><BR><BR>
    <h1>Cari Penginapan Murah ? Yuk CheckIn aja di Hotellope</h1>
</div>

</body>
</html>