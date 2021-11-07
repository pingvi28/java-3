<%--
  Created by IntelliJ IDEA.
  User: 79179
  Date: 11/5/2021
  Time: 4:18 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
                   role="button" data-bs-toggle="dropdown">
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
                    <li><a class="dropdown-item" href="${pageContext.request.contextPath}/logout"><i
                            class='bx bx-log-out-circle'></i><span>Выйти</span></a>
                    </li>
                </ul>
            </div>
        </nav>
    </div>
</header>
<!--end header -->