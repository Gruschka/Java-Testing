import java.util.Scanner;
import java.util.List;

public class Menu {
    Scanner menuScanner;


    //Methods
    public void startMenu(Player aPlayer, List aWeaponList){
        this.showMenuOptions();
        int optionChosen = this.getUserMenuOption();

        while(optionChosen != Constants.QUIT_JMORDHAU){
            this.resolveMainMenuOption(optionChosen,aPlayer,aWeaponList);
            showMenuOptions();
            optionChosen = this.getUserMenuOption();
        }

    }

    public void showMenuOptions(){
        System.out.println("Choose an option:");
        System.out.println("1 - Create new mercenary");
        System.out.println("2 - Buy weapons");
        System.out.println("3 - See Player's Weapon List");
        System.out.println("4 - See Player's Mercenary List");
        System.out.println("0 - Quite jMordhau");
    }

    public int getUserMenuOption(){
        int result = menuScanner.nextInt();
        return result;
    }

    public void resolveMainMenuOption(int menuOptionChosen, Player aPlayer, List aWeaponList){

        switch (menuOptionChosen){
            case Constants.CREATE_NEW_MERCENARY:
                menuScanner.nextLine();
                System.out.println("You chose option 1: Create a new Mercenary");
                System.out.println("Choose a name for your Mercenary");
                String newName = menuScanner.nextLine();
                Mercenary newMercenary = new Mercenary(newName);
                newMercenary.battleCry();
                aPlayer.mercenaryList.add(newMercenary);
                break;

            case Constants.BUY_WEAPONS:
                System.out.println("Want to buy some weapons, huh?");

                this.showWeaponList(aWeaponList);
                this.getWeaponMenuOption(aWeaponList,aPlayer);

                break;

            case Constants.QUIT_JMORDHAU:
                System.out.println("Thanks for playing!");
                break;


            default:
                System.out.println("Invalid option!");
        }

    }



    public void showWeaponList(List weaponList){

        Weapon aWeapon = new Weapon();
        System.out.println("Available weapons:");
        for(int i = 0; i < weaponList.size(); i++){
            System.out.print("{"+(i+1)+"}  ");
            aWeapon = (Weapon) weaponList.get(i);
            aWeapon.dumpWeapon();

        }


    }


    public int getWeaponMenuOption(List weaponList, Player aPlayer){
        int result = menuScanner.nextInt();
        Weapon weaponToBuy = (Weapon) weaponList.get(result-1);

        System.out.println("So, you want to buy " + weaponToBuy.name + " ...");

        if(aPlayer.money > weaponToBuy.cost){

            System.out.println("That'll cost you $"+weaponToBuy.cost);
            System.out.println("Do we have a deal? Y/N");

            char deal = menuScanner.next().charAt(0);
            if(deal == 'y' || deal == 'Y'){
                System.out.println("It's a deal then! Thank you!");
                aPlayer.spendMoney(weaponToBuy.cost);
                aPlayer.weaponList.add(weaponToBuy);
            }else{
                System.out.println("A'ight then. 'Till next time!");
            }
        }else{
            System.out.println("You miserable rat! Come back when you've got more money");
        }





        return result;

    }

    //Constructor
    public Menu(){
        this.menuScanner = new Scanner(System.in);
    }



}
