package run;

public class  MonsterRoom extends Room{

	private Monster monster;

	MonsterRoom( Monster mons) {

		monster = mons;
	}
	public boolean roomIsClear(Monster m) {
		if (m.isAlive())
			return true;
		return false;
	}

	public String toString() {

		return "2";
}
}
