<%@page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<c:choose>
    <c:when test="${sessionScope.email == null}">
        <c:redirect url="/login"></c:redirect>
    </c:when>
</c:choose>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Tambah Obat</title>

    <!-- Custom fonts for this template-->
    <link href="vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
    <link
            href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
            rel="stylesheet">

    <!-- Custom styles for this template-->
    <link href="css/sb-admin-2.min.css" rel="stylesheet">
</head>

<body id="page-top">
<form:form id="obat" action="/saveObat" modelAttribute="obatDto" method="POST">

<!-- Page Wrapper -->
<div id="wrapper">

    <!-- Sidebar -->
    <ul class="navbar-nav bg-gradient-primary sidebar sidebar-dark accordion" id="accordionSidebar">

        <!-- Sidebar - Brand -->
        <c:url var="index" value="/"/>
        <a class="sidebar-brand d-flex align-items-center justify-content-center" href="${index}">
            <div class="sidebar-brand-icon rotate-n-15">
                <i class="fas fa-hospital"></i>
            </div>
            <div class="sidebar-brand-text mx-3">APOTEK ZYO</div>
        </a>

        <!-- Divider -->
        <hr class="sidebar-divider my-0">

        <!-- Nav Item - Dashboard -->
        <li class="nav-item active">
            <a class="nav-link" href="${index}">
                <i class="fas fa-fw fa-home"></i>
                <span>Dashboard</span></a>
        </li>

        <!-- Divider -->
        <hr class="sidebar-divider">

        <!-- Heading -->
        <div class="sidebar-heading">
            Interface
        </div>

        <!-- Nav Item - Pages Collapse Menu -->
        <li class="nav-item">
            <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#collapseTwo"
               aria-expanded="true" aria-controls="collapseTwo">
                <i class="fas fa-fw fa-user"></i>
                <span>Pegawai</span>
            </a>
            <div id="collapseTwo" class="collapse" aria-labelledby="headingTwo" data-parent="#accordionSidebar">
                <div class="bg-white py-2 collapse-inner rounded">
                    <c:url var="createPegawai" value="/createPegawai"/>
                    <a class="collapse-item" href="${createPegawai}">Input Pegawai</a>
                    <c:url var="pegawai" value="/pegawai"/>
                    <a class="collapse-item" href="${pegawai}">Data Pegawai</a>
                </div>
            </div>
        </li>

        <!-- Divider -->
        <hr class="sidebar-divider">

        <!-- Nav Item - Pages Collapse Menu -->
        <li class="nav-item">
            <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#collapseTwo1"
               aria-expanded="true" aria-controls="collapseTwo">
                <i class="fas fa-fw fa-users"></i>
                <span>Pelanggan</span>
            </a>
            <div id="collapseTwo1" class="collapse" aria-labelledby="headingTwo" data-parent="#accordionSidebar">
                <div class="bg-white py-2 collapse-inner rounded">
                    <c:url var="createPelanggan" value="/createPelanggan"/>
                    <a class="collapse-item" href="${createPelanggan}">Input Pelanggan</a>
                    <c:url var="pelanggan" value="/pelanggan"/>
                    <a class="collapse-item" href="${pelanggan}">Data Pelanggan</a>
                </div>
            </div>
        </li>

        <!-- Divider -->
        <hr class="sidebar-divider">

        <!-- Nav Item - Pages Collapse Menu -->
        <li class="nav-item">
            <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#collapseTwo2"
               aria-expanded="true" aria-controls="collapseTwo">
                <i class="fas fa-fw fa-upload"></i>
                <span>Pemasok</span>
            </a>
            <div id="collapseTwo2" class="collapse" aria-labelledby="headingTwo" data-parent="#accordionSidebar">
                <div class="bg-white py-2 collapse-inner rounded">
                    <c:url var="createPemasok" value="/createPemasok"/>
                    <a class="collapse-item" href="${createPemasok}">Input Pemasok</a>
                    <c:url var="pemasok" value="/pemasok"/>
                    <a class="collapse-item" href="${pemasok}">Data Pemasok</a>
                </div>
            </div>
        </li>

        <!-- Divider -->
        <hr class="sidebar-divider">

        <!-- Nav Item - Pages Collapse Menu -->
        <li class="nav-item">
            <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#collapseTwo3"
               aria-expanded="true" aria-controls="collapseTwo">
                <i class="fas fa-fw fa-hospital-alt"></i>
                <span>Kategori</span>
            </a>
            <div id="collapseTwo3" class="collapse" aria-labelledby="headingTwo" data-parent="#accordionSidebar">
                <div class="bg-white py-2 collapse-inner rounded">
                    <c:url var="createKategori" value="/createKategori"/>
                    <a class="collapse-item" href="${createKategori}">Input Kategori</a>
                    <c:url var="kategori" value="/kategori"/>
                    <a class="collapse-item" href="${kategori}">Data Kategori</a>
                </div>
            </div>
        </li>

        <!-- Divider -->
        <hr class="sidebar-divider">

        <!-- Nav Item - Pages Collapse Menu -->
        <li class="nav-item">
            <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#collapseTwo4"
               aria-expanded="true" aria-controls="collapseTwo">
                <i class="fas fa-fw fa-tablets"></i>
                <span>Obat</span>
            </a>
            <div id="collapseTwo4" class="collapse" aria-labelledby="headingTwo" data-parent="#accordionSidebar">
                <div class="bg-white py-2 collapse-inner rounded">
                    <c:url var="createObat" value="/createObat"/>
                    <a class="collapse-item" href="${createObat}">Input Obat</a>
                    <c:url var="obat" value="/obat"/>
                    <a class="collapse-item" href="${obat}">Data Obat</a>
                </div>
            </div>
        </li>

        <!-- Divider -->
        <hr class="sidebar-divider">

        <!-- Nav Item - Pages Collapse Menu -->
        <li class="nav-item">
            <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#collapseTwo5"
               aria-expanded="true" aria-controls="collapseTwo">
                <i class="fas fa-fw fa-tablets"></i>
                <span>Lainnya</span>
            </a>
            <div id="collapseTwo5" class="collapse" aria-labelledby="headingTwo" data-parent="#accordionSidebar">
                <div class="bg-white py-2 collapse-inner rounded">
                    <c:url var="tentang" value="/tentang"/>
                    <a class="collapse-item" href="${tentang}">Tentang</a>
                    <c:url var="contactUs" value="/contactUs"/>
                    <a class="collapse-item" href="${contactUs}">Contact Us</a>
                </div>
            </div>
        </li>

        <!-- Sidebar Toggler (Sidebar) -->
        <div class="text-center d-none d-md-inline">
            <button class="rounded-circle border-0" id="sidebarToggle"></button>
        </div>
    </ul>
    <!-- End of Sidebar -->

    <!-- Content Wrapper -->
    <div id="content-wrapper" class="d-flex flex-column">

        <!-- Main Content -->
        <div id="content">

            <!-- Topbar -->
            <nav class="navbar navbar-expand navbar-light bg-white topbar mb-4 static-top shadow">

                <!-- Sidebar Toggle (Topbar) -->
                <button id="sidebarToggleTop" class="btn btn-link d-md-none rounded-circle mr-3">
                    <i class="fa fa-bars"></i>
                </button>

                <!-- Topbar Navbar -->
                <ul class="navbar-nav ml-auto">
                    <div class="topbar-divider d-none d-sm-block"></div>

                    <!-- Nav Item - User Information -->
                    <li class="nav-item dropdown no-arrow">
                        <a class="nav-link dropdown-toggle" href="#" id="userDropdown" role="button"
                           data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                            <span class="mr-2 d-none d-lg-inline text-gray-600 small">Admin</span>
                            <img class="img-profile rounded-circle"
                                 src="img/undraw_profile.svg">
                        </a>

                        <!-- Dropdown - User Information -->
                        <div class="dropdown-menu dropdown-menu-right shadow animated--grow-in"
                             aria-labelledby="userDropdown">
                            <a class="dropdown-item" href="#" data-toggle="modal" data-target="#logoutModal">
                                <i class="fas fa-sign-out-alt fa-sm fa-fw mr-2 text-gray-400"></i>
                                Logout
                            </a>
                        </div>

                    </li>

                </ul>
            </nav>
            <!-- End of Topbar -->

            <!-- Begin Page Content -->
            <div class="container-fluid">

                <!-- Page Heading -->
                <div class="d-sm-flex align-items-center justify-content-between mb-4">
                    <h1 class="h3 mb-0 text-gray-800"> Input Data Obat </h1>
                </div>

                <div class="row">
                    <div class="col-xl-12 col-lg-7">
                        <div class="card shadow mb-5">
                            <form class="user col-md-auto">
                                <br>
                                <div class="col-xl-5 col-lg-7">
                                    <i> Nama Obat : </i>
                                    <form:input path="nama" type="text" placeholder="Nama Obat" class="form-control form-control-user" pattern="[A-Za-z ]{3,30}" required="required"/>
                                </div>
                                <br>
                                <div class="col-xl-5 col-lg-7">
                                    <i> Unit : </i><br>
                                    <form:radiobutton path="unit" name="unit" value="Tablet" id="activeRadio"/> Tablet <br>
                                    <form:radiobutton path="unit" name="unit" value="Kapsul"/> Kapsul <br>
                                    <form:radiobutton path="unit" name="unit" value="Kaplet"/> Kaplet <br>
                                    <form:radiobutton path="unit" name="unit" value="Sirup"/> Sirup
                                </div>
                                <br>
                                <div class="col-xl-5 col-lg-7">
                                    <i> Stok : </i>
                                    <form:input path="stok" type="text" placeholder="Stok obat" class="form-control form-control-user" pattern="[0-9]{1,20}" required="required"/>
                                </div>
                                <br>
                                <div class="col-xl-5 col-lg-7">
                                    <i> Kategori : </i>
                                        <form:select path="kategori" name="kategori" required="required">
                                            <c:forEach var="kat" items="${KategoriModels.n}">
                                                <form:option value="${kat}">${kat}</form:option>
                                            </c:forEach>
                                        </form:select>
                                </div>
                                <br>
                                <div class="col-xl-5 col-lg-7">
                                    <i> Harga Beli : </i>
                                    <form:input path="hargabeli" type="text" placeholder="Min 100 (Dalam Rp)" class="form-control form-control-user" pattern="[0-9]{3,15}" required="required"/>
                                </div>
                                <div class="col-xl-5 col-lg-7">
                                    <i> Harga Jual : </i>
                                    <form:input path="hargajual" type="text" placeholder="Max 100 (Dalam Rp)" class="form-control form-control-user" pattern="[0-9]{3,15}" required="required"/>
                                </div>
                                <br>
                                <div class="col-xl-5 col-lg-7">
                                    <i> Pemasok : </i>
                                    <form:select path="pemasok" name="pemasok" required="required">
                                        <c:forEach var="pem" items="${Pemasok}">
                                            <form:option value="${pem}">${pem}</form:option>
                                        </c:forEach>
                                    </form:select>
                                </div>
                                <br>
                                    <form:button type="submit" id="save" class="btn btn-success btn-block">Simpan
                                    </form:button>
                                <br>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
            <!-- /.container-fluid -->

        </div>
        <!-- End of Main Content -->

        <!-- Footer -->
        <footer class="sticky-footer bg-white">
            <div class="container my-auto">
                <div class="copyright text-center my-auto">
                    <span>Copyright &copy; APOTEK ZYO 2022</span>
                </div>
            </div>
        </footer>
        <!-- End of Footer -->

    </div>
    <!-- End of Content Wrapper -->

</div>
<!-- End of Page Wrapper -->

<!-- Scroll to Top Button-->
<a class="scroll-to-top rounded" href="#page-top">
    <i class="fas fa-angle-up"></i>
</a>

<!-- Logout Modal-->
<div class="modal fade" id="logoutModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel"
     aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="exampleModalLabel">Apakah anda ingin keluar?</h5>
                <button class="close" type="button" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">�</span>
                </button>
            </div>
            <div class="modal-body">Tekan Tombol "Keluar" Jika ingin keluar.</div>
            <div class="modal-footer">
                <button class="btn btn-secondary" type="button" data-dismiss="modal">Cancel</button>
                <c:url var="logout" value="/logout"></c:url>
                <a class="btn btn-primary" href="${logout}">Logout</a>
            </div>
        </div>
    </div>
</div>

<!-- Bootstrap core JavaScript-->
<script src="vendor/jquery/jquery.min.js"></script>
<script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

<!-- Core plugin JavaScript-->
<script src="vendor/jquery-easing/jquery.easing.min.js"></script>

<!-- Custom scripts for all pages-->
<script src="js/sb-admin-2.min.js"></script>

<!-- Page level plugins -->
<script src="vendor/chart.js/Chart.min.js"></script>

<!-- Page level custom scripts -->
<script src="js/demo/chart-area-demo.js"></script>
<script src="js/demo/chart-pie-demo.js"></script>

</form:form>
</body>

<script>
    document.getElementById('activeRadio').checked = true;
</script>

</html>