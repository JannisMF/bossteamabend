function addProgress() {
    httpRequestMakerGet(new XMLHttpRequest(), "addProgress")
}

function removeProgress() {
    httpRequestMakerGet(new XMLHttpRequest(), "removeProgress")
}

function sendNews() {
    let elem = document.getElementById("message")
    let message = elem.value
    let json = JSON.stringify({message: message})
    elem.value = ""
    httpRequestMakerPost(new XMLHttpRequest(), json, "sendNews")
}

let httpRequestMakerGet = function (httpRequest, page) {
    httpRequest.open("GET", "https://bossteam.azurewebsites.net/game/progress/" + page);
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

let httpRequestMakerPost = function (httpRequest, json, page) {
    window.console.log(json)
    httpRequest.open("POST", "https://bossteam.azurewebsites.net/game/progress/" + page)
    //httpRequest.open("POST", "http://localhost:8080/game/progress/" + page)
    httpRequest.setRequestHeader("Content-Type", "application/json;charset=UTF-8")
    httpRequest.send(json)
    httpRequest.onload = function () {
        alert(httpRequest.responseText)
    }
}








