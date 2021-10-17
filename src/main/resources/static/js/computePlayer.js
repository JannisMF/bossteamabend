function addHealth(playerId) {
    httpRequestMaker(new XMLHttpRequest(), playerId, "/addHealth")
}

function removeHealth(playerId) {
    httpRequestMaker(new XMLHttpRequest(), playerId, "/removeHealth")
}

function fillFood(playerId) {
    httpRequestMaker(new XMLHttpRequest(), playerId, "/fillFood")
}

function removeFood(playerId) {
    httpRequestMaker(new XMLHttpRequest(), playerId, "/removeFood")
}

function addArmor(playerId) {
    httpRequestMaker(new XMLHttpRequest(), playerId, "/addArmor")
}

let httpRequestMaker = function (httpRequest, playerId, page) {
    httpRequest.open("GET", "http://localhost:8080/player/" + playerId + page);
    httpRequest.send();
    httpRequest.onload = function () {
        window.location.reload()
        if (httpRequest.responseText.startsWith("<!DOCTYPE html>")) {
            alert("Du hast keine Berechtigung dafür!")
        } else if (httpRequest.responseText.startsWith("TOT!")) {
            alert(httpRequest.responseText)
        }
    }
}








