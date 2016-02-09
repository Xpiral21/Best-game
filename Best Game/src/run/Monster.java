package run;

public class Monster extends Unit {

	Skills monsterSkills;

	public Monster(String name, int maxHitPoints, int armor, int maxDamage, int minDamage,
			int evasion, int accuracy) {
		super(name, maxHitPoints, armor, maxDamage, minDamage, evasion, accuracy);
		monsterSkills = new MonsterSkills();

	}

	@Override
	int attack() {
		return random.nextInt(getMaxDamage() - getMinDamage() + 1) + getMinDamage();
	}

	/*
	 * @Override void heal() { if (numPotions > 0) {
	 * setCurrentHitPoints(getCurrentHitPoints() + 20);
	 * System.out.println(getName() + "was healed"); numPotions--; } else {
	 * System.out.println("You don't have any potions"); } }
	 */

	@Override
	boolean isAlive() {
		return getCurrentHitPoints() > 0;
	}

	@Override
	void surrender() {
		// TODO Auto-generated method stub

	}

	@Override
	String getStatus() {
		return "Current HP is " + getCurrentHitPoints();
	}

	@Override
	void heal() {
		// TODO Auto-generated method stub

	}

}