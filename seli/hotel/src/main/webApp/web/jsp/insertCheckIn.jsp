<%@page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>

<html>
<head>
    <meta charset="ISO-8859-1">
    <title>CheckIn</title>
    <link rel="stylesheet" type="text/css" href="${contexPath}/css/table.css">
</head>
<body class="body">
<div class="container" align="center">
    <h1>Insert Data CheckIn </h1>

    <form:form id="checkIn" action="/saveCheckIn" modelAttribute="checkInDto" method="POST">
        <table class="tab">
            <tr>
                <td>Tipe Kamar</td>
                <td>
                    <form:select class="input" path="tipe_kamar" >

                        <c:forEach var="t" items="${listKamar}">
                            <form:option value="${t.tipe_kamar}">${f.tipe_kamar}</form:option>
                        </c:forEach>
                    </form:select>
                </td>
            </tr>

            <tr>
                <td>Fasilitas</td>
                <td>
                    <form:select class="input" path="fasilitas" >

                        <c:forEach var="f" items="${listKamar}">
                            <form:option value="${f.fasilitas}">${f.fasilitas}</form:option>
                        </c:forEach>
                    </form:select>
                </td>
            </tr>
            <tr>
                <td>Nama Karyawan :</td>
                <td>
                    <form:select class="input" path="nama_karyawan" >

                        <c:forEach var="k" items="${listKaryawan}">
                            <form:option value="${k.nama_karyawan}">${k.nama_karyawan}</form:option>
                        </c:forEach>
                    </form:select>
                </td>
            </tr>
            <tr>
                <td>Nama Pengunjung :</td>
                <td>
                    <form:select class="input" path="nama_pengunjung" >

                        <c:forEach var="p" items="${listPengunjung}">
                            <form:option value="${p.nama_pengunjung}">${p.nama_pengunjung}</form:option>
                        </c:forEach>
                    </form:select>
                </td>
            </tr>
            <tr>
                <td>Lama Menginap :</td>
                <td>
                    <form:input class="input" path="lama_menginap" type="text" placeholder="Masukan lama menginap" />
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
