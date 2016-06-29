package run;

import java.util.ArrayList;

import javax.swing.DefaultListModel;

public class EquippedItems {

	private ArrayList<Item> items = new ArrayList();

	public ArrayList<Item> getItems() {
		return items;
	}

	public Item getItem(int i) {
		return items.get(i);
		
	}

	public void addItem(Item item) {
		items.add(item);
		DefaultListModel<Item> listModel_1 = new DefaultListModel();
		for (int i = 0; i < MainThread.getHero().getEquippedItems().getSize(); i++) {
			listModel_1.addElement(MainThread.getHero().getEquippedItems().getItem(i));
		}
		GUI.getList_1().setModel(listModel_1);
	}

	public int getSize() {
		return items.size();
	}

	@Override
	public String toString() {
		String str = "EQUIPPED ITEMS" + System.lineSeparator();
		for (int i = 0; i < items.size(); i++) {
			str = str + items.get(i) + System.lineSeparator();
		}
		str = str + System.lineSeparator();
		return str;
	}

	// Temporary
	public void removeItem(String itemName) {
		for (int i = 0; i < items.size(); i++) {
			if (items.get(i).getName().compareTo(itemName) == 0) {
				items.remove(i);
			}
		}
		DefaultListModel<Item> listModel_1 = new DefaultListModel();
		for (int i = 0; i < MainThread.getHero().getEquippedItems().getSize(); i++) {
			listModel_1.addElement(MainThread.getHero().getEquippedItems().getItem(i));
		}
		GUI.getList_1().setModel(listModel_1);
	}
}
