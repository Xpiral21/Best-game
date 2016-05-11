package run;

import java.io.IOException;
import java.rmi.server.LoaderHandler;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {

	public static void main(String[] args) {
		// SimplePlayer music = new SimplePlayer();
		Map m = new Map(10);
		Scanner sc = new Scanner(System.in);
		// for (int i = 0; i < 9; i++) {
		// for (int j = 0; j < 9; j++) {
		// System.out.print(m.getRoom(i, j) + " ");
		// }
		// System.out.println();
		// }
		// System.out.println(m.getRoom(2, 3).getRoomDescription());

		// System.out.println(jedy.getArmor());
		// System.out.println(jedy.getDmgReduction());
		// jedy.defend(jedy2, "a");
		// System.out.println(jedy.getDescription());
		System.out.print("Give your character a name : ");

		Hero hero = new Hero(sc.nextLine(), 800, 50, 75, 20, 10, 10);
		//hero=Load.loadHero("r");

		System.out.println("Character created.");
		//System.out.println(hero.getDescription());
		if (m.getRoom(hero.charLocation[0], hero.charLocation[1]) instanceof MonsterRoom) {
			MonsterRoom temp = (MonsterRoom) (m.getRoom(hero.charLocation[0], hero.charLocation[1]));
			try {
				Battle oneBattle = new Battle(hero, temp.getMonster());
			} catch (IOException ex) {
				Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
			}
		}
	}
	// try {
	// // Save gigi=new Save(hero);
	// // Load l = new Load(hero);
	// //while(hero.isAlive()){
	//
	// //}
	// } catch (IOException ex) {
	// Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
	// }
}
