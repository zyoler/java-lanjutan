<%@page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>

<html>
<head>
    <meta charset="ISO-8859-1">
    <title>insert karyawan</title>
    <link rel="stylesheet" type="text/css" href="${contexPath}/css/table.css">
</head>
<body class="body">
<div class="container" align="center">
    <h1>Insert Data Karyawan</h1>
    <form:form id="karyawan" action="/saveKaryawan" modelAttribute="karyawanDto" method="POST">
        <table class="tab">
            <tr>
                <td>No KTP :</td>
                <td>
                    <form:input class="input" path="no_ktp" type="text" placeholder="Masukan No ktp"/>
                </td>
            </tr>
            <tr>
                <td>Nama :</td>
                <td>
                    <form:input cssClass="input" path="nama_karyawan" type="text" placeholder="Masukan Nama "/>
                </td>
            </tr>
            <tr>
                <td>Jenis Kelamin :</td>
                <td>
                    <form:radiobutton path="jenis_kelamin" value="Perempuan"/>
                    Perempuan
                    <form:radiobutton path="jenis_kelamin" value="Laki-laki"/>
                    Laki-laki
                </td>
            </tr>
            <tr>
                <td>Alamat :</td>
                <td>
                    <form:input class="input" path="alamat" type="text" placeholder="Masukan Alamat"/>
                </td>
            </tr>
            <tr>
                <td>Email :</td>
                <td>
                    <form:input class="input" path="email" type="text" placeholder="Masukan email"/>
                </td>
            </tr>
            <tr>
                <td>No Telp :</td>
                <td>
                    <form:input class="input" path="no_telp" type="text" placeholder="Masukan no hp"/>
                </td>
            </tr>
            <tr>
                <td colspan="2">
                    <form:button class="buttonSimpan" type="submit" id="save">Simpan</form:button>
                </td>
            </tr>
        </table>
    </form:form>

</div>
</body>
</html>
