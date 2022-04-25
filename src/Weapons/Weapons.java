package Weapons;

public class Weapons {
    private String name;
    private int id;
    private int damage;
    private int price;

    public Weapons(String name, int id, int damage, int price) {
        this.name = name;
        this.id = id;
        this.damage = damage;
        this.price = price;
    }

    public static Weapons[] weapons(){
        Weapons[] weaponsList = new Weapons[3];
        weaponsList[0] = new Weapons("Pistol",1,2,25);
        weaponsList[1] = new Weapons("Blade",2,3,35);
        weaponsList[2] = new Weapons("Rifle", 3,7,45);
        return weaponsList;
    }

    public static Weapons getWeaponObj(int id){
        for (Weapons weapons : Weapons.weapons()){
            if (weapons.getId() == id){
                return weapons;
            }
        }
        return null;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
