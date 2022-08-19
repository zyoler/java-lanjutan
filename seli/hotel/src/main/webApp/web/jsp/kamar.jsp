<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<!DOCTYPE html>

<html>
<head>
    <meta charset="ISO-8859-1">
    <link rel="stylesheet" type="text/css" href="${contexPath}/css/style.css">
    <link rel="stylesheet" type="text/css" href="${contexPath}/css/table.css">
    <title>Data Kamar</title>
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
    </a>    <a href="/begin" id="judul">Hotellope</a>
</div>

<div id="content-pane">

   <h1>Data Kamar</h1>
    <form:form action="/searchKamar" modelAttribute="cari" method="POST">
        <form:input type="text" path="cari"  class="search" placeholder="Masukan kata kunci"/>
        <form:button class="button" type="submit">Cari</form:button>
        <form:button class="button" type="submit">
            <c:url var="insert" value="/insertKamar">
            </c:url>
            <a href="${insert}">
                Tambah
            </a>
        </form:button>

    </form:form>

    <table border="1" class="table1" style="margin-left:auto;margin-right:auto">
        <tr>
            <th>Id</th>
            <th>Tipe Kamar</th>
            <th>Fasilitas</th>
            <th>Harga</th>
            <th>Kapasitas</th>
            <th>Status</th>
            <th>Aksi</th>
        </tr>
        <c:forEach var="Kamar" items="${Kamar}">
            <tr>
                <td>${Kamar.id}</td>
                <td>${Kamar.tipe_kamar}</td>
                <td>${Kamar.fasilitas}</td>
                <td>${Kamar.harga}</td>
                <td>${Kamar.kapasitas}</td>
                <td>${Kamar.status}</td>
                <td>
                    <button class="button" type="submit">
                    <c:url var="updateDataKamar" value="/updateDataKamar">
                        <c:param name="id" value="${Kamar.id}"/>
                    </c:url>
                    <a href="${updateDataKamar}">Ubah</a>
                    </button>
                    <button class="button" type="submit">
                    <c:url var="deleteDataKamar" value="/deleteDataKamar">
                        <c:param name="id" value="${Kamar.id}"/>
                    </c:url>
                    <a href="${deleteDataKamar}">Hapus</a>
                    </button>
                </td>
            </tr>
        </c:forEach>

    </table>
</div>

</body>
</html>