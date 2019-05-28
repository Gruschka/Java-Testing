
import java.io.IOException;
import java.util.Scanner;
import java.util.List;


public interface iCommand {

    Scanner commandScanner = new Scanner(System.in);



    void execute(Player aPlayer, List weaponList) throws IOException;

}
