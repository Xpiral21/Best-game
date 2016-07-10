package run;

public class CityRoom extends Room {

	private Trader trader;

	CityRoom(Trader t) {
		super("You enter a city");
		trader = t;

	}

	@Override
	public String toString() {
		return "3";
	}

}
