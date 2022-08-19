<%@page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>

<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Insert Table</title>
</head>
<body>
<h1>Insert Data Buku</h1>
<form:form id="book" action="/saveBook" modelAttribute="bookDto" method="POST">
    <table>
        <tr>
            <td>title :</td>
            <td>
                <form:input path="title" type="text" placeholder="Masukan title"/>
            </td>
        </tr>
        <tr>
            <td>Isbn :</td>
            <td>
                <form:input path="isbn" type="text" placeholder="Masukan isbn"/>
            </td>
        </tr>
        <tr>
            <td>Total Pages :</td>
            <td>
                <form:input path="total_pages" type="text" placeholder="Masukan title"/>
            </td>
        </tr>
        <tr>
            <td>Rating :</td>
            <td>
                <form:input path="rating" type="text" placeholder="Masukan title"/>
            </td>
        </tr>
        <tr>
            <td>Published date :</td>
            <td>
                <form:input path="published_date" type="text" placeholder="Masukan title"/>
            </td>
        </tr>
        <tr>
            <td>Id photo :</td>
            <td>
                <form:input path="id_photo" type="text" placeholder="Masukan id photo"/>
            </td>
        </tr>
        <form:button type="submit" id="save" >Simpan</form:button>
    </table>
</form:form>
</body>
</html>