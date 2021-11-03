<%--
  Created by IntelliJ IDEA.
  User: 79179
  Date: 10/13/2021
  Time: 1:11 AM
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
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/plugins/perfect-scrollbar/css/perfect-scrollbar.css" type="text/css"/>
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/main/bootstrap.min.css" type="text/css"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/main/icons.css" type="text/css"/>
    <!--my CSS -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/common.css" type="text/css"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/main/styleYT.css" type="text/css"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/main/theme.css" type="text/css"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/main/app.css" type="text/css"/>

    <title>Lamp corner</title>
</head>

<body class="bg-theme bg-theme13">
    <!--wrapper-->
    <div class="wrapper">
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
            <ul class="metismenu" id="menu">
                <li>
                    <a href="">
                        <div class="parent-icon"><i class='bx bx-home-circle'></i>
                        </div>
                        <div class="menu-title">Главная страница</div>
                    </a>
                </li>
                <li>
                    <a href="${pageContext.request.contextPath}/userProfile">
                        <div class="parent-icon"><i class="bx bx-user-circle"></i>
                        </div>
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
                    <div class="mobile-toggle-menu"><i class='bx bx-menu'></i>
                    </div>
                    <div class="search-bar flex-grow-1"></div><div class="header-notifications-list"></div><div class="header-message-list"></div>
                    <div class="user-box dropdown">
                        <a class="d-flex dropdown-toggle-nocaret down" href="#"
                           role="button" data-bs-toggle="dropdown" aria-expanded="false">
                            <img src="${pageContext.request.contextPath}/static/images/profile/water.png" class="user-img" alt="user avatar">
                            <div class="user-info ps-3">
                                <p class="user-name mb-0">Частичка вселенной*</p>
                                <label class="" for="first-name"></label>
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
                            <li><a class="dropdown-item" href="javascript:;"><i
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

                <div class="ytd-rich-grid-video-renderer row row-cols-1 row-cols-md-2 row-cols-lg-4">

                    <div class="myRow ytd-rich-item-renderer">
                        <div class="bg-light text-center">
                            <div class="p-4 text-dark rounded">
                                <iframe class="videoFrame" width="230" height="140" src="" frameborder="0"
                                        allowfullscreen ></iframe>
                            </div>
                        </div>
                    </div>
                    <div class="myRow ytd-rich-item-renderer">
                        <div class="bg-light text-center">
                            <div class="p-4 text-dark rounded">
                                <iframe class="videoFrame" width="230" height="140" src="" frameborder="0"
                                        allowfullscreen></iframe>
                            </div>
                        </div>
                    </div>
                    <div class="myRow ytd-rich-item-renderer">
                        <div class="bg-light text-center">
                            <div class="p-4 text-dark rounded">
                                <iframe class="videoFrame" width="230" height="140" src="" frameborder="0"
                                        allowfullscreen></iframe>
                            </div>
                        </div>
                    </div>
                    <div class="myRow ytd-rich-item-renderer">
                        <div class="bg-light text-center">
                            <div class="p-4 text-dark rounded">
                                <iframe class="videoFrame" width="230" height="140" src="" frameborder="0"
                                        allowfullscreen></iframe>
                            </div>
                        </div>
                    </div>
                    <div class="myRow ytd-rich-item-renderer">
                        <div class="bg-light text-center">
                            <div class="p-4 text-dark rounded">
                                <iframe class="videoFrame" width="230" height="140" src="" frameborder="0"
                                        allowfullscreen></iframe>
                            </div>
                        </div>
                    </div>
                    <div class="myRow ytd-rich-item-renderer">
                        <div class="bg-light text-center">
                            <div class="p-4 text-dark rounded">
                                <iframe class="videoFrame" width="230" height="140" src="" frameborder="0"
                                        allowfullscreen></iframe>
                            </div>
                        </div>
                    </div>
                    <div class="myRow ytd-rich-item-renderer">
                        <div class="bg-light text-center">
                            <div class="p-4 text-dark rounded">
                                <iframe class="videoFrame" width="230" height="140" src="" frameborder="0"
                                        allowfullscreen></iframe>
                            </div>
                        </div>
                    </div>
                    <div class="myRow ytd-rich-item-renderer">
                        <div class="bg-light text-center">
                            <div class="p-4 text-dark rounded">
                                <iframe class="videoFrame" width="230" height="140" src="" frameborder="0"
                                        allowfullscreen></iframe>
                            </div>
                        </div>
                    </div>
                    <div class="myRow ytd-rich-item-renderer">
                        <div class="bg-light text-center">
                            <div class="p-4 text-dark rounded">
                                <iframe class="videoFrame" width="230" height="140" src="" frameborder="0"
                                        allowfullscreen></iframe>
                            </div>
                        </div>
                    </div>
                    <div class="myRow ytd-rich-item-renderer">
                        <div class="bg-light text-center">
                            <div class="p-4 text-dark rounded">
                                <iframe class="videoFrame" width="230" height="140" src="" frameborder="0"
                                        allowfullscreen></iframe>
                            </div>
                        </div>
                    </div>
                    <div class="myRow ytd-rich-item-renderer">
                        <div class="bg-light text-center">
                            <div class="p-4 text-dark rounded">
                                <iframe class="videoFrame" width="230" height="140" src="" frameborder="0"
                                        allowfullscreen></iframe>
                            </div>
                        </div>
                    </div>
                    <div class="myRow ytd-rich-item-renderer">
                        <div class="bg-light text-center">
                            <div class="p-4 text-dark rounded">
                                <iframe class="videoFrame" width="230" height="140" src="" frameborder="0"
                                        allowfullscreen></iframe>
                            </div>
                        </div>
                    </div>
                    <div class="myRow ytd-rich-item-renderer">
                        <div class="bg-light text-center">
                            <div class="p-4 text-dark rounded">
                                <iframe class="videoFrame" width="230" height="140" src="" frameborder="0"
                                        allowfullscreen></iframe>
                            </div>
                        </div>
                    </div>
                    <div class="myRow ytd-rich-item-renderer">
                        <div class="bg-light text-center">
                            <div class="p-4 text-dark rounded">
                                <iframe class="videoFrame" width="230" height="140" src="" frameborder="0"
                                        allowfullscreen></iframe>
                            </div>
                        </div>
                    </div>
                    <div class="myRow ytd-rich-item-renderer">
                        <div class="bg-light text-center">
                            <div class="p-4 text-dark rounded">
                                <iframe class="videoFrame" width="230" height="140" src="" frameborder="0"
                                        allowfullscreen></iframe>
                            </div>
                        </div>
                    </div>
                    <div class="myRow ytd-rich-item-renderer">
                        <div class="bg-light text-center">
                            <div class="p-4 text-dark rounded">
                                <iframe class="videoFrame" width="230" height="140" src="" frameborder="0"
                                        allowfullscreen></iframe>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <!--end page wrapper -->
        </div>

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
    <!--JS-->
    <script src="${pageContext.request.contextPath}/static/js/boot/app.js"></script>
    <script src="${pageContext.request.contextPath}/static/js/randomVideoYT.js"></script>
    <script src="${pageContext.request.contextPath}/static/js/cancel.js"></script>
</body>

</html>
