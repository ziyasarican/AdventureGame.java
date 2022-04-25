package Locations;

import Weapons.Weapons;
import Game.Inventory;
import Weapons.Armors;
import Game.Player;


public class ToolStore extends NormalLocation {
    public ToolStore(Player player) {
        super(player, "Tool Store");
    }

    @Override
    public boolean onLocation() {
        boolean showMenu = true;
        System.out.println("Welcome Tool Store!");
        System.out.println("You can buy item!");

        while (showMenu){
            System.out.println("1- Weapons.Weapons");
            System.out.println("2- Weapons.Weapons.Armors");
            System.out.println("3- Quit");

            System.out.print("What do you want:");
            int selectCase = Location.scan.nextInt();



            while (selectCase < 1 || selectCase > 3){
                System.out.println("Make a valid choice:");
                selectCase = Location.scan.nextInt();
            }
            switch (selectCase) {
                case 1:
                    printWeapons();
                    buyWeapon();
                    break;
                case 2:
                    printArmors();
                    buyArmor();
                    break;
                case 3:
                    System.out.println("Come again!");
                    showMenu = false;
                    break;

            }

        }
        return true;
    }

    public void buyWeapon(){
        System.out.print("Choice a weapon: ");
        int selectWeaponID = Location.scan.nextInt();

        while (selectWeaponID < 0 || selectWeaponID > Weapons.weapons().length){
            System.out.println("Make a valid choice:");
            selectWeaponID = Location.scan.nextInt();
        }
        if(selectWeaponID != 0){
            Weapons selectedWeapon = Weapons.getWeaponObj(selectWeaponID);

            if(selectedWeapon.getPrice() > this.getPlayer().getMoney()){
                System.out.println("Your money is not enough.");
            }
            else{
                System.out.println("You bought this weapon. - " + selectedWeapon.getName() );
                this.getPlayer().setMoney(this.getPlayer().getMoney()-selectedWeapon.getPrice()) ;
                System.out.println("Your money is: " + this.getPlayer().getMoney());
                this.getPlayer().getInventory().setWeapons(selectedWeapon);

            }
        }

    }
    public void buyArmor(){
        System.out.print("Choice a Armor: ");
        int selectArmorID = Location.scan.nextInt();

        while (selectArmorID < 0 || selectArmorID > Armors.armors().length){
            System.out.println("Make a valid choice:");
            selectArmorID = Location.scan.nextInt();
        }

        if(selectArmorID != 0){
            Armors selectedArmor = Armors.getArmorObj(selectArmorID);

            if(selectedArmor.getPrice() > this.getPlayer().getMoney()){
                System.out.println("Your money is not enough.");
            }
            else{
                System.out.println("You bought this armor. - " + selectedArmor.getName() );
                this.getPlayer().setMoney(this.getPlayer().getMoney()-selectedArmor.getPrice()) ;
                System.out.println("Your money is: " + this.getPlayer().getMoney());
                this.getPlayer().getInventory().setArmors(selectedArmor);
            }
        }

    }
    public void printWeapons(){
        System.out.println("\nWeapons.Weapons:");
        for(Weapons weapons : Weapons.weapons()){
            System.out.println(weapons.getId() + "-" + weapons.getName() + " <> Cost: " + weapons.getPrice() + " Damage: " +weapons.getDamage());
        }
        System.out.println("0: Quit");
    }
    public void printArmors(){
        System.out.println("\nWeapons.Weapons.Armors:");
        for(Armors armors : Armors.armors()){
            System.out.println(armors.getId() + " <> " +
                    armors.getName() +
                    " Armor: " + armors.getBlock() +
                    " Price: " + armors.getPrice());
        }
        System.out.println("0: Quit");
    }
}
