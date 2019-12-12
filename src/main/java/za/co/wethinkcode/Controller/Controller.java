package za.co.wethinkcode.Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import za.co.wethinkcode.GameMap;
import za.co.wethinkcode.MoveHero;
import za.co.wethinkcode.model.heroes.AntiHeroFactory;
import za.co.wethinkcode.model.heroes.Hero;
import za.co.wethinkcode.model.Model;
import za.co.wethinkcode.views.ConsoleViews;
import za.co.wethinkcode.views.DisplayInterface;
import za.co.wethinkcode.views.GUIViews;

public class Controller {
	private Model model;
	private DisplayInterface Views;
	private List<Hero> Heroes;
	private GameMap mGameMap;
	private Hero player;
	private int battleOutcome = -1;

	public enum gameState {
		NEXT, START, SELECTION, CREATION, ERRORS, PLAY, RUN_FIGHT, FORCED_FIGHT, GAME_OVER, QUIT, LAST_LEVEL
	};

	private gameState currentState;

	public Controller(Model theModel, String gameMode) {
		this.model = theModel;

		if (gameMode == null)
		{
			System.out.println("Accepted arguments are either gui or console.");
			System.exit(0);
		} else if (gameMode.equalsIgnoreCase("console")) {
			Views = new ConsoleViews();
			gameMode = "console";
			currentState = gameState.START;
			runGame();
			return;
		} else if (gameMode.equalsIgnoreCase("gui")) {
			Views = new GUIViews();
			Views.welcomeText();
			Views.communicator(new GUIButtons());
		}
	}

	public int fight(Hero player, Hero Villain) {
		int outCome = -1;
		int heroHealth = player.getHeroHitPoints();
		int villainHealth = Villain.getHeroHitPoints();
		int heroAttack = player.getHeroAttack();
		int villainAttack = Villain.getHeroAttack();

		Random chance = new Random();
		while (true) {
			if ((chance.nextInt(5) % 2) == 0) {
				villainHealth -= heroAttack - Villain.getHeroDefense();
			} else {
				heroHealth -= villainAttack - player.getHeroDefense();
			}
			if (heroHealth <= 0 || villainHealth <= 0)
				break;
		}
		if (heroHealth <= 0) {
			Views.displayBattleLoss(heroHealth);
			outCome = 0;
		} else if (villainHealth <= 0) {
			outCome = 1;
			player.setHeroExperience(player.getHeroExperience() + 20);
		}
		return outCome;
	}

	public int escapeChance() {
		Random chance;

		chance = new Random();
		return (chance.nextInt(2));
	}

	public void runGame() {
		int battleOutcome = -1;
		Heroes = model.getHeroesFromDB();
		switch (currentState) {
		case START:
			Views.welcomeText();
			if (Heroes.size() > 0 && ((ConsoleViews) Views).getAction() == 1) {
				Views.selectHero(Heroes);
				this.player = Views.getChosenOne();
			} else if (((ConsoleViews) Views).getAction() == 2) {
				Views.forceNewHero();
				this.model.addHero(Views.getPlayerName(), Views.getPlayerClass());
				player = this.model.getPlayer();
			}
			currentState = gameState.PLAY;
		case PLAY:
			this.mGameMap = new GameMap(player.getHeroLevel());
			mGameMap.displayMap();
			Scanner sc = new Scanner(System.in);
			String move = null;
			while (currentState == gameState.PLAY) {
				if (sc.hasNext()) {
					move = sc.nextLine();
					if (move.equals("n")) {
						if (mGameMap.metVillain('n')) {

							Views.encounterText();
							if (((ConsoleViews) Views).getAction() == 1) {
								if ((battleOutcome = fight(player, AntiHeroFactory.newHero("AntiHero"))) == 0) {
									currentState = gameState.GAME_OVER;
									break;
								} else if (battleOutcome == 1) {
									Views.displayPlayerVictory();
								}
							} else if (((ConsoleViews) Views).getAction() == 2) {
								if (escapeChance() == 0) {
									Views.displayEscapeFailure();
									if ((battleOutcome = fight(player, AntiHeroFactory.newHero("AntiHero"))) == 0) {
										currentState = gameState.GAME_OVER;
										break;
									} else if (battleOutcome == 1) {
										Views.displayPlayerVictory();
									}

								} else {
									Views.displayEscapeSuccess();
								}
							}
						}
						MoveHero.moveUp(mGameMap.heroY, mGameMap.heroX, mGameMap);
					} else if (move.equals("s")) {
						if (mGameMap.metVillain('s')) {

							Views.encounterText();
							if (((ConsoleViews) Views).getAction() == 1) {
								if ((battleOutcome = fight(player, AntiHeroFactory.newHero("AntiHero"))) == 0) {
									currentState = gameState.GAME_OVER;
									break;
								} else if (battleOutcome == 1) {
									Views.displayPlayerVictory();
								}
							} else if (((ConsoleViews) Views).getAction() == 2) {
								if (escapeChance() == 0) {
									Views.displayEscapeFailure();
									if ((battleOutcome = fight(player, AntiHeroFactory.newHero("AntiHero"))) == 0) {
										currentState = gameState.GAME_OVER;
										break;
									} else if (battleOutcome == 1) {
										Views.displayPlayerVictory();
									}

								} else {
									Views.displayEscapeSuccess();
								}
							}
						}
						MoveHero.moveDown(mGameMap.heroY, mGameMap.heroX, mGameMap);
					} else if (move.equals("w")) {
						if (mGameMap.metVillain('w')) {
							Views.encounterText();
							if (((ConsoleViews) Views).getAction() == 1) {
								if ((battleOutcome = fight(player, AntiHeroFactory.newHero("AntiHero"))) == 0) {
									currentState = gameState.GAME_OVER;
									break;
								} else if (battleOutcome == 1) {
									Views.displayPlayerVictory();
								}
							} else if (((ConsoleViews) Views).getAction() == 2) {
								if (escapeChance() == 0) {
									Views.displayEscapeFailure();
									if ((battleOutcome = fight(player, AntiHeroFactory.newHero("AntiHero"))) == 0) {
										currentState = gameState.GAME_OVER;
										break;
									} else if (battleOutcome == 1) {
										Views.displayPlayerVictory();
									}

								} else {
									Views.displayEscapeSuccess();
								}
							}
						}
						MoveHero.left(mGameMap.heroY, mGameMap.heroX, mGameMap);
					} else if (move.equals("e")) {
						if (mGameMap.metVillain('e')) {
							Views.encounterText();
							if (((ConsoleViews) Views).getAction() == 1) {
								if ((battleOutcome = fight(player, AntiHeroFactory.newHero("AntiHero"))) == 0) {
									currentState = gameState.GAME_OVER;
									break;
								} else if (battleOutcome == 1) {
									Views.displayPlayerVictory();
								}
							} else if (((ConsoleViews) Views).getAction() == 2) {
								if (escapeChance() == 0) {
									Views.displayEscapeFailure();
									if ((battleOutcome = fight(player, AntiHeroFactory.newHero("AntiHero"))) == 0) {
										currentState = gameState.GAME_OVER;
										break;
									} else if (battleOutcome == 1) {
										Views.displayPlayerVictory();
									}

								} else {
									Views.displayEscapeSuccess();
								}
							}
						}
						MoveHero.right(mGameMap.heroY, mGameMap.heroX, mGameMap);
					}
				}
				mGameMap.displayMap();
				if (mGameMap.checkEdge()) {
					player.setHeroLevel(player.getHeroLevel() + 1);
					this.mGameMap = new GameMap(player.getHeroLevel());
					currentState = gameState.PLAY;
					mGameMap.displayMap();
					if (player.getHeroLevel() == 10) {
						Views.displayVictoryScreen(this.player.getHeroName());
						currentState = gameState.GAME_OVER;
						Views.peasantStats(player);
					}
				}
			}
			System.out.println("\n");
			sc.close();
		case GAME_OVER:
			Views.gameOver();
		default:
		}
	}

	public class GUIButtons implements ActionListener {
		private String pName;
		private String pClass;

		public void actionPerformed(ActionEvent event) {
			if (event.getActionCommand().equals("2.Select an existing Hero")) {
				Views.clearScreen();
				Views.selectHero(model.getHeroesFromDB());

			}
			if (event.getActionCommand().equals("ShowHeroStats")) {
				Views.peasantStats(Views.getChosenOne());
			}
			if (event.getActionCommand().equals("1.Create a new Hero")) {
				Views.newGameView();
			}
			if (event.getActionCommand().equals("confirmPlayerName")) {
				pName = Views.getPlayerName();
			}
			if (event.getActionCommand().equals("ConfirmClass")) {
				try {
					pClass = Views.getPlayerClass();
				} catch (IndexOutOfBoundsException e) {
					((GUIViews) Views).displayError("Please select a class from the list");
					pClass = null;
				}
			}
			if (event.getActionCommand().equals("confirmDbHero")) {
				player = Views.getChosenOne();
				mGameMap = new GameMap(player.getHeroLevel());
				((GUIViews) Views).setupGameView(mGameMap);
			}
			if (event.getActionCommand().equals("saveNewHero")) {
				try {
					if (pClass != null)
						model.addHero(pName, pClass);
					else if (pClass == null)
						((GUIViews) Views).displayError("Please select a class from the list");
				} catch (Exception e) {
					((GUIViews) Views).displayError(e.getMessage());
				}
				if (!model.getErrors().isEmpty()) {
					Views.clearScreen();
					Views.displayErrors(model.getErrors());
					model.clearErrors();
				} else {
					Views.clearScreen();
					player = model.getPlayer();
					mGameMap = new GameMap(player.getHeroLevel());
					((GUIViews) Views).setupGameView(mGameMap);
				}
			}

			if (player != null) {
				if (event.getActionCommand().equals("n")) {
					if (mGameMap.metVillain('n')) {
						((GUIViews) Views).enableEncounterActions();
						Views.encounterText();
						Views.clearScreen();
						((GUIViews) Views).disableButtons();
					}
					MoveHero.moveUp(mGameMap.heroY, mGameMap.heroX, mGameMap);
					((GUIViews) Views).updateMap(mGameMap);
				} else if (event.getActionCommand().equals("s")) {
					
					if (mGameMap.metVillain('s')) {
						((GUIViews) Views).enableEncounterActions();
						Views.encounterText();
						Views.clearScreen();
						((GUIViews) Views).disableButtons();
					}
					MoveHero.moveDown(mGameMap.heroY, mGameMap.heroX, mGameMap);
					((GUIViews) Views).updateMap(mGameMap);

				} else if (event.getActionCommand().equals("w")) {
					if (mGameMap.metVillain('w')) {
						((GUIViews) Views).enableEncounterActions();
						Views.encounterText();
						Views.clearScreen();
						((GUIViews) Views).disableButtons();
					}
					MoveHero.left(mGameMap.heroY, mGameMap.heroX, mGameMap);
					((GUIViews) Views).updateMap(mGameMap);
				} else if (event.getActionCommand().equals("e")) {
					if (mGameMap.metVillain('e')) {
						((GUIViews) Views).enableEncounterActions();
						Views.encounterText();
						Views.clearScreen();
						((GUIViews) Views).disableButtons();
					}
				
					MoveHero.right(mGameMap.heroY, mGameMap.heroX, mGameMap);
					((GUIViews) Views).updateMap(mGameMap);
				}

				if (event.getActionCommand().equals("fight")) {
					if ((battleOutcome = fight(player, AntiHeroFactory.newHero("AntiHero"))) == 0) {
						currentState = gameState.GAME_OVER;
						System.exit(0);
						return;
					} else if (battleOutcome == 1) {
						Views.displayPlayerVictory();
						((GUIViews) Views).disableEncounterActions();
						((GUIViews) Views).removeEncounterText();
						((GUIViews) Views).enableButtons();
					}
				} else if (event.getActionCommand().equals("flee")) {
					if (escapeChance() == 0) {
						Views.displayEscapeFailure();
						if ((battleOutcome = fight(player, AntiHeroFactory.newHero("AntiHero"))) == 0) {
							currentState = gameState.GAME_OVER;
							System.exit(0);
						} else if (battleOutcome == 1) {
							Views.displayPlayerVictory();
							((GUIViews) Views).removeEncounterText();
							((GUIViews) Views).disableEncounterActions();
							((GUIViews) Views).enableButtons();
						}
					} else {
						((GUIViews) Views).disableEncounterActions();
						((GUIViews) Views).enableButtons();
						((GUIViews) Views).removeEncounterText();
						Views.displayEscapeSuccess();
					}
				}
				if (mGameMap.checkEdge()) {
					player.setHeroLevel(player.getHeroLevel() + 1);
					mGameMap = new GameMap(player.getHeroLevel());
					((GUIViews) Views).updateMap(mGameMap);
					currentState = gameState.PLAY;
					if (player.getHeroLevel() == 10) {
						Views.displayVictoryScreen(player.getHeroName());
						currentState = gameState.GAME_OVER;
						Views.peasantStats(player);
						System.exit(0);
					}
				}
			}
		}
	}
}