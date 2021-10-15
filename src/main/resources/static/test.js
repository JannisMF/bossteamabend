function addHpPlayer01(element) {
    element.$server.addHealth(0);

}

function removeHpPlayer01() {
    if (ap01 == 0) {
        var string = --hp01 + " Health";
        document.getElementById("healthBar01").innerText = string;
    } else {
        var string = --ap01 + " Armor";
        document.getElementById("armorBar01").innerText = string
    }
}

function addHungerpPlayer01() {
    var string = ++hungerp01 + " Hunger";
    document.getElementById("hungerBar01").innerText = string;
}

function removeHungerpPlayer01() {
    var string = --hungerp01 + " Hunger";
    document.getElementById("hungerBar01").innerText = string;
}

function addApPlayer01() {
    var string = ++ap01 + " Armor";
    document.getElementById("armorBar01").innerText = string;
}
