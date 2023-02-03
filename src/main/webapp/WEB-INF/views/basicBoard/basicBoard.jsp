<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: young
  Date: 2023-02-02
  Time: 오후 7:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    기본 게시판 준비
</body>

    여기서 리스트를 AJAX로 HTML 모양 그대로 받아 뿌릴 예정
<div id="list_area">

</div>

<c:if test="${sessionScope.loginUser != null}">
    <hr>
    <a href="basic_board/write_page">write</a>
</c:if>

<button onclick="changeBoard(1)">GetBoardListTest</button>
<script>
    function changeBoard(pageNum){
        var xhr = new XMLHttpRequest();
        xhr.open("GET","/basic_board/" +pageNum)
        xhr.send(1);
        xhr.onreadystatechange = () =>{
            if(xhr.readyState == xhr.DONE) {
                if(xhr.status == 200) {
                    console.log(xhr.response);
                    changeBoardView(xhr.response);
                } else {
                    alert("문제가 있는데?");
                    alert(xhr.response);
                }
            }
        }
    }

    function changeBoardView(response) {
        document.getElementById("list_area").innerHTML = response;
    }
</script>
</html>
