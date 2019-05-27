import java.io.IOException;
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


    public static void main(String[] args) throws IOException {

        //Declares scanner and menu
        Scanner scanner = new Scanner(System.in);
        Menu menu = new Menu();
        saveObject save = new saveObject();
        List weaponList = generateWeaponList(); // Vendor's weapons
        Player newPlayer = new Player();

        //Create new player and generate weapon list
        System.out.println("Welcome to jMordhau!");

        System.out.println("Would you like to load from last save game? Y/N");
        char option = scanner.nextLine().charAt(0); //Reads the first char from the read string




        if(option == 'y' || option =='Y'){
            newPlayer = save.readPlayerFromFile(Constants.SAVE_GAME_FILEPATH);
            newPlayer.dumpPlayerInfo();
        }else{
            System.out.println("Please provide desired Player name");
            String newPlayerName = scanner.nextLine();
            newPlayer = new Player(newPlayerName,2000);

        }





        //Show menu
        menu.startMenu(newPlayer, weaponList);



    }







}
