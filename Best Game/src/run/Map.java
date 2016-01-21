package run;

public class Map {
	private int map[][] = new int[10][10];
	private int mapSize;

	Map(int n) {
		NewMap(n);
		mapSize = n;
	}

	public void NewMap(int n) {
		int random;
		for (int i = 0; i < n; i++)
			for (int j = 0; j < n; j++) {
				random = (int) (Math.random() * 100) + 1;
				if (random > 97)
					map[i][j] = 4;
				else if (random > 94)
					map[i][j] = 3;
				else if (random > 75)
					map[i][j] = 2;
			}
		map[n / 2][n / 2] = 1;
	}

	public void clearSpace(int x, int y) {
		map[x][y] = 0;
	}

	public void addEnemy(int x, int y) {
		map[x][y] = 2;
	}

	public void addChest(int x, int y) {
		map[x][y] = 3;
	}

	public void addTown(int x, int y) {
		map[x][y] = 4;
	}

	public void showMap() {
		for (int i = 0; i < mapSize; i++) {
			for (int j = 0; j < mapSize; j++)
				System.out.print(map[i][j] + " ");
			System.out.println();
		}
	}
}
