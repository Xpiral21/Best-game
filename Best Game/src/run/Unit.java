package run;

import java.util.Random;

public abstract class Unit {

	private String name; // Thor- constructor
	private String description; // God of Thunder-builder constructor
	private int maxHitPoints;// -builder constructor
	private int currentHitPoints;
	private int armor; // reduces damage;
	private int maxDamage;// -builder constructor
	private int minDamage;
	private int evasion; // percentage of miss
	private int mana;

	public Unit(String name, String description, int maxHitPoints, int currentHitPoints, int armor, int maxDamage,
			int minDamage, int evasion) {
		this.name = name;
		this.description = description;
		this.maxHitPoints = maxHitPoints;
		this.currentHitPoints = currentHitPoints;
		this.armor = armor;
		this.maxDamage = maxDamage;
		this.minDamage = minDamage;
		this.evasion = evasion;
	}

	// abstract methods shared between all UNITS

	abstract int attack();

	abstract void heal();

	abstract boolean isAlive();

	abstract void surrender();

	abstract String getStatus(); // return currentHitpoints

	public final Random random = new Random();

	// end abstract methods shared between all UNITS

	// getters

	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}

	public int getMaxHitPoints() {
		return maxHitPoints;
	}

	public int getCurrentHitPoints() {
		return currentHitPoints;
	}

	public int getArmor() {
		return armor;
	}

	public int getMaxDamage() {
		return maxDamage;
	}

	public int getMinDamage() {
		return minDamage;
	}

	public int getEvasion() {
		return evasion;
	}

	public int getMana() {
		return mana;
	}

	// end getters

	// begin setters

	public void setCurrentHitPoints(int currentHitPoints) {
		this.currentHitPoints = currentHitPoints;
	}

	public void setArmor(int armor) {
		this.armor = armor;
	}

	public void setMaxDamage(int maxDamage) {
		this.maxDamage = maxDamage;
	}

	public void setMinDamage(int minDamage) {
		this.minDamage = minDamage;
	}

	public void setEvasion(int evasion) {
		this.evasion = evasion;
	}

	// end setters

}
