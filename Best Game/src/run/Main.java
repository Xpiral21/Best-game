package run;

import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		Hero hero = new Hero("Hero", 800, 0, 0, 0, 0, 0);
		Item i1 = new Item();
		Item i2 = new Item();
		Item i3 = new Item();
		Item i4 = new Item();
		Item i5 = new Item();

		hero.inventory.addItem(i1);
		hero.inventory.addItem(i2);
		hero.inventory.addItem(i3);
		hero.inventory.addItem(i4);
		hero.inventory.addItem(i5);

		System.out.println(i1.getName());
		System.out.println(i2.getName());
		System.out.println(i3.getName());
		System.out.println(i4.getName());
		System.out.println(i5.getName());

	
		for (int i = 0; i < hero.inventory.getSize(); i++) {
			System.out.println(hero.inventory.getItem(i).getName());
			System.out.println();
			hero.equipItem(hero.inventory.getItem(i));
		}

		System.out.println("After equipping " + hero);
		System.out.println();

		System.out.println(hero.inventory);
		System.out.println(hero.equippedItems);

		// SimplePlayer music = new SimplePlayer();
		// Map m = new Map(10);
		// Scanner sc = new Scanner(System.in);
		// System.out.print("Give your character a name : ");
		// Hero hero = new Hero(sc.nextLine(), 800, 50, 7000, 20, 10, 10);
		// System.out.println("Character created.");
		// Armour a = new Armour();
		// System.out.println(a);
		// System.out.println(hero.getArmor());
		// hero.equipArmour(a);
		// System.out.println(hero.getArmor());
		/*
		 * while (hero.getCurrentHitPoints() > 0) { System.out .println(
		 * "You are at :  X " + hero.getVerticalLocation() + "  Y  " +
		 * hero.getHorizontalLocation()); try { m.movePlayer(hero); if
		 * (m.getRoom(hero.getVerticalLocation(), hero.getHorizontalLocation())
		 * instanceof MonsterRoom) { MonsterRoom temp = (MonsterRoom)
		 * (m.getRoom(hero.getVerticalLocation(),
		 * hero.getHorizontalLocation())); if (temp.getMonster().isAlive() ==
		 * false) { System.out.println("Monster is dead.");
		 * 
		 * } else { Battle b = new Battle(hero, temp.getMonster()); } } } catch
		 * (IOException e) { e.printStackTrace(); } }
		 */

		// System.out.println("YOU LOST!");
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
