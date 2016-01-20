package run;

public class Monster extends Unit {
	public Monster(double hp, double maxDamage, double minDamage, double defense, double mana, String name){
		super(hp, maxDamage, minDamage,defense,mana, name);
		setDescription("The "+getName()+" does between "+getMinDamage()+"-"+getMaxDamage()+" and has "+getHp()+" HP");
	}

}
