import java.util.Scanner;
import java.util.List;
public class commandEditMercenary implements iCommand {

    Scanner commandScanner = new Scanner(System.in);

    public commandEditMercenary() {
    }

    @Override
    public void execute(Player aPlayer, List weaponList) {
        System.out.println("Which of the following mercenaries do you want to edit? (case sensitive)");
        aPlayer.showMercenaryList(aPlayer.mercenaryList);
        int mercenaryToEdit = commandScanner.nextInt();
        this.editMercenary(mercenaryToEdit, aPlayer);

    }



    public void editMercenary(int mercenaryIndex, Player aPlayer){
        commandScanner.nextLine(); //Prevent the newline to be read as user input
        System.out.println("Editing: "+mercenaryIndex);
        //Get the index of a mercenary in the list of mercenaries of a player and store it in a variable
        Mercenary mercenaryToEdit = (Mercenary) aPlayer.mercenaryList.get(mercenaryIndex -1);// -1 due to the fact that the mercenary list starts by 0

        //Select which weapon is to be replaced
        System.out.println("What do you want to edit?");
        System.out.println("1) Primary Weapon"+"\n"+"2) Secondary Weapon"+"\n"+"3)Tertiary weapon");
        int weaponToEdit = commandScanner.nextInt();
        System.out.println("Changing "+mercenaryIndex+"'s weapon:["+weaponToEdit+"]");

        //Selecting new item
        System.out.println("By which item do you wish to replace it?");
        aPlayer.showWeaponList(aPlayer.weaponList);
        int newWeaponIndex = commandScanner.nextInt();
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
}
