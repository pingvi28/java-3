<%--
  Created by IntelliJ IDEA.
  User: 79179
  Date: 10/31/2021
  Time: 10:17 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html>

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!--favicon-->
    <link rel="icon" href="${pageContext.request.contextPath}/static/images/icons/favicon.png" type="image/png"/>
    <!--plugins-->
    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/static/plugins/perfect-scrollbar/css/perfect-scrollbar.css"
          type="text/css"/>
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/main/bootstrap.min.css" type="text/css"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/main/icons.css" type="text/css"/>
    <!--my CSS -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/common.css" type="text/css"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/main/theme.css" type="text/css"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/main/app.css" type="text/css"/>

    <title>Lamp corner</title>
</head>

<body class="bg-theme bg-theme15">
<!--wrapper-->
<div class="wrapper toggled">
    <!--sidebar wrapper -->
    <div class="sidebar-wrapper" data-simplebar="true">
        <div class="sidebar-header">
            <div>
                <h4 class="logo-text">Lamp corner</h4>
            </div>
            <div class="toggle-icon ms-auto"><i class='bx bx-arrow-to-left'></i>
            </div>
        </div>
        <!--navigation-->
        <!--navigation-->
        <ul class="metismenu" id="menu">
            <li>
                <a href="${pageContext.request.contextPath}/corner">
                    <div class="parent-icon"><i class='bx bx-home-circle'></i></div>
                    <div class="menu-title">Главная страница</div>
                </a>
            </li>
            <li>
                <a href="">
                    <div class="parent-icon"><i class="bx bx-user-circle"></i></div>
                    <div class="menu-title">Личный кабинет</div>
                </a>
            </li>
        </ul>
        <!--end navigation-->
    </div>
    <!--end sidebar wrapper -->
    <!--start header -->
    <header>
        <div class="topbar d-flex align-items-center">
            <nav class="navbar navbar-expand">
                <div class="mobile-toggle-menu"><i class='bx'></i></div>
                <div class="search-bar flex-grow-1"></div>
                <div class="header-notifications-list"></div>
                <div class="header-message-list"></div>
                <div class="user-box dropdown">
                    <a class="d-flex dropdown-toggle-nocaret down" href="#"
                       role="button" data-bs-toggle="dropdown" aria-expanded="false">
                        <img src="${pageContext.request.contextPath}/static/images/profile/water.png" class="user-img"
                             alt="user avatar">
                        <div class="user-info ps-3">
                            <p class="user-name mb-0">Частичка вселенной*</p>
                            <label class="designattion mb-0" for="first-name"></label>
                            <h6 id="first-name">
                                <c:if test="${not empty FirstName}">
                                    ${FirstName}
                                </c:if>
                            </h6>
                        </div>
                    </a>

                    <ul class="dropdown-menu dropdown-menu-end">
                        <li><a class="dropdown-item" href="${pageContext.request.contextPath}/userProfile"><i
                                class="bx bx-user"></i><span>Профиль</span></a>
                        </li>
                        <li>
                            <div class="dropdown-divider mb-0"></div>
                        </li>
                        <li><a class="dropdown-item" href="javascript:"><i
                                class='bx bx-log-out-circle'></i><span>Выйти</span></a>
                        </li>
                    </ul>
                </div>
            </nav>
        </div>
    </header>
    <!--end header -->
    <!--start page wrapper -->
    <div class="page-wrapper">
        <div class="page-content">
            <!--breadcrumb-->
            <div class="page-breadcrumb d-none d-sm-flex align-items-center mb-3">
                <div class="breadcrumb-title pe-3">Личный кабинет</div>
                <div class="ps-3">
                    <nav>
                        <ol class="breadcrumb mb-0 p-0">
                            <li class="breadcrumb-item"><a href="${pageContext.request.contextPath}/corner"><i
                                    class="bx bx-home-alt"></i></a>
                            </li>
                            <li class="breadcrumb-item active" aria-current="page">Твой профиль</li>
                        </ol>
                    </nav>
                </div>
            </div>
            <!--end breadcrumb-->
            <div class="container">
                <div class="main-body">
                    <div class="row">
                        <div class="col-lg-4">
                            <div class="d-flex flex-column align-items-center text-center">
                                <img src="${pageContext.request.contextPath}/static/images/profile/water.png" alt=""
                                     class="rounded-circle p-1" width="150">
                                <div>
                                    <label for="full-name"></label>
                                    <h4 id="full-name">
                                        <c:if test="${not empty fullName}">
                                            ${fullName}
                                        </c:if>
                                    </h4>
                                </div>

                                <div>
                                    <label class="mb-0" for="email"></label>
                                    <h5 id="email">
                                        <c:if test="${not empty email}">
                                            ${email}
                                        </c:if>
                                    </h5>
                                </div>
                            </div>
                        </div>
                        <div class="col-lg-8">
                            <div class="card">
                                <div class="card-body">
                                    <form action="${pageContext.request.contextPath}/updateNS" id="stopSend" method="post">
                                        <div class="row mb-3">
                                            <div class="upd col-sm-3">
                                                <h6 class="mb-0">Фамилия</h6>
                                            </div>
                                            <div class="col-sm-9">
                                                <label>
                                                    <input type="text" name="changedSurname" class="form-control item"
                                                           placeholder="Фамилия" required/>
                                                </label>
                                            </div>
                                        </div>
                                        <div class="row mb-3">
                                            <div class="upd col-sm-3">
                                                <h6 class="mb-0">Имя</h6>
                                            </div>
                                            <div class="col-sm-9">
                                                <label>
                                                    <input type="text" name="changedName" class="form-control item"
                                                           placeholder="Имя" required/>
                                                </label>
                                            </div>
                                        </div>
                                        <div class="row mb-3">
                                            <div class="upd col-sm-3">
                                                <h6 class="mb-0">Текущий пароль</h6>
                                            </div>
                                            <div class="col-sm-9">
                                                <label>
                                                    <input type="password" name="passwordCur" id="passwordCur" class="form-control item"
                                                           minlength="6" placeholder="Текущий пароль" required/>
                                                </label>
                                                <a href="#" class="password-control3"></a>
                                            </div>
                                        </div>
                                        <div class="row">
                                            <div class="col-sm-3"></div>
                                            <div class="col-sm-9">
                                                <label>
                                                    <input type="submit" class="btn" value="save"/>
                                                </label>
                                            </div>
                                        </div>
                                    </form>
                                </div>
                            </div>
                        </div>

                        <div class="col-lg-4">
                            <div class="d-flex flex-column align-items-center text-center">

                            </div>
                        </div>
                        <div class="col-lg-8" >
                            <div class="card">
                                <div class="card-body" id = "2form">
                                    <form action="${pageContext.request.contextPath}/updatePas"  method="post">
                                        <div class="row mb-3">
                                            <div class="upd col-sm-3">
                                                <h6 class="mb-0">Текущий пароль</h6>
                                            </div>
                                            <div class="col-sm-9">
                                                <label>
                                                    <input type="password" name="passwordCur2" id="passwordCur2" class="form-control item"
                                                           minlength="6" placeholder="Текущий пароль" required/>
                                                </label>
                                                <a href="#" class="password-control4"></a>
                                            </div>
                                        </div>
                                        <div class="row mb-3">
                                            <div class="upd col-sm-3">
                                                <h6 class="mb-0">Новый пароль</h6>
                                            </div>
                                            <div class="col-sm-9">
                                                <label>
                                                    <input type="password" name="password" id="password" class="form-control item"
                                                           minlength="6" placeholder="Новый пароль" required/>
                                                </label>
                                                <a href="#" class="password-control"></a>
                                            </div>
                                        </div>
                                        <div class="row mb-3">
                                            <div class="upd col-sm-3">
                                                <h6 class="mb-0">Повтор нового пароля</h6>
                                            </div>
                                            <div class="col-sm-9">
                                                <label>
                                                    <input type="password" name="passwordRep" id="passwordRep" class="form-control item"
                                                           minlength="6" placeholder="Повтори" required/>
                                                </label>
                                                <a href="#" class="password-control2"></a>
                                            </div>
                                        </div>
                                        <div class="row">
                                            <div class="col-sm-3"></div>
                                            <div class="col-sm-9">
                                                <label>
                                                    <input type="submit" class="btn" value="save"/>
                                                </label>
                                            </div>
                                        </div>
                                    </form>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <!--end page wrapper -->


    <!--end wrapper-->
    <!--start switcher-->
    <div class="switcher-wrapper" id="id01">
        <div class="switcher-btn"><i class='bx bx-cog bx-spin'></i>
        </div>
        <div class="switcher-body">
            <div class="d-flex align-items-center">
                <h5 class="switcher-text text-uppercase">Настрой сайт под себя</h5>
                <button type="button" class="btn-close ms-auto close-switcher" aria-label="Close"></button>
            </div>
            <hr/>
            <div class="scroll">
                <p class="switcher-text category">Вжух💫</p>
                <hr>
                <ul class="switcher">
                    <li id="theme1"></li>
                    <li id="theme2"></li>
                    <li id="theme3"></li>
                    <li id="theme4"></li>
                    <li id="theme5"></li>
                    <li id="theme6"></li>
                </ul>
                <hr>
                <p class="switcher-text category ">Градиент</p>
                <hr>
                <ul class="switcher">
                    <li id="theme7"></li>
                    <li id="theme8"></li>
                    <li id="theme9"></li>
                    <li id="theme10"></li>
                    <li id="theme11"></li>
                    <li id="theme12"></li>
                </ul>
                <hr>
                <p class="switcher-text category">Персональное)</p>
                <hr>
                <ul class="switcher">
                    <li id="theme13"></li>
                    <li id="theme14"></li>
                    <li id="theme15"></li>
                </ul>
            </div>
        </div>
    </div>
    <!--end switcher-->
</div>
<!-- Bootstrap JS -->
<script src="${pageContext.request.contextPath}/static/js/boot/bootstrap.bundle.min.js"></script>
<!--plugins-->
<script src="${pageContext.request.contextPath}/static/js/jquery.min.js"></script>
<script src="${pageContext.request.contextPath}/static/plugins/perfect-scrollbar/js/perfect-scrollbar.js"></script>
<!--app JS-->
<script src="${pageContext.request.contextPath}/static/js/boot/app.js"></script>
<script src="${pageContext.request.contextPath}/static/js/showPas.js"></script>
<script src="${pageContext.request.contextPath}/static/js/pasSigUpCorrect.js"></script>
<script src="${pageContext.request.contextPath}/static/js/sendFormStop.js"></script>
</body>

</html>
