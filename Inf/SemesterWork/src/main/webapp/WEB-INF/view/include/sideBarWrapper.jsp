<%--
  Created by IntelliJ IDEA.
  User: 79179
  Date: 11/5/2021
  Time: 4:13 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
            <a href="${pageContext.request.contextPath}/userProfile">
                <div class="parent-icon"><i class="bx bx-user-circle"></i></div>
                <div class="menu-title">Личный кабинет</div>
            </a>
        </li>
    </ul>
    <!--end navigation-->
</div>
<!--end sidebar wrapper -->
