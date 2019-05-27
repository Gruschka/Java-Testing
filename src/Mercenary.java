public class Mercenary {

    //Attributes
    String name;
    Weapon primary;
    Weapon secondary;
    Weapon tertiary;


    //Methods
    public void battleCry(){
         System.out.println(("My name is "+name+", prepare to die!"));
    }

    public void dumpMercenaryInfo(){
        System.out.println("Name: "+this.name);
        System.out.println("Primary: "+this.primary);
        System.out.println("Secondary: "+this.secondary);

    }


    //Constructor
    public Mercenary(String name, Weapon primary, Weapon secondary, Weapon tertiary){
        this.name = name;
        this.primary = primary;
        this.secondary= secondary;
        this.tertiary = tertiary;

    }

    public Mercenary(String name){
        this.name = name;

    }

    public Mercenary() {
    }
}

