package run;

public class Monster extends Unit {
	public Monster(int hp, int maxDamage, int minDamage, int defense, int mana, String name){
		super(hp, maxDamage, minDamage,defense,mana, name);
		setDescription("The "+getName()+" does between "+getMinDamage()+"-"+getMaxDamage()+" and has "+getHp()+" HP");
	}

}
