package run;

public class Main {

	public static void main(String[] args) {
		// SimplePlayer music = new SimplePlayer();
		Map m = new Map(10);
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				System.out.print(m.getRoom(i, j) + " ");
			}
			System.out.println();
		}
		System.out.println(m.getRoom(2, 3).getRoomDescription());
		Unit jedy = new Monster("Loki", 800, 800, 50, 75, 20, 10, 10);
		System.out.println(jedy.getArmor());
		System.out.println(jedy.getDmgReduction());
		jedy.attack();
		
	}
}
