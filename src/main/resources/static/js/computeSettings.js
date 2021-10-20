function startGame() {
    let numberOfPlayers = document.getElementById("numberOfPlayers").value
    let json = JSON.stringify({numberOfPlayers: numberOfPlayers})
    httpRequestMaker(new XMLHttpRequest(), json, "startGame")
}

let httpRequestMaker = function (httpRequest, json, page) {
    window.console.log(json)
    httpRequest.open("POST", "https://bossteam.azurewebsites.net/game/settings/" + page)
    httpRequest.setRequestHeader("Content-Type", "application/json;charset=UTF-8")
    httpRequest.send(json)
    httpRequest.onload = function () {
        alert(httpRequest.responseText)
    }
}








