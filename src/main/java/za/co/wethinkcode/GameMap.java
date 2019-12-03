
package za.co.wethinkcode;

//import za.co.wethinkcode.MoveHero;

public class GameMap {
	public int[][] map;
	public int x, y;
	public int heroY, heroX;

	public 	void 	 getHeroPos(){
		for (int i = 0;i < this.y ;i++){
			for (int j = 0; j < this.x;j++) {
				if (map[i][j] == 'h') {
					heroX = j;
					heroY = i;
					return ;
				}
			}
		}
	}

	public    GameMap(final int heroLevel) {
		this.y = (heroLevel - 1) * 5 + 10 - (heroLevel % 2);
		this.x = this.y;
		this.map = new int[this.y][this.x];
		populateMap(this.y, this.x);
		int pos = getMapMid();
		heroY = pos;
		heroX = pos;
		this.map[pos][pos] = 'h';
		displayMap();
	}
	
	public boolean checkEdge() {
		if (heroX == 0 || heroY == 0 || heroX == map.length - 1 || heroY == map[heroX].length - 1)
			return true;
		return false;
	}

	private void    populateMap( final int y, final int x ) {
		for (int i = 0; i < y;i++){
			for (int j = 0; j < x; j++){
				map[i][j] = '*';
			}
		}
	}

	public void     displayMap(){
		for (int i = 0; i < y;i++){
			for (int j = 0; j < x; j++){
				System.out.printf("%c",map[i][j]);
			}
			System.out.print("\n");
		}
	}

	public int getMapMid() {
		if (this.x % 2 == 0)
			return  (this.x / 2);
		return (this.x / 2 + 1);
	}
}
