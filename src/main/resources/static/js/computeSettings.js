function startGame() {
    let numberOfPlayers = document.getElementById("numberOfPlayers").value
    let json = JSON.stringify({"numberOfPlayers": numberOfPlayers})
    httpRequestMaker(new XMLHttpRequest(), json, "startGame")
}

let httpRequestMaker = function (httpRequest, json, page) {
    httpRequest.open("POST", "https://bossteam.azurewebsites.net/game/settings/" + page)
    httpRequest.send(json)
    httpRequest.onload = function () {
        alert(httpRequest.responseText)
    }
}








