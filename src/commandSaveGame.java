import java.io.IOException;
import java.util.List;

public class commandSaveGame implements iCommand {

    public commandSaveGame() {
    }

    @Override
    public void execute(Player aPlayer, List weaponList) throws IOException {
        System.out.println("Saving progress!");
        //Instantiates saveObject class
        saveObject save = new saveObject();
        //Saves player object data to file
        save.writePlayerToFile(aPlayer);

    }
}
