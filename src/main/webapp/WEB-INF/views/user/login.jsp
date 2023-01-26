<%--
  Created by IntelliJ IDEA.
  User: young
  Date: 2023-01-01
  Time: 오후 5:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<script type="text/javascript" src="/resources/js/defaultJs.js"></script>
<body>
  <form name="submitForm"  id="submitForm" method="post">
    id
    <input type="text" name="id" id="id">
    <br/>
    password
    <input type="password" name="password" id="password">
    <button type="button" onclick="tryLogin()" >로그인</button>
  </form>

  <script>

    function afterAjxFunction() {
      console.log(xmlHttpResultObj.response);
      temp = JSON.parse(xmlHttpRequest.response);
      if (temp.login == "success") {
          window.location.href = "/";
      }
    }

    function tryLogin() {
      var obj = {
        "id": document.getElementById("id").value,
        "password": document.getElementById("password").value
      }
      ajaxRequest("POST","login-try",JSON.stringify(obj) );
    }
  </script>
</body>
</html>
