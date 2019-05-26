public class Weapon {

    public String type;
    public String name;
    public int attack;
    public int speed;
    public int block;
    public int cost;

    public Weapon(String type, String name, int attack, int speed, int block, int cost) {
        this.type = type;
        this.name = name;
        this.attack = attack;
        this.speed = speed;
        this.block = block;
        this.cost = cost;
    }

    public Weapon() {
        super();
    }


    public void dumpWeapon(){

        System.out.println("Type: ["+this.type+"]     Name: ["+this.name+"]     Attack: "+this.attack+" Speed: "+this.speed+" Block: "+this.block+" Cost: "+this.cost);


    }

}
