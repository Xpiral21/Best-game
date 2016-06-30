package run;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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
	private int accuracy;
	private int gold;
	private int level;

	public Unit(String name, int maxHitPoints, int armor, int maxDamage, int minDamage, int evasion, int accuracy) {
		this.name = name;

		this.maxHitPoints = maxHitPoints;
		this.currentHitPoints = maxHitPoints;
		this.armor = armor;
		this.maxDamage = maxDamage;
		this.minDamage = minDamage;
		this.evasion = evasion;
		this.accuracy = accuracy;
		this.description = name + " has " + maxHitPoints + "HP and is pissed off.";
	}

	// abstract methods shared between all UNITS

	abstract int attack();

	abstract void heal();

	abstract boolean isAlive();

	abstract void surrender();

	abstract String getStatus(); // return currentHitpoints

	public final Random random = new Random();

	// end abstract methods shared between all UNITS

	void defend(Unit unit, String attackType) {
		if (attackType.equals("a")) {
			int attackStrengthNormal = unit.attack();
			int chanceToEvade=((evasion*99)/(evasion+200)+1)-((unit.accuracy*99)/(unit.accuracy+200)+1)/10;
			int rand=(int) (Math.random()*100);
			if (rand<=chanceToEvade) {
				System.out.println(unit.getName() + " missed.");
			} else {
				int remainingHitPoints = (getCurrentHitPoints() > attackStrengthNormal) ? getCurrentHitPoints()
						- (attackStrengthNormal - attackStrengthNormal * getDmgReduction() / 100) : 0;

				setCurrentHitPoints(remainingHitPoints);
				System.out.printf(getName() + " is hit for " + attackStrengthNormal + " HP " + getStatus() + "\n");
				;
			}

		} else if (attackType == "s") {
			HeroSkills heroSkills = new HeroSkills();
			int attackStrengthSkill = heroSkills.fury(getMaxDamage());
			int remainingHitPoints = (getCurrentHitPoints() > attackStrengthSkill)
					? (getCurrentHitPoints()) - attackStrengthSkill : 0;

			setCurrentHitPoints(remainingHitPoints);
			System.out.printf(" " + getName() + " is hit for %d HP (%s)\n", attackStrengthSkill, getStatus());
		}
		if(unit instanceof Monster){
			GUI.getLabel().setText(String.valueOf(currentHitPoints));
			
		}
	}

	int getDmgReduction() {
		int dmgRed = (armor * 99) / (armor + 200) + 1;
		return dmgRed;
	}
	// getters

	public String getName() {
		return name;
	}

	public int getAccuracy() {
		return accuracy;
	}

	public String getDescription() {
		return description;
	}

	public int getGold() {
		return gold;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
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

	public void setName(String name) {
		this.name = name;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setMaxHitPoints(int maxHitPoints) {
		this.maxHitPoints = maxHitPoints;
	}

	public void setCurrentHitPoints(int currentHitPoints) {
		this.currentHitPoints = currentHitPoints;
	}

	public void setArmor(int armor) {
		this.armor = armor;
	}

	public void setGold(int gold) {
		this.gold = gold;
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

	public void setMana(int mana) {
		this.mana = mana;
	}

	public void setAccuracy(int accuracy) {
		this.accuracy = accuracy;
	}

}
