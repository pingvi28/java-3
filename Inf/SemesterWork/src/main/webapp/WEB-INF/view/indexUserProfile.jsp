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
    <jsp:include page="include/styleMain.jsp" />

    <title>Lamp corner</title>
</head>

<body class="bg-theme bg-theme15">
<!--wrapper-->
<div class="wrapper toggled">
    <jsp:include page="include/sideBarWrapper.jsp" />
    <jsp:include page="include/header.jsp" />
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
                                                           placeholder="фамилия" required/>
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
                                                           placeholder="имя" required/>
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
                                                           minlength="6" placeholder="текущий пароль" required/>
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
                                                           minlength="6" placeholder="текущий пароль" required/>
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
                                                           minlength="6" placeholder="новый пароль" required/>
                                                </label>
                                                <a href="#" class="password-control"></a>
                                            </div>
                                        </div>
                                        <div class="row mb-3">
                                            <div class="upd col-sm-3">
                                                <h6 class="mb-0">Повтори</h6>
                                            </div>
                                            <div class="col-sm-9">
                                                <label>
                                                    <input type="password" name="passwordRep" id="passwordRep" class="form-control item"
                                                           minlength="6" placeholder="новый пароль" required/>
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
    <jsp:include page="include/switcher.jsp" />
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
<script src="${pageContext.request.contextPath}/static/js/logSiteAlert.js"></script>
</body>

</html>
