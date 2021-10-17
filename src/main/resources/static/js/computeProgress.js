function addProgress(progress, maxProgress) {
    setProgressbarHigher(progress, maxProgress)
    httpRequestMaker(new XMLHttpRequest(), "/addProgress")
}

function removeProgress(progress, maxProgress) {
    setProgressbarLower(progress, maxProgress)
    httpRequestMaker(new XMLHttpRequest(), "/removeProgress")
}

let setProgressbarHigher = function (progress, maxProgress) {
    let width = 0
    if (progress < maxProgress) {
        width = (progress + 1) / maxProgress
    } else {
        width = 100
    }
    let elem = document.getElementById("progressBar")
    elem.style.width = width + "%"
}

let setProgressbarLower = function (progress, maxProgress) {
    let width = 0
    if (progress > 0) {
        width = (progress - 1) / maxProgress
    } else {
        width = 0
    }
    let elem = document.getElementById("progressBar")
    elem.style.width = width + "%"
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








