
package run;

public class Map  {
	private Room map[][] = new Room[10][10];
	private int mapSize;

	public int getMapSize() {
		return mapSize;
	}

	Map(int n) {
		NewMap(n);
		mapSize = n;
	}

	public void NewMap(int n) {

		for (int i = 0; i < n; i++)
			for (int j = 0; j < n; j++) {
				map[i][j]=new Room ();}
	}




	public Room getRoom(int x,int y) {
		return map[x][y];
	}



}