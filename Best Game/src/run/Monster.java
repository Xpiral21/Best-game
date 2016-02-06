package run;

public class Monster extends Unit {

	Skills monsterSkills;

	public Monster(String name, String description, int maxHitPoints, int currentHitPoints, int armor, int maxDamage,
			int minDamage, int evasion,int accuracy) {
		super(name, description, maxHitPoints, currentHitPoints, armor, maxDamage, minDamage, evasion,accuracy);
		monsterSkills = new MonsterSkills();

	}

	@Override
	int attack() {
		return random.nextInt(getMaxDamage() - getMinDamage() + 1) + getMinDamage();
	}

	void defend(Hero hero, String attackType) {
		if (attackType.equals("a")) {
			int attackStrengthNormal = hero.attack();

			int remainingHitPoints = (getCurrentHitPoints() > attackStrengthNormal)
					? (getCurrentHitPoints() + getArmor()) - attackStrengthNormal : 0;

			setCurrentHitPoints(remainingHitPoints);
			System.out.printf(" " + getName() + " is hit for %d HP of damage-%d armor (%s)\n", attackStrengthNormal,
					getArmor(), getStatus());
		} else {
			int attackStrengthSkill = ((Hero) hero).useSkill(attackType);
			int remainingHitPoints = (getCurrentHitPoints() > attackStrengthSkill)
					? (getCurrentHitPoints() + getArmor()) - attackStrengthSkill : 0;

			setCurrentHitPoints(remainingHitPoints);
			System.out.printf(" " + getName() + " is hit for %d HP of damage-%d armor (%s)\n", attackStrengthSkill,
					getArmor(), getStatus());
		}
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
		return getName() + " " + getDescription() + " HP is " + getCurrentHitPoints();
	}

	@Override
	void heal() {
		// TODO Auto-generated method stub

	}

}