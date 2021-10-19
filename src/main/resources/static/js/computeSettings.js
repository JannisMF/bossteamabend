function startGame() {
    httpRequestMaker(new XMLHttpRequest(), "startGame")
}

let httpRequestMaker = function (httpRequest, page) {
    httpRequest.open("POST", "https://bossteam.azurewebsites.net/game/" + page)
    let numberOfPlayers = document.getElementById("numberOfPlayers").value
    let request = "numberofplayers=" + numberOfPlayers;
    httpRequest.send(request)
    httpRequest.onload = function () {
        window.location.reload()
        alert("Spiel gestartet!")
    }
}








