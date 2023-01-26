var xmlHttpRequest = new XMLHttpRequest();
var xmlHttpResultObj = {
    "canUse": false
}

function ajaxRequest(type,url,obj,contentType ) {
    xmlHttpRequest.onreadystatechange = onAjxRequestStateChange
    xmlHttpResultObj.canUse = false;
    xmlHttpRequest.open(type,url);
    if(!contentType) {xmlHttpRequest.setRequestHeader("Content-type" , "application/json")}
    if(!obj) {xmlHttpRequest.send();}else {xmlHttpRequest.send(obj)}
}

function onAjxRequestStateChange() {
    if(xmlHttpRequest.readyState == xmlHttpRequest.DONE) {
        if (xmlHttpRequest.status == 200 ) {
            console.log(xmlHttpRequest.response);
            xmlHttpResultObj.canUse = true;
            xmlHttpResultObj.response = xmlHttpRequest.response;
            xmlHttpResultObj.responseType = xmlHttpRequest.responseType;
            xmlHttpResultObj.responseJson = JSON.parse(xmlHttpRequest.response);
            afterAjxFunction();
        } else {
            console.log("something wrong");
        }
    }
}

