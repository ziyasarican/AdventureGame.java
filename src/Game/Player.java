package Game;

import Game.Inventory;
import GameCharacters.Archer;
import GameCharacters.GameChar;
import GameCharacters.Knight;
import GameCharacters.Samurai;

import java.util.Scanner;

public class Player {
    private int damage;
    private int health;
    private int money;
    private int originalHealth;
    private String name;
    private String characterName;
    private Inventory inventory;

    Scanner input = new Scanner(System.in);

    public Player(String name) {
        this.name = name;
        this.inventory = new Inventory();
    }


    public void selectChar(){
        GameChar[] charList = {new Samurai(), new Archer(), new Knight()};
        System.out.println("\n*** Char List ***");
        for (GameChar gameChar: charList) {
            System.out.println("ID: " + gameChar.getId() +
                            "\tChar: " + gameChar.getName() +
                            "\tDamage: " + gameChar.getDamage() +
                            "\tHealth: " + gameChar.getHealth() +
                            "\tMoney: " + gameChar.getMoney());
        }

        System.out.print("\nChose your character: ");
        int selectChar = input.nextInt();

        switch (selectChar){
            case 1:
                initPlayer(new Samurai());
                break;

            case 2:
                initPlayer(new Archer());
                break;

            case 3:
                initPlayer(new Knight());
                break;

        }

        System.out.println("Now your Buddy is: " + this.getCharacterName());
    }

    private void initPlayer(GameChar gameChar) {
        this.setDamage(gameChar.getDamage());
        this.setHealth(gameChar.getHealth());
        this.setOriginalHealth(gameChar.getHealth());
        this.setMoney(gameChar.getMoney());
        this.setCharacterName(gameChar.getName());
    }

    public void printInfo(){
        System.out.println("Weapon: " + this.getInventory().getWeapons().getName() +
                " Damage: " + this.getTotalDamage() +
                " Health: " + this.getHealth() +
                " Money: " + this.getMoney() +
                " Armor: " + this.getInventory().getArmors().getName() +
                " Block: " + this.getInventory().getArmors().getBlock() );
        System.out.print("Awards: ");
        if(getInventory().isFirewood() == true)
            System.out.print("Firewood ");
        if(getInventory().isFood() == true)
            System.out.print("Food ");
        if(getInventory().isWater() == true)
            System.out.print("Water ");
        System.out.println();

    }

    public int getDamage() {

        return damage + this.getInventory().getWeapons().getDamage();
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }
    public int getTotalDamage() {
        return damage + this.getInventory().getWeapons().getDamage();
    }
    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public int getOriginalHealth() {
        return originalHealth;
    }

    public void setOriginalHealth(int originalHealth) {
        this.originalHealth = originalHealth;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCharacterName() {
        return characterName;
    }

    public void setCharacterName(String characterName) {
        this.characterName = characterName;
    }
}
