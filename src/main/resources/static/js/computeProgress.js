function addProgress(serverUrl) {
    httpRequestMakerGet(new XMLHttpRequest(), serverUrl + "progress/addProgress")
}

function removeProgress(serverUrl) {
    httpRequestMakerGet(new XMLHttpRequest(), serverUrl + "progress/removeProgress")
}

function sendNews(serverUrl) {
    let elem = document.getElementById("message")
    let message = elem.value
    let json = JSON.stringify({message: message})
    elem.value = ""
    httpRequestMakerPost(new XMLHttpRequest(), serverUrl + "progress/sendNews", json)
}

let httpRequestMakerGet = function (httpRequest, page) {
    page = page.replace("undefined", "")
    httpRequest.open("GET", page)
    httpRequest.send();
    httpRequest.onload = function () {
        window.location.reload()
        if (httpRequest.responseText.startsWith("<!DOCTYPE html>")) {
            alert("Du hast keine Berechtigung dafür!")
        } else {
            alert(httpRequest.responseText)
        }
    }
}

let httpRequestMakerPost = function (httpRequest, page, json) {
    page = page.replace("undefined", "")
    httpRequest.open("POST", page)
    httpRequest.setRequestHeader("Content-Type", "application/json;charset=UTF-8")
    httpRequest.send(json)
    httpRequest.onload = function () {
        alert(httpRequest.responseText)
    }
}








