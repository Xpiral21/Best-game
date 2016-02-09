
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
		Monster m= new Monster ("Le",5,10,30,30,30,10);
		Trader t= new Trader ();
		for (int i = 0; i < n; i++)
			for (int j = 0; j < n; j++) {
				

				random = (int) (Math.random() * 100);
				if (random > 50) {
					map[i][j] = new MonsterRoom(m);
				} else   {
					map[i][j] = new CityRoom(t);
				} 
			}
	}

	public Room getRoom(int x, int y) {
		return map[x][y];
	}

}