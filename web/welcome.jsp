<%-- 
    Document   : index
    Created on : 24.Ara.2020, 13:39:26
    Author     : MGUL
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<!DOCTYPE html>

<html lang="tr">
    <head>
                <meta charset="utf-8">
                        <meta http-equiv="X-UA-Compatible" content="IE=edge">
                        <title>Müşteri Yönetim Sistemi</title>
                        <meta name="description" content="">
                        <meta name="viewport" content="width=device-width, initial-scale=1">
                        <meta name="robots" content="all,follow">
                        

    <!-- Bootstrap CSS-->
    <link rel="stylesheet" href="vendor/bootstrap/css/bootstrap.min.css">
        <!-- Font Awesome CSS-->
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.3.1/css/all.css" integrity="sha384-mzrmE5qonljUremFsqc01SB46JvROS7bZs3IO2EmfFsd15uHvIt+Y8vEf7N7fWAU" crossorigin="anonymous">
            <!-- Google fonts - Popppins for copy-->
            <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Poppins:300,400,800">
                <!-- orion icons-->
                <link rel="stylesheet" href="css/orionicons.css">
                    <!-- theme stylesheet-->
                    <link rel="stylesheet" href="css/style.default.css" id="theme-stylesheet">
                        <!-- Custom stylesheet - for your changes-->
                        <link rel="stylesheet" href="css/custom.css">
                            <!-- Favicon-->
                            <link rel="shortcut icon" href="img/favicon.png?3">
                                <!-- Tweaks for older IEs--><!--[if lt IE 9]>
                                    <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
                                    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script><![endif]-->
                                </head>
                                <body>
                                    <header class="header">
                                        <nav class="navbar navbar-expand-lg px-4 py-2 bg-white shadow"><a href="#" class="sidebar-toggler text-gray-500 mr-4 mr-lg-5 lead"><i class="fas fa-align-left"></i></a><a href="<%=request.getContextPath()%>/home" class="navbar-brand ">Müsteri Yönetim</a>
                                        </nav>
                                    </header>

                                    <!-- navbar-->

                                <div class="d-flex align-items-stretch">
                                    <div id="sidebar" class="sidebar py-3">
                                        <ul>
                                                <li><a> Hoşgeldin:<%=session.getAttribute("tamadi")%></a></li>
                                                <li><a> Yetki:<%=session.getAttribute("turu")%></a></li>
                                        </ul>                                        
                                        <div class="text-gray-400 px-3 px-lg-4 py-4 font-weight-bold small headings-font-family">Menü</div>
                                        <ul class="sidebar-menu list-unstyled">
                                            <c:set var="yetki" scope="session" value="${yetki}"/>
                                            <li class="sidebar-list-item"><a href="<%=request.getContextPath()%>/home" class="sidebar-link text-muted active"><i class="o-home-1 mr-3 text-gray"></i><span>Ana Sayfa</span></a></li>
                                            <c:if test="${yetki=="Admin" || yetki=="User"}" > 
                                            <li class="sidebar-list-item"><a href="#" data-toggle="collapse" data-target="#pages" aria-expanded="false" aria-controls="pagess" class="sidebar-link text-muted"><i class="o-user-1 mr-3 text-gray"></i><span>Müsteri</span></a>
                                                <div id="pages" class="collapse">
                                                    <ul class="sidebar-menu list-unstyled border-left border-primary border-thick">
                                                       <li class="sidebar-list-item"><a href="<%=request.getContextPath()%>/newmus" class="sidebar-link text-muted pl-lg-5">Müsteri Kayıt</a></li>
                                                        <li class="sidebar-list-item"><a href="<%=request.getContextPath()%>/listmus" class="sidebar-link text-muted pl-lg-5">Müsteri Listesi</a></li>
                                                    </ul>
                                                </div>
                                            </li>
                                            </c:if>

                                            <li class="sidebar-list-item"><a href="<%=request.getContextPath()%>/istektalep" class="sidebar-link text-muted"><i class="o-imac-screen-1 mr-3 text-gray"></i><span>İstek-Talep İşlemleri</span></a></li>

                                            <c:if test="${yetki=="Admin" || yetki=="User"}" > 
                                            <li class="sidebar-list-item"><a href="<%=request.getContextPath()%>/listkontak" class="sidebar-link text-muted"><i class="o-sales-up-1 mr-3 text-gray"></i><span>Kontak İşlemleri</span></a></li>
                                            </c:if>
                                            
                                            <c:if test="${yetki=="Admin"}" > 
                                            <li class="sidebar-list-item"><a href="<%=request.getContextPath()%>/listteklif" class="sidebar-link text-muted"><i class="o-table-content-1 mr-3 text-gray"></i><span>Teklif İşlemleri</span></a></li>
                                            </c:if>
                                            <c:if test="${yetki=="User"}" >  
                                            <li class="sidebar-list-item"><a href="<%=request.getContextPath()%>/home" class="sidebar-link text-muted"><i class="o-table-content-1 mr-3 text-gray"></i><span>Teklif İşlemleri</span></a></li>
                                            </c:if>
                                            <c:if test="${yetki=="Admin" || yetki=="User"}" >
                                            <li class="sidebar-list-item"><a href="#" data-toggle="collapse" data-target="#user" aria-expanded="false" aria-controls="pages" class="sidebar-link text-muted"><i class="o-user-1 mr-3 text-gray"></i><span>Kullanıcı</span></a>
                                                
                                                <div id="user" class="collapse">
                                                    <c:if test="${yetki=="Admin"}" > 
                                                    <ul class="sidebar-menu list-unstyled border-left border-primary border-thick">
                                                        <li class="sidebar-list-item"><a href="<%=request.getContextPath()%>/new" class="sidebar-link text-muted pl-lg-5">Kullanıcı Kayıt</a></li>
                                                        <li class="sidebar-list-item"><a href="<%=request.getContextPath()%>/list" class="sidebar-link text-muted pl-lg-5">Kullanıcı Listesi</a></li>
                                                    </ul>
                                                </div>
                                                    </c:if>
                                                    <c:if test="${yetki=="User"}" > 
                                                    <ul class="sidebar-menu list-unstyled border-left border-primary border-thick">
                                                        <li class="sidebar-list-item"><a href="<%=request.getContextPath()%>/home" class="sidebar-link text-muted pl-lg-5">Kullanıcı Kayıt</a></li>
                                                        <li class="sidebar-list-item"><a href="<%=request.getContextPath()%>/home" class="sidebar-link text-muted pl-lg-5">Kullanıcı Listesi</a></li>
                                                    </ul>
                                                </div>
                                                    </c:if>
                                            </li>
                                                </c:if>
                                            <li class="sidebar-list-item"><a href="index.jsp" class="sidebar-link text-muted"><i class="o-exit-1 mr-3 text-gray"></i><span>Logout</span></a></li>
                                        </ul>
                                    </div>
 <%-- arabölüm --%>                 
                                    <c:if test="${yetki=="Admin"}" >
                                    <div class="page-holder w-70 d-flex flex-wrap">
                                        <div class="container-fluid px-xl-5">
                                            <section class="py-5">
                                                <div class="row">
                                                    <div class="col-xl-3 col-lg-6 mb-4 mb-xl-0">
                                                        <div class="bg-white shadow roundy p-4 h-100 d-flex align-items-center justify-content-between">
                                                            <div class="flex-grow-1 d-flex align-items-center">
                                                                <div class="dot mr-3 bg-violet"></div>
                                                                <div class="text">
                                                                    <h6 class="mb-0">Toplam Müşteri</h6>
                                                                    <span class="text-gray">
                                                                    <%=session.getAttribute("msayi")%>
                                                                    </span>

                                                                </div>
                                                            </div>
                                                            <div class="icon text-white bg-violet"><i class="fas fa-server"></i></div>
                                                        </div>
                                                    </div>
                                                    <div class="col-xl-3 col-lg-6 mb-4 mb-xl-0">
                                                        <div class="bg-white shadow roundy p-4 h-100 d-flex align-items-center justify-content-between">
                                                            <div class="flex-grow-1 d-flex align-items-center">
                                                                <div class="dot mr-3 bg-green"></div>
                                                                <div class="text">
                                                                    <h6 class="mb-0">Gerçek Müşteri</h6>
                                                                    <span class="text-gray">
                                                                       <%=session.getAttribute("gsayi")%>
                                                                    </span>
                                                                </div>
                                                            </div>
                                                            <div class="icon text-white bg-green"><i class="far fa-clipboard"></i></div>
                                                        </div>
                                                    </div>
                                                    <div class="col-xl-3 col-lg-6 mb-4 mb-xl-0">
                                                        <div class="bg-white shadow roundy p-4 h-100 d-flex align-items-center justify-content-between">
                                                            <div class="flex-grow-1 d-flex align-items-center">
                                                                <div class="dot mr-3 bg-blue"></div>
                                                                <div class="text">
                                                                    <h6 class="mb-0">Potansiyel Müşteri</h6>
                                                                    <span class="text-gray">
                                                                        <%=session.getAttribute("psayi")%>
                                                                    </span>
                                                                </div>
                                                            </div>
                                                            <div class="icon text-white bg-blue"><i class="fa fa-dolly-flatbed"></i></div>
                                                        </div>
                                                    </div>
                                                    <div class="col-xl-3 col-lg-6 mb-4 mb-xl-0">
                                                        <div class="bg-white shadow roundy p-4 h-100 d-flex align-items-center justify-content-between">
                                                            <div class="flex-grow-1 d-flex align-items-center">
                                                                <div class="dot mr-3 bg-red"></div>
                                                                <div class="text">
                                                                    <h6 class="mb-0">Kişisel Müşteri</h6>
                                                                    <span class="text-gray">
                                                                        <%=session.getAttribute("ksayi")%>
                                                                    </span>
                                                                </div>
                                                            </div>
                                                            <div class="icon text-white bg-red"><i class="fas fa-receipt"></i></div>
                                                        </div>
                                                    </div>
                                                </div>
                                            </section>
                                            <section class="py-5">
                                                <div class="row">
                                                    <div class="col-xl-3 col-lg-6 mb-4 mb-xl-0">
                                                        <div class="bg-white shadow roundy p-4 h-100 d-flex align-items-center justify-content-between">
                                                            <div class="flex-grow-1 d-flex align-items-center">
                                                                <div class="dot mr-3 bg-secondary"></div>
                                                                <div class="text">
                                                                    <h6 class="mb-0">Toplam Teklif</h6>
                                                                    <span class="text-gray">
                                                                    <%=session.getAttribute("tekliftoplam")%>
                                                                    </span>

                                                                </div>
                                                            </div>
                                                            <div class="icon text-white bg-secondary"><i class="far fa-clipboard"></i></div>
                                                        </div>
                                                    </div>
                                                    <div class="col-xl-3 col-lg-6 mb-4 mb-xl-0">
                                                        <div class="bg-white shadow roundy p-4 h-100 d-flex align-items-center justify-content-between">
                                                            <div class="flex-grow-1 d-flex align-items-center">
                                                                <div class="dot mr-3 bg-green"></div>
                                                                <div class="text">
                                                                    <h6 class="mb-0">Onaylı Teklif</h6>
                                                                    <span class="text-gray">
                                                                       <%=session.getAttribute("onayli")%>
                                                                    </span>
                                                                </div>
                                                            </div>
                                                            <div class="icon text-white bg-green"><i class="far fa-clipboard"></i></div>
                                                        </div>
                                                    </div>
                                                    <div class="col-xl-3 col-lg-6 mb-4 mb-xl-0">
                                                        <div class="bg-white shadow roundy p-4 h-100 d-flex align-items-center justify-content-between">
                                                            <div class="flex-grow-1 d-flex align-items-center">
                                                                <div class="dot mr-3 bg-blue"></div>
                                                                <div class="text">
                                                                    <h6 class="mb-0">Onaysız Teklif</h6>
                                                                    <span class="text-gray">
                                                                        <%=session.getAttribute("onaysiz")%>
                                                                    </span>
                                                                </div>
                                                            </div>
                                                            <div class="icon text-white bg-blue"><i class="fa fa-dolly-flatbed"></i></div>
                                                        </div>
                                                    </div>
                                                    <div class="col-xl-3 col-lg-6 mb-4 mb-xl-0">
                                                        <div class="bg-white shadow roundy p-4 h-100 d-flex align-items-center justify-content-between">
                                                            <div class="flex-grow-1 d-flex align-items-center">
                                                                <div class="dot mr-3 bg-red"></div>
                                                                <div class="text">
                                                                    <h6 class="mb-0">Teklifler Tutar</h6>
                                                                    <span class="text-gray">
                                                                        <%=session.getAttribute("onaylitutar")%>
                                                                    </span>
                                                                </div>
                                                            </div>
                                                            <div class="icon text-white bg-red"><i class="fas fa-receipt"></i></div>
                                                        </div>
                                                    </div>
                                                </div>
                                            </section>                                                                    
                                            



                                        </div>
                                    </div>
                                </c:if>
                                <c:if test="${yetki=="User" || yetki=="Müşteri"}" >
                                    <div class="col-lg-8 mb-4 mb-lg-4" align="center">
                                        <img align="middle" src="img/muratpng.png" alt="centered image" />
                                    </div>
                                </c:if>
<%-- arabölümson                                                    --%>
                                </div>
                                <!-- JavaScript files-->
                                <script src="vendor/jquery/jquery.min.js"></script>
                                <script src="vendor/popper.js/umd/popper.min.js"></script>
                                <script src="vendor/bootstrap/js/bootstrap.min.js"></script>
                                <script src="vendor/jquery.cookie/jquery.cookie.js"></script>
                                <script src="vendor/chart.js/Chart.min.js"></script>
                                <script src="https://cdn.jsdelivr.net/npm/js-cookie@2/src/js.cookie.min.js"></script>
                                <script src="js/charts-home.js"></script>
                                <script src="js/front.js"></script>
                                </body>
                                </html>
