<%@page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>

<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Insert Admin</title>
    <link rel="stylesheet" type="text/css" href="${contexPath}/css/table.css">
</head>
<body class="body">
<div class="container" align="center">
    <h1>Insert Data Admin</h1>
    <form:form id="admin" action="/saveAdmin" modelAttribute="adminDto" method="POST">
        <table class="tab">
            <tr>
                <td>Username :</td>
                <td>
                    <form:input class="input" path="username" type="text" placeholder="Masukan Username"/>
                </td>
            </tr>
            <tr>
                <td>Password :</td>
                <td>
                    <form:input class="input" path="password" type="text" placeholder="Masukan Password "/>
                </td>
            </tr>

                <td colspan="2">
                    <form:button class="buttonSimpan" type="submit" id="save">Simpan</form:button>
                </td>
            </tr>
        </table>
    </form:form>

</div>
</body>
</html>
