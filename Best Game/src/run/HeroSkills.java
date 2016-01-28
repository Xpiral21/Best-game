package run;
import java.util.Random;

public class HeroSkills implements Skills {
	public final Random random = new Random();
	@Override
	public int fury(int initialAttack) {
		
		int newAttack=initialAttack+random.nextInt(10);
		System.out.println("Using FURY");
		return newAttack;
	}

}
