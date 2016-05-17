package run;

import java.io.IOException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// SimplePlayer music = new SimplePlayer();
		Map m = new Map(10);
		Scanner sc = new Scanner(System.in);
		System.out.print("Give your character a name : ");
		Hero hero = new Hero(sc.nextLine(), 800, 50, 7000, 20, 10, 10);
		System.out.println("Character created.");
		while (hero.getCurrentHitPoints() > 0) {
			System.out
					.println("You are at :  X " + hero.getVerticalLocation() + "  Y  " + hero.getHorizontalLocation());
			try {
				m.movePlayer(hero);
				if (m.getRoom(hero.getVerticalLocation(), hero.getHorizontalLocation()) instanceof MonsterRoom) {
					MonsterRoom temp = (MonsterRoom) (m.getRoom(hero.getVerticalLocation(),
							hero.getHorizontalLocation()));
					if (temp.getMonster().isAlive() == false) {
						System.out.println("Monster is dead.");

					} else {
						Battle b = new Battle(hero, temp.getMonster());
					}
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		System.out.println("caca maca");
		System.out.println("YOU LOST!");
	}
}

/*
 * if (m.getRoom(hero.charLocation[0], hero.charLocation[1]) instanceof
 * MonsterRoom) { MonsterRoom temp = (MonsterRoom)
 * (m.getRoom(hero.charLocation[0], hero.charLocation[1])); try { Battle
 * oneBattle = new Battle(hero, temp.getMonster()); } catch (IOException ex) {
 * Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex); } } } //
 * try {
 */ // // Save gigi=new Save(hero);
	// // Load l = new Load(hero);
	// //while(hero.isAlive()){
	//
	// //}
	// } catch (IOException ex) {
	// Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
	// }
