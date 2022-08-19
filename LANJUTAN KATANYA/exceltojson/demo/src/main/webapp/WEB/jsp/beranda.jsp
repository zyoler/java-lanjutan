<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>

<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Beranda</title>
    <style>
        body {
            background-color: lightgray;
        }
    </style>
</head>
<body>
    <h1 class="tengah">Biodata Mahasiswa</h1>
    <table border="1">
        <tr>
            <td colspan="1">

                <c:url var="create" value="/createMahasiswa"></c:url>
                <a href="${create}">Tambah data</a>

            </td>
            <td colspan="7" style="text-align: end">
                <form:form action="/searchMahasiswa" modelAttribute="cari" method="POST">
                    <form:input type="text" path="cari"  placeholder="Masukan kata kunci"/>
                    <form:button type="submit">Cari</form:button>
                </form:form>


            </td>
        </tr>

        <tr>
            <th>NIM</th>
            <th>Nama</th>
            <th>Jenis Kelamin</th>
            <th>Jurusan</th>
            <th>No Hp</th>
            <th>Email</th>
            <th>Alamat</th>
            <th>Aksi</th>
        </tr>
        <c:forEach var="mhs" items="${Mahasiswa}">
            <tr>
                <td>${mhs.nim}</td>
                <td>${mhs.nama}</td>
                <td>${mhs.jk}</td>
                <td>${mhs.jurusan}</td>
                <td>${mhs.nohp}</td>
                <td>${mhs.email}</td>
                <td>${mhs.alamat}</td>
                <td>
                    <c:url var="updateMahasiswa" value="/updateMahasiswa">
                        <c:param name="id" value="${mhs.id}"/>
                    </c:url>
                    <a href="${updateMahasiswa}">Ubah</a>

                    <c:url var="deleteMahasiswa" value="/deleteMahasiswa">
                        <c:param name="id" value="${mhs.id}"/>
                    </c:url>
                    <a href="${deleteMahasiswa}">Hapus</a>
                </td>
            </tr>
        </c:forEach>
        <c:url var="toExcel" value="/downloadExcel">

        </c:url>
        <a href="${toExcel}">
            Export to Excel
        </a>
    </table>
</body>
</html>