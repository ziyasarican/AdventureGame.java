package Game;

import Weapons.Weapons;
import Weapons.Armors;

public class Inventory {
    private Weapons weapons;
    private Armors armors;
    private boolean food;
    private boolean firewood;
    private boolean water;
    public Inventory() {
        this.weapons = new Weapons("punch",-1,0,0);
        this.armors = new Armors(-1,"Scraps",0,0);

        this.food = false;
        this.water = false;
        this.firewood = false;
    }

    public boolean isFood() {
        return food;
    }

    public void setFood(boolean food) {
        this.food = food;
    }

    public boolean isFirewood() {
        return firewood;
    }

    public void setFirewood(boolean firewood) {
        this.firewood = firewood;
    }

    public boolean isWater() {
        return water;
    }

    public void setWater(boolean water) {
        this.water = water;
    }

    public Armors getArmors() {
        return armors;
    }

    public void setArmors(Armors armors) {
        this.armors = armors;
    }

    public Weapons getWeapons() {
        return weapons;
    }

    public void setWeapons(Weapons weapons) {
        this.weapons = weapons;
    }
}
