package run;

import java.util.ArrayList;

public class EquippedItems {

	ArrayList<Item> Items = new ArrayList();

	public void equipItem(Item item, Hero hero) {
		boolean alreadyEquipped = false;
		String itemType = "";
		if (item.getName().contains("Helmet")) {
			itemType = "Helmet";
		}
		if (item.getName().contains("Chest")) {
			itemType = "Chest";
		}
		if (item.getName().contains("Gloves")) {
			itemType = "Gloves";
		}
		if (item.getName().contains("Pants")) {
			itemType = "Pants";
		}
		if (item.getName().contains("Boots")) {
			itemType = "Boots";
		}
		if (item.getName().contains("Sword")) {
			itemType = "Sword";
		}
		if (item.getName().contains("Spear")) {
			itemType = "Spear";
		}
		if (item.getName().contains("Staff")) {
			itemType = "Staff";
		}
	
			for (int i = 0; i < Items.size(); i++) {
				if (Items.get(i).getName().contains(itemType)) {
					alreadyEquipped = true;
				}
			
		}
			
		if (alreadyEquipped == false) {
			hero.setMaxHitPoints(hero.getMaxHitPoints() + item.getMaxHitPoints());
			hero.setArmor(hero.getArmor() + item.getArmor());
			hero.setMaxDamage(hero.getMaxDamage() + item.getMaxDamage());
			hero.setMinDamage(hero.getMinDamage() + item.getMinDamage());
			hero.setEvasion(hero.getEvasion() + item.getEvasion());
			hero.setAccuracy(hero.getAccuracy() + item.getAccuracy());
			Items.add(item);
		}
		System.out.println("You have equipped "+item.getName());
	}
}
