package run;

public class Trader {
	Inventory inventory = new Inventory();

	public Trader() {
		int items = (int) (Math.random() * 2) + 1;
		for (int i = 0; i < items; i++) {
			Item item = new Item();
			inventory.addItem(item);
		}
	}

	public void buyItem(int i, Hero hero) {
		try {
			if (i < inventory.getSize()) {
				Item copy = inventory.getItem(i);
				inventory.removeItem(i);
				hero.inventory.addItem(copy);
				hero.setGold(hero.getGold() - copy.getValue());
			}
		} catch (IndexOutOfBoundsException e) {
			System.out.println("Try a real number.");
		}

	}
}