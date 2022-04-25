package Locations;


import Monsters.Monster;
import Weapons.Armors;
import Weapons.Weapons;
import Game.Player;

import java.util.Random;

public class BattleLocation extends Location {
    private Monster monster;
    private String award;
    private int maxMonster;

    public BattleLocation(Player player, String name, Monster monster, String award, int maxMonster) {
        super(player, name);
        this.monster = monster;
        this.award = award;
        this.maxMonster = maxMonster;
    }

    @Override
    public boolean onLocation() {
        int monsterNumber = this.randomMonsterCreate();
        System.out.println("You are here: " + this.getName());
        System.out.println("Be careful! " + monsterNumber + " " + this.getMonster().getName() +  " lives here!");
        System.out.println("<F>ight or <E>scape");
        String selectCase = Location.scan.nextLine();
        selectCase = selectCase.toUpperCase();

        if(selectCase.equals("F")){
            if(combat(monsterNumber)){
                System.out.println(this.getName() + " is now clear.");
                System.out.println("You won " + this.getAward());
                if(this.getAward().equals("Food"))
                    this.getPlayer().getInventory().setFood(true);
                if(this.getAward().equals("Firewood"))
                    this.getPlayer().getInventory().setFirewood(true);
                if(this.getAward().equals("Water"))
                    this.getPlayer().getInventory().setWater(true);

                return true;
            }
        }

        if(this.getPlayer().getHealth() <= 0){
            System.out.println("You are dead!");
            return false;
        }

        return true;
    }

    public boolean combat(int monsterNumber){
        for (int i = 1; i <= monsterNumber; i++) {
            this.getMonster().setHealth(this.getMonster().getDefaultHealth());
            playerStatus();
            monsterStatus(i);

            Random random = new Random();
            int firstAttack = random.nextInt(2);

            while (this.getPlayer().getHealth() > 0 && this.getMonster().getHealth() > 0){
                System.out.println("<A>ttack or <R>un");
                String selectCombat = Location.scan.nextLine().toUpperCase();

                if(selectCombat.equals("A")){

                    if(firstAttack == 0){
                        System.out.println("You first.");
                        hitUser();
                        hitMonster();
                    }
                    else{
                        System.out.println("Monsters.Monster first.");
                        hitMonster();
                        hitUser();
                    }
                }
                else
                    return false;
            }

            if(this.getMonster().getHealth() < this.getPlayer().getHealth()){
                System.out.println("You defeated the monster!");
                if(this.getMonster().getId() == 4){
                    System.out.println("Calculating reward probabilities");
                    calculateReward();
                }else
                    System.out.println("Your award: " + this.getMonster().getAward());

                this.getPlayer().setMoney(this.getPlayer().getMoney() + this.getMonster().getAward());
                System.out.println("Your money is: " + this.getPlayer().getMoney());
            }
            else
                return false;
        }
        return true;
    }

    private void calculateReward() {
        Random random = new Random();
        int chance = random.nextInt(100) + 1;

        if(chance <= 15){
            System.out.println("You won weapon!");
            int chanceWeapon = random.nextInt(100) + 1;
            if(chanceWeapon <= 20){
                this.getPlayer().getInventory().setWeapons(new Weapons("Pistol",1,2,15));
                System.out.println("You won " + this.getPlayer().getInventory().getWeapons().getName());
            }
            else if(chanceWeapon > 20 && chanceWeapon <=50){
                this.getPlayer().getInventory().setWeapons(new Weapons("Blade",2,3,35));
                System.out.println("You won " + this.getPlayer().getInventory().getWeapons().getName());
            }
            else if(chanceWeapon > 20 && chanceWeapon <=50){
                this.getPlayer().getInventory().setWeapons(new Weapons("Rifle",3,7,45));
                System.out.println("You won " + this.getPlayer().getInventory().getWeapons().getName());
            }

        }else if (chance > 15 && chance <=30) {
            System.out.println("You won armor!");
            int chanceArmor = random.nextInt(100) + 1;
            if(chanceArmor <= 20){
                this.getPlayer().getInventory().setArmors(new Armors(3, "Heavy", 5, 40));
                System.out.println("You won " + this.getPlayer().getInventory().getArmors().getName());
            }
            else if(chanceArmor > 20 && chanceArmor <=50){
                this.getPlayer().getInventory().setArmors(new Armors(2, "Middle", 3, 25));
                System.out.println("You won " + this.getPlayer().getInventory().getArmors().getName());
            }
            else {
                this.getPlayer().getInventory().setArmors(new Armors(1, "Light", 1, 15));
                System.out.println("You won " + this.getPlayer().getInventory().getArmors().getName());
            }

        }else if (chance > 30 && chance <=55){
            System.out.println("You won money!");
            int chanceMoney = random.nextInt(100) + 1;
            if(chanceMoney <= 20){

                this.getPlayer().setMoney(this.getPlayer().getMoney()+10);
            }
            else if(chanceMoney > 20 && chanceMoney <= 50){

                this.getPlayer().setMoney(this.getPlayer().getMoney()+5);
            }
            else if(chanceMoney > 50 && chanceMoney <= 100){

                this.getPlayer().setMoney(this.getPlayer().getMoney()+1);
            }

        }else{
            System.out.println("You did not award!");
        }
    }

    private void hitMonster() {
        if(this.getMonster().getHealth() > 0){
            System.out.println();
            System.out.println("Monsters.Monster attacked!");
            int monsterDamage = this.getMonster().getDamage()  + this.getPlayer().getInventory().getArmors().getBlock();

            if(monsterDamage < 0){
                monsterDamage = 0;
            }
            this.getPlayer().setHealth(this.getPlayer().getHealth() - monsterDamage);
            afterHit();
        }
    }

    private void hitUser() {
        System.out.println("You attacked!");
        this.getMonster().setHealth(this.getMonster().getHealth()-this.getPlayer().getTotalDamage());
        afterHit();
    }

    private void afterHit() {
        System.out.println("Your Health: " + this.getPlayer().getHealth() );
        System.out.println("Monsters.Monster Health: " + this.getMonster().getHealth());
        System.out.println();
    }

    private void monsterStatus(int i) {
        System.out.println(i + ". " + this.getMonster().getName() + " Status:");
        System.out.println("---------------------");
        System.out.println("Health: " + this.getMonster().getHealth() +
                " Damage: " + this.getMonster().getDamage() +
                " Award: " + this.getMonster().getAward() + " coin");
        System.out.println();
    }

    private void playerStatus() {
        System.out.println("Game.Player Status:");
        System.out.println("---------------------");
        System.out.println("Health: " + this.getPlayer().getHealth() +
                " Damage: " + this.getPlayer().getTotalDamage() +
                " Money: " + this.getPlayer().getMoney() +
                " Armor: " + this.getPlayer().getInventory().getArmors().getName() +
                " Weapon: " + this.getPlayer().getInventory().getWeapons().getName());
        System.out.println();
    }

    public int randomMonsterCreate(){
        Random random = new Random();
        return random.nextInt(this.getMaxMonster())+1;
    }
    public int getMaxMonster() {
        return maxMonster;
    }

    public void setMaxMonster(int maxMonster) {
        this.maxMonster = maxMonster;
    }

    public Monster getMonster() {
        return monster;
    }

    public void setMonster(Monster monster) {
        this.monster = monster;
    }

    public String getAward() {
        return award;
    }

    public void setAward(String award) {
        this.award = award;
    }
}
