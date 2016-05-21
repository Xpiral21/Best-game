package run;

import java.util.ArrayList;

public class Inventory {
	ArrayList<Item> inventory = new ArrayList();

	public void addItem(Item item) {
		inventory.add(item);
	}
	public Item getItem(int i){
		Item copy = inventory.get(i);
		inventory.remove(i);
		return copy;
	}
}
