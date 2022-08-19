<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<!DOCTYPE html>

<html>
<head>
    <meta charset="ISO-8859-1">
    <link rel="stylesheet" type="text/css" href="${contexPath}/css/style.css">
    <link rel="stylesheet" type="text/css" href="${contexPath}/css/table.css">
    <title>CheckIn</title>
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

<div id="content-pane">
    <h1>DATA CHECKIN</h1>
    <form:form action="/searchCheckIn" modelAttribute="cari" method="POST">
        <form:input type="text" path="cari"  class="search" placeholder="Masukan kata kunci"/>
        <form:button class="button" type="submit">Cari</form:button>
        <form:button class="button" type="submit">
            <c:url var="insert" value="/insertCheckIn">
            </c:url>
            <a href="${insert}">
                Tambah
            </a>
        </form:button>

    </form:form>


    <table border="1" class="table1" style="margin-left:auto;margin-right:auto">
        <tr>
            <th>id</th>
            <th>tipe kamar</th>
            <th>fasilitas</th>
            <th>Nama Karyawan</th>
            <th>Nama pengunjung</th>
            <th>Lama menginap</th>
            <th>Aksi</th>
        </tr>
        <c:forEach var="CheckIn" items="${CheckIn}">
            <tr>
                <td>${CheckIn.id}</td>
                <td>${CheckIn.tipe_kamar}</td>
                <td>${CheckIn.fasilitas}</td>
                <td>${CheckIn.nama_karyawan}</td>
                <td>${CheckIn.nama_pengunjung}</td>
                <td>${CheckIn.lama_menginap}</td>

            <td>

                    <button class="button" type="submit">
                    <c:url var="updateDataCheckIn" value="/updateDataCheckIn">
                        <c:param name="id" value="${CheckIn.id}"/>
                    </c:url>
                    <a href="${updateDataCheckIn}">Ubah</a>
                    </button>

                <button class="button" type="submit">
                <c:url var="deleteDataCheckIn" value="/deleteDataCheckIn">
                    <c:param name="id" value="${CheckIn.id}"/>
                    </c:url>
                    <a href="${deleteDataCheckIn}">Hapus</a>
                </button>

            </td>
            </tr>

        </c:forEach>

    </table>
</div>

</body>
</html>