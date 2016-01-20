package run;

public class Unit {
	private double hp;
	private double maxDamage;
	private double minDamage;
	private double defense;
	private double mana;
	private String name;
	private String description;

	public Unit(double hp, double maxDamage, double minDamage, double defense, double mana, String name,
			String description) {
		this.hp = hp;
		this.maxDamage = maxDamage;
		this.minDamage = minDamage;
		this.defense = defense;
		this.mana = mana;
		this.name = name;
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

	public void setDescription(String description) {
		this.description = description;
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

	public double getDefence() {
		return defense;
	}

	public void setDefence(double defence) {
		this.defense = defence;
	}

	public double getMana() {
		return mana;
	}

	public void setMana(double mana) {
		this.mana = mana;
	}

}
