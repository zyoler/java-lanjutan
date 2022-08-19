<%@page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>

<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Mahasiswa</title>
</head>
<body>
<h1>Update Data Mahasiswa</h1>
<form:form id="mhs" action="/saveUpdateMahasiswa" modelAttribute="mhsDto" method="POST">
    <form:hidden path="id" value="${mhsDto.id}"/>
    <table>
        <tr>
            <td>NIM :</td>
            <td>
                <form:input path="nim" type="text" placeholder="Masukan NIM"/>
            </td>
        </tr>
        <tr>
            <td>Nama :</td>
            <td>
                <form:input path="nama" type="text" placeholder="Masukan Nama"/>
            </td>
        </tr>
        <tr>
            <td>Alamat :</td>
            <td>
                <form:input path="alamat" type="text" placeholder="Masukan Alamat"/>
            </td>
        </tr>
        <tr>
            <td>Jenis Kelamin :</td>
            <td>
                Perempuan
                <form:radiobutton path="jenisKelamin" value="Perempuan"/>
                Laki-laki
                <form:radiobutton path="jenisKelamin" value="Laki-laki"/>
            </td>
        </tr>
        <tr>
            <td>Jurusan</td>
            <td>
                <select name="jurusan" id="jurusan">
                    <option value="D3 MI">D3 MI</option>
                    <option value="S1 Psikologi">S1 Psikologi</option>
                    <option value="S1 Akuntansi">S1 Akuntansi</option>
                    <option value="S1 TI">S1 TI</option>
                    <option value="S1 Sastra Jepang">S1 Sastra Jepang</option>
                </select>
            </td>
        </tr>
        <tr>
            <td>No Hp :</td>
            <td>
                <form:input path="nohp" type="text" placeholder="Masukan no hp"/>
            </td>
        </tr>
        <tr>
            <td>Email :</td>
            <td>
                <form:input path="email" type="text" placeholder="Masukan email"/>
            </td>
        </tr>

        <tr>
            <td colspan="2">
                <form:button type="submit" id="save">Simpan</form:button>
            </td>
        </tr>


    </table>
</form:form>
</body>
</html>