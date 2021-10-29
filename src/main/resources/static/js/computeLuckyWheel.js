function spinWheel(player) {
    window.console.log(player);
    httpRequestMaker(new XMLHttpRequest(), player, "spinWheel/spin")
}

let httpRequestMaker = function (httpRequest, json, page) {
    window.console.log(json)
    //httpRequest.open("POST", "https://bossteam.azurewebsites.net/luckywheel/" + page)
    httpRequest.open("POST", "http://localhost:8080/luckywheel/" + page)
    httpRequest.setRequestHeader("Content-Type", "application/json;charset=UTF-8")
    httpRequest.send(json)
    httpRequest.onload = function () {
        alert(httpRequest.responseText)
    }
}








