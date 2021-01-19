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
                                    <!-- navbar-->
                                    <header class="header">
                                        <nav class="navbar navbar-expand-lg px-4 py-2 bg-white shadow"><a href="#" class="sidebar-toggler text-gray-500 mr-4 mr-lg-5 lead"><i class="fas fa-align-left"></i></a><a href="<%=request.getContextPath()%>/home" class="navbar-brand ">Müsteri Yönetim</a>
                                        </nav>
                                    </header>
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
                                            <li class="sidebar-list-item"><a href="#" data-toggle="collapse" data-target="#pages" aria-expanded="false" aria-controls="pages" class="sidebar-link text-muted"><i class="o-user-1 mr-3 text-gray"></i><span>Kullanıcı</span></a>
                                                
                                                <div id="pages" class="collapse">
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
                                            <li class="sidebar-list-item"><a href="index.jsp" class="sidebar-link text-muted"><i class="o-exit-1 mr-3 text-gray"></i><span>Login</span></a></li>
                                        </ul>
                                    </div>
<%-- arabölümilk--%>                                                        
                 <div class="col-lg-10 mb-5">
                <div class="card">
                  <div class="card-header">
                    <h3 class="h6 mb-0">Müşteri Kayıt Formu</h3>
                  </div>
                  <div class="card-body">
                      <c:if test="${musteri != null}">
                        <form class="form-horizontal" action="musupdate" method="post">
                            </c:if>
                         <c:if test="${musteri == null}">
                            <form class="form-horizontal" action="musinsert" method="post" >
                                </c:if>
                                
                                
                                       <caption>
                                        <h2>
                                            <c:if test="${musteri != null}">
                                                Düzeltme
                                            </c:if>
                                            <c:if test="${musteri == null}">
                                                Yeni Müşteri Kayıt

                                            </c:if>
                                        </h2>
                                    </caption>

                                    <c:if test="${musteri != null}">
                                        <input type="hidden" name="id" value="<c:out value='${musteri.id}' />" />
                                    </c:if>
                    
                      <div class="form-group row">
                        <label class="col-md-2 form-control-label">Müsteri Türü</label>
                        <div class="col-md-3 select mb-3">
                          <select type="text" value="<c:out value='${musteri.turu}' />" name="turu" class="form-control">
                            <option>Gerçek Müşteri</option>
                            <option>Potansiyel Müşteri</option>
                            <option>Kişisel Müşteri</option>
                          </select>
                            

                            
                        </div>
                        
                                              
                        
                      </div>
                      <div class="form-group row">
                        <label class="col-md-2 form-control-label">Müşteri Kodu</label>
                        <div class="col-md-9">
                          <div class="row">
                            <div class="col-md-4">
                             <input type="text" value="<c:out value='${musteri.kodu}' />" class="form-control" name="kodu" required="required" placeholder="Müşteri Kodu">
                            </div>
                              <label class="col-md-3 form-control-label">Müşteri Gsm</label>
                            <div class="col-md-4">
                              <input type="text" value="<c:out value='${musteri.gsm}' />" class="form-control" name="gsm" required="required" placeholder="Müşteri gsm">
                            </div>
                          </div>
                        </div>
                      </div>
                       <div class="form-group row">
                        <label class="col-md-2 form-control-label">Müşteri Adı</label>
                        <div class="col-md-9">
                          <div class="row">
                            <div class="col-md-4">
                              <input type="text" value="<c:out value='${musteri.adi}' />" class="form-control" name="adi" required="required" placeholder="Müşteri veya Firma Adı">
                            </div>
                              <label class="col-md-3 form-control-label">Müşteri İş Tel</label>
                            <div class="col-md-4">
                              <input type="text" value="<c:out value='${musteri.tel}' />" class="form-control" name="tel" required="required" placeholder="Müşteri İş Tel">
                            </div>
                          </div>
                        </div>
                      </div>
                       <div class="form-group row">
                        <label class="col-md-2 form-control-label">Yetkili Adı</label>
                        <div class="col-md-9">
                          <div class="row">
                            <div class="col-md-4">
                              <input type="text" value="<c:out value='${musteri.yetkiliadi}' />" class="form-control" name="yetkiliadi" required="required" placeholder="Müşteri veya Firma Yetkili Adı">
                            </div>
                              <label class="col-md-3 form-control-label">Müşteri Ülke</label>
                            <div class="col-md-4">
                              <select type="text" value="<c:out value='${musteri.ulke}' />" class="form-control" name="ulke">  
                                 <option >Türkiye</option>
                              </select>
                            </div>
                          </div>
                        </div>
                      </div>
                       <div class="form-group row">
                        <label class="col-md-2 form-control-label">Müşteri e-mail</label>
                        <div class="col-md-9">
                          <div class="row">
                            <div class="col-md-4">
                              <input type="text" value="<c:out value='${musteri.email}' />" class="form-control" name="email" required="required" placeholder="Müşteri e-mail"> 
                            </div>
                              <label class="col-md-3 form-control-label">Müşteri Şehir</label>
                            <div class="col-md-4">
                              <input type="text" value="<c:out value='${musteri.sehir}' />" class="form-control" name="sehir" required="required" placeholder="Şehir">  
                            </div>
                          </div>
                        </div>
                      </div>
                       
                      <div class="form-group row">
                        <label class="col-md-2 form-control-label">Müşteri Adres</label>
                        <div class="col-md-9">
                          <div class="row">
                            <div class="col-md-9">
                             <input type="text" value="<c:out value='${musteri.adres}' />" class="form-control" name="adres" required="required" placeholder="Adres">
                            </div>
                          </div>
                        </div>
                      </div>
                        <div class="line"></div>
                            <div class="form-group row">
                                <div class="col-md-12 ml-auto">
                                    
                                    <button type="submit" class="btn btn-primary">Kaydet Liste</button>
                                </div>
                             </div>
                    </form>
                  </div>
                </div>
              </div>
 <%-- arabölüm son--%>                                        
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