import java.io.IOException;
import java.util.Scanner;
import java.util.List;

public class Menu {
    Scanner menuScanner;


    //Methods
    public void startMenu(Player aPlayer, List aWeaponList) throws IOException {
        this.showMenuOptions();
        int optionChosen = this.getUserMenuOption();

        while(optionChosen != Constants.QUIT_JMORDHAU){
            this.resolveMainMenuOption(optionChosen -1,aPlayer,aWeaponList); // because resolveMainMenuOption creates an array of commands and the first command is on the 0 index
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
        System.out.println("5 - Edit Mercenary");
        System.out.println("6 - Save game");
        System.out.println("0 - Quit jMordhau");
    }

    public int getUserMenuOption(){
        int result = menuScanner.nextInt();
        return result;
    }

    public void resolveMainMenuOption(int menuOptionChosen, Player aPlayer, List aWeaponList) throws IOException {
        menuScanner.nextLine(); //Prevent the newline to be read as user input

        commandList commandList = new commandList();
        List menuCommandList = commandList.createCommandList();
        iCommand commandToExecute = (iCommand) menuCommandList.get(menuOptionChosen);
        commandToExecute.execute(aPlayer,aWeaponList);


    }

    public void editMercenary(int mercenaryIndex, Player aPlayer){
        menuScanner.nextLine(); //Prevent the newline to be read as user input
        System.out.println("Editing: "+mercenaryIndex);
        //Get the index of a mercenary in the list of mercenaries of a player and store it in a variable
        Mercenary mercenaryToEdit = (Mercenary) aPlayer.mercenaryList.get(mercenaryIndex -1);// -1 due to the fact that the mercenary list starts by 0

        //Select which weapon is to be replaced
        System.out.println("What do you want to edit?");
        System.out.println("1) Primary Weapon"+"\n"+"2) Secondary Weapon"+"\n"+"3)Tertiary weapon");
        int weaponToEdit = menuScanner.nextInt();
        System.out.println("Changing "+mercenaryIndex+"'s weapon:["+weaponToEdit+"]");

        //Selecting new item
        System.out.println("By which item do you wish to replace it?");
        this.showWeaponList(aPlayer.weaponList);
        int newWeaponIndex = menuScanner.nextInt();
        Weapon newWeapon = (Weapon) aPlayer.weaponList.get(newWeaponIndex-1); // -1 due to the fact that the weapon list starts by 0

        //Replacing weapon with the new one
        switch (weaponToEdit){

            case Constants.PRIMARY_WEAPON:
                mercenaryToEdit.primary = newWeapon;
                break;

            case Constants.SECONDARY_WEAPON:
                mercenaryToEdit.secondary = newWeapon;
                break;

            case Constants.TERTIARY_WEAPON:
                mercenaryToEdit.tertiary = newWeapon;
                break;
        }



    }

    public void createNewMercenary(Player aPlayer){
        System.out.println("You chose option 1: Create a new Mercenary");
        System.out.println("Choose a name for your Mercenary");
        String newName = menuScanner.nextLine();
        Mercenary newMercenary = new Mercenary(newName);
        newMercenary.battleCry();
        aPlayer.mercenaryList.add(newMercenary);
    }

    public void showWeaponList(List weaponList){

        Weapon aWeapon = new Weapon();
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
