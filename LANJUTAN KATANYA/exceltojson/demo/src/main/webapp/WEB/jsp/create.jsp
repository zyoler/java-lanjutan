<%@page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>

<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Create</title>
    <style>
        body{
            background-color: lightblue;
        }
        table {
            margin-left: auto;
            margin-right: auto;
        }
        .tengah {
            text-align: center;
        }
    </style>
</head>
<body>
<h1 class="tengah">Tambahkan Obat</h1>
<form:form id="mhs" action="/saveMahasiswa" modelAttribute="mhsDto" method="POST">
    <table>
        <tr>
            <td>NIM</td>
            <td>
                <form:input path="nim" type="text" placeholder="Masukan NIM"/>
            </td>
        </tr>
        <tr>
            <td>Nama</td>
            <td>
                <form:input path="nama" type="text" placeholder="Masukan Nama"/>
            </td>
        </tr>
        <tr>
            <td>Jenis kelamin</td>
            <td>
                <form:radiobutton path="jk" name="jk" value="Laki-laki"/>Laki-laki
                <form:radiobutton path="jk" name="jk" value="Perempuan"/>Perempuan
            </td>
        </tr>
        <tr>
            <td>Jurusan</td>
            <td>
                <form:select path="jurusan" name="jurusan" value="D3 MI">
                    <form:option value="D3 MI">D3 MI</form:option>
                    <form:option value="S1 TI">S1 TI</form:option>
                    <form:option value="S1 AKUTANSI">S1 AKUTANSI</form:option>
                </form:select>
            </td>
        </tr>
        <tr>
            <td>No hp</td>
            <td>
                <form:input path="nohp" type="text" placeholder="Masukan No HP"/>
            </td>
        </tr>
        <tr>
            <td>Email</td>
            <td>
                <form:input path="email" type="email" placeholder="Masukan Email"/>
            </td>
        </tr>

        <tr>
            <td>Alamat</td>
            <td>
                <form:input path="alamat" type="text" placeholder="Masukan Alamat"/>
            </td>
        </tr>
        <tr>
            <td></td>
            <td colspan="2">
                <form:button type="submit" id="save">Simpan</form:button>
            </td>
        </tr>
    </table>
</form:form>
</body>
</html>