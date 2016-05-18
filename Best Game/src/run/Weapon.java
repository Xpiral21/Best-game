package run;

public class Weapon extends Item{
	
		private String name;
		private int maxDamage;
		private int minDamage;
		private int accuracy;

		public Weapon() {
			int rand = (int) (Math.random() * 100);
			if (rand >= 0) {
				name= "Bad Sword";
				maxDamage = (int) (Math.random() * 16)+6;
			} if (rand >= 33) {
				name= name+" of Low Damage";
				minDamage = (int) (Math.random() * 5)+6;
			}  if (rand >= 66) {
				name="Accurate "+name;
				accuracy= (int) (Math.random() * 16)+6;
			} 
		}

		@Override
		public String toString() {
			String str = name + System.lineSeparator();

			if (minDamage > 0) {
				str = str+"MAXIMUM DAMAGE : " + maxDamage + System.lineSeparator();
			}
			if (maxDamage > 0) {
				str = str+"MIN DAMAGE : " + minDamage + System.lineSeparator();
			}
			if (accuracy > 0) {
				str = str+"ACCURACY : " + accuracy + System.lineSeparator();
			}

			return str;
		}
	

}
