package run;

import java.util.ArrayList;

public class Hero extends Unit {
	int previousExperienceRequiered = 100;
	int currentExperienceRequiered = 100;
	int currentExperiencePoints = 0;
	int prevLocation[] = { 4, 5 };
	int charLocation[] = { 5, 5 };
	Skills heroSkills;
	private int numPotions = 2;
	Inventory inventory = new Inventory();
	EquippedItems equippedItems = new EquippedItems();
	
	

	public Inventory getInventory() {
		return inventory;
	}

	public EquippedItems getEquippedItems() {
		return equippedItems;
	}

	

	public int getNumPotions() {
		return numPotions;
	}

	public int getVerticalLocation() {
		return charLocation[0];
	}

	public int getCurrentExperienceRequiered() {
		return currentExperienceRequiered;
	}

	public int getCurrentExperiencePoints() {
		return currentExperiencePoints;
	}

	public void setCurrentExperiencePoints(int currentExperiencePoints) {
		this.currentExperiencePoints = currentExperiencePoints;
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

	void levelUP() {

		if (currentExperiencePoints >= currentExperienceRequiered) {
			int copy = currentExperienceRequiered;
			currentExperiencePoints = currentExperiencePoints - currentExperienceRequiered;
			currentExperienceRequiered = (int) (previousExperienceRequiered * 1.3);
			GUI.getProgressBar_1().setMaximum(currentExperienceRequiered);
			previousExperienceRequiered = copy;
			this.setLevel(this.getLevel() + 1);
			System.out.println("You are now Level " + this.getLevel());
			this.setMaxDamage((int) (this.getMaxDamage() * 1.08));
			this.setMinDamage((int) (this.getMinDamage()*1.08));
			this.setMaxHitPoints((int) (this.getMaxHitPoints() * 1.08));
			this.setAccuracy((int)(this.getAccuracy()*1.08));
			this.setArmor((int)(this.getArmor()*1.08));
			this.setEvasion((int)(this.getEvasion()*1.08));
		}
	}

	@Override
	String getStatus() {
		return "Your HP  " + getCurrentHitPoints();
	}

	public void equipItem(Item item) {
		ArrayList<Item> items = equippedItems.getItems();
		boolean alreadyEquipped = false;
		int similarItem = 0;

		for (int i = 0; i < items.size(); i++) {

			if (items.get(i).getName().contains(item.getItemType())) {
				alreadyEquipped = true;
				similarItem = i;
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
			System.out.println("You have equipped " + item.getName());
		} else {
			this.setMaxHitPoints(this.getMaxHitPoints() + item.getMaxHitPoints());
			this.setArmor(this.getArmor() + item.getArmor());
			this.setMaxDamage(this.getMaxDamage() + item.getMaxDamage());
			this.setMinDamage(this.getMinDamage() + item.getMinDamage());
			this.setEvasion(this.getEvasion() + item.getEvasion());
			this.setAccuracy(this.getAccuracy() + item.getAccuracy());
			System.out.println(
					"You have swapped " + equippedItems.getItem(similarItem).getName() + " with " + item.getName());
			unequipItem(equippedItems.getItem(similarItem));
			equippedItems.addItem(item);

		}

	}

	public void unequipItem(Item item) {
		this.setMaxHitPoints(this.getMaxHitPoints() - item.getMaxHitPoints());
		this.setArmor(this.getArmor() - item.getArmor());
		this.setMaxDamage(this.getMaxDamage() - item.getMaxDamage());
		this.setMinDamage(this.getMinDamage() - item.getMinDamage());
		this.setEvasion(this.getEvasion() - item.getEvasion());
		this.setAccuracy(this.getAccuracy() - item.getAccuracy());
		equippedItems.removeItem(item.getName());
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
