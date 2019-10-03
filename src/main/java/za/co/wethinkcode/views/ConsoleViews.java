package za.co.wethinkcode.views;

import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.InputMismatchException;

import za.co.wethinkcode.heroes.*;

public class ConsoleViews
{
	private String greetings;
	private String PlayerName;
	public static void main(String args[])
	{
		List<Hero> heroes = new ArrayList<Hero>();
		Hero lucas = HeroFactory.newHero("lucas", "flank");
		heroes.add(lucas);
		Hero kerane = HeroFactory.newHero("kerane", "damage");
		heroes.add(kerane);
		// // peasantStats(lucas);
		// listHeroes(heroes);
		// encounterText();
		selectHero(heroes);
	}

	public ConsoleViews(String name)
	{
		PlayerName = name;
	}

	public static void welcomeText( )
	{
		int action = -1;
		Scanner input= new Scanner(System.in);
	
		System.out.print("/*********************************************************/\n"+
						"/*        Welcome to a text based semi violent RPG       */\n"+
						"/*        To Start:                                      */\n"+
						"/*        1.Select an existing hero                      */\n"+
						"/*	  2.Create a New Hero                            */\n"+
						"/*********************************************************/\n");
		while (action != 1  && action != 2 )
		{
			if (input.hasNext())
			{
				action = input.nextInt();
				if (action != 1 || action != 2)
					continue;
				else
					break;
			}
		}
	}
	
	public static void encounterText()
	{
		int action = -1;
		Scanner input= new Scanner(System.in);
		System.out.printf("You've encountered an enemy\nWhat do you want to do?\n1.Fight\n2.Run Away\n");
		
		while (action != 1  && action != 2 )
		{
		
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

	public static void 	peasantStats(Hero Peasant)
	{
		System.out.println("Hero Name : " + Peasant.getHeroName());
		System.out.println("Hero class : " + Peasant.getHeroClass());
		System.out.println("Hero Level : "+ Peasant.getHeroLevel());
		System.out.println("Hero Attack : " + Peasant.getHeroAttack());
		System.out.println("Hero Defense : " + Peasant.getHeroDefense());
		System.out.println("Hero HP : " + Peasant.getHeroHitPoints());
		System.out.println("Hero Experience " + Peasant.getHeroExperience());
	}
	
	public static void selectHero(List<Hero> heroes)
	{
		int limit = heroes.size();
		int choice;
		choice = limit > 0 ? limit + 1 : 0;
		Scanner input = new Scanner(System.in);
		if (limit > 0){
			System.out.println("Here's a list of available heroes, choose by typing the corresponding number and press enter: \n");
			int i = 1;
			for (Hero players : heroes)
			{
				System.out.print(i++ + "\n");
				peasantStats(players);
			}
			while (choice > limit || choice == 0)
			{
				if (input.hasNext())
				{
					try {
						choice = input.nextInt();
					} catch (InputMismatchException e) {
						System.out.println("numbers only peasant");
						choice = 0;
						// throw new InputMismatchException();
					} 
				}		
			}
		}
	}
}
