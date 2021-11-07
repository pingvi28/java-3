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
    <jsp:include page="include/styleMain.jsp" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/main/styleYT.css" type="text/css"/>

    <title>Lamp corner</title>
</head>

<body class="bg-theme bg-theme13">
<!--wrapper-->
<div class="wrapper toggled">
    <jsp:include page="include/sideBarWrapper.jsp" />
    <jsp:include page="include/header.jsp" />
    <section>
        <!--start page wrapper -->
        <div class="page-wrapper holder">
            <div class="page-content">
                <div class="ytd-rich-grid-video-renderer row row-cols-1 row-cols-md-2 row-cols-lg-4">
                    <jsp:include page="include/video.jsp" />
                    <jsp:include page="include/video.jsp" />
                    <jsp:include page="include/video.jsp" />
                    <jsp:include page="include/video.jsp" />

                    <jsp:include page="include/video.jsp" />
                    <jsp:include page="include/video.jsp" />
                    <jsp:include page="include/video.jsp" />
                    <jsp:include page="include/video.jsp" />

                    <jsp:include page="include/video.jsp" />
                    <jsp:include page="include/video.jsp" />
                    <jsp:include page="include/video.jsp" />
                    <jsp:include page="include/video.jsp" />

                    <jsp:include page="include/video.jsp" />
                    <jsp:include page="include/video.jsp" />
                    <jsp:include page="include/video.jsp" />
                    <jsp:include page="include/video.jsp" />
                </div>
            </div>
            <!--end page wrapper -->
        </div>
        <jsp:include page="include/switcher.jsp" />
    </section>
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
