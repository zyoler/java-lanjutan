<%--
  Created by IntelliJ IDEA.
  User: Herdiana
  Date: 01/05/2021
  Time: 21.19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<c:choose>
    <c:when test="${sessionScope.email != null}">
        <c:redirect url="/dashboard"></c:redirect>
    </c:when>
</c:choose>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Login Apotek Corona</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!--===============================================================================================-->
    <link rel="icon" type="image/png" href="${contextPath}/LoginAssets/images/icons/favicon.ico"/>
    <!--===============================================================================================-->
    <link rel="stylesheet" type="text/css" href="${contextPath}/LoginAssets/vendor/bootstrap/css/bootstrap.min.css">
    <!--===============================================================================================-->
    <link rel="stylesheet" type="text/css" href="${contextPath}/LoginAssets/fonts/font-awesome-4.7.0/css/font-awesome.min.css">
    <!--===============================================================================================-->
    <link rel="stylesheet" type="text/css" href="${contextPath}/LoginAssets/vendor/animate/animate.css">
    <!--===============================================================================================-->
    <link rel="stylesheet" type="text/css" href="${contextPath}/LoginAssets/vendor/css-hamburgers/hamburgers.min.css">
    <!--===============================================================================================-->
    <link rel="stylesheet" type="text/css" href="${contextPath}/LoginAssets/vendor/select2/select2.min.css">
    <!--===============================================================================================-->
    <link rel="stylesheet" type="text/css" href="${contextPath}/LoginAssets/css/util.css">
    <link rel="stylesheet" type="text/css" href="${contextPath}/LoginAssets/css/main.css">
    <!--===============================================================================================-->
</head>
<body>

<div class="limiter">
    <div class="container-login100">
        <div class="wrap-login100">
            <div class="login100-pic js-tilt" data-tilt>
                <img src="${contextPath}/LoginAssets/images/medicine.jpg" alt="IMG">
            </div>

            <form class="login100-form validate-form" action="/cekLogin" modelAttribute="loginDto" method="post">
					<span class="login100-form-title">
						Apotek Login
					</span>

                <div class="wrap-input100 validate-input" data-validate = "Valid email is required: ex@abc.xyz">
                    <input class="input100" type="text" name="email" id="email" path="email" placeholder="Email">
                    <span class="focus-input100"></span>
                    <span class="symbol-input100">
							<i class="fa fa-envelope" aria-hidden="true"></i>
						</span>
                </div>

                <div class="wrap-input100 validate-input" data-validate = "Password is required">
                    <input class="input100" type="password" name="password" id="password" path="password" placeholder="Password">
                    <span class="focus-input100"></span>
                    <span class="symbol-input100">
							<i class="fa fa-lock" aria-hidden="true"></i>
						</span>
                </div>

                <div class="container-login100-form-btn">
                    <button class="login100-form-btn">Login</button>
                </div>
            </form>
        </div>
    </div>
</div>


<!--===============================================================================================-->
<script src="${contextPath}/LoginAssets/vendor/jquery/jquery-3.2.1.min.js"></script>
<!--===============================================================================================-->
<script src=${contextPath}/LoginAssets/vendor/bootstrap/js/popper.js"></script>
<script src="${contextPath}/LoginAssets/vendor/bootstrap/js/bootstrap.min.js"></script>
<!--===============================================================================================-->
<script src=${contextPath}/LoginAssets/vendor/select2/select2.min.js"></script>
<!--===============================================================================================-->
<script src="${contextPath}/LoginAssets/vendor/tilt/tilt.jquery.min.js"></script>
<script >
    $('.js-tilt').tilt({
        scale: 1.1
    })
</script>
<!--===============================================================================================-->
<script src="${contextPath}/LoginAssets/js/main.js"></script>

</body>
</html>