package run;

import java.util.ArrayList;

public class Inventory {
	private ArrayList<Item> inventory = new ArrayList();

	public void addItem(Item item) {
		this.inventory.add(item);
	}

	public Item getItem(int i) {
	
		return inventory.get(i);
	}


	public int getSize (){
		return inventory.size();
	}
	@Override
	public String toString() {
		String str="INVENTROY"+System.lineSeparator();
		for(int i =0;i<inventory.size();i++){
			str = str+inventory.get(i)+System.lineSeparator();
		}
		str=str+System.lineSeparator();
		return str;
	}
}
