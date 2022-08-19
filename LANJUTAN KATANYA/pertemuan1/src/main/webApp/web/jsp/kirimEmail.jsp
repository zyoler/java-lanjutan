<%@page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>

<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Send Email</title>
</head>
<body>
<h1>Send Email</h1>
<form:form id="email" action="/saveEmail" modelAttribute="mailRequestDto" method="POST">
    <table>
        <tr>
            <td>Nama :</td>
            <td>
                <form:input path="nama" type="text" placeholder="Masukan Nama"/>
            </td>
        </tr>
        <tr>
            <td>NIM :</td>
            <td>
                <form:input path="nim" type="text" placeholder="Masukan NIM"/>
            </td>
        </tr>
        <tr>
            <td>Jenis Kelamin :</td>
            <td>
                <form:radiobutton path="jenis_kelamin" value="perempuan"/>Perempuan
                <form:radiobutton path="jenis_kelamin" value="laki laki"/>Laki laki
            </td>
        </tr>
        <tr>
            <td>Email To :</td>
            <td>
                <form:input path="to" type="text" placeholder="Masukan Email"/>
            </td>
        </tr>
        <tr>
            <td>
                <form:button type="submit" id="save" >Submit</form:button>
            </td>

        </tr>
    </table>
</form:form>
</body>
</html>