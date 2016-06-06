package run;

import java.awt.EventQueue;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Scanner;

public class Main {
	static Thread t;

	public static void main(String[] args) {

		try {
			EventQueue.invokeAndWait(new Runnable() {
				public void run() {
					try {
						GUI window = new GUI();
						window.setVisible(true);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			});
		} catch (InvocationTargetException | InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		t = Thread.currentThread ( );

		System.out.println("Enter your name:");
		try {
			synchronized (t) {
				t.wait();
			}
			
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			
		}
		Hero hero = new Hero(GUI.getStdin(), 1000, 100, 200, 100, 100, 100);

		// SimplePlayer music = new SimplePlayer();
		Map m = new Map(10);

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
						System.out.println("Current Gold : " + hero.getGold());
					}
				}
				if (m.getRoom(hero.getVerticalLocation(), hero.getHorizontalLocation()) instanceof CityRoom) {
					Trader t = new Trader();
					System.out.println(t.inventory);
					System.out.println("Buy an item by typing it's number");
					int itemNumber = 5;
					if (hero.getGold() >= t.inventory.getItem(itemNumber).getValue()) {
						t.buyItem(itemNumber, hero);
						hero.equipItem(hero.inventory.getItem(hero.inventory.getSize() - 1));
						System.out.println(hero);
					} else
						System.out.println("Shooo peasant!");
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

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
