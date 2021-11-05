function startGame(serverUrl) {
    let numberOfPlayers = document.getElementById("numberOfPlayers").value
    let json = JSON.stringify({numberOfPlayers: numberOfPlayers})
    httpRequestMaker(new XMLHttpRequest(), serverUrl + "startGame", json)
}

let httpRequestMakerPost = function (httpRequest, page, json) {
    httpRequest.open("POST", page)
    httpRequest.setRequestHeader("Content-Type", "application/json;charset=UTF-8")
    httpRequest.send(json)
    httpRequest.onload = function () {
        alert(httpRequest.responseText)
    }
}








