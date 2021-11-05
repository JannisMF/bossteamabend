function spinWheel(serverUrl) {
    httpRequestMaker(new XMLHttpRequest(), serverUrl + "spin/spin")
}

let httpRequestMaker = function (httpRequest, page) {
    page = page.replace("undefined", "")
    httpRequest.open("GET", page)
    httpRequest.send()
    httpRequest.onload = function () {
        window.location.reload()
        alert(httpRequest.responseText)
    }
}



