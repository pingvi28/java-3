<%--
  Created by IntelliJ IDEA.
  User: 79179
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html>

<head>
    <meta http-equiv="Content-type" content="text/html;charset=UTF-8"/>
    <!--favicon-->
    <link rel="icon" href="${pageContext.request.contextPath}/static/images/icons/favicon.png" type="image/png"/>
    <!--my CSS -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/common.css" type="text/css"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/registration&login/loginANDreg.css" type="text/css" >
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/registration&login/registration.css" type="text/css" >

    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Kaushan+Script|Montserrat:400,700&display=swap&subset=cyrillic" type="text/css" >
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/sweetalert2@7.12.15/dist/sweetalert2.min.css" type="text/css"/>

    <title>Lamp corner</title>
</head>

<body>
    <div class="intro" id="id02">
        <div class="container">
            <div class="intro__inner">
                <h2 class="intro__title intro_glow">Еще немного...</h2>
                <button class="btn" onclick="document.getElementById('id01').style.display='block'">Создать аккаунт</button>
                <!-- The Modal -->
                <div id="id01" class="modal">
                    <span onclick="document.getElementById('id01').style.display='none'" class="close" title="Close Modal">&times;</span>
                    <!-- Modal Content -->
                    <form class="modal-content animate" id="stopSend" action="${pageContext.request.contextPath}/signUp"
                          method="post">
                        <div class="container">
                            <div class="form-group">
                                <input class="form-control item" type="text" name="surname" id="surname"
                                       placeholder="Фамилия" required>
                            </div>
                            <div class="form-group">
                                <input class="form-control item" type="text" name="name" id="name" placeholder="Имя"
                                       required>
                            </div>
                            <div class="form-group blockEmail">
                                <input class="form-control item hover" type="email" name="email" id="email"
                                       placeholder="Email" required title="Внимание, на эту почту придет ссылка">
                            </div>
                            <div class="form-group pas">
                                <input class="form-control item password-input " type="password" name="password"
                                       minlength="6" id="password" placeholder="Пароль (мин 6 символов)" required>
                                <a href="#" class="password-control"></a>
                            </div>
                            <div class="form-group pas">
                                <input class="form-control item password-input" type="password" name="password-repeat"
                                       minlength="6" id="passwordRep" placeholder="Повторите пароль" required>
                                <a href="#" class="password-control2"></a>
                            </div>
                            <div class="form-group item">
                                <button class="btn" type="submit">Создать аккаунт</button>
                            </div>
                        </div>
                    </form>
                </div>
                <div class="container">
                    <span class="create_ac"><a href="${pageContext.request.contextPath}/login">вернуться</a></span>
                </div>
            </div>
        </div>
    </div>
    <!--Script-->
    <script src="${pageContext.request.contextPath}/static/js/cancel.js"></script>
    <script src="${pageContext.request.contextPath}/static/js/pasSigUpCorrect.js"></script>
    <script src="${pageContext.request.contextPath}/static/js/jquery.min.js"></script>
    <script src="${pageContext.request.contextPath}/static/js/showPas.js"></script>
    <script src="${pageContext.request.contextPath}/static/js/logSiteAlert.js"></script>
    <script src="${pageContext.request.contextPath}/static/js/sendFormStop.js"></script>
</body>

</html>
