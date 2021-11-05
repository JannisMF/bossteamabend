function spinWheel() {
    httpRequestMaker(new XMLHttpRequest(),  "spin/spin")
}

let httpRequestMaker = function (httpRequest, page) {
    //httpRequest.open("POST", "https://bossteam.azurewebsites.net/luckywheel/" + page)
    httpRequest.open("GET", "http://localhost:8080/luckywheel/" + page)
    httpRequest.send()
    httpRequest.onload = function () {
        window.location.reload()
        alert(httpRequest.responseText)
    }
}



