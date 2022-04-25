package Locations;

import Monsters.Monster;
import Monsters.Zombie;
import Game.Player;

public class Cave extends BattleLocation {
    public Cave(Player player) {
        super(player, "Locations.Cave", new Zombie(), "Food",3);

    }
}
