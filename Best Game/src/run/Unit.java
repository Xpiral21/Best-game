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
	private int accuracy;

	public Unit(String name,  int maxHitPoints, int currentHitPoints, int armor, int maxDamage,
			int minDamage, int evasion, int accuracy) {
		this.name = name;
		
		this.maxHitPoints = maxHitPoints;
		this.currentHitPoints = currentHitPoints;
		this.armor = armor;
		this.maxDamage = maxDamage;
		this.minDamage = minDamage;
		this.evasion = evasion;
		this.accuracy = accuracy;
		this.description = name+" has "+currentHitPoints+" out of "+maxHitPoints+" and does between "+minDamage+"-"+maxDamage+" DMG";
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

			if (getEvasion() * (1 + (int) (Math.random() * ((10 - 1) + 1))) > unit.getAccuracy()
					* (1 + (int) (Math.random() * ((10 - 1) + 1)))) {
				System.out.println(unit.getName() + " missed you");
			} else {
				int remainingHitPoints = (getCurrentHitPoints() > attackStrengthNormal) ? getCurrentHitPoints()
						- (attackStrengthNormal - attackStrengthNormal * getDmgReduction() / 100) : 0;

				setCurrentHitPoints(remainingHitPoints);
				System.out.printf(" " + getName() + " is hit for %d HP of damage-%d armor (%s)\n", attackStrengthNormal,
						getArmor(), getStatus());
			}

		} else if (attackType == "fury") {
			HeroSkills heroSkills = new HeroSkills();
			int attackStrengthSkill = heroSkills.fury(getMaxDamage());
			int remainingHitPoints = (getCurrentHitPoints() > attackStrengthSkill)
					? (getCurrentHitPoints() + getArmor()) - attackStrengthSkill : 0;

			setCurrentHitPoints(remainingHitPoints);
			System.out.printf(" " + getName() + " is hit for %d HP of damage-%d armor (%s)\n", attackStrengthSkill,
					getArmor(), getStatus());
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
