package run;

public class CityRoom extends Room {
	private Trader trader;

	CityRoom(Trader t) {
		super("You enter a city");
		trader = t;

	}

	public String toString() {
		return "3";
	}
public boolean roomIsClear(Monster m) {
		if (m.isAlive())
			return true;
		return false;
	}

	public Monster getMonster() {
		return null;
	}
}
