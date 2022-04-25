package Game;

import Locations.*;

import java.util.Scanner;

public class Game {
    private Scanner scan = new Scanner(System.in);
    public void start(){
        System.out.println("Welcome Adventure Game.Game !");
        System.out.print("Enter Your Name: ");
        String playerName = scan.nextLine();
        Player player = new Player(playerName);
        System.out.println(player.getName() + " are you ready? You must be ready!");
        player.selectChar();

        Location location = null;

        boolean isContinue = true;
        while (isContinue){
            player.printInfo();

            System.out.println("-------------------------------------------------");
            System.out.println("***LOCATIONS***");
            System.out.println("1- Safe House");
            System.out.println("2- Tool Store");
            System.out.println("3- Locations.Cave -> Award: Food. Be careful, there is a zombie!");
            System.out.println("4- Locations.Forest -> Award: Firewood. Be careful, there is a vampire!");
            System.out.println("5- Locations.River -> Award: Water. Be careful, there is a bear !");
            System.out.println("6- Locations.Mine -> Award: Loot. Be careful, there is a snake !");
            System.out.println("0- Quit");
            System.out.print("Select the region you want to go to: ");
            int selectLocation = scan.nextInt();
            switch (selectLocation){
                case 0:
                    location = null;
                    break;
                case 1:
                    location = new SafeHouse(player);
                    break;
                case 2:
                    location = new ToolStore(player);
                    break;
                case 3:
                    location = new Cave(player);
                    break;
                case 4:
                    location = new Forest(player);
                    break;
                case 5:
                    location = new River(player);
                    break;
                case 6:
                    location = new Mine(player);
                    break;
                default:
                    location = new SafeHouse(player);
            }
            if(location == null){
                System.out.println("Game.Game End");
                break;
            }
            if(!location.onLocation()){
                System.out.println("GAME OVER!");
                break;
            }
            if(player.getInventory().isWater() == true && player.getInventory().isFood() == true && player.getInventory().isFirewood() == true){
                System.out.println("\nYou have successfully collected all the rewards.");
                System.out.println("Congratulations You Finished the Game.Game");
                isContinue = false;
            }

        }
    }
}
