package Locations;

import Game.Player;

public class SafeHouse extends NormalLocation {

    @Override
    public boolean onLocation() {
        System.out.println("You are in the Safe House!");
        System.out.println("Now your health is full!");
        this.getPlayer().setHealth(this.getPlayer().getOriginalHealth());
        return true;
    }

    public SafeHouse(Player player) {
        super(player, "Safe House!");
    }
}
