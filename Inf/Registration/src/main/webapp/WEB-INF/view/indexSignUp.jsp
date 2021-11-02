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
    <title>Registration on the website</title>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/style.css" type="text/css"/>
</head>

<body style="background-color: #f6f6f6">
<form action="${pageContext.request.contextPath}/up" method="post">
    <div class="container">
        <%--@declare id="name"--%><%--@declare id="surname"--%><%--@declare id="email"--%><%--@declare id="psw"--%><%--@declare id="psw-repeat"--%>
        <h1>Registration on the website</h1>
        <p>Please fill in this form to create an account.</p>
        <hr>
        <label for="name"><b>Name</b></label>
        <input type="text" placeholder="Enter name" name="name" required>

        <label for="surname"><b>Surname</b></label>
        <input type="text" placeholder="Enter surname" name="surname" required>

        <label for="email"><b>Email</b></label>
        <input type="text" placeholder="Enter Email" name="email" required>

        <label for="psw"><b>Password</b></label>
        <input type="password" placeholder="Enter Password" name="password" required>

        <label for="psw-repeat"><b>Repeat Password</b></label>
        <input type="password" placeholder="Repeat Password" name="password-repeat" required>
        <hr>

        <button type="submit" class="registerbtn">Register</button>
    </div>
    </div>
</form>
<a href="${pageContext.request.contextPath}/">войти</a>
</body>

</html>

