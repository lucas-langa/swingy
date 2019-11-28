package za.co.wethinkcode.views;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;
// import javax.validation.constraints.NotNull;
// import javax.validation.constraints.Size;
// import java.io.IOException;
// import java.util.ArrayList;
import java.util.InputMismatchException;
import za.co.wethinkcode.heroes.*;
// import za.co.wethinkcode.model.Model;
import za.co.wethinkcode.MotherOfException;

public class ConsoleViews {
	// private String greetings;
	// private String PlayerName;

	// public static void main(String args[]) {
		// Model heroModel = new Model();
		// List<Hero> heroes = new ArrayList<Hero>();
		// Hero lucas = HeroFactory.newHero("lucas", "flank");
		// heroes.add(lucas);
		// Hero kerane = HeroFactory.newHero("kerane", "damage");
		// heroes.add(kerane);
		// selectHero(heroes);
		// peasantStats(lucas);
		// heroModel.getHeroesFromDB();
		// listHeroes(heroes);
		// encounterText();
		// try {
		// selectHero(heroes);
		// } catch(MotherOfException a){
		// System.out.println(a.getMessage());
		// }
		// // divisionExample();
		// newHeroClass();
		// newHeroName();
	// }

	public void listHeroes(List<Hero> heroes){
		for (Hero hero : heroes){
			peasantStats(hero);
		}
	}

	public  void welcomeText() {
		int action = -1;
		Scanner input = new Scanner(System.in);

		System.out.print("/*********************************************************/\n"
				+ "/*        Welcome to a text based semi violent RPG       */\n"
				+ "/*        To Start:                                      */\n"
				+ "/*        1.Select an existing hero                      */\n"
				+ "/*	  2.Create a New Hero                            */\n"
				+ "/*********************************************************/\n");
		while (action != 1 && action != 2) {
			if (input.hasNext()) {
				action = input.nextInt();
				if (action != 1 || action != 2)
					continue;
				else
					break;
			}
		}
	}
	
	private static void 	clearScreen()
	{
		System.out.print("\033[H\033[2J");  
		System.out.flush();  
	}

	public static void 	newHeroClass(){
		System.out.println("/*********************************************************/\n"+
							"/*	Choose a hero Class:                             */\n"+
							"/*	1.Flank                                          */\n"+
							"/*	2.Damage                                         */\n"+
							"/*	3.Tank                                           */\n"+
							"/*********************************************************/\n");
	}

	public static void 	newHeroName(){
	
		
		String name;
		Scanner input = new Scanner(System.in);
		System.out.println("/*********************************************************/\n"+
							"/*	Give your hero a name : 		         */\n"+
							"/*	at least 3 characters in length with a max of 15 */\n"+
							"/*********************************************************/\n");
		while (true){
			try{
				name = input.next();
			}catch(Exception e){

			}
		}
	}
	
	public static void encounterText()
	{
		int action = -1;
		Scanner input= new Scanner(System.in);
		
		while (action != 1 && action != 2)
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
	
	public void selectHero(List<Hero> heroes) throws MotherOfException
	{
		int limit = heroes.size();
		int choice;
		int loop = 0;
		Hero chosenOne = null;

		Scanner input = new Scanner(System.in);
		if (limit > 0) {
			System.out.println("Here's a list of available heroes, choose by typing the corresponding number and press enter: \n");
			int i = 1;
			for (Hero players : heroes)
			{
				System.out.print("\nHero number "+ i++ + "\n\n");
				peasantStats(players);
			}

			while (loop == 0){
                try {

                    try {
                        choice = input.nextInt()-1;
                        chosenOne =  heroes.get(choice);

                        loop = 2;
//						1
                    } catch(IndexOutOfBoundsException e){
                        System.out.println("please pick a valid hero from 1 and " + (limit-1));
//                        input.next();

//						input.nextLine();

                    }
//					if (choice > limit || choice == limit || choice == 0)
//						throw new MotherOfException("I gave you a chance to choose a hero and you chose one that doesn't exist, restart the program and think carefully about your choices.");
                  ;
                } catch (InputMismatchException im) {
                    System.out.println("numbers only, peasant");
					input.next();
                }
                catch (NoSuchElementException nose){
                    System.out.println("Something happened, try again");
                    loop = 0;
//					input.nextLine();
                }
                catch (IllegalStateException ise){
                    System.out.println("OOf");
                    loop = 0;
//					input.nextLine();
                } catch(NullPointerException e){
                    System.out.println("please pick a valid hero from 1 and " + (limit-1));
//                    input.next();
                }
            }
			if(loop != 2)
			{
				String watch =  chosenOne.toString() != null ? chosenOne.toString() : "nothing";
				System.out.println(watch);
			}
			input.close();
		}			
	}

	public static void divisionExample()
	{
		Scanner input = new Scanner(System.in);
		int numerator;
		int denominator;
		int sum;
		int x = 0;
		do {
			try {
				System.out.println("Enter numerator: ");
				numerator = input.nextInt();
				System.out.println("Enter Denominator: ");
				denominator = input.nextInt();
				sum = numerator/denominator;
				System.out.println(sum);
				x = 2;
				input.close();
			}
			catch(Exception e){
				System.out.println("No.");
			}
			input.nextLine();
		} while (x == 0);
	}
}
