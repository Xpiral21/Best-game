package run;
public class MonsterSkills implements Skills{

	@Override
	public int fury(int initialAttack) {
		int newAttack=initialAttack+random.nextInt(10);
		System.out.println("Using FURY");
		return newAttack;
	}

	
	
}
