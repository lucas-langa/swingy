package za.co.wethinkcode.views;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.Set;
import java.awt.event.ActionListener;

import javax.validation.ConstraintViolation;
import java.util.InputMismatchException;
import za.co.wethinkcode.heroes.*;
import za.co.wethinkcode.model.Model;
import za.co.wethinkcode.MotherOfException;

public class ConsoleViews implements DisplayInterface {
	private String PlayerName;
	private String playerClass;
	private Scanner input = new Scanner(System.in);
	private int action;
	private Hero chosenOne;

	/**
	 * @return the chosenOne
	 */
	public Hero getChosenOne() {
		return chosenOne;
	}
	public void listHeroes(List<Hero> heroes) {
		for (Hero hero : heroes) {
			peasantStats(hero);
		}
	}

	public void welcomeText() {

		System.out.print("/*********************************************************/\n"
				+ "/*        Welcome to a text based semi violent RPG       */\n"
				+ "/*        To Start:                                      */\n"
				+ "/*        1.Select an existing hero                      */\n"
				+ "/*	  2.Create a New Hero                            */\n"
				+ "/*********************************************************/\n");
		while (true) {
			try {
				action = input.nextInt();
				if (action == 1 || action == 2)
					break;
				else
					System.out.println("Please select a valid option");
			} catch (InputMismatchException im) {
				System.out.println("numbers only, peasant");
				input.next();
			} catch (IllegalStateException ise) {
				System.out.println("OOf: " + ise.getMessage());
				input.next();
			} catch (NullPointerException e) {
				System.out.println("please enter some data");
				input.next();
			}
		}
	}

	private void clearScreen() {
		System.out.print("\033[H\033[2J");
		System.out.flush();
	}

	public void displayErrors(Set<ConstraintViolation<Hero>> thingsGoneWrong) {
		System.out.println("So many things could have gone wrong but...");

		for (ConstraintViolation<Hero> constraintViolation : thingsGoneWrong) {
			System.out.println(constraintViolation.getMessage());
		}
	}

	public void forceNewHero() {
		System.out.println("Looks like there's no heroes for you to choose yet, please create one:");
		newHeroName();
		newHeroClass();
	}

	/**
	 * @return the action
	 */
	public int getAction() {
		return action;
	}

	/**
	 * @return the playerName
	 */
	public String getPlayerName() {
		return PlayerName;
	}

	/**
	 * @return the playerClass
	 */
	public String getPlayerClass() {
		return playerClass;
	}

	public void communicator(ActionListener ActionListener) {
		return;
	}

	public void fightSim() {
		return;
	}

	public void newHeroClass() {
		action = -1;

		System.out.println("/*********************************************************/\n"
				+ "/*	Choose a hero Class:                             */\n"
				+ "/*	1.Flank                                          */\n"
				+ "/*	2.Damage                                         */\n"
				+ "/*	3.Tank                                           */\n"
				+ "/*********************************************************/\n");

		while (true) {
			try {
				action = input.nextInt();
				switch (action) {
				case 1:
					playerClass = "flank";
					break;
				case 2:
					playerClass = "damage";
					break;
				case 3:
					playerClass = "tank";
					break;
				default:
					break;
				}
				break;
			} catch (InputMismatchException im) {
				System.out.println("numbers only, peasant");
				input.next();
			} catch (IllegalStateException ise) {
				System.out.println("OOf: " + ise.getMessage());
				input.next();
			} catch (NullPointerException e) {
				System.out.println("please pick a valid hero from 1 and ");
				input.next();
			}
		}
	}

	public void newHeroName() {

		String name;
		System.out.println("/*********************************************************/\n"
				+ "/*	Give your hero a name :                          */\n"
				+ "/*	at least 3 characters in length with a max of 15 */\n"
				+ "/*********************************************************/\n");
		while (true) {
			try {
				name = input.next();
				if (name.length() >= 3 && name.length() <= 15) {
					PlayerName = name;
					break;
				} else
					System.out.println("must be 3 to 15 characters long");
			} catch (InputMismatchException im) {
				System.out.println("characters only, peasant");
				input.next();
			} catch (IllegalStateException ise) {
				System.out.println("OOf: " + ise.getMessage());
				input.next();
			} catch (NullPointerException e) {
				System.out.println("please pick a valid hero from 1 and ");
				input.next();
			}
		}
		return;
	}

	public void encounterText() {
		System.out.println("/*********************************************************/\n"
				+ "/*			You have encountered an enemy.               */\n"
				+ "/*			What do you want to do?						 */\n"
				+ "/*			1.Fight			2.Flee						 */\n"
				+ "/*********************************************************/\n");
		while (true) {
			try {
				action = input.nextInt();
				if (action == 1 || action == 2)
					break;
				else
					System.out.println("Please enter a valid number");
			} catch (InputMismatchException im) {
				System.out.println("numbers only, peasant");
				input.next();
			} catch (IllegalStateException ise) {
				System.out.println("OOf: " + ise.getMessage());
				input.next();
			} catch (NullPointerException e) {
				System.out.println("please pick a valid hero from 1 and ");
				input.next();
			}
		}
	}

	public void displayMap(int[][] map, int size) {
		int y = size, x = size;
		for (int i = 0; i < y; i++) {
			for (int j = 0; j < x; j++) {
				System.out.printf("%c", map[i][j]);
			}
			System.out.print("\n");
		}
	}

	public void peasantStats(Hero Peasant) {
		System.out.println("Hero Name : " + Peasant.getHeroName());
		System.out.println("Hero class : " + Peasant.getHeroClass());
		System.out.println("Hero Level : " + Peasant.getHeroLevel());
		System.out.println("Hero Attack : " + Peasant.getHeroAttack());
		System.out.println("Hero Defense : " + Peasant.getHeroDefense());
		System.out.println("Hero HP : " + Peasant.getHeroHitPoints());
		System.out.println("Hero Experience " + Peasant.getHeroExperience());
	}

	public void selectHero(List<Hero> heroes) {
		int limit = heroes.size();
		int choice;
		int loop = 0;
		chosenOne = null;
	
		if (limit > 0) {
			System.out.println(
					"Here's a list of available heroes, choose by typing the corresponding number and press enter: \n");
			int i = 1;
			for (Hero players : heroes) {
				System.out.print("\nHero number " + i++ + "\n\n");
				peasantStats(players);
			}

			while (loop == 0) {
				try {

					try {
						choice = input.nextInt() - 1;
						chosenOne = heroes.get(choice);
						loop = 2;
					} catch (IndexOutOfBoundsException e) {
						System.out.println("please pick a valid hero from 1 and " + (limit - 1));
						// input.next();
						// input.nextLine();
					}
				} catch (InputMismatchException im) {
					System.out.println("numbers only, peasant");
					input.next();
				} catch (NoSuchElementException nose) {
					System.out.println("Something happened, try again");
					loop = 0;

					// input.nextLine();
				} catch (IllegalStateException ise) {
					System.out.println("OOf");
					loop = 0;
					// input.nextLine();
				} catch (NullPointerException e) {
					System.out.println("please pick a valid hero from 1 and " + (limit - 1));
					// input.next();
				}
			}
			// if (loop != 2) {
			String watch = chosenOne.toString() != null ? chosenOne.toString() : "nothing";
			System.out.println(watch);
			// }
			// input.close();
		} else {
			System.out.println("Looks like there are no heroes available, create some");
		}
	}

	public void displayVictoryScreen(String heroName) {
		System.out.println("Congratulations " + heroName + ", you have won");
	}

}
