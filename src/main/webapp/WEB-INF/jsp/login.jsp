<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

    <c:url value="/login" var="loginUrl"/>
    <form method="POST" action="${loginUrl}">
        <label>User name:</label>
        <input type="text" name="spring_login"/>

        <label>User name:</label>
        <input type="password" name="spring_password"/>

        <sec:csrfInput/>
        <c:if test="${param.error != null}">
            <p style="color: red">data invalid</p>
        </c:if>
        <button type="submit">Log in</button>
    </form>

</body>
</html>
