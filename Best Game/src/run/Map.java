
package run;

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

	public void NewMap(int n) {

		for (int i = 0; i < n; i++)
			for (int j = 0; j < n; j++) {
				

				random = (int) (Math.random() * 100);
				if (random > 95) {
					map[i][j] = new Room("Trader", chichi);
				} else if (random > 25) {
					map[i][j] = new Room("Spooky Monster",);
				} else if (random <= 25) {
					map[i][j] = new Room();
				}
			}
	}

	public Room getRoom(int x, int y) {
		return map[x][y];
	}

}