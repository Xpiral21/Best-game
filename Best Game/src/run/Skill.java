package run;

public class Skill {
	private int minDamage;
	private int maxDamage;
	private int manaCost;
	private String name;
	private String description;

	public Skill(int minDamage, int maxDamage, int manaCost, String name) {
		description = "The skill " + name + " does betwwen " + minDamage + "-" + maxDamage + " and costs " + manaCost
				+ " Mana";
		this.minDamage = minDamage;
		this.manaCost = manaCost;
		this.maxDamage = maxDamage;
		this.name = name;
	}

	public int getMinDamage() {
		return minDamage;
	}

	public void setMinDamage(int minDamage) {
		this.minDamage = minDamage;
	}

	public int getMaxDamage() {
		return maxDamage;
	}

	public void setMaxDamage(int maxDamage) {
		this.maxDamage = maxDamage;
	}

	public int getManaCost() {
		return manaCost;
	}

	public void setManaCost(int manaCost) {
		this.manaCost = manaCost;
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

}
