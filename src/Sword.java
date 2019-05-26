public class Sword extends Weapon {

    int amountOfHands;


    public Sword(String type, String name, int attack, int speed, int block,int cost, int amountOfHands) {
        super(type, name, attack, speed, block,cost);
        this.amountOfHands = amountOfHands;
    }



}
