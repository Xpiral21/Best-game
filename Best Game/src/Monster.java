package src;

public class Monster extends Unit {
	public Monster(int hp, int maxDamage, int minDamage, int defense, int mana, String name) {
		super(hp, maxDamage, minDamage, defense, mana, name);
		setDescription("The " + name + " does between " + minDamage + "-" + maxDamage + " and has " + hp + " HP");
	}

}
