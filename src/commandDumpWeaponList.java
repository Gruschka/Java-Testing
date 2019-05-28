import java.util.List;
import java.util.Scanner;


public class commandDumpWeaponList implements iCommand {

    public commandDumpWeaponList() {
    }

    @Override
    public void execute(Player aPlayer, List weaponList) {
        aPlayer.showWeaponList(weaponList);
    }
}
