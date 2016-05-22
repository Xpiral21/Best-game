package run;

import java.util.ArrayList;

public class Hero extends Unit {
	int prevLocation[] = { 4, 5 };
	int charLocation[] = { 5, 5 };
	Skills heroSkills;
	private int numPotions = 2;
	Inventory inventory = new Inventory();
	EquippedItems equippedItems = new EquippedItems();

	public int getNumPotions() {
		return numPotions;
	}

	public int getVerticalLocation() {
		return charLocation[0];
	}

	public int getHorizontalLocation() {
		return charLocation[1];
	}

	public void moveHero(String direction) {
		prevLocation = charLocation;
		if (direction.compareTo("up") == 0) {
			charLocation[0]--;
		} else if (direction.compareTo("down") == 0) {
			charLocation[0]++;
		} else if (direction.compareTo("left") == 0) {
			charLocation[1]--;
		} else if (direction.compareTo("right") == 0) {
			charLocation[1]++;
		} else
			System.out.println("Nice Try.");
	}

	public void setNumPotions(int numPotions) {
		this.numPotions = numPotions;
	}

	public Hero(String name, int maxHitPoints, int armor, int maxDamage, int minDamage, int evasion, int accuracy) {
		super(name, maxHitPoints, armor, maxDamage, minDamage, evasion, accuracy);
		heroSkills = new HeroSkills();
	}

	@Override
	int attack() {
		return random.nextInt(getMaxDamage() - getMinDamage() + 1) + getMinDamage();
	}

	int useSkill(String skillName) {

		int skillDamage = heroSkills.fury(getMaxDamage());
		return skillDamage;
	}

	@Override
	void heal() {
		if (numPotions > 0) {
			setCurrentHitPoints(getCurrentHitPoints() + 20);
			System.out.println(getName() + "was healed");
			numPotions--;
		} else {
			System.out.println("You don't have any potions");
		}
	}

	@Override
	boolean isAlive() {
		return getCurrentHitPoints() > 0;
	}

	@Override
	void surrender() {
	}

	@Override
	String getStatus() {
		return "Your HP is " + getCurrentHitPoints();
	}

	public void equipItem(Item item) {
		ArrayList<Item> items = equippedItems.getItems();
		boolean alreadyEquipped = false;
		ArrayList<String> itemType = new ArrayList();
		if (item.getName().contains("Helmet")) {
			itemType.add("Helmet");
		}
		if (item.getName().contains("Chest")) {
			itemType.add("Chest");
		}
		if (item.getName().contains("Gloves")) {
			itemType.add("Gloves");
		}
		if (item.getName().contains("Pants")) {
			itemType.add("Pants");
		}
		if (item.getName().contains("Boots")) {
			itemType.add("Boots");
		}
		if (item.getName().contains("Sword") || item.getName().contains("Spear") || item.getName().contains("Staff")) {
			itemType.add("Sword");
			itemType.add("Spear");
			itemType.add("Staff");
		}

		for (int i = 0; i < items.size(); i++) {
			for (int j = 0; j < itemType.size(); j++) {
				if (items.get(i).getName().contains(itemType.get(j))) {
					alreadyEquipped = true;
				}
			}
		}

		if (alreadyEquipped == false) {
			this.setMaxHitPoints(this.getMaxHitPoints() + item.getMaxHitPoints());
			this.setArmor(this.getArmor() + item.getArmor());
			this.setMaxDamage(this.getMaxDamage() + item.getMaxDamage());
			this.setMinDamage(this.getMinDamage() + item.getMinDamage());
			this.setEvasion(this.getEvasion() + item.getEvasion());
			this.setAccuracy(this.getAccuracy() + item.getAccuracy());
			equippedItems.addItem(item);
		}
		System.out.println("You have equipped " + item.getName());
	}

	public void unequipItem(Item item) {

	}

	@Override
	public String toString() {
		String str = System.lineSeparator() + "NAME : " + this.getName() + System.lineSeparator();
		str = str + "MAX HIT POINTS : " + this.getMaxHitPoints() + System.lineSeparator();
		str = str + "CURRENT HIT POINTS : " + this.getCurrentHitPoints() + System.lineSeparator();
		str = str + "MAX DAMAGE : " + this.getMaxDamage() + System.lineSeparator();
		str = str + "MIN DAMAGE : " + this.getMinDamage() + System.lineSeparator();
		str = str + "ARMOR : " + this.getArmor() + System.lineSeparator();
		str = str + "EVASION : " + this.getEvasion() + System.lineSeparator();
		str = str + "ACCURACY : " + this.getAccuracy() + System.lineSeparator();

		return str;
	}
}
