
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>signIn</title>
</head>
<script type="text/javascript" src="/resources/js/defaultJs.js"></script>
<body>

    자바스크립트에서 1차 발리데이션
    idcheck ajax로 확인
    submit ajax로 보내서 response로 nextPage주소 받을까?..
    이걸로 하자.  ==> 아니면 그냥 Post로 넘겨서.. 발리데이션 하고 넥스트 페이지 띄울까..


    <form name="submitForm" method="post">
        userId
        <input type="text" name="id" id="id" class="user-id" >
        <button type="button" onclick="sameIdCheck()" id="idCheckButton" onchange="javascript:pageObject.idCheck = false">sameIdCheck</button>
        <br/>
        password
        <input type="password" name="password" id="password" class="user-password" onfocusout="validatePassword()">
        <br/>
        emailAddreass (//패스워드 바꿀때 쓸 예정)
        <input type="email" name="email" id="email">
        <br/>
        phoneNum
        <input type="text" name="phonenumber" id="phoneNumber">
        <br/>
        address
        <input type="text" name="address" id="address">
        <input type="number" name="age" id="age" value="1">
        <button type="button" onclick="formSubmit()">submit</button>
    </form>
</body>


<script>
    var pageObject = {};
    pageObject.idCheck = false;
    pageObject.passwordCheck = false;

    // 아이디 채크

    function sameIdCheck() {
        var userId = document.getElementById("id").value;
        if(userId.length == 0) {
            alert("아이디를 입력하세요");
            return ;
        }
        var regexp =  /^[a-z]+[a-z0-9]{6,20}$/g;;
        regexp.test(userId)?  ajaxRequest("GET", userId ) : alert(" 6글자 이상으로 입력해주세요");
    }

    afterAjxFunction =  function (){
        if(xmlHttpResultObj.responseJson.canUseId == true) {
            alert( "사용 가능합니다.");
            pageObject.idCheck = true;
        } else {
            alert("사용 불가합니다. 다른 아이디를 입력하세요")
            document.getElementById("id").value = "";
            pageObject.idCheck = false;
        }
    }
    onAjxRequestStateChange(sameIdCheck);

    function checkPassword(password) {
        var regexp = /^(?=.*[a-zA-z])(?=.*[0-9])(?=.*[$`~!@$!%*#^?&\\(\\)\-_=+]).{8,20}$/;

        return regexp.test(password)
    }

    function validatePassword() {
        var passwordArea = document.getElementById("password");
        if ( passwordArea.value == "" ) {
            pageObject.passwordCheck = false;
            return;
        }
        if ( !checkPassword(passwordArea.value) ) {
            pageObject.passwordCheck = false;
            alert("사용 불가능한 비번입니다.");
            passwordArea.value = "";
            return;
        }
        pageObject.passwordCheck = true;

    }


    function formSubmit() {

        if ( pageObject.idCheck && pageObject.passwordCheck) {
            var form = document.submitForm;
            form.submit();
        }
    }
</script>
</html>
