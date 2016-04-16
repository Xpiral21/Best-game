package run;

public class EmptyRoom extends Room {

	EmptyRoom() {
		super("You enter an empty room.It's kinda empty.");
	}

	public String toString() {
		return "0";
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
