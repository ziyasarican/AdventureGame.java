package Locations;

import Locations.BattleLocation;
import Monsters.Snake;
import Game.Player;

public class Mine extends BattleLocation {
    public Mine(Player player) {
        super(player, "Locations.Mine", new Snake(), "Loot", 5);
    }
}
