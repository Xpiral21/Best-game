package run;

public class Monster extends Unit {

	Skills monsterSkills;

	public Monster(String name, int maxHitPoints, int armor, int maxDamage, int minDamage, int evasion, int accuracy,
			int level) {
		super(name, maxHitPoints, armor, maxDamage, minDamage, evasion, accuracy);
		monsterSkills = new MonsterSkills();
		this.setLevel(level);
		this.setMaxHitPoints((int) (this.getMaxHitPoints() * (1+ (0.1*level))));
		this.setCurrentHitPoints((int) (this.getCurrentHitPoints() * (1+ (0.1*level))));
		this.setMaxDamage((int) (this.getMaxDamage() * (1+ (0.1*level))));
		this.setMinDamage((int) (this.getMinDamage() * (1+ (0.1*level))));
		this.setEvasion((int) (this.getEvasion() * (1+ (0.1*level))));
		this.setArmor((int) (this.getArmor() * (1+ (0.1*level))));

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
	}

	@Override
	String getStatus() {
		return this.getName() + "s HP is " + getCurrentHitPoints();
	}

	@Override
	void heal() {
	}

}