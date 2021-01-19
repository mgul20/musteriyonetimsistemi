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
                                <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto">
                                <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
                                <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
                                <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>                                
                                </head>
                                <style>
                                    
table.table td a.view {
    color: #03A9F4;
}
table.table td a.edit {
    color: #FFC107;
}
table.table td a.delete {
    color: #E34724;
}
table.table td a.kontak {
    color: #34ce57;
}
                                </style>                                  
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
                 <div class="col-lg-4 mb-5">
                <div class="card">
                  <div class="card-header">
                    <h3 class="h6 mb-0">Müşteri Detay</h3>

                  </div>
                                        <ul>
                                            <font color="red"><li><a> Müşteri Türü:</font>  ${musteri.turu}</a></li>
                                            <font color="red"><li><a> Müşteri Kodu:</font>  ${musteri.kodu}</a></li>
                                            <font color="red"><li><a> Müşteri Adı :</font>  ${musteri.adi}</a></li>
                                            <font color="red"><li><a> Müşteri Yetkili :</font> ${musteri.yetkiliadi}</a></li>
                                            <font color="red"><li><a> Müşteri email:</font>  ${musteri.email}</a></li>
                                            <font color="red"><li><a> Müşteri Gsm :</font>  ${musteri.gsm}</a></li>
 <div class="line"></div>                                       
<a href="teklifmus?id=<c:out value='${musteri.id}' />"<button type="button" class="btn btn-primary">Teklif Ekle</button>
<a href="kontakmus?id=<c:out value='${musteri.id}' />"<button type="button" class="btn btn-success">Kontak ekle</button></a>
<button type="button" class="btn btn-warning">Uyarı Gir</button>
<a href="<%=request.getContextPath()%>/listmus"<button type="button" class="btn btn-dark">Listeye Dön</button></a>

               
             </ul>
                      <%--kontak detay--%>
             
               
                  <div class="card-header">
                    <h6 class=" mb-0">Kontak Listesi</h6>
                  </div>
                 
                      <div class="card-body">                           
                    <table class="table table-striped table-hover card-text">
                      <thead>
                       <tr>
                                <th>Departman</th>
                                <th>Unvan</th>
                                <th>Hitap</th>
                                <th>gsm</th>
                                <th>Tel</th>
                                <th>email</th>
                       </tr>
                      </thead>
                      <tbody>
<c:forEach var="kontak" items="${kontak}">

                                <tr>
                                    <td>
                                        <c:out value="${kontak.departman}" />
                                    </td>
                                    <td>
                                        <c:out value="${kontak.unvan}" />
                                    </td>
                                    <td>
                                        <c:out value="${kontak.hitap}" />
                                    </td>
                                    <td>
                                        <c:out value="${kontak.gsm}" />
                                    </td>
                                    <td>
                                        <c:out value="${kontak.tel}" />
                                    </td>
                                    <td>
                                        <c:out value="${kontak.email}" />
                                    </td>
                                                                
                                </tr>
                            </c:forEach>
                      </tbody>
                    </table>
                  </div>
                </div>
              </div>
                                       <div class="col-lg-6 mb-5">
                                         <div class="card">
                                            <div class="card-header">
                                                <h3 class="h6 mb-0">Teklifler</h3>
                                         <div class="card-body">                           
                                                 <table class="table table-sm table-hover card-text">
                                             <thead>
                                                        <tr class="thead-dark">
                                                                 <th>Tamam</th>
                                                                 <th>Onay</th>                                                            
                                                                 <th>Teklif No</th>
                                                                 <th>Durumu</th>
                                                                 <th>Konu</th>
                                                                 <th>Tarih</th>
                                                                 <th>Aciklama</th>
                                                                 <th>Action</th>

                                                        </tr>
                                            </thead>
                                            <tbody>
<c:forEach var="teklif" items="${teklif}">

                                <tr>
                                    <td>
                                        <c:set var="tamam" scope="session" value="${teklif.tamamla}"/>
                                        <c:if test="${tamam=="1"}">
                                       <img src="img/onay.png"></img>
                                        </c:if>
                                        <c:if test="${tamam=="0"}">
                                       <img src="img/onaysiz.png"></img>
                                        </c:if>
                                    </td>
                                    <td>
                                        <c:set var="onay" scope="session" value="${teklif.onay}"/>
                                        <c:if test="${onay=="1"}">
                                       <img src="img/onay.png"></img>
                                        </c:if>
                                        <c:if test="${onay=="0"}">
                                       <img src="img/onaysiz.png"></img>
                                        </c:if>
                                    </td>                                     
                                    <td>
                                        <c:out value="${teklif.teklif_no}" />
                                    </td>
                                    <td>
                                        <c:out value="${teklif.durumu}" />
                                    </td>
                                    <td>
                                        <c:out value="${teklif.konu}" />
                                    </td>
                                    <td>
                                        <c:out value="${teklif.tarih}" />
                                    </td>
                                    <td>
                                        <c:out value="${teklif.aciklama}" />
                                    </td>                                   
                                    <td>
                                    <a href="teklifdetayekle?id=<c:out value='${teklif.id}' />" class="view" title="Detay" data-toggle="tooltip"><i class="material-icons">&#xE417;</i></a>
                                    <a href="teklifdetayekle?id=<c:out value='${teklif.id}' />" class="edit" title="Detay Ekle" data-toggle="tooltip"><i class="material-icons">&#xE254;</i></a>
                                    <a href="#" class="delete" title="Sil" data-toggle="tooltip"><i class="material-icons">&#xE872;</i></a>
                                    
                                    </td>                             
                                </tr>
                            </c:forEach>
                      </tbody>
                    </table>
                  </div>
                                            </div>
                                         </div>
                                        </div>
                        <%--kontak detayson--%>                        
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