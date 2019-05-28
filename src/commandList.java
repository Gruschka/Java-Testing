import java.util.ArrayList;
import java.util.List;


public class commandList {
    public commandList() {
    }

    public List createCommandList(){

        List newList = new ArrayList();

        //create, buy, see weapon, see merc, edit merc, save
        commandNewMercenary newMercenaryCommand = new commandNewMercenary();
        commandBuyWeapons buyWeaponCommand = new commandBuyWeapons();
        commandDumpWeaponList dumpWeaponCommand = new commandDumpWeaponList();
        commandGetMercenaryList getMercenaryCommand = new commandGetMercenaryList();
        commandEditMercenary editMercenaryCommand = new commandEditMercenary();
        commandSaveGame saveGameCommand = new commandSaveGame();

        newList.add(newMercenaryCommand);
        newList.add(buyWeaponCommand);
        newList.add(dumpWeaponCommand);
        newList.add(getMercenaryCommand);
        newList.add(editMercenaryCommand);
        newList.add(saveGameCommand);

        return newList;
    }

}
