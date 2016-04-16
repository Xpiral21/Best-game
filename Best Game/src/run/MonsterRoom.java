package run;

import java.util.ArrayList;

public class MonsterRoom extends Room {

    private Monster monster;

    MonsterRoom(ArrayList<Monster> mons) {
        super("There's a monster in here.");
        monster = mons.get((int) (Math.random() * 2));
    }

    @Override
    public boolean roomIsClear(Monster m) {
        if (m.isAlive()) {
            return true;
        }
        return false;
    }

    @Override
    public Monster getMonster() {
        return monster;
    }

    @Override
    public String toString() {

        return "2";
    }
}
