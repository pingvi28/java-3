<%--
  Created by IntelliJ IDEA.
  User: 79179
  Date: 11/2/2021
  Time: 10:25 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <!--favicon-->
    <link rel="icon" href="${pageContext.request.contextPath}/static/images/icons/favicon.png" type="image/png"/>
    <!--CSS -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/common.css" type="text/css"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/sendEmail.css" type="text/css">
    <!--JS-->
    <script src="${pageContext.request.contextPath}/static/js/logSiteAlert.js"></script>
    <script src="${pageContext.request.contextPath}/static/js/sendFormStop.js"></script>

    <title>SendEmail</title>
</head>
<body >
    <!-- Intro -->
    <div class="intro">
        <div class="intro_inner">
            <label for="first-title"></label>
            <h2 class="intro_title" id="first-title">
                <c:if test="${not empty FirstTitle}">
                    ${FirstTitle}
                </c:if>
            </h2>
            <h4 ></h4>
            <label for="second-title"></label>
            <h4 class="intro_titleH3" id="second-title">
                <c:if test="${not empty SecondTitle}">
                    ${SecondTitle}
                </c:if>
            </h4>
            <br/><br/>
            <c:if test="${not empty sendAgain}">
                <form id="stopSend" action="${pageContext.request.contextPath}/send" method="post">
                    <button class="btn" type="submit"> >  еще попытка </button>
                </form>
            </c:if>
            <c:if test="${not empty sendLogin}">
                <form id="stopSend" action="${pageContext.request.contextPath}/sendAgain" method="post">
                    <button class="btn" type="submit"> >  прислать </button>
                </form>
            </c:if>
        </div>
    </div>
</body>

</html>
