package run;
import java.util.Random;

public class HeroSkills implements Skills {
	public final Random random = new Random();
	@Override
	public int fury(int initialAttack) {
		int megaMultiplyer =(int) (Math.random()*7);
			System.out.print("Mega multiplier X "+megaMultiplyer);
		double damageModifier = (10+random.nextInt(40))*megaMultiplyer;
		int newAttack=(int) (initialAttack*(damageModifier/100));
		System.out.println("  FURY makes you deal  "+damageModifier+"% of your total damage for a total of "+newAttack);
		return newAttack;
	}

}
