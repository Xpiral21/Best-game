package run;

public class MonsterRoom extends Room {

	private Monster monster;

	MonsterRoom(Monster mons) {
		super("There's a monster in here.");
		monster = mons;
	}

	public boolean roomIsClear(Monster m) {
		if (m.isAlive())
			return true;
		return false;
	}

	public Monster getMonster() {
		return monster;
	}

	public void setMonster(Monster monster) {
		this.monster = monster;
	}

	public String toString() {

		return "2";
	}
}
