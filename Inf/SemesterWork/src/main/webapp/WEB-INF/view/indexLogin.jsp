<%--
  Created by IntelliJ IDEA.
  User: 79179
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html>

<head>
    <meta http-equiv="Content-type" content="text/html;charset=UTF-8"/>
    <!--favicon-->
    <link rel="icon" href="${pageContext.request.contextPath}/static/images/icons/favicon.png" type="image/png"/>
    <!--my CSS -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/common.css" type="text/css"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/registration&login/loginANDreg.css" type="text/css"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/registration&login/login.css" type="text/css"/>
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Kaushan+Script|Montserrat:400,700&display=swap&subset=cyrillic" type="text/css"/>
    <!--Script-->
    <script src="${pageContext.request.contextPath}/static/js/jquery.min.js"></script>
    <script src="${pageContext.request.contextPath}/static/js/cancel.js"></script>
    <script src="${pageContext.request.contextPath}/static/js/showPas.js"></script>
    <script src="${pageContext.request.contextPath}/static/js/sendFormStop.js" defer></script>
    <script src="${pageContext.request.contextPath}/static/js/logSiteAlert.js" async></script>

    <title>Lamp corner</title>
</head>

<body>
    <div>
        <!-- Intro -->
        <div class="intro" id="id02">
            <div class="container">
                <div class="intro__inner">
                    <h2 class="intro__title intro_glow">Добро пожаловать в <br/><br/>Lamp corner</h2>
                    <button class="btn" onclick="document.getElementById('id01').style.display='block'">Присоединиться...
                    </button>
                    <!-- The Modal -->
                    <div id="id01" class="modal">
                        <span onclick="document.getElementById('id01').style.display='none'" class="close" title="Close Modal">&times;</span>
                        <!-- Modal Content -->
                        <form class="modal-content animate" id="stopSend" action="${pageContext.request.contextPath}/login" method="post">
                            <div class="container">
                                <div class="form-group">
                                    <input class="form-control item" type="email" name="email" id="email" placeholder="Email" required>
                                </div>
                                <div class="form-group pas">
                                    <input class="form-control item" type="password" name="password" minlength="6" id="password" placeholder="Пароль" required>

                                    <a href="#" class="password-control"></a>
                                </div>
                                <label>
                                    <input class="check" type="checkbox" checked="checked" name="remember"> Remember me
                                </label>
                                <div class="form-group item">
                                    <button class="btn" type="submit">Вход в аккаунт</button>
                                </div>
                                <span class="create_ac"></span>
                                <span class="create_ac ctr">Войти через:&emsp;
                                    <a href="https://oauth.vk.com/authorize?client_id=7984087&display=page&redirect_uri=http://localhost:8084/lamp/vk_auth&scope=email&response_type=code&v=5.131">
                                        <img class="img vk" src="${pageContext.request.contextPath}/static/images/icons/vk.png">
                                    </a>
                                </span>
                            </div>
                            <div class="container">
                                <span class="create_ac">Еще не  <a href="${pageContext.request.contextPath}/signUp">зарегистрировались?</a></span>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
        <!-- Section -->
        <section class="section">
            <div class="container">
                <div class="section__header">
                    <h3 class="section__suptitle">about project</h3>
                    <h2 class="section__title">Начало*</h2>
                    <div class="section__text">
                        <p>
                            Здесь должно быть красивое описание*
                        </p>
                    </div>
                </div>
            </div>
            <div class="about">
                <div class="about_item">
                    <div class="about_img">
                        <img class="img" src="${pageContext.request.contextPath}/static/images/loginPage/loginPic1.jpg">
                    </div>
                    <div class="about_text">
                        <p>Место</p>
                    </div>
                </div>
                <div class="about_item">
                    <div class="about_img">
                        <img class="img" src="${pageContext.request.contextPath}/static/images/loginPage/loginPic2.jpg">
                    </div>
                    <div class="about_text">
                        <p>Где</p>
                    </div>
                </div>
                <div class="about_item">
                    <div class="about_img">
                        <img class="img" src="${pageContext.request.contextPath}/static/images/loginPage/loginPic3.jpg">
                    </div>
                    <div class="about_text">
                        <p>Уютно</p>
                    </div>
                </div>
            </div>
        </section>
    </div>
</body>

</html>
