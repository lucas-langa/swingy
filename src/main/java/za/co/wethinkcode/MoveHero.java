package za.co.wethinkcode;

public class MoveHero {
       public static void moveUp(int currentY, int currentX, GameMap map) {
              map.getHeroPos();
              map.map[map.heroY][map.heroX] = '*';
              map.heroY -= 1;
              map.map[map.heroY][map.heroX] = 'h';
       }

       public static void moveDown(int currentY, int currentX, GameMap map) {
              map.getHeroPos();
              map.map[map.heroY][map.heroX] = '*';
              map.heroY += 1;
              map.map[map.heroY][map.heroX] = 'h';
       }

       public static void left(int currentY, int currentX, GameMap map) {
              map.getHeroPos();
              map.map[map.heroY][map.heroX] = '*';
              map.heroX -= 1;
              map.map[map.heroY][map.heroX] = 'h';
       }

       public static void right(int currentY, int currentX, GameMap map) {
              map.getHeroPos();
              map.map[map.heroY][map.heroX] = '*';
              map.heroX += 1;
              map.map[map.heroY][map.heroX] = 'h';
       }
}