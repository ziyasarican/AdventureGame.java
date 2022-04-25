package Locations;

import Locations.BattleLocation;
import Monsters.Vampire;
import Game.Player;

public class Forest extends BattleLocation {
    public Forest(Player player) {
        super(player, "Locations.Forest", new Vampire(), "Firewood",3);
    }
}
