<%@page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>

<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Mahasiswa</title>
    <style>
        body{
            background-color: gray;
        }
    </style>
</head>
<body>
<h1>Data Mahasiswa</h1>

<form:form action="/searchMahasiswa" modelAttribute="cari" method="POST">
    <form:input type="text" path="cari"  placeholder="Masukan kata kunci"/>
    <form:button type="submit">Cari</form:button>
</form:form>

<c:url var="insert" value="/InsertMahasiswa">
</c:url>
<a href="${insert}">
    Tambah Data
</a>

<table border="1">
    <tr>
        <th>Id</th>
        <th>NIM</th>
        <th>Nama</th>
        <th>Alamat</th>
        <th>Jenis Kelamin</th>
        <th>Jurusan</th>
        <th>No. Telp</th>
        <th>E-Mail</th>
        <th>Aksi</th>
    </tr>
    <c:forEach var="mhs" items="${Mahasiswa}">
        <tr>
            <td>${mhs.id}</td>
            <td>${mhs.nim}</td>
            <td>${mhs.nama}</td>
            <td>${mhs.alamat}</td>
            <td>${mhs.jk}</td>
            <td>${mhs.jurusan}</td>
            <td>${mhs.telp}</td>
            <td>${mhs.email}</td>
            <td>
                <c:url var="updateMahasiswa" value="/updateMahasiswa">
                    <c:param name="id" value="${mhs.id}"/>
                </c:url>
                <a href="${updateMahasiswa}">Ubah</a>
                <c:url var="deleteDataMahasiswa" value="/deleteDataMahasiswa">
                    <c:param name="id" value="${mhs.id}"/>
                </c:url>
                <a href="${deleteDataMahasiswa}">Hapus</a>
            </td>
        </tr>
    </c:forEach>

</table>
</body>
</html>