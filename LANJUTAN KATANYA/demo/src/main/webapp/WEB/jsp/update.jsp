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
    <form:hidden path="id" value="${mhsDto.id}" />
    <table>
        <tr>
            <td>NIM :</td>
            <td>
                <form:input path="nim" type="text" placeholder="Masukan NIM" value="${mhsDto.nim}"/>
            </td>
        </tr>
        <tr>
            <td>Nama :</td>
            <td>
                <form:input path="nama" type="text" placeholder="Masukan Nama" value="${mhsDto.nama}"/>
            </td>
        </tr>
        <tr>
            <td>Alamat :</td>
            <td>
                <form:input path="alamat" type="text" placeholder="Masukan Alamat" value="${mhsDto.alamat}"/>
            </td>
        </tr>
        <tr>
            <td>Jenis Kelamin : </td>
            <td>
                <form:radiobutton path="jk" value="Laki-laki"/>Laki-laki
                <form:radiobutton path="jk" value="Perempuan"/>Perempuan
            </td>
        </tr>
        <tr>
            <td>Jurusan : </td>
            <td>
                <form:select path="jurusan">
                    <form:option value="D3 Manajemen Informatika"/>
                    <form:option value="D3 Sastra Inggris"/>
                    <form:option value="S1 Tenik Informatika"/>
                    <form:option value="S1 Manajemen"/>
                    <form:option value="S1 Akuntansi"/>
                    <form:option value="S1 Psikologi"/>
                    <form:option value="S1 Sastra Jepang"/>
                </form:select>
            </td>
        </tr>
        <tr>
            <td>No. Telp : </td>
            <td>
                <form:input path="telp" type="text" placeholder="Masukan No. Telp"/>
            </td>
        </tr>
        <tr>
            <td>E-Mail : </td>
            <td>
                <form:input path="email" type="text" placeholder="example01@gmail.com"/>
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