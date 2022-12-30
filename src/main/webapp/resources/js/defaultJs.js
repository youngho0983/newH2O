var xmlHttpRequest = new XMLHttpRequest();
var xmlHttpResultObj = {
    "canUse": false
}

function ajaxRequest(type,url,obj) {
    xmlHttpResultObj.canUse = false;
    xmlHttpRequest.open(type,url);
    if(!obj) xmlHttpRequest.send(obj);
}
xmlHttpRequest.onreadystatechange = onAjxRequestStateChange

function onAjxRequestStateChange() {
    if(xmlHttpRequest.readyState == xmlHttpRequest.DONE) {
        if (xmlHttpRequest.status == 200 ) {
            console.log(xmlHttpRequest.response);
            xmlHttpResultObj.canUse = true;
            xmlHttpResultObj.response = xmlHttpRequest.response;
            xmlHttpResultObj.responseType = xmlHttpRequest.responseType;
        } else {
            console.log("something wrong");
        }
    }
}