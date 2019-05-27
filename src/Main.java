import java.util.ArrayList;     //Manage mercenaries and weapons list
import java.util.List;          //Manage mercenaries and weapons list
import java.util.Scanner;       //Get User Input

public class Main {




    public static List generateWeaponList(){

        List weaponList = new ArrayList();
        Sword sword1 = new Sword("bastard","Glamdring",7,3,5,3500,2);
        Sword sword2 = new Sword("Longsword","Anduril",6,4,5,3000,2);
        Sword sword3 = new Sword("bastard","Hadhafang",5,7,3,2500,1);
        Sword sword4 = new Sword("Letter opener","Sting",2,8,3,1500,1);

        weaponList.add(sword1);
        weaponList.add(sword2);
        weaponList.add(sword3);
        weaponList.add(sword4);

        return weaponList;


    }


    public static void main(String[] args) {

        //Declares scanner and menu
        Scanner scanner = new Scanner(System.in);
        Menu menu = new Menu();

        //Create new player and generate weapon list
        System.out.println("Choose your Player Name");
        String newPlayerName = scanner.nextLine();
        Player newPlayer = new Player(newPlayerName,2000);
        List weaponList = generateWeaponList();


        System.out.println("Welcome to jMordhau!");

        //Show menu
        menu.startMenu(newPlayer, weaponList);



    }







}
