function startGame() {
    httpRequestMaker(new XMLHttpRequest(), "startGame")
}

let httpRequestMaker = function (httpRequest, page) {
    httpRequest.open("POST", "https://bossteam.azurewebsites.net/game/settings/" + page)
    let numberOfPlayers = document.getElementById("numberOfPlayers").value
    let request = new Object()
    request.numberOfPlayers = numberOfPlayers
    httpRequest.send(request)
    httpRequest.onload = function () {
        alert(httpRequest.responseText)
    }
}








