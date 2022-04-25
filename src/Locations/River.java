package Locations;

import Game.Player;
import Locations.BattleLocation;
import Monsters.Bear;

public class River extends BattleLocation {
    public River(Player player) {
        super(player, "Locations.River", new Bear(), "Water",2);
    }
}
