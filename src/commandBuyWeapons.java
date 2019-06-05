import java.util.List;
import java.util.Scanner;

public class commandBuyWeapons implements iCommand {

    Scanner commandScanner = new Scanner(System.in);

    @Override
    public void execute(Player aPlayer, List weaponList) {

        System.out.println("Want to buy some weapons, huh?");
        System.out.println("Available weapons:");
        aPlayer.showWeaponList(weaponList);
        this.getWeaponMenuOption(weaponList,aPlayer);

    }


    public commandBuyWeapons() {
    }

    public int getWeaponMenuOption(List weaponList, Player aPlayer){
        int result = commandScanner.nextInt();
        Weapon weaponToBuy = (Weapon) weaponList.get(result-1);

        System.out.println("So, you want to buy " + weaponToBuy.name + " ...");

        if(aPlayer.money > weaponToBuy.cost){

            System.out.println("That'll cost you $"+weaponToBuy.cost);
            System.out.println("Do we have a deal? Y/N");

            char deal = commandScanner.next().charAt(0);
            if(deal == 'y' || deal == 'Y'){
                System.out.println("It's a deal then! Thank you!");
                aPlayer.spendMoney(weaponToBuy.cost);
                Weapon newWeapon = new Weapon(weaponToBuy.type, weaponToBuy.name, weaponToBuy.attack, weaponToBuy.speed, weaponToBuy.block, weaponToBuy.cost);
                aPlayer.weaponList.add(weaponToBuy);
            }else{
                System.out.println("A'ight then. 'Till next time!");
            }
        }else{
            System.out.println("You miserable rat! Come back when you've got more money");
        }





        return result;

    }




}
