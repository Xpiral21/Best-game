package run;

public class Monster extends Unit {
	public Monster(){
		super(hp, maxDamage, minDamage,defense,mana, name);
		setDescription("The "+getName()+" does between "+getMinDamage()+"-"+getMaxDamage()+" and has "+getHp()+" HP");
	}

}
