package za.co.wethinkcode.views;

import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;
import za.co.wethinkcode.heroes.*;

public class ConsoleViews
{
	private String greetings;
	private String PlayerName;
	

	public static void main(String args[])
	{
		// List<Hero> heroes = new ArrayList<Hero>();
		// Hero lucas = HeroFactory.newHero("lucas", "flank");
		// heroes.add(lucas);
		// // peasantStats(lucas);
		// listHeroes(heroes);
		encounterText();
	}

	public ConsoleViews(String name)
	{
		PlayerName = name;
	}

	public void welcomeText( )
	{
		int action = -1;
		Scanner input= new Scanner(System.in);
	
		while (action != 1  && action != 2 )
		{
			System.out.print("/*********************************************************/\n"+
						"/*        Welcome to a text based semi violent RPG       */\n"+
						"/*        To Start:                                      */\n"+
						"/*        1.Select an existing hero                      */\n"+
						"/*	  2.Create a New Hero                            */\n"+
						"/*********************************************************/\n");
		}
	}
	
	public static void encounterText()
	{
		int action = -1;
		Scanner input= new Scanner(System.in);
	
		while (action != 1  && action != 2 )
		{
			System.out.printf("You've encountered an enemy\nWhat do you want to do?\n1.Fight\n2.Run Away\n");
			// input.hasNext();
			action = input.nextInt();
		}
		input.close();
	}

	public void     displayMap(int[][] map, int size)
	{
		int y = size, x = size;
		for (int i = 0; i < y;i++){
			for (int j = 0; j < x; j++){
				System.out.printf("%c",map[i][j]);
			}
			System.out.print("\n");
		}
	}

	public void 	peasantStats(Hero Peasant)
	{
		System.out.println("Hero Name : " + Peasant.getHeroName());
		System.out.println("Hero class : " + Peasant.getHeroClass());
		System.out.println("Hero Level : "+ Peasant.getHeroLevel());
		System.out.println("Hero Attack : " + Peasant.getHeroAttack());
		System.out.println("Hero Defense : " + Peasant.getHeroDefense());
		System.out.println("Hero HP : " + Peasant.getHeroHitPoints());
		System.out.println("Hero Experience " + Peasant.getHeroExperience());
	}

	public void listHeroes(List<Hero> heroes)
	{
		for (Hero players : heroes)
		{
			peasantStats(players);
		}
	}
}
