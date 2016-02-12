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

}
