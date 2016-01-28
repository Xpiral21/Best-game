package run;

public class Room {
	private String description;
	private Monster monster;
	private Trader trader;
	Room(String desc, Monster mons) {
		description = desc;
		monster = mons;

	}

	public boolean roomIsClear(Monster m) {
		if (m.isAlive())
			return true;
		return false;
	}
	Room (String desc,Trader trader){
		description=desc;
		this.trader=trader;
	}
	Room(String desc) {
		description = desc;
	}
	Room() {
		description = "Test Room";
		
	}
	
	public String toString() {

			return "0";
	}

	public String getDescription() {
		return description;
	}

	public Monster getMonster() {
		return monster;
	}

	public Trader getTrader() {
		return trader;
	}
	
}
