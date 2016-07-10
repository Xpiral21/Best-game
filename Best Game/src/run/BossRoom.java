package run;

import java.util.ArrayList;

public class BossRoom extends Room{

	private Monster monster;

	BossRoom(ArrayList<Monster> bosses) {
		super("There's a Boss in here and it's not you.");
		monster = bosses.get((int) (Math.random() * bosses.size()));
	}

	public boolean roomIsClear(Monster m) {
		if (m.isAlive()) {
			return true;
		}
		return false;
	}

	public Monster getMonster() {
		return monster;
	}

	@Override
	public String toString() {

		return "6";
	}
}
