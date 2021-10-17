function addProgress() {
    httpRequestMaker(new XMLHttpRequest(), "addProgress")
}

function removeProgress() {
    httpRequestMaker(new XMLHttpRequest(), "removeProgress")
}

let httpRequestMaker = function (httpRequest, page) {
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








