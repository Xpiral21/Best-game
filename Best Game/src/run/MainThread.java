package run;

import java.io.IOException;

public class MainThread extends Thread {
	public void run() {
		System.out.print("Enter your name:");
		try {
			synchronized (Main.gigi) {
				Main.gigi.wait();
			}

		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block

		}
		Hero hero = new Hero(GUI.getStdin(), 2500, 0, 20000, 100, 10, 10);
		System.out.println(" " + hero.getName());
		//SimplePlayer music = new SimplePlayer();
		Map m = new Map(10);
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
				if (m.getRoom(hero.getVerticalLocation(), hero.getHorizontalLocation()) instanceof BossRoom) {
					BossRoom temp = (BossRoom) (m.getRoom(hero.getVerticalLocation(), hero.getHorizontalLocation()));
					Battle b = new Battle(hero, temp.getMonster());
					System.out.println("Current Gold : " + hero.getGold());
					System.out.println(temp.getMonster().getName() + " is dead,you delve deeper into the dungeon.");
					m = new Map(10);
					hero.setCurrentHitPoints(hero.getMaxHitPoints());
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

}
