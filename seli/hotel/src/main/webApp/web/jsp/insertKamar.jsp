<%@page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>

<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Insert Kamar</title>
    <link rel="stylesheet" type="text/css" href="${contexPath}/css/table.css">
</head>
<body class="body">
<div class="container" align="center">
    <h1>Insert Data Kamar</h1>
    <form:form id="kamar" action="/saveKamar" modelAttribute="kamarDto" method="POST">
        <table class="tab">
            <tr>
                <td>Tipe Kamar</td>
                <td>
                    <form:input class="input" path="tipe_kamar" type="text" placeholder="Masukan tipe kamar"/>
                </td>
            </tr>

            <tr>
                <td>Fasilitas</td>
                <td>
                    <form:input class="input" path="fasilitas" type="text" placeholder="Masukan fasilitas"/>
                </td>
            </tr>
            <tr>
                <td>Harga :</td>
                <td>
                    <form:input class="input" path="harga" type="text" placeholder="Masukan Harga"/>
                </td>
            </tr>
            <tr>
                <td>Kapasitas :</td>
                <td>
                    <form:input class="input" path="kapasitas" type="text" placeholder="Masukan Kapasitas"/>
                </td>
            </tr>
            <tr>
                <td>Status :</td>
                <td>
                    <form:radiobutton path="status" value="tersedia"/>
                    Tersedia
                    <form:radiobutton path="status" value="kosong"/>
                    Kosong
                </td>
            </tr>
            <td colspan="2">
                <form:button class="buttonSimpan" type="submit" id="save">Simpan</form:button>
            </td>
            </tr>
        </table>
    </form:form>

</div>
</body>
</html>
