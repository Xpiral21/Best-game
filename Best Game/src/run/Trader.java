package run;

public class Trader {
	Inventory inventory = new Inventory();

	public Trader() {
		for (int i = 0; i < 5; i++) {
			Item item = new Item();
			inventory.addItem(item);
		}
	}

	public void buyItem(int i, Hero hero) {

			Item copy = inventory.getItem(i);
			inventory.removeItem(i);
			hero.inventory.addItem(copy);
			hero.setGold(hero.getGold() - copy.getValue());
		
	}

}
