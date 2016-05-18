package run;

public class Armour extends Item {
	private String name;

	private int maxHitPoints;
	private int armor;
	private int evasion;
	private int accuracy;

	public Armour() {
		int rand = (int) (Math.random() * 100)+66;
		if (rand >= 0) {
			this.armor = (int) (Math.random() * 20);
			this.name = "Armour";
		} if (rand >= 25) {
			this.maxHitPoints = (int) (Math.random() * 20);
			this.name = "Thick " + this.name;
		}  if (rand >= 50) {
			this.evasion = (int) (Math.random() * 20);
			this.name = this.name + " of Quickness";
		} if(rand>75){
			this.accuracy = (int) (Math.random() * 20);
			this.name = "Accurate " + this.name;
		}
	}

	@Override
	public String toString() {
		String str = name + System.lineSeparator();
		if (maxHitPoints > 0) {
			str = str+"LIFE : " + maxHitPoints + System.lineSeparator();
		}
		if (armor > 0) {
			str = str+"ARMOR : " + armor + System.lineSeparator();
		}
		if (evasion > 0) {
			str = str+"EVASION : " + evasion + System.lineSeparator();
		}
		if (accuracy > 0) {
			str = str+"ACCURACY : " + accuracy + System.lineSeparator();
		}

		return str;
	}

	public String getName() {
		return name;
	}

	public int getMaxHitPoints() {
		return maxHitPoints;
	}

	public int getArmor() {
		return armor;
	}

	public int getEvasion() {
		return evasion;
	}

	public int getAccuracy() {
		return accuracy;
	}
	
}
