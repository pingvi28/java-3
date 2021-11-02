<%--
  Created by IntelliJ IDEA.
  User: 79179
  Date: 10/12/2021
  Time: 11:25 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<head>
    <!--заголовок страницы в браузере-->
    <title>Sign in on the website</title>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/style.css" type="text/css"/>
</head>

<body style="background-color: #f6f6f6">
<form action="${pageContext.request.contextPath}/su" method="post">
    <div class="container">
        <%--@declare id="name"--%><%--@declare id="surname"--%><%--@declare id="email"--%><%--@declare id="psw"--%><%--@declare id="psw-repeat"--%>
        <h1>Registration on the website</h1>
        <p>Sign in</p>
        <hr>

        <label for="email"><b>Email</b></label>
        <input type="text" placeholder="Enter Email" name="email" required>

        <label for="psw"><b>Password</b></label>
        <input type="password" placeholder="Enter Password" name="password" required>

        <button type="submit" class="registerbtn">Sign in</button>
    </div>
    </div>
</form>
<a href="${pageContext.request.contextPath}/up">зарегистрироваться</a>
</body>

</html>

