package run;

import java.awt.EventQueue;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

public class MainThread extends Thread {
	private static Hero hero = new Hero("Crocoa", 2500, 0, 300, 100, 10, 10);
	MapGUI mapGUI;
	Map m;

	public void run() {
		System.out.print("Your name is :");
		try {
			synchronized (Main.gigi) {
				Main.gigi.wait();
			}

		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block

		}
		
		hero.setName(GUI.getStdin());
		hero.setGold(300);
		System.out.println( hero.getName());
		 SimplePlayer music = new SimplePlayer();
		int mapLevel = 1;
		m = new Map(9, mapLevel);
		try {
			EventQueue.invokeAndWait(new Runnable() {
				public void run() {
					try {
						mapGUI = new MapGUI(m, hero);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			});
		} catch (InvocationTargetException | InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		while (hero.getCurrentHitPoints() > 0) {
			mapGUI.update();
			mapGUI.repaint();

			//System.out
				//	.println("You are at :  X " + hero.getVerticalLocation() + "  Y  " + hero.getHorizontalLocation());
			try {
				m.movePlayer(hero);
				if (m.getRoom(hero.getVerticalLocation(), hero.getHorizontalLocation()) instanceof EmptyRoom){
					System.out.println("This room is empty as fuck.");
				}
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
				if (m.getRoom(hero.getVerticalLocation(), hero.getHorizontalLocation()) instanceof BossRoom) {
					BossRoom temp = (BossRoom) (m.getRoom(hero.getVerticalLocation(), hero.getHorizontalLocation()));
					Battle b = new Battle(hero, temp.getMonster());
					if (!temp.getMonster().isAlive()) {
						
						System.out.println("Current Gold : " + hero.getGold());
						System.out.println(temp.getMonster().getName() + " is dead,you delve deeper into the dungeon.");
						mapLevel++;
						m = new Map(9, mapLevel);
						mapGUI.hide();
						mapGUI = new MapGUI(m, hero);
						hero.setCurrentHitPoints(hero.getMaxHitPoints());
					}
				}
				if (m.getRoom(hero.getVerticalLocation(), hero.getHorizontalLocation()) instanceof CityRoom) {
					Trader t = new Trader();
					Trade trade = new Trade(hero, t);
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		// SQL.recordHighScore(hero.getName(), hero.getGold());
		System.out.println("YOU LOST!");
		// SQL.getHighScores();
	}

	public static Hero getHero() {
		return hero;
	}

}
