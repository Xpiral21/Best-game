package run;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Map {

    private Room [][] map=new Room[10][10];
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
        return x < mapSize && y < mapSize;
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
        Monster monster1 = new Monster("Loki", 800, 50, 75, 20, 10, 10);
        Monster monster2 = new Monster("Loki 2", 800, 50, 75, 20, 10, 10);
        ArrayList <Monster> allMonsters=new ArrayList<>();
        allMonsters.add(monster1);
        allMonsters.add(monster2);
        Trader t = new Trader();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {

                random = (int) (Math.random() * 100);
                if (random > 70) {
                    map[i][j] = new MonsterRoom(allMonsters);
                } else if (random > 5) {
                    map[i][j] = new CityRoom(t);
                } else {
                    map[i][j] = new EmptyRoom();
                }
            }
        }
    }

    public Room getRoom(int x, int y) {
        return map[x][y];
    }

}
