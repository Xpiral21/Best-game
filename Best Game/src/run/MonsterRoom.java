package run;

import java.util.ArrayList;

public class MonsterRoom extends Room {

	private Monster monster;

	MonsterRoom(ArrayList<Monster> mons) {
		super("There's a monster in here.");
		monster = mons.get((int)(Math.random()*2));
	}

	public boolean roomIsClear(Monster m) {
		if (m.isAlive())
			return true;
		return false;
	}

	public Monster getMonster() {
		return monster;
	}

	

	public String toString() {

		return "2";
	}
}
