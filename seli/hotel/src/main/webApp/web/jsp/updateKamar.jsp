<%@page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>

<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Update Data Kamar</title>
    <link rel="stylesheet" type="text/css" href="${contexPath}/css/table.css">
</head>
<body class="body">
<div class="container" align="center">
    <h1>Update Data Kamar</h1>
    <form:form id="kamar" action="/saveUpdateKamar" modelAttribute="kamarDto" method="POST">
        <form:input path="id" type="hidden"/>
        <table class="tab">
            <tr>
                <td>Tipe Kamar</td>
                <td>
                    <select class="input" name="tipe_kamar" id="tipe_kamar">
                        <option value="Single Room">Single Room</option>
                        <option value="Twin Room">Twin Room</option>
                        <option value="Double Room">Double Room</option>
                        <option value="Family Room">Family Room</option>
                    </select>
                </td>
            </tr>

            <tr>
                <td>Fasilitas</td>
                <td>
                    <select class="input" name="fasilitas" id="fasilitas">
                        <option value="Standar">Standar</option>
                        <option value="Superior">Superior</option>
                        <option value="Deluxe">Deluxe</option>
                        <option value="Junior Suite">Junior Suite</option>
                        <option value="Suite">Suite</option>
                        <option value="Presidental Suite">Presidental Suite</option>
                    </select>
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
