<%@page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>

<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Mahasiswa</title>
</head>
<body>
<h1>Insert Data Mahasiswa</h1>
<form:form id="mhs" action="/saveBook" modelAttribute="mhsDto" method="POST">
    <table>
        <tr>
            <td>NIM :</td>
            <td>
                <form:input path="title" type="text" placeholder="Masukan title"/>
            </td>
        </tr>
        <tr>
            <td>NIM :</td>
            <td>
                <form:input path="isbn" type="text" placeholder="Masukan title"/>
            </td>
        </tr>
        <tr>
            <td>NIM :</td>
            <td>
                <form:input path="total_pages" type="text" placeholder="Masukan title"/>
            </td>
        </tr>
        <tr>
            <td>NIM :</td>
            <td>
                <form:input path="rating" type="text" placeholder="Masukan title"/>
            </td>
        </tr>
        <tr>
            <td>NIM :</td>
            <td>
                <form:input path="published_date" type="text" placeholder="Masukan title"/>
            </td>
        </tr>
        </table>
</form:form>
</body>
</html>