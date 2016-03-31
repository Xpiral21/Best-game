
package run;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Map {
	private Room map[][] = new Room[10][10];
	private int mapSize;

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
        if (x>mapSize||y>mapSize) {
            return false;
        }else
        return true;
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
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String direction = in.readLine();
        if (direction.equals("n") && northPossible) {
        	player.charLocation[1]++;
        } else if (direction.equals("s") && southPossible) {
        	player.charLocation[1]--;
        } else if (direction.equals("e") && eastPossible) {
        	player.charLocation[0]++;
        } else if (direction.equals("w") && westPossible) {
        	player.charLocation[0]--;
        }}
	public void NewMap(int n) {
		Monster m = new Monster("Le", 5, 10, 30, 30, 30, 10);
		Trader t = new Trader();
		for (int i = 0; i < n; i++)
			for (int j = 0; j < n; j++) {

				random = (int) (Math.random() * 100);
				if (random > 70) {
					map[i][j] = new MonsterRoom(m);
				} else if (random > 63) {
					map[i][j] = new CityRoom(t);
				} else {
					map[i][j] = new EmptyRoom();
				}
			}
	}
	
       
    
	public Room getRoom(int x, int y) {
		return map[x][y];
	}

}