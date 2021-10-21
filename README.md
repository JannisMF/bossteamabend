# bossteamabend

Project to make a Webgame.

Game:
The players get a QR-Code stuck to their chest or shoulder, which opens their playerpage (page: player/{playerId}).
Supervisors can do actions like adding health or removing it at minigames.

Minigames:
Minigames are played IRL. Some minigames are: e. g. rainbowroad on mario kart, luckywheel or pool noodle fight!
NOTICE: The majority of minigames are not implemented in code, because they are played IRL (the luckywheel needs to be implemented).
To play a minigame players need to pay with health (or armor if a player got some)
When winning a minigame they get gain progress with is represented by the progressbar.

Progressbar/Goal of the game:
If the progressbar is at 100 %, the players have won the game. Progress is added by winning minigames.

Healthpoints
With healthpoints players can pay to play minigames.
If a player lost all healthpoints they die and need to go to the "dead room" and lose all armor they might had.

Foodpoints:
Players lose foodpoint every 2 1/2 minutes. They can refill them, when they eat something IRL. A supervisor fills their health by scanning the QR-Code.
If a player lost all foodpoints they lose healthpoints instead.

Armorpoints:
Armor is like a small addon to healthpoints. To play minigames armorpoints are used instead of healthpoints (when having some).
NOICE: Losing health by the foodpoints-removal ignores armor!

On Death:
If a player dies, they need to enter the "dead room" where are getting respawned after like 10 minutes.
In the dead room they need to listen to Wap Bap from Bibi H. in an endless loop (THAT'S TORTURE!)
To be respawned, a supervisor can respawn them.
