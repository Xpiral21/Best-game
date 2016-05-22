package run;

import java.util.ArrayList;

public class Inventory {
	private ArrayList<Item> inventory = new ArrayList();

	public void addItem(Item item) {
		inventory.add(item);
	}

	public Item getItem(int i) {
		Item copy = inventory.get(i);
		inventory.remove(i);
		return copy;
	}

	public void showInventory() {
		for (int i = 0; i < inventory.size(); i++) {
			System.out.println("Item number : " + i);
			System.out.println(inventory.get(i));
		}

	}
	public int getSize (){
		return inventory.size();
	}
}
