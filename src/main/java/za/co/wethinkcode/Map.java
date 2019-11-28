
package za.co.wethinkcode;
//import za.co.wethinkcode.MoveHero;

public class Map {
	public int[][] map;
	private int x, y;
//	JFrame f;
	public static void main(String[] args) {

		Map map = new Map(1);

//		String optioN = JOptionPane.showInputDialog(null, "enter something");
		int i = 0;
		int pos = map.getMapMid();
		int x = pos;
		int y = pos;
		System.out.println(pos);
		map.map[pos][pos] = 'h';
		map.displayMap();


		System.out.println("\n");
		map.displayMap();

		System.out.printf("My hero goes here %d\n",map.getMapMid());
		
	}

//	public    Map(String typeS)
//	{
//
//	}

	public    Map(final int heroLevel){
		this.y = (heroLevel - 1) * 5 + 10 - (heroLevel % 2);
		this.x = this.y;
		map = new int[this.y][this.x];
		populateMap(this.y, this.x);
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
