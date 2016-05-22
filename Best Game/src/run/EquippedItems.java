package run;

import java.util.ArrayList;

public class EquippedItems {

	private ArrayList<Item> Items = new ArrayList();

	public ArrayList<Item> getItems() {
		return Items;
	}
	public void addItem(Item item){
		Items.add(item);
	}
}
