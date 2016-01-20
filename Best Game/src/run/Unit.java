package run;

public class Unit {
	protected double hp;
	protected double maxDamage;
	protected double minDamage;
	protected double defense;
	protected double mana;
	protected String name;
	protected String description;

	public Unit(double hp, double maxDamage, double minDamage, double defense, double mana, String name) {
		this.hp = hp;
		this.maxDamage = maxDamage;
		this.minDamage = minDamage;
		this.defense = defense;
		this.mana = mana;
		this.name = name;
		
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}


	public double getHp() {
		return hp;
	}

	public void setHp(double hp) {
		this.hp = hp;
	}

	public double getMaxDamage() {
		return maxDamage;
	}

	public void setMaxDamage(double maxDamage) {
		this.maxDamage = maxDamage;
	}

	public double getMinDamage() {
		return minDamage;
	}

	public void setMinDamage(double minDamage) {
		this.minDamage = minDamage;
	}

	public double getDefense() {
		return defense;
	}

	public void setDefense(double defense) {
		this.defense = defense;
	}

	public double getMana() {
		return mana;
	}

	public void setMana(double mana) {
		this.mana = mana;
	}

	protected double giveDmg() {
		double randomDmg = minDamage + (Math.random() * ((maxDamage - minDamage) + 0.1));
		return randomDmg;
	}

}
