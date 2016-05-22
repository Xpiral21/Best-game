package run;

import java.util.ArrayList;

public class EquippedItems {

	private ArrayList<Item> items = new ArrayList();

	public ArrayList<Item> getItems() {
		return items;
	}
	public void addItem(Item item){
		items.add(item);
	}
	@Override
	public String toString() {
		String str="EQUIPPED ITEMS"+System.lineSeparator();
		for(int i =0;i<items.size();i++){
			str = str+items.get(i)+System.lineSeparator();
		}
		str=str+System.lineSeparator();
		return str;
	}
}
