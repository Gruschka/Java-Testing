import java.util.ArrayList;
import java.util.List;
import java.io.Serializable;

public class Player implements Serializable {

    public String playerName;
    public int money;
    public List mercenaryList;
    public List weaponList;
    private static final long serialVersionUID = 1L; //If a class does not explicitly define a private static final long serialVersionUID in the code it will be autogenerated,
    // and there is no guarantee that different machines will generate the same id

    public Player(String playerName, int money) {
        this.playerName = playerName;
        this.money = money;
        this.mercenaryList = new ArrayList();
        this.weaponList = new ArrayList();
    }

    public Player() {
    }

    public void spendMoney(int amountToSpend) {
        this.money -= amountToSpend;
    }

    public void dumpPlayerInfo() {
        System.out.println("Player name: " + this.playerName + " Money: $" + this.money);
        System.out.println("Mercenary list: ");
        this.showMercenaryList(this.mercenaryList);
        this.showWeaponList(this.weaponList);

    }


    public void showMercenaryList(List mercenaryList) {
        Mercenary aMercenary;
        System.out.println(this.playerName+"'s Mercenaries:");

        for (int i = 0; i < mercenaryList.size(); i++) {
            System.out.print("{" + (i + 1) + "}  ");
            aMercenary = (Mercenary) mercenaryList.get(i);
            aMercenary.dumpMercenaryInfo();

        }
    }

    public int getIndexOfMercenaryByName(List mercenaryList, String mercenaryName) {

        Mercenary aMercenary;

        for (int i = 0; i < mercenaryList.size(); i++) {
            aMercenary = (Mercenary) mercenaryList.get(i);
            if (aMercenary.name.equals(mercenaryName)) {
                return i;
            }
        }

        return Constants.MERCENARY_NOT_FOUND;

    }


    public void showWeaponList(List weaponList) {
        System.out.println(this.playerName+"'s weapons:");

        Weapon aWeapon = new Weapon();
        for (int i = 0; i < weaponList.size(); i++) {
            System.out.print("{" + (i + 1) + "}  ");
            aWeapon = (Weapon) weaponList.get(i);
            aWeapon.dumpWeapon();

        }


    }

}