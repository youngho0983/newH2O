var xmlHttpRequest = new XMLHttpRequest();
var xmlHttpResultObj = {
    "canUse": false
}

function ajaxRequest(type,url,obj ) {
    xmlHttpRequest.onreadystatechange = onAjxRequestStateChange
    xmlHttpResultObj.canUse = false;
    xmlHttpRequest.open(type,url);
    if(!obj) xmlHttpRequest.send(obj);
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

var afterAjxFunction;
