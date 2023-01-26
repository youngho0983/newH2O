<%@ page import="com.company.tool.SessionConst" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<a href="/user/signin">signin</a>
<c:choose>
    <c:when test="${sessionScope.loginUser == null}">
        <a href="/user/login">login</a>
    </c:when>
    <c:otherwise>
        <a href="/user/logout">logout</a>
    </c:otherwise>
</c:choose>

<a href="/chatting/waittingRoom">대화창웨이팅룸</a>
</body>
</html>
