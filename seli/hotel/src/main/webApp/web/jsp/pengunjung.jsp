<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<!DOCTYPE html>

<html>
<head>
    <meta charset="ISO-8859-1">
    <link rel="stylesheet" type="text/css" href="${contexPath}/css/style.css">
    <link rel="stylesheet" type="text/css" href="${contexPath}/css/table.css">
    <title>Data Pengunjung</title>
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
    <h1>DATA PENGUNJUNG</h1>


    <form:form action="/searchPengunjung" modelAttribute="cari" method="POST">
          <form:input type="text" path="cari"  class="search" placeholder="Masukan kata kunci"/>
          <form:button class="button" type="submit">Cari</form:button>
        <form:button class="button" type="submit">
            <c:url var="insert" value="/insertPengunjung">
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
            <th>Nama_pengunjung</th>
            <th>Jenis_Kelamin</th>
            <th>Alamat</th>
            <th>Email</th>
            <th>No hp</th>
            <th>Aksi</th>
        </tr>

        <c:forEach var="Pengunjung" items="${Pengunjung}">
            <tr>
                <td>${Pengunjung.id}</td>
                <td>${Pengunjung.no_ktp}</td>
                <td>${Pengunjung.nama_pengunjung}</td>
                <td>${Pengunjung.jenis_kelamin}</td>
                <td>${Pengunjung.alamat}</td>
                <td>${Pengunjung.email}</td>
                <td>${Pengunjung.no_hp}</td>
                <td>
                    <button class="button" type="submit">
                    <c:url var="updateDataPengunjung" value="/updateDataPengunjung">
                        <c:param name="id" value="${Pengunjung.id}"/>
                    </c:url>

                    <a href="${updateDataPengunjung}">Ubah</a>
                    </button>
                    <button class="button" type="submit">
                     <c:url var="deleteDataPengunjung" value="/deleteDataPengunjung">
                    <c:param name="id" value="${Pengunjung.id}"/>
                    </c:url>
                    <a href="${deleteDataPengunjung}">Hapus</a>
                    </button>
                </td>
            </tr>
        </c:forEach>

    </table>

</div>
</body>
</html>