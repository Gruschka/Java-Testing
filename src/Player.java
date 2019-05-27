import java.util.ArrayList;
import java.util.List;
import java.io.Serializable;

public class Player implements Serializable{

    public String playerName;
    public int money;
    public List mercenaryList;
    public List weaponList;

    public Player(String playerName, int money) {
        this.playerName = playerName;
        this.money = money;
        this.mercenaryList = new ArrayList();
        this.weaponList = new ArrayList();
    }

    public void spendMoney(int amountToSpend){
        this.money -= amountToSpend;
    }
}
