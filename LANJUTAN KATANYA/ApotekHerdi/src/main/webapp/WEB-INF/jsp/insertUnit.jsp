<%--
  Created by IntelliJ IDEA.
  User: Herdiana
  Date: 29/04/2021
  Time: 17.10
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<c:choose>
    <c:when test="${sessionScope.email == null}">
        <c:redirect url="/login"></c:redirect>
    </c:when>
</c:choose>
<%-- Bagian Head Pada View--%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <!-- Meta, title, CSS, favicons, etc. -->
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="icon" href="${contextPath}/assets/images/favicon.ico" type="image/ico" />

    <title>${title}</title>

    <!-- Import CSS -->
    <link href="${contextPath}/vendors/bootstrap/dist/css/bootstrap.min.css" rel="stylesheet">
    <link href="${contextPath}/vendors/font-awesome/css/font-awesome.min.css" rel="stylesheet">
    <link href="${contextPath}/vendors/nprogress/nprogress.css" rel="stylesheet">
    <link href="${contextPath}/vendors/iCheck/skins/flat/green.css" rel="stylesheet">
    <link href="${contextPath}/vendors/google-code-prettify/bin/prettify.min.css" rel="stylesheet">
    <link href="${contextPath}/vendors/select2/dist/css/select2.min.css" rel="stylesheet">
    <link href="${contextPath}/vendors/switchery/dist/switchery.min.css" rel="stylesheet">
    <link href="${contextPath}/vendors/starrr/dist/starrr.css" rel="stylesheet">
    <link href="${contextPath}/vendors/jqvmap/dist/jqvmap.min.css" rel="stylesheet">
    <link href="${contextPath}/vendors/bootstrap-daterangepicker/daterangepicker.css" rel="stylesheet">
    <link href="${contextPath}/vendors/bootstrap-datetimepicker/build/css/bootstrap-datetimepicker.css" rel="stylesheet">


    <link href="${contextPath}/vendors/bootstrap-progressbar/css/bootstrap-progressbar-3.3.4.min.css" rel="stylesheet">

    <!-- PNotify -->
    <link href="${contextPath}/vendors/pnotify/dist/pnotify.css" rel="stylesheet">
    <link href="${contextPath}/vendors/pnotify/dist/pnotify.buttons.css" rel="stylesheet">
    <link href="${contextPath}/vendors/pnotify/dist/pnotify.nonblock.css" rel="stylesheet">


    <!-- FullCalendar -->
    <link href="${contextPath}/vendors/fullcalendar/dist/fullcalendar.min.css" rel="stylesheet" >
    <link href="${contextPath}/vendors/fullcalendar/dist/fullcalendar.print.css" rel="stylesheet" media="print">


    <!-- Datatables -->
    <link href="${contextPath}/vendors/datatables.net-bs/css/dataTables.bootstrap.min.css" rel="stylesheet">
    <link href="${contextPath}/vendors/datatables.net-buttons-bs/css/buttons.bootstrap.min.css" rel="stylesheet">
    <link href="${contextPath}/vendors/datatables.net-fixedheader-bs/css/fixedHeader.bootstrap.min.css" rel="stylesheet">
    <link href="${contextPath}/vendors/datatables.net-responsive-bs/css/responsive.bootstrap.min.css" rel="stylesheet">
    <link href="${contextPath}/vendors/datatables.net-scroller-bs/css/scroller.bootstrap.min.css" rel="stylesheet">
    <!-- Custom Theme Style -->
    <link href="${contextPath}/assets/css/custom.min.css" rel="stylesheet">
    <!-- /Import CSS -->
    <script src="${contextPath}/js/jquery.save.js"></script>
</head>

<body class="nav-md">
<div class="container body">
    <div class="main_container">
        <div class="col-md-3 left_col menu_fixed">
            <div class="left_col scroll-view">
                <div class="navbar nav_title" style="border: 0;">
                    <!-- logo info -->
                    <div class="logo_pic">
                        <a href="<?php echo base_url(); ?>"><img src="${contextPath}/assets/images/apotek.png" alt="..." class="img-circle logo_img"></a>
                    </div>

                </div>
                <div class="profile">
                    <c:url var="dashboard" value="/dashboard"></c:url>
                    <a href="${dashboard}" class="site_title"><span style="font-size: 20px;">Apotek Corona dr.Herdiana</span></a>
                </div>

                <div class="clearfix"></div>


                <!-- /menu profile quick info -->
                <br>
                <!-- Sidebar Menu -->
                <div id="sidebar-menu" class="main_menu_side hidden-print main_menu">
                    <div class="menu_section">
                        <h3></h3>
                        <ul class="nav side-menu">

                            <li><a href="${dashboard}"><i class="fa fa-home"></i> Beranda </a></li>
                            <li><a><i class="fa fa-medkit"></i> Obat <span class="fa fa-chevron-down"></span></a>
                                <ul class="nav child_menu">
                                    <c:url var="insertObat" value="/doInsertObat"></c:url>
                                    <li><a href="${insertObat}">Tambah Obat</a></li>
                                    <c:url var="dataobat" value="/dataobat"></c:url>
                                    <li><a href="${dataobat}">Lihat Obat</a></li>
                                    <c:url var="dataexp" value="/dataobatexp"></c:url>
                                    <li><a href="${dataexp}">Obat Kedaluwarsa</a></li>
                                    <c:url var="stokout" value="/dataobatoutstok"></c:url>
                                    <li><a href="${stokout}">Obat Habis</a></li>

                                </ul>
                            </li>
                            <li><a><i class="fa fa-hospital-o"></i> Kategori & Unit <span class="fa fa-chevron-down"></span></a>
                                <ul class="nav child_menu">
                                    <c:url var="inputkat" value="/doInsertKat"></c:url>
                                    <li><a href="${inputkat}">Tambah Kategori</a></li>
                                    <c:url var="gokat" value="/datakat"></c:url>
                                    <li><a href="${gokat}">Lihat Kategori</a></li>
                                    <c:url var="inputunit" value="/doInsertUnit"></c:url>
                                    <li><a href="${inputunit}">Tambah Unit</a></li>
                                    <c:url var="gounit" value="/dataunit"></c:url>
                                    <li><a href="${gounit}">Lihat Unit</a></li>
                                </ul>
                            </li>

                            <li><a><i class="fa fa-users"></i> Pemasok <span class="fa fa-chevron-down"></span></a>
                                <ul class="nav child_menu">
                                    <c:url var="inputsupp" value="/doInsertSupp"></c:url>
                                    <li><a href="${inputsupp}">Tambah Pemasok</a></li>
                                    <c:url var="gosupp" value="/datasupp"></c:url>
                                    <li><a href="${gosupp}">Lihat Pemasok</a></li>
                                </ul>
                            </li>


                            <li><a><i class="fa fa-edit"></i> Penjualan <span class="fa fa-chevron-down"></span></a>
                                <ul class="nav child_menu">
                                    <c:url var="inputjual" value="/doInsertJual"></c:url>
                                    <li><a href="${inputjual}">Tambah Penjualan</a></li>
                                    <c:url var="gojual" value="/datajual"></c:url>
                                    <li><a href="${gojual}">Lihat Penjualan</a></li>
                                    <c:url var="jualchart" value="/grafikJual"></c:url>
                                    <li><a href="${jualchart}">Grafik Penjualan</a></li>
                                </ul>
                            </li>


                            <li><a><i class="fa fa-shopping-cart"></i> Pembelian <span class="fa fa-chevron-down"></span></a>
                                <ul class="nav child_menu">
                                    <c:url var="inputbeli" value="/doInsertBeli"></c:url>
                                    <li><a href="${inputbeli}">Tambah Pembelian</a></li>
                                    <c:url var="gobeli" value="/databeli"></c:url>
                                    <li><a href="${gobeli}">Lihat Pembelian</a></li>
                                    <c:url var="belichart" value="/grafikBeli"></c:url>
                                    <li><a href="${belichart}">Grafik Pembelian</a></li>
                                </ul>
                            </li>


                            <c:url var="chart" value="/grafikdata"></c:url>
                            <li><a href="${chart}"><i class="fa fa-bar-chart"></i> Laporan </a></li>
                            <c:url var="logout" value="/logout"></c:url>
                            <li><a href="${logout}"><i class="fa fa-lock"></i> Logout </a></li>

                        </ul>
                    </div>
                </div>
            </div>
        </div>

        <!-- Top Nav -->
        <div class="top_nav">
            <div class="nav_menu">
                <nav>
                    <div class="nav toggle"><a id="menu_toggle"><i class="fa fa-bars"></i></a></div>
                    <ul class="nav navbar-nav navbar-right">
                        <li>
                            <a href="javascript:;" class="user-profile dropdown-toggle" data-toggle="dropdown" aria-expanded="false"><img src="${contextPath}/assets/images/img.jpg" alt="">Selamat Datang <!-- <span class="fa fa-angle-down"></span> --></a>
                        </li>

                        <li role="presentation" class="dropdown">
                            <a href="javascript:;" class="dropdown-toggle info-number" data-toggle="dropdown" aria-expanded="false">
                                <i class="fa fa-bell-o" style="font-size: 18px"></i>
                                <span class="badge bg-red" >${countexp + countstok}</span>
                            </a>
                            <ul id="menu1" class="dropdown-menu list-unstyled msg_list" role="menu">
                                <li>
                                    <c:url var="goexp" value="/dataobatexp"></c:url>
                                    <a href="${goexp}">
                                        <span class="fa fa-warning" style="font-size: 18px;"></span>
                                        <span style="font-size: 15px;">
                          <span> Kedaluwarsa</span>
                          <span class="time">${countexp} obat</span>
                        </span>
                                        <span class="message">
                          Obat sudah kedaluwarsa...
                        </span>
                                    </a>
                                </li>
                                <li>
                                    <c:url var="gooutstok" value="/dataobatoutstok"></c:url>
                                    <a href="${gooutstok}">
                                        <span class="fa fa-warning" style="font-size: 18px;"></span>
                                        <span style="font-size: 15px;">
                          <span> Habis</span>
                          <span class="time">${countstok} obat</span>
                        </span>
                                        <span class="message">
                          Obat sudah habis...
                        </span>
                                    </a>
                                </li>
                            </ul>
                        </li>
                    </ul>
                </nav>
            </div>
        </div>
        <!-- /Top Nav -->

        <div class="right_col" role="main">

            <%-- isi konten--%>
                <div class="row">
                    <div class="col-md-12 col-sm-12 col-xs-12">
                        <div class="x_panel">
                            <div class="x_title">
                                <h2>Tambah Unit Obat</h2>
                                <ul class="nav navbar-right panel_toolbox">
                                    <li><a class="collapse-link"><i class="fa fa-chevron-up"></i></a>
                                    </li>

                                    <li><a class="close-link"><i class="fa fa-close"></i></a>
                                    </li>
                                </ul>
                                <div class="clearfix"></div>
                            </div>
                            <div class="x_content">

                                <form action="/saveUnit" modelAttribut="unitDto" method="post" class="form-horizontal form-label-left" novalidate >


                                    <div class="item form-group">
                                        <label class="control-label col-md-3 col-sm-3 col-xs-12" for="unit">Nama Unit</label>
                                        <div class="col-md-6 col-sm-6 col-xs-12">
                                            <input type="text" id="unit" name="unit" path="unit" class="form-control col-md-7 col-xs-12" data-validate-length-range="1" data-validate-words="1" required="required">
                                        </div>
                                    </div>


                                    <div class="ln_solid"></div>
                                    <div class="form-group">
                                        <div class="col-md-6 col-md-offset-3">
                                            <c:url var="gounit" value="/dataunit"></c:url>
                                            <a href="${gounit}"><button type="button" class="btn btn-danger">Batal</button></a>
                                            <button id="send" type="submit" class="btn btn-success">Simpan</button>
                                        </div>
                                    </div>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>

            <%-- isi konten--%>

            <div style=" margin-top: 10%; ">
                <c:url var="gbr" value="/dashboard"></c:url>
                <a href="${gbr}"><img src="${contextPath}/assets/images/Background.png" alt="..." class="img-home"></a>
                <div class="clearfix"></div>
            </div>
        </div>

        <!-- /Page Content -->

        <!-- Footer Content -->
        <footer>
            <div class="pull-right">
                <a href="">Apotek Corona dr.Herdiana</a>
            </div>
            <div class="clearfix"></div>
        </footer>
        <!-- /Footer Content -->
    </div>
</div>

<!-- Import Javascript -->
<script src="${contextPath}/vendors/jquery/dist/jquery.min.js"></script>
<script src="${contextPath}/vendors/jquery-ui/jquery-ui.js"></script>
<script src="${contextPath}/vendors/bootstrap/dist/js/bootstrap.min.js"></script>
<script src="${contextPath}/vendors/fastclick/lib/fastclick.js"></script>
<script src="${contextPath}/vendors/nprogress/nprogress.js"></script>

<script src="${contextPath}/vendors/Chart.js/dist/Chart.min.js"></script>
<script src="${contextPath}/vendors/jquery-sparkline/dist/jquery.sparkline.min.js"></script>

<script src="${contextPath}/vendors/morris.js/morris.min.js"></script>
<script src="${contextPath}/vendors/raphael/raphael.min.js"></script>

<script src="${contextPath}/vendors/gauge.js/dist/gauge.min.js"></script>
<script src="${contextPath}/vendors/bootstrap-progressbar/bootstrap-progressbar.min.js"></script>
<script src="${contextPath}/vendors/iCheck/icheck.min.js"></script>
<script src="${contextPath}/vendors/skycons/skycons.js"></script>
<!-- Flot -->
<script src="${contextPath}/vendors/Flot/jquery.flot.js"></script>
<script src="${contextPath}/vendors/Flot/jquery.flot.pie.js"></script>
<script src="${contextPath}/vendors/Flot/jquery.flot.time.js"></script>
<script src="${contextPath}/vendors/Flot/jquery.flot.stack.js"></script>
<script src="${contextPath}/vendors/Flot/jquery.flot.resize.js"></script>
<!-- Flot Plugins -->
<script src="${contextPath}/vendors/flot.orderbars/js/jquery.flot.orderBars.js"></script>
<script src="${contextPath}/vendors/flot-spline/js/jquery.flot.spline.min.js"></script>
<script src="${contextPath}/vendors/flot.curvedlines/curvedLines.js"></script>
<!-- JQVMap -->
<script src="${contextPath}/vendors/jqvmap/dist/jquery.vmap.js"></script>
<script src="${contextPath}/vendors/jqvmap/dist/maps/jquery.vmap.world.js"></script>
<script src="${contextPath}/vendors/jqvmap/examples/js/jquery.vmap.sampledata.js"></script>

<script src="${contextPath}/vendors/DateJS/build/date.js"></script>
<!-- Bootstrap Date Range Picker -->
<script src="${contextPath}/vendors/moment/min/moment.min.js"></script>
<script src="${contextPath}/vendors/bootstrap-daterangepicker/daterangepicker.js"></script>
<!-- bootstrap-datetimepicker -->
<script src="${contextPath}/vendors/bootstrap-datetimepicker/build/js/bootstrap-datetimepicker.min.js"></script>



<!-- FullCalendar -->
<script src="${contextPath}/vendors/fullcalendar/dist/fullcalendar.min.js"></script>


<!-- Ion.RangeSlider -->
<script src="${contextPath}/vendors/ion.rangeSlider/js/ion.rangeSlider.min.js"></script>
<!-- Bootstrap Colorpicker -->
<script src="${contextPath}/vendors/mjolnic-bootstrap-colorpicker/dist/js/bootstrap-colorpicker.min.js"></script>
<!-- jquery.inputmask -->
<script src="${contextPath}/vendors/jquery.inputmask/dist/min/jquery.inputmask.bundle.min.js"></script>
<!-- jQuery Knob -->
<script src="${contextPath}/vendors/jquery-knob/dist/jquery.knob.min.js"></script>


<script src="${contextPath}/vendors/bootstrap-wysiwyg/js/bootstrap-wysiwyg.min.js"></script>
<script src="${contextPath}/vendors/jquery.hotkeys/jquery.hotkeys.js"></script>
<script src="${contextPath}/vendors/google-code-prettify/src/prettify.js"></script>
<script src="${contextPath}/vendors/jquery.tagsinput/src/jquery.tagsinput.js"></script>
<script src="${contextPath}/vendors/switchery/dist/switchery.min.js"></script>
<script src="${contextPath}/vendors/select2/dist/js/select2.full.min.js"></script>

<!-- Validate -->
<script src="${contextPath}/vendors/parsleyjs/dist/parsley.min.js"></script>
<script src="${contextPath}/vendors/validator/validator.js"></script>

<script src="${contextPath}/vendors/autosize/dist/autosize.min.js"></script>
<script src="${contextPath}/vendors/devbridge-autocomplete/dist/jquery.autocomplete.min.js"></script>
<script src="${contextPath}/vendors/starrr/dist/starrr.js"></script>
<!-- Datatables -->
<script src="${contextPath}/vendors/datatables.net/js/jquery.dataTables.min.js"></script>
<script src="${contextPath}/vendors/datatables.net-bs/js/dataTables.bootstrap.min.js"></script>
<script src="${contextPath}/vendors/datatables.net-buttons/js/dataTables.buttons.min.js"></script>
<script src="${contextPath}/vendors/datatables.net-buttons-bs/js/buttons.bootstrap.min.js"></script>
<script src="${contextPath}/vendors/datatables.net-buttons/js/buttons.flash.min.js"></script>
<script src="${contextPath}/vendors/datatables.net-buttons/js/buttons.html5.min.js"></script>
<script src="${contextPath}/vendors/datatables.net-buttons/js/buttons.print.min.js"></script>
<script src="${contextPath}/vendors/datatables.net-fixedheader/js/dataTables.fixedHeader.min.js"></script>
<script src="${contextPath}/vendors/datatables.net-keytable/js/dataTables.keyTable.min.js"></script>
<script src="${contextPath}/vendors/datatables.net-responsive/js/dataTables.responsive.min.js"></script>
<script src="${contextPath}/vendors/datatables.net-responsive-bs/js/responsive.bootstrap.js"></script>
<script src="${contextPath}/vendors/datatables.net-scroller/js/dataTables.scroller.min.js"></script>
<script src="${contextPath}/vendors/jszip/dist/jszip.min.js"></script>
<script src="${contextPath}/vendors/pdfmake/build/pdfmake.min.js"></script>
<script src="${contextPath}/vendors/pdfmake/build/vfs_fonts.js"></script>
<!-- Custom JS -->


<!-- PNotify -->
<script src="${contextPath}/vendors/pnotify/dist/pnotify.js"></script>
<script src="${contextPath}/vendors/pnotify/dist/pnotify.buttons.js"></script>
<script src="${contextPath}/vendors/pnotify/dist/pnotify.nonblock.js"></script>



<script src="${contextPath}/assets/js/custom.min.js"></script>
<!-- /Import Javascript -->


<!-- Date Picker -->
<script>


    $('#myDatepicker2').datetimepicker({
        format: 'DD-MM-YYYY',
        allowInputToggle: true
    });

    $('#myDatepicker3').datetimepicker({
        format: 'hh:mm A'
    });

    $('#myDatepicker4').datetimepicker({
        ignoreReadonly: true,
        allowInputToggle: true
    });

    $('#datetimepicker6').datetimepicker();

    $('#datetimepicker7').datetimepicker({
        useCurrent: false
    });

    $("#datetimepicker6").on("dp.change", function(e) {
        $('#datetimepicker7').data("DateTimePicker").minDate(e.date);
    });

    $("#datetimepicker7").on("dp.change", function(e) {
        $('#datetimepicker6').data("DateTimePicker").maxDate(e.date);
    });



</script>

<!-- remove welcome notif pnotify and add notif -->
<script>
    $(document).ready(function (){
        $('.ui-pnotify').remove();
        $('.source').trigger("click");

    });

</script>

<script type="text/javascript">
    var tablenambah = $('#nambah').DataTable( {

    });
</script>




<!-- Add row and calculate -->

<script type="text/javascript">




    var transaksi = $('#prod').DataTable( {
        "paging":   false,
        "ordering": false,
        "info":     false,
        "searching": false,
    });

    var counter = 1;

    $('#addRow').on( 'click', function () {
        transaksi.row.add( [
            '<select required="required" style="width:100%;" class="form-control nama_obat" id="nama_obat'+counter+'" name="nama_obat[]" data-stok="#stok'+counter+'" data-unit="#unit'+counter+'" data-harga_jual="#harga_jual'+counter+'"><option selected="true" value="" disabled ></option><?php foreach($get_med as $gm){ ?><option value="<?php echo $gm; ?>"><?php echo $gm; ?></option><?php  }?></select>',
            '<input id="stok'+counter+'" name="stok[]" class="form-control stok" readonly >',
            '<input id="unit'+counter+'" name="unit[]" class="form-control" readonly>',
            '<input id="harga_jual'+counter+'" name="harga_jual[]" class="form-control harga_jual" readonly>',
            '<input type="number" id="banyak'+counter+'" name="banyak[]" class="form-control banyak" required="required">',
            '<input id="subtotal'+counter+'" name="subtotal[]" class="form-control subtotal" readonly>',
            '<button id="removeproduk" class="btn btn-danger btn-sm" type="button"><span class="fa fa-trash"></span> Hapus</button>',
        ] ).draw( false );

        var myOpt = [];
        $("select").each(function () {
            myOpt.push($(this).val());
        });
        $("select").each(function () {
            $(this).find("option").prop('hidden', false);
            var sel = $(this);
            $.each(myOpt, function(key, value) {
                if((value != "") && (value != sel.val())) {
                    sel.find("option").filter('[value="' + value +'"]').prop('hidden', true);
                }
            });
        });

        counter++;

    } );


    $('#addRow').click();


    $('#prod').on("click", "#removeproduk", function(){
        console.log($(this).parent());
        t.row($(this).parents('tr')).remove().draw(false);
        updateTotal();
    });



    $('#prod').on('change', '.nama_obat', function() {

        var $select = $(this);
        var nama_obat = $select.val();


        $.ajax({
            type: "POST",
            url: "<?php echo base_url('example/product')?>",
            dataType: "JSON",
            data: { nama_obat: nama_obat },
            cache: false,
            success: function(data) {
                $.each(data, function(nama_obat, stok, unit, harga_jual) {
                    $($select.data('stok')).val(data.stok);
                    $($select.data('unit')).val(data.unit);
                    $($select.data('harga_jual')).val(data.harga_jual);
                });
            }
        });

    });



    $('#prod').on('change', '.banyak', function() {
        updateSubtotal();

    });

    function updateSubtotal() {

        $(".banyak").each(function(){
            var $row = $(this).closest('tr');
            var unitStock = parseInt($row.find('.stok').val()) ;
            var unitCount = parseInt($row.find('.banyak').val()) ;


            if(unitCount > unitStock){
                $row.find('.banyak').val(unitStock);
                updateSubtotal();
            }
            else if (unitCount < 0){
                $row.find('.banyak').val(0);
                updateSubtotal();

            }
            else {

                var Sub = parseInt(($row.find('.harga_jual').val()) * unitCount);
                $row.find('.subtotal').val(Sub);
                updateTotal();


            }
        });
    }

    function updateTotal() {
        var grandtotal = 0;
        $('.subtotal').each(function() {
            grandtotal += parseInt($(this).val());
        });
        $('#grandtotal').val(grandtotal);
    }

</script>

<script>
    $.ajax({

        url: "<?php echo base_url('example/chart')?>",
        method: "GET",

        success: function(data) {
            var data = JSON.parse(data);
            console.log(data);


            var stok = [];
            var nama_kategori = [];

            for (var i in data){
                stok.push(data[i].stok);
                nama_kategori.push(data[i].nama_kategori);
            }

            var chartdata = {
                labels: nama_kategori,
                datasets : [
                    {
                        label: 'Stok obat',
                        backgroundColor: 'rgba(26, 187, 156, 0.7)',
                        borderColor: 'rgba(26, 187, 156, 0.7)',
                        hoverBackgroundColor: 'rgba(26, 187, 156, 1)',
                        hoverBorderColor: 'rgba(26, 187, 156, 1)',
                        data: stok
                    }
                ]
            };

            var ctx = $("#canvas");

            var barGraph = new Chart(ctx, {
                type: 'bar',
                data: chartdata
            });


        }
    });
</script>

<script>
    $('#coba').datetimepicker({

        format: 'YYYY',
        allowInputToggle: true,

    })
        .on('dp.change', function(e) {

            transChart();

        });

    function transChart(){
        var tahun_beli = $('#coba').data('date');
        $.ajax({
            type: "POST",
            url: "<?php echo base_url('example/chart_trans')?>",
            dataType: "JSON",

            data: { "tahun_beli": tahun_beli },
            success: function(data) {

                console.log(data);

                var total = [];
                var month = [];

                for (var i in data){
                    total.push(data[i].total);
                    month.push(data[i].month);
                }

                var chartdata = {
                    labels: month,
                    datasets : [
                        {
                            label: 'Total Penjualan',
                            backgroundColor: 'rgba(26, 187, 156, 0.4)',
                            borderColor: 'rgba(26, 187, 156, 0.7)',
                            hoverBackgroundColor: 'rgba(26, 187, 156, 0.6)',
                            hoverBorderColor: 'rgba(26, 187, 156, 1)',
                            lineTension: 0,
                            data: total
                        }
                    ]
                };

                var ctx = $("#transaksi");

                var barGraph = new Chart(ctx, {
                    type: 'line',
                    data: chartdata,

                });


            }
        });


        $.ajax({
            url: "<?php echo base_url('example/topdemand')?>",
            async: false,
            type: "POST",
            data: { "tahun_beli": tahun_beli },
            dataType: "JSON",
            success: function(data) {

                var html = '';

                for(i=0; i<data.length; i++){
                    html += '<tr >'+
                        '<td>'+(i+1)+'</td>'+
                        '<td>'+data[i].nama_obat+'</td>'+
                        '<td>'+data[i].totSold+'</td>'+

                        '</tr>';
                }
                $("#topdemand").html(html); //pass the data to your tbody
            }
        })


        $.ajax({
            url: "<?php echo base_url('example/leastdemand')?>",
            async: false,
            type: "POST",
            data: { "tahun_beli": tahun_beli },
            dataType: "JSON",
            success: function(data) {

                var html = '';

                for(i=0; i<data.length; i++){
                    html += '<tr >'+
                        '<td>'+(i+1)+'</td>'+
                        '<td>'+data[i].nama_obat+'</td>'+
                        '<td>'+data[i].totSold+'</td>'+

                        '</tr>';
                }
                $("#leastdemand").html(html); //pass the data to your tbody
            }
        })


        $.ajax({
            url: "<?php echo base_url('example/highearn')?>",
            async: false,
            type: "POST",
            data: { "tahun_beli": tahun_beli },
            dataType: "JSON",
            success: function(data) {

                var html = '';

                for(i=0; i<data.length; i++){
                    html += '<tr >'+
                        '<td>'+(i+1)+'</td>'+
                        '<td>'+data[i].nama_obat+'</td>'+
                        '<td>'+data[i].totEarned+'</td>'+

                        '</tr>';
                }
                $("#highearn").html(html); //pass the data to your tbody
            }
        })

        $.ajax({
            url: "<?php echo base_url('example/lowearn')?>",
            async: false,
            type: "POST",
            data: { "tahun_beli": tahun_beli },
            dataType: "JSON",
            success: function(data) {

                var html = '';

                for(i=0; i<data.length; i++){
                    html += '<tr >'+
                        '<td>'+(i+1)+'</td>'+
                        '<td>'+data[i].nama_obat+'</td>'+
                        '<td>'+data[i].totEarned+'</td>'+

                        '</tr>';
                }
                $("#lowearn").html(html); //pass the data to your tbody
            }
        })
    }


</script>

<script>
    $('#dada').datetimepicker({

        format: 'YYYY',
        allowInputToggle: true
    })
        .on('dp.change', function(e) {

            purChart();
        });

    function purChart(){

        var tahun_beli = $('#dada').data('date');


        $.ajax({
            type: "POST",
            url: "<?php echo base_url('example/chart_purchase')?>",
            dataType: "JSON",

            data: { "tahun_beli": tahun_beli },
            success: function(data) {

                console.log(data);

                var total = [];
                var month = [];

                for (var i in data){
                    total.push(data[i].total);
                    month.push(data[i].month);
                }

                var chartdata = {
                    labels: month,
                    datasets : [
                        {
                            label: 'Total Pembelian',
                            backgroundColor: 'rgba(57, 80, 103, 0.4)',
                            borderColor: 'rgba(57, 80, 103, 0.7)',
                            hoverBackgroundColor: 'rgba(57, 80, 103, 0.6)',
                            hoverBorderColor: 'rgba(57, 80, 103, 1)',
                            lineTension: 0,
                            data: total
                        }
                    ]

                };

                var ctx = $("#purdate");

                var barGraph = new Chart(ctx, {
                    type: 'line',
                    data: chartdata
                });


            }
        });


        $.ajax({
            url: "<?php echo base_url('example/toppurchase')?>",
            async: false,
            type: "POST",
            data: { "tahun_beli": tahun_beli },
            dataType: "JSON",
            success: function(data) {

                var html = '';

                for(i=0; i<data.length; i++){
                    html += '<tr >'+
                        '<td>'+(i+1)+'</td>'+
                        '<td>'+data[i].nama_obat+'</td>'+
                        '<td>'+data[i].totSold+'</td>'+

                        '</tr>';
                }
                $("#toppurchase").html(html); //pass the data to your tbody
            }
        })


        $.ajax({
            url: "<?php echo base_url('example/leastpurchase')?>",
            async: false,
            type: "POST",
            data: { "tahun_beli": tahun_beli },
            dataType: "JSON",
            success: function(data) {

                var html = '';

                for(i=0; i<data.length; i++){
                    html += '<tr >'+
                        '<td>'+(i+1)+'</td>'+
                        '<td>'+data[i].nama_obat+'</td>'+
                        '<td>'+data[i].totSold+'</td>'+

                        '</tr>';
                }
                $("#leastpurchase").html(html); //pass the data to your tbody
            }
        })


        $.ajax({
            url: "<?php echo base_url('example/highpurchase')?>",
            async: false,
            type: "POST",
            data: { "tahun_beli": tahun_beli },
            dataType: "JSON",
            success: function(data) {

                var html = '';

                for(i=0; i<data.length; i++){
                    html += '<tr >'+
                        '<td>'+(i+1)+'</td>'+
                        '<td>'+data[i].nama_obat+'</td>'+
                        '<td>'+data[i].totEarned+'</td>'+

                        '</tr>';
                }
                $("#highpurchase").html(html); //pass the data to your tbody
            }
        })

        $.ajax({
            url: "<?php echo base_url('example/lowpurchase')?>",
            async: false,
            type: "POST",
            data: { "tahun_beli": tahun_beli },
            dataType: "JSON",
            success: function(data) {

                var html = '';

                for(i=0; i<data.length; i++){
                    html += '<tr >'+
                        '<td>'+(i+1)+'</td>'+
                        '<td>'+data[i].nama_obat+'</td>'+
                        '<td>'+data[i].totEarned+'</td>'+

                        '</tr>';
                }
                $("#lowpurchase").html(html); //pass the data to your tbody
            }
        })



    }

</script>


<script type="text/javascript">

    var purchase = $('#purchase').DataTable( {
        "paging":   false,
        "ordering": false,
        "info":     false,
        "searching": false,
    });

    $(document).on('change', '.nama_pemasok', function() {

        var nama_pemasok = $('.nama_pemasok').val();


        $.ajax({
            url : "<?php echo base_url('example/getmedbysupplier')?>",
            method : "POST",
            data : {nama_pemasok: nama_pemasok},
            async : false,
            dataType : 'json',
            success: function(data){
                var html = '';
                var i;
                html += '<option selected="true" value="" disabled >Pilih obat</option>';
                for(i=0; i<data.length; i++){
                    html += '<option>'+data[i].nama_obat+'</option>';
                }
                $('.nama_obat').html(html);

            }
        });
    });


    var count = 1;

    $('#addpurchase').on( 'click', function () {

        purchase.row.add( [
            '<select required="required" style="width:100%;" class="form-control nama_obat" id="nama_obat'+count+'" name="nama_obat[]" data-stok="#stok'+count+'" data-unit="#unit'+count+'" data-harga_beli="#harga_beli'+count+'"><option selected="true" value="" disabled >Pilih pemasok</option></select>',
            '<input id="stok'+count+'" name="stok[]" class="form-control stok" readonly >',
            '<input id="unit'+count+'" name="unit[]" class="form-control unit" readonly>',
            '<input id="harga_beli'+count+'" name="harga_beli[]" class="form-control harga_beli" readonly>',
            '<input type="number" id="banyak'+count+'" name="banyak[]" class="form-control banyak" required="required">',
            '<input id="subtotal'+count+'" name="subtotal[]" class="form-control subtotal" readonly>',
            '<button id="removeproduk" class="btn btn-danger btn-sm" type="button"><span class="fa fa-trash"></span> Hapus</button>',
        ] ).draw( false );

        var myOpt = [];
        $("select").each(function () {
            myOpt.push($(this).val());
        });
        $("select").each(function () {
            $(this).find("option").prop('hidden', false);
            var sel = $(this);
            $.each(myOpt, function(key, value) {
                if((value != "") && (value != sel.val())) {
                    sel.find("option").filter('[value="' + value +'"]').prop('hidden', true);
                }
            });
        });

        count++;

    } );



    $('#addpurchase').click();



    $('#purchase').on("click", "#removeproduk", function(){
        console.log($(this).parent());
        purchase.row($(this).parents('tr')).remove().draw(false);
        updatePurchase();
    });


    $('#purchase').on('change', '.nama_obat', function() {
        var $select = $(this);
        var nama_obat = $select.val();

        $.ajax({
            type: "POST",
            url: "<?php echo base_url('example/product')?>",
            dataType: "JSON",
            data: { nama_obat: nama_obat },
            cache: false,
            success: function(data) {
                $.each(data, function(nama_obat, stok, unit, harga_beli) {
                    $($select.data('stok')).val(data.stok);
                    $($select.data('unit')).val(data.unit);
                    $($select.data('harga_beli')).val(data.harga_beli);
                });
            }
        });

    });



    $('#purchase').on('change', '.banyak', function() {
        updateSubtotalp();

    });

    function updateSubtotalp() {

        $(".banyak").each(function(){
            var $row = $(this).closest('tr');
            var unitStock = parseInt($row.find('.stok').val()) ;
            var unitCount = parseInt($row.find('.banyak').val()) ;


            if (unitCount < 0){
                $row.find('.banyak').val(0);
                updateSubtotal();

            }
            else {

                var Sub = parseInt(($row.find('.harga_beli').val()) * unitCount);
                $row.find('.subtotal').val(Sub);
                updateTotal();


            }
        });
    }

    function updatePurchase() {
        var grandtotal = 0;
        $('.subtotal').each(function() {
            grandtotal += parseInt($(this).val());
        });
        $('#grandtotal').val(grandtotal);
    }

</script>


<script>
    $('#gabung').datetimepicker({

        format: 'YYYY',
        allowInputToggle: true
    })
        .on('dp.change', function(e) {

            gabungChart();
        });

    function gabungChart(){

        var tahun_beli = $('#gabung').data('date');


        $.ajax({
            type: "POST",
            url: "<?php echo base_url('example/gabung')?>",
            dataType: "JSON",

            data: { "tahun_beli": tahun_beli },
            success: function(data) {

                console.log(data);

                var total_inv = [];
                var total_pur = [];
                var month = [];

                for (var i in data){
                    total_inv.push(data[i].total_inv);
                    total_pur.push(data[i].total_pur);
                    month.push(data[i].month);
                }

                var chartdata = {
                    labels: month,
                    datasets : [
                        {
                            label: 'Total Pembelian',
                            backgroundColor: 'rgba(57, 80, 103, 0.4)',
                            borderColor: 'rgba(57, 80, 103, 0.7)',
                            hoverBackgroundColor: 'rgba(57, 80, 103, 0.6)',
                            hoverBorderColor: 'rgba(57, 80, 103, 1)',

                            data: total_pur
                        },
                        {
                            label: 'Total Penjualan',
                            backgroundColor: 'rgba(26, 187, 156, 0.3)',
                            borderColor: 'rgba(26, 187, 156, 0.7)',
                            hoverBackgroundColor: 'rgba(26, 187, 156, 0.6)',
                            hoverBorderColor: 'rgba(26, 187, 156, 1)',
                            data: total_inv


                        }
                    ]

                };

                var ctx = $("#report");

                var barGraph = new Chart(ctx, {
                    type: 'line',
                    data: chartdata,
                    options: {
                        responsive: true,
                        legend: {


                        },

                    }
                });


            }
        });



        $.ajax({
            url: "<?php echo base_url('example/gabung')?>",
            async: false,
            type: "POST",
            data: { "tahun_beli": tahun_beli },
            dataType: "JSON",
            success: function(data) {

                var html = '';
                var mytotal= '';
                var total_inv=0;
                var total_pur=0;


                for(i=0; i<data.length; i++){
                    html += '<tr >'+
                        '<td>'+(i+1)+'</td>'+
                        '<td>'+data[i].month+'</td>'+
                        '<td>'+(parseInt(data[i].total_inv)||0)+'</td>'+
                        '<td>'+(parseInt(data[i].total_pur)||0)+'</td>'+
                        '<td>'+(data[i].total_inv-data[i].total_pur)+'</td>'+
                        '</tr>';
                }
                $("#laba").html(html); //pass the data to your tbody


                for(i=0; i<data.length; i++){
                    total_inv += parseInt(data[i].total_inv) || 0;
                    total_pur += parseInt(data[i].total_pur) || 0;
                    mytotal = '<tr >'+
                        '<td>#</td>'+
                        '<td>Total</td>'+
                        '<td>'+total_inv+'</td>'+
                        '<td>'+total_pur+'</td>'+
                        '<td>'+(total_inv-total_pur)+'</td>'+
                        '</tr>';
                }
                $("#labatotal").html(mytotal); //pass the data to your tbody
            }


        })



    }

</script>

<script>
    $.ajax({

        url: "<?php echo base_url('example/chart_unit')?>",
        method: "GET",

        success: function(data) {
            var data = JSON.parse(data);
            console.log(data);


            var stok = [];
            var unit = [];

            for (var i in data){
                stok.push(data[i].stok);
                unit.push(data[i].unit);
            }

            var chartdata = {
                labels: unit,
                datasets : [
                    {
                        label: 'Stok obat',
                        backgroundColor: 'rgba(26, 187, 156, 0.7)',
                        borderColor: 'rgba(26, 187, 156, 0.7)',
                        hoverBackgroundColor: 'rgba(26, 187, 156, 1)',
                        hoverBorderColor: 'rgba(26, 187, 156, 1)',
                        data: stok
                    }
                ]
            };

            var ctx = $("#unit_chart");

            var barGraph = new Chart(ctx, {
                type: 'bar',
                data: chartdata
            });


        }
    });

</script>
</body>
</html>

