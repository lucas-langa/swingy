//import java.util.Scanner;
//
//public class loop {
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//
//        GameMap mGameMap = new GameMap(1);
//        // int pos = mGameMap.getMapMid();
//        Status gameStatus;
//        gameStatus = Status.PLAYING;
//        String  move = null;
//        while (gameStatus == Status.PLAYING) {
//            if (sc.hasNext())
//            {
//                move =  sc.nextLine();
//                if (move.equals("up"))
//                    MoveHero.moveUp(mGameMap.heroY,mGameMap.heroX, mGameMap);
//                else if (move.equals("down"))
//                    MoveHero.moveDown(mGameMap.heroY,mGameMap.heroX, mGameMap);
//                else if (move.equals("left"))
//                    MoveHero.left(mGameMap.heroY,mGameMap.heroX, mGameMap);
//                else if (move.equals("right"))
//                    MoveHero.right(mGameMap.heroY,mGameMap.heroX, mGameMap);
//            }
//            mGameMap.displayMap();
//        }
//        System.out.println("\n");
//      sc.close();
//	}
//
//}
//
