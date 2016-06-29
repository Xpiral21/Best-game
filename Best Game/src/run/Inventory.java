package run;

import java.util.ArrayList;

import javax.swing.DefaultListModel;

public class Inventory {
	public ArrayList<Item> inventory = new ArrayList<>();

	public void addItem(Item item) {
		this.inventory.add(item);
		DefaultListModel<Item>listModel = new DefaultListModel();
		for (int i = 0; i < inventory.size(); i++) {
			listModel.addElement(inventory.get(i));
		}
		GUI.getList().setModel(listModel);
		
	}
	public void removeItem(int z){
		inventory.remove(z);
		DefaultListModel<Item>listModel = new DefaultListModel();
		for (int i = 0; i < inventory.size(); i++) {
			listModel.addElement(inventory.get(i));
		}
		GUI.getList().setModel(listModel);
	}

	public Item getItem(int i) {
		return inventory.get(i);
	}

	public int getSize() {
		return inventory.size();
	}

	@Override
	public String toString() {
		String str = "INVENTROY" + System.lineSeparator();
		for (int i = 0; i < inventory.size(); i++) {
			str = str +"Item no : "+i+System.lineSeparator()+ inventory.get(i) + System.lineSeparator();
		}
		str = str + System.lineSeparator();
		return str;
	}
}
