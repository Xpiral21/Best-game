package run;

import java.util.ArrayList;
import java.util.List;

public class Hero extends Unit {
	int prevLocation[] = { 4, 5 };
	int charLocation[] = { 5, 5 };
	Skills heroSkills;
	private int numPotions = 2;
	private List<String> inventory = new ArrayList<String>();

	public int getNumPotions() {
		return numPotions;
	}

	public int getVerticalLocation(){
		return charLocation[0];
	}
	public int getHorizontalLocation(){
		return charLocation[1];
	}
	public void moveHero(String direction) {
		prevLocation=charLocation;
		if (direction.compareTo("up") == 0) {
			charLocation[0]--;
		} else if (direction.compareTo("down") == 0) {
			charLocation[0]++;
		} else if (direction.compareTo("left") == 0) {
			charLocation[1]--;
		} else if (direction.compareTo("right") == 0) {
			charLocation[1]++;
		} else
			System.out.println("Nice Try.");
	}

	public void setNumPotions(int numPotions) {
		this.numPotions = numPotions;
	}

	public Hero(String name, int maxHitPoints, int armor, int maxDamage, int minDamage, int evasion, int accuracy) {
		super(name, maxHitPoints, armor, maxDamage, minDamage, evasion, accuracy);
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
	}

	@Override
	String getStatus() {
		return "Your HP is " + getCurrentHitPoints();
	}
	public void equipArmour(Armour armour){
		setMaxHitPoints(getMaxHitPoints()+armour.getMaxHitPoints());
		setArmor(getArmor()+armour.getArmor());
		setAccuracy(getAccuracy()+armour.getAccuracy());
		setEvasion(getEvasion()+armour.getEvasion());
	}

}
