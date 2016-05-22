package run;

public class Trader {
	Inventory inventory = new Inventory();

	public Trader() {
		for (int i = 0; i < 5; i++) {
			Item item = new Item();
			inventory.addItem(item);
		}
	}

	public Item buyItem(int i) {
		Item copy = inventory.getItem(i);
		inventory.removeItem(i);
		return copy ;
	}

}
