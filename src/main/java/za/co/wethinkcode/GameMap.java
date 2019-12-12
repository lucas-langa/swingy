package za.co.wethinkcode;

import java.util.Random;

public class GameMap {
	public int[][] map;
	public int x, y;
	public int heroY, heroX;
	private int size;

	/**
	 * @return the size
	 */
	public int getSize() {
		return size;
	}

	public void getHeroPos() {
		for (int i = 0; i < this.y; i++) {
			for (int j = 0; j < this.x; j++) {
				if (map[i][j] == 'h') {
					heroX = j;
					heroY = i;
					return;
				}
			}
		}
	}

	public static void placeVillains(GameMap Map) {
		int mapSize = Map.y;
		int nextBaddie;
		int baddieY;
		Random bb = new Random();
		for (int i = 0; i < mapSize; i++) {
			for (int j = 0; j < mapSize; j++) {
				nextBaddie = bb.nextInt(mapSize - 2);
				baddieY = bb.nextInt(mapSize - 2);
				if (Map.map[baddieY][nextBaddie] != 'h' && Map.map[baddieY][nextBaddie] != 'v') {
					Map.map[baddieY][nextBaddie] = 'v';
				}
			}
		}
	}

	private void populateMap(final int y, final int x) {
		for (int i = 0; i < y; i++) {
			for (int j = 0; j < x; j++) {
				map[i][j] = '*';
			}
		}
	}

	// String []choices = {"AntiHero", "DemonHero", "WarlockHero"};

	public GameMap(final int heroLevel) {
		size = (heroLevel - 1) * 5 + 10 - (heroLevel % 2);
		this.y = (heroLevel - 1) * 5 + 10 - (heroLevel % 2);
		this.x = this.y;
		this.map = new int[this.y][this.x];
		populateMap(this.y, this.x);
		int pos = getMapMid();
		heroY = pos;
		heroX = pos;
		this.map[pos][pos] = 'h';
		placeVillains(this);
		System.out.println("POS "+pos);
	}

	public boolean metVillain(char d) {
		boolean did = false;
		switch (d) {
		case 'e':
			if (this.map[heroY][heroX + 1] == 'v')
				did = true;
			break;
		case 'w':
			if (this.map[heroY][heroX - 1] == 'v')
				did = true;
			break;
		case 's':
			if (this.map[heroY + 1][heroX] == 'v')
				did = true;
			break;
		case 'n':
			if (this.map[heroY - 1][heroX] == 'v')
				did = true;
			break;
		default:
			break;
		}
		return did;
	}

	public boolean checkEdge() {
		if (heroX == 0 || heroY == 0 || heroX == map.length - 1 || heroY == map[heroX].length - 1)	
			return true;
		return false;
	}

	public void displayMap() {
		
		for (int i = 0; i < y; i++) {
			for (int j = 0; j < x; j++) {
				System.out.printf("%c", map[i][j]);
			}
			System.out.print("\n");
		}
	}

	public int getMapMid() {
		if (this.size % 2 == 0)
			return ((this.size / 2)-1);
		return (this.size / 2);
	}
}
