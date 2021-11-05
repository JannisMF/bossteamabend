function addHealth(serverUrl, playerId) {
    httpRequestMaker(new XMLHttpRequest(), serverUrl + "player/" + playerId + "/addHealth")
}

function removeHealth(serverUrl, playerId) {
    httpRequestMaker(new XMLHttpRequest(), serverUrl + "player/" + playerId + "/removeHealth")
}

function fillFood(serverUrl, playerId) {
    httpRequestMaker(new XMLHttpRequest(), serverUrl + "player/" + playerId + "/fillFood")
}

function removeFood(serverUrl, playerId) {
    httpRequestMaker(new XMLHttpRequest(), serverUrl + "player/" + playerId + "/removeFood")
}

function addArmor(serverUrl, playerId) {
    httpRequestMaker(new XMLHttpRequest(), serverUrl + "player/" + playerId + "/addArmor")
}

function respawnPlayer(serverUrl, playerId) {
    httpRequestMaker(new XMLHttpRequest(), serverUrl + "player/" + playerId + "/respawnPlayer")
}

let httpRequestMaker = function (httpRequest, page) {
    httpRequest.open("GET", page)
    httpRequest.send();
    httpRequest.onload = function () {
        window.location.reload()
        if (httpRequest.responseText.startsWith("<!DOCTYPE html>")) {
            alert("Du hast keine Berechtigung dafür!")
        } else if (httpRequest.responseText.startsWith("TOT!")
            || httpRequest.responseText.startsWith("Oops!")
            || httpRequest.responseType.startsWith("Respawned!")) {
            alert(httpRequest.responseText)
        }
    }
}








