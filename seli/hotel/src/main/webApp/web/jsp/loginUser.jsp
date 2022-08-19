<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE HTML>
<html>
<head>
    <title>Halaman Login</title>
    <link rel="stylesheet" type="text/css" href="${contexPath}/css/login.css">
</head>

<body>
<div class="container">
    <h1>Login</h1>
    <form:form action="/cekmasukUser" modelAttribute="user" method="POST">

        <label for="Username">Username</label>
        <form:input id="Username" path="username" type="text" placeholder="Username"/>


        <label for="Password" class="form-label">Password</label>
        <form:input id="Password" path="password" type="password" placeholder="Password"/>

        <form:button class="btn btn-primary" type="submit" id="save">LOGIN</form:button>
    </form:form>
</div>
</body>
</html>