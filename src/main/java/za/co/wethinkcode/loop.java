import java.util.Scanner;
import Status;
public class loop {
       Status gameStatus;
       gameStatus = Status.PLAYING;
	   String  move = null;
	   Scanner sc = new Scanner(System.in);
       while (gameStatus == Status.PLAYING) {
		Object mGameMap;
		if (sc.hasNext())
		{
			move =  sc.nextLine();
			if (move.equals("up"))
				MoveHero.moveUp(mGameMap.heroY,mGameMap.heroX, mGameMap);
			else if (move.equals("down"))
				MoveHero.moveDown(mGameMap.heroY,mGameMap.heroX, mGameMap);
			else if (move.equals("left"))
				MoveHero.left(mGameMap.heroY,mGameMap.heroX, mGameMap);
			else if (move.equals("right"))
				MoveHero.right(mGameMap.heroY,mGameMap.heroX, mGameMap);
		}
           mGameMap.displayMap();
       }
       System.out.println("\n");
     sc.close();
	}

}

