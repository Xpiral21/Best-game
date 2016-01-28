package run;
import java.util.ArrayList;
import java.util.List;

public class Hero extends Unit {

	Skills heroSkills;
	private int numPotions = 2;
	private List<String> inventory = new ArrayList<String>();

	public int getNumPotions() {
		return numPotions;
	}

	public void setNumPotions(int numPotions) {
		this.numPotions = numPotions;
	}

	public Hero(String name, String description, int maxHitPoints, int currentHitPoints, int armor, int maxDamage,
			int minDamage, int evasion) {
		super(name, description, maxHitPoints, currentHitPoints, armor, maxDamage, minDamage, evasion);
		heroSkills = new HeroSkills();
	}

	@Override
	int attack() {
		return random.nextInt(getMaxDamage() - getMinDamage() + 1) + getMinDamage();
	}


	int useSkill(String skillName) {

		int skillDamage = heroSkills.fury(getMaxDamage());
		return skillDamage;
	}

	@Override
	void defend(Object monster, String attackType) {
		if (attackType == "a") {
			int attackStrengthNormal = ((Monster) monster).attack();

			int remainingHitPoints = (getCurrentHitPoints() > attackStrengthNormal)
					? (getCurrentHitPoints() + getArmor()) - attackStrengthNormal : 0;

			setCurrentHitPoints(remainingHitPoints);
			System.out.printf(" " + getName() + " is hit for %d HP of damage-%d armor (%s)\n", attackStrengthNormal,
					getArmor(), getStatus());
			
		} else if (attackType=="fury"){
			int attackStrengthSkill = heroSkills.fury(getMaxDamage());
			int remainingHitPoints = (getCurrentHitPoints() > attackStrengthSkill)
					? (getCurrentHitPoints() + getArmor()) - attackStrengthSkill : 0;

			setCurrentHitPoints(remainingHitPoints);
			System.out.printf(" " + getName() + " is hit for %d HP of damage-%d armor (%s)\n", attackStrengthSkill,
					getArmor(), getStatus());
		}
	}

	@Override
	void heal() {
		if (numPotions > 0) {
			setCurrentHitPoints(getCurrentHitPoints() + 20);
			System.out.println(getName() + "was healed");
			numPotions--;
		} else {
			System.out.println("You don't have any potions");
		}
	}

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

}
