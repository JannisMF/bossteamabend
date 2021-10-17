function addHealth(playerId, element) {
    element.$server.addHealth(playerId);
}

function removeHealth(playerId, element) {
    element.$server.removeHealth(playerId);
}

function fillFood(playerId, element) {
    element.$server.fillFood(playerId);
}

function removeFood(playerId, element) {
    element.$server.removeFood(playerId);
}

function addArmor(playerId, element) {
    element.$server.addArmor(playerId);
}
