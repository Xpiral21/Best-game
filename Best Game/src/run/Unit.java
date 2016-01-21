package run;

public class Unit {
	private int hp;
	private int maxDamage;
	private int minDamage;
	private int defense;
	private int mana;
	private String name;
	private String description;

	public Unit(int hp, int maxDamage, int minDamage, int defense, int mana, String name) {
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


	public int getHp() {
		return hp;
	}

	public void setHp(int hp) {
		this.hp = hp;
	}

	public int getMaxDamage() {
		return maxDamage;
	}

	public void setMaxDamage(int maxDamage) {
		this.maxDamage = maxDamage;
	}

	public int getMinDamage() {
		return minDamage;
	}

	public void setMinDamage(int minDamage) {
		this.minDamage = minDamage;
	}

	public int getDefense() {
		return defense;
	}

	public void setDefense(int defense) {
		this.defense = defense;
	}

	public int getMana() {
		return mana;
	}

	public void setMana(int mana) {
		this.mana = mana;
	}

	public int giveDmg() {
		int randomDmg = minDamage + (int)(Math.random() * ((maxDamage - minDamage) + 1));
		return randomDmg;
	}
	public int takeDmg(int h){
		return hp=hp-h;
	}

}
