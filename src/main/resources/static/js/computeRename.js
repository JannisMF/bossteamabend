function changeName(serverUrl) {
    let elem = document.getElementById("newName")
    let name = elem.value
    let json = JSON.stringify({name: name})
    elem.value = ""
    httpRequestMakerPost(new XMLHttpRequest(), serverUrl + "player/rename/changeName", json)
}

let httpRequestMakerPost = function (httpRequest, page, json) {
    page = page.replace("undefined", "")
    httpRequest.open("POST", page)
    httpRequest.setRequestHeader("Content-Type", "application/json;charset=UTF-8")
    httpRequest.send(json)
    httpRequest.onload = function () {
        alert(httpRequest.responseText)
    }
}








