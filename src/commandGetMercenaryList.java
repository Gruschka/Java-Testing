import java.util.List;

public class commandGetMercenaryList implements iCommand {

    public commandGetMercenaryList() {
    }

    @Override
    public void execute(Player aPlayer, List weaponList) {
        aPlayer.showMercenaryList(aPlayer.mercenaryList);
    }
}
