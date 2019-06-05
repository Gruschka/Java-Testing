import java.util.Scanner;
import java.util.List;

public class commandNewMercenary implements iCommand {

    Scanner commandScanner = new Scanner(System.in);

    public commandNewMercenary() {
        super();
    }

    @Override
    public void execute(Player aPlayer, List weaponList) {
        System.out.println("You chose option 1: Create a new Mercenary");
        System.out.println("Choose a name for your Mercenary");
        String newName = commandScanner.nextLine();
        Mercenary newMercenary = new Mercenary(newName);
        newMercenary.battleCry();
        Weapon primary = new Weapon();
        Weapon secondary = new Weapon();
        Weapon tertiary = new Weapon();

        newMercenary.primary = primary;
        newMercenary.secondary = secondary;
        newMercenary.tertiary = tertiary;

        aPlayer.mercenaryList.add(newMercenary);
    }


}
