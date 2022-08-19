<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<c:choose>
    <c:when test="${sessionScope.username!=null}">
        <c:redirect url="/dashboard"></c:redirect>
    </c:when>
</c:choose>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>AinzRent - Login</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!--===============================================================================================-->
    <!-- <link rel="icon" type="image/png" href="login/images/icons/favicon.ico"/> -->
    <!--===============================================================================================-->
    <link rel="stylesheet" type="text/css" href="${contextPath}login/vendor/bootstrap/css/bootstrap.min.css">
    <!--===============================================================================================-->
    <link rel="stylesheet" type="text/css" href="${contextPath}login/fonts/font-awesome-4.7.0/css/font-awesome.min.css">
    <!--===============================================================================================-->
    <link rel="stylesheet" type="text/css" href="${contextPath}login/fonts/Linearicons-Free-v1.0.0/icon-font.min.css">
    <!--===============================================================================================-->
    <link rel="stylesheet" type="text/css" href="${contextPath}login/vendor/animate/animate.css">
    <!--===============================================================================================-->
    <link rel="stylesheet" type="text/css" href="${contextPath}login/vendor/css-hamburgers/hamburgers.min.css">
    <!--===============================================================================================-->
    <link rel="stylesheet" type="text/css" href="${contextPath}login/vendor/animsition/css/animsition.min.css">
    <!--===============================================================================================-->
    <link rel="stylesheet" type="text/css" href="${contextPath}login/vendor/select2/select2.min.css">
    <!--===============================================================================================-->
    <link rel="stylesheet" type="text/css" href="${contextPath}login/vendor/daterangepicker/daterangepicker.css">
    <!--===============================================================================================-->
    <link rel="stylesheet" type="text/css" href="${contextPath}login/css/util.css">
    <link rel="stylesheet" type="text/css" href="${contextPath}login/css/main.css">
    <!--===============================================================================================-->

</head>
<body>

<div class="limiter">
    <div class="container-login100">
        <div class="wrap-login100">
            <div class="login100-form-title" >
					<span class="login100-form-title-1">
						Login AinzRent
					</span>
            </div>
            <form:form  action="/cekMasuk" class="login100-form validate-form" modelAttribute="anggota" method="POST">
                <div class="wrap-input100 validate-input m-b-26" data-validate="Username is required">
                    <span for="Username" class="label-input100">Username</span>
                    <form:input class="input100" path="username" type="text" placeholder="Enter Username" autocomplete="off"/>
                    <span class="focus-input100"></span>
                </div>

                <div class="wrap-input100 validate-input m-b-18" data-validate = "Password is required">
                    <span for="Password" class="label-input100">Password</span>
                    <form:input class="input100" path="password" type="password" name="pass" placeholder="Enter Password"/>
                    <span class="focus-input100"></span>
                </div>

                <div class="container-login100-form-btn">
                    <form:button class="login100-form-btn" type="submit" id="save" name="login">LOGIN</form:button>
                </div>
<%--                <h5>Belum punya akun?<c:url var="createAnggota" value="/createAnggota"></c:url>--%>
<%--                    <a href="${createAnggota}">Sign Up </a>--%>
<%--                </h5>--%>
<%--                <br><c:url var="updateAnggota" value="/updateAnggota"></c:url>--%>
<%--                <a href="${updateAnggota}">lupa Kata Sandi?</a>--%>

            </form>
            </form:form>
        </div>
    </div>
</div>


<!--===============================================================================================-->
<script src="login/vendor/jquery/jquery-3.2.1.min.js"></script>
<!--===============================================================================================-->
<script src="login/vendor/animsition/js/animsition.min.js"></script>
<!--===============================================================================================-->
<script src="login/vendor/bootstrap/js/popper.js"></script>
<script src="login/vendor/bootstrap/js/bootstrap.min.js"></script>
<!--===============================================================================================-->
<script src="login/vendor/select2/select2.min.js"></script>
<!--===============================================================================================-->
<script src="login/vendor/daterangepicker/moment.min.js"></script>
<script src="login/vendor/daterangepicker/daterangepicker.js"></script>
<!--===============================================================================================-->
<script src="login/vendor/countdowntime/countdowntime.js"></script>
<!--===============================================================================================-->
<script src="login/js/main.js"></script>

</body>
</html>
