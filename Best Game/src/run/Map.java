package run;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Map {

	private Room[][] map = new Room[10][10];
	private final int mapSize;

	public int getMapSize() {
		return mapSize;
	}

	Trader chichi = new Trader();

	Map(int n) {
		NewMap(n);
		mapSize = n;
	}

	private int random;

	private boolean roomExists(int x, int y) {
		return x < mapSize && y < mapSize||x<0||y<0;
	}

	public void movePlayer(Hero player) throws IOException {
		boolean northPossible = roomExists(player.charLocation[0], player.charLocation[1] + 1);
		boolean southPossible = roomExists(player.charLocation[0], player.charLocation[1] - 1);
		boolean eastPossible = roomExists(player.charLocation[0] + 1, player.charLocation[1]);
		boolean westPossible = roomExists(player.charLocation[0] - 1, player.charLocation[1]);
		System.out.print("Where would you like to go :");
		if (northPossible) {
			System.out.print(" North (n)");
		}
		if (eastPossible) {
			System.out.print(" East (e)");
		}
		if (southPossible) {
			System.out.print(" South (s)");
		}
		if (westPossible) {
			System.out.print(" West (w)");
		}
		System.out.print(" ? ");

		try {
			synchronized (Main.gigi) {
				Main.gigi.wait();
			}

		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block

		}

		String direction = GUI.getStdin();
		if (direction.equals("n") && northPossible) {
			player.charLocation[1]++;
		} else if (direction.equals("s") && southPossible) {
			player.charLocation[1]--;
		} else if (direction.equals("e") && eastPossible) {
			player.charLocation[0]++;
		} else if (direction.equals("w") && westPossible) {
			player.charLocation[0]--;
		}
	}

	public void NewMap(int n) {
		ArrayList<Monster> allMonsters = new ArrayList<>();
		ArrayList<Monster> allBosses = new ArrayList<>();
		Monster monster1 = new Monster("Golem", 800, 0, 75, 20, 10, 10);
		Monster monster2 = new Monster("Gnoll", 800, 0, 75, 20, 10, 10);
		Monster monster3 = new Monster("Duck", 400, 0, 150, 50, 20, 10);
		Monster monster4 = new Monster("Rocky", 400, 25, 200, 120, 0, 5);
		Monster monster5 = new Monster("Magical Horse", 250, 0, 230, 100, 50, 10);
		Monster monster6 = new Monster("Duckling", 300, 0, 190, 100, 0, 10);
		Monster monster7 = new Monster("Gnoll", 900, 3, 210, 120, 0, 10);
		Monster monster8 = new Monster("Thief", 300, 5, 120, 80, 20, 10);
		Monster monster9 = new Monster("Angry peasant", 200, 0, 90, 30, 2, 5);
		Monster monster10 = new Monster("Zombie", 800, 5, 280, 90, 0, 5);
		Monster monster11 = new Monster("Cat", 300, 0, 190, 30, 20, 20);
		Monster monster12 = new Monster("Leprechaun", 600, 0, 130, 90, 0, 12);
		Monster monster13 = new Monster("Viking", 500, 10, 200, 100, 0, 15);
		Monster monster14 = new Monster("Wondering Granny", 1000, 0, 390, 30, 0, 5);
		Monster monster15 = new Monster("Turtle", 700, 2, 190, 100, 0, 10);
		Monster monster16 = new Monster("Gargoyle", 900, 10, 230, 140, 0, 10);
		Monster monster17 = new Monster("Tiger", 500, 0, 230, 140, 10, 20);
		Monster monster18 = new Monster("Stone Golem", 900, 10, 170, 100, 0, 10);
		Monster monster19 = new Monster("Yhuri", 700, 2, 185, 115, 0, 10);
		Monster monster20 = new Monster("Ortiss", 560, 0, 200, 120, 0, 10);
		Monster monster21 = new Monster("Mergos", 700, 0, 200, 140, 0, 10);
		Monster monster22 = new Monster("Gnik", 695, 0, 190, 90, 0, 10);
		Monster monster23 = new Monster("Demos", 560, 0, 200, 100, 0, 10);
		Monster boss1 = new Monster("Brutus", 1200, 0, 200, 100, 0, 10);
		Monster boss2 = new Monster("Crimson", 1500, 5, 230, 120, 0, 10);
		Monster boss3 = new Monster("Dervish", 1000, 15, 180, 90, 0, 10);
		Monster boss4 = new Monster("Eldrich", 2000, 0, 200, 100, 5, 10);
		Monster boss5 = new Monster("Ragnarok", 2300, 0, 250, 110, 10, 10);
		Monster boss6 = new Monster("Groot", 3200, 15, 330, 150, 0, 7);
		Monster boss7 = new Monster("Pharoh", 2500, 30, 290, 160, 0, 20);
		Monster boss8 = new Monster("Giant Turtle", 4000, 0, 150, 100, 0, 10);
		Monster boss9 = new Monster("Yhorm", 3200, 10, 230, 140, 0, 10);
		Monster boss10 = new Monster("High King", 2800, 5, 280, 200, 0, 20);

		allMonsters.add(monster1);
		allMonsters.add(monster2);
		allMonsters.add(monster3);
		allMonsters.add(monster4);
		allMonsters.add(monster5);
		allMonsters.add(monster6);
		allMonsters.add(monster7);
		allMonsters.add(monster8);
		allMonsters.add(monster9);
		allMonsters.add(monster10);
		allMonsters.add(monster11);
		allMonsters.add(monster12);
		allMonsters.add(monster13);
		allMonsters.add(monster14);
		allMonsters.add(monster15);
		allMonsters.add(monster16);
		allMonsters.add(monster17);
		allMonsters.add(monster18);
		allMonsters.add(monster19);
		allMonsters.add(monster20);
		allMonsters.add(monster21);
		allMonsters.add(monster22);
		allMonsters.add(monster23);

		allBosses.add(boss1);
		allBosses.add(boss2);
		allBosses.add(boss3);
		allBosses.add(boss4);
		allBosses.add(boss5);
		allBosses.add(boss6);
		allBosses.add(boss7);
		allBosses.add(boss8);
		allBosses.add(boss9);
		allBosses.add(boss10);

		Trader t = new Trader();
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {

				random = (int) (Math.random() * 100);
				if (random > 30) {
					map[i][j] = new EmptyRoom();
				} else if (random > 20) {
					map[i][j] = new CityRoom(t);
				} else if (random >= 0) {
					map[i][j] = new MonsterRoom(allMonsters);
				}
			}
		}
		int i = (int) (Math.random() * 9) + 1;
		int j = (int) (Math.random() * 9) + 1;
		map[i][j] = new BossRoom(allBosses);
		System.out.println("A terrible foe is at X " + i + " Y " + j);
	}

	public Room getRoom(int x, int y) {
		return map[x][y];
	}

}
