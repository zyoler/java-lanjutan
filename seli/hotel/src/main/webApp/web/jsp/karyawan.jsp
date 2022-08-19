<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<!DOCTYPE html>

<html>
<head>
    <meta charset="ISO-8859-1">
    <link rel="stylesheet" type="text/css" href="${contexPath}/css/style.css">
    <link rel="stylesheet" type="text/css" href="${contexPath}/css/table.css">
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

<div id="content-pane">
   <h1>DATA KARYAWAN</h1>
    <form:form action="/searchKaryawan" modelAttribute="cari" method="POST">
        <form:input type="text" path="cari"  class="search" placeholder="Masukan kata kunci"/>
        <form:button class="button" type="submit">Cari</form:button>
        <form:button class="button" type="submit">
            <c:url var="insert" value="/insertKaryawan">
            </c:url>
            <a href="${insert}">
                Tambah
            </a>
        </form:button>

    </form:form>

    <table border="1" class="table1" style="margin-left:auto;margin-right:auto">
        <tr>
            <th>Id</th>
            <th>No_ktp</th>
            <th>Nama_karyawan</th>
            <th>Jenis_Kelamin</th>
            <th>Alamat</th>
            <th>Email</th>
            <th>No Telp</th>
            <th>Aksi</th>
        </tr>
        <c:forEach var="Karyawan" items="${Karyawan}">
            <tr>
                <td>${Karyawan.id}</td>
                <td>${Karyawan.no_ktp}</td>
                <td>${Karyawan.nama_karyawan}</td>
                <td>${Karyawan.jenis_kelamin}</td>
                <td>${Karyawan.alamat}</td>
                <td>${Karyawan.email}</td>
                <td>${Karyawan.no_telp}</td>

                <td>
                    <button class="button" type="submit">
                    <c:url var="updateDataKaryawan" value="/updateDataKaryawan">
                        <c:param name="id" value="${Karyawan.id}"/>
                    </c:url>
                    <a href="${updateDataKaryawan}">Ubah</a>
                    </button>
                    <button class="button" type="submit">
                    <c:url var="deleteDataKaryawan" value="/deleteDataKaryawan">
                        <c:param name="id" value="${Karyawan.id}"/>
                    </c:url>
                    <a href="${deleteDataKaryawan}">Hapus</a>
                    </button>
                </td>
            </tr>
        </c:forEach>

    </table>
</div>

</body>
</html>