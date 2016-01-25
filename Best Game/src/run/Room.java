package run;

public class Room {
	private String description;
	private Monster monster;

	Room(String desc, Monster mons) {
		description = desc;
		monster = mons;

	}
	public boolean roomIsClear(){
		if(monster.getHp()<1)
			return true;
		return false;
	}
	 Room (){
	description = "Test Room";
	monster = monster.randomMonster();
	}
}
