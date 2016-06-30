package run;

import java.util.ArrayList;

public class Trader {
	ArrayList<Item> gg = new ArrayList<>();

	public Trader() {
		int items = (int) (Math.random() * 2) + 1;
		for (int i = 0; i < items; i++) {
			Item item = new Item();
			gg.add(item);
		}
	}

	public void buyItem(int i, Hero hero) {
		try {
			if (i < gg.size()) {
				Item copy = gg.get(i);
				gg.remove(i);
				hero.inventory.addItem(copy);
				hero.setGold(hero.getGold() - copy.getValue());
			}
		} catch (IndexOutOfBoundsException e) {
			System.out.println("Try a real number.");
		}

	}
}