
package run;

public class Monster extends Unit {
	public Monster(int hp, int maxDamage, int minDamage, int defense, int mana, String name) {
		super(hp, maxDamage, minDamage, defense, mana, name);
		setDescription("The " + name + " does between " + minDamage + "-" + maxDamage + " and has " + hp + " HP");
	}

	public Monster randomMonster() {
		final int life = (int) (Math.random() * 100) + 100;
		final int maxDamage = (int) (Math.random() * 10) + 10;
		final int minDamage = (int) (Math.random() * 5) + 5;
		final int defense = (int) (Math.random() * 3) + 5;
		final int mana = 100;
		final String name = "Test";
		return new Monster(life, minDamage, maxDamage, defense, mana, name);
	}

}
