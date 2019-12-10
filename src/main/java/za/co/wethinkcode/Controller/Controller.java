package za.co.wethinkcode.Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import javax.swing.JOptionPane;

import za.co.wethinkcode.GameMap;
import za.co.wethinkcode.MoveHero;
import za.co.wethinkcode.heroes.AntiHeroFactory;
import za.co.wethinkcode.heroes.Hero;
import za.co.wethinkcode.model.Model;
import za.co.wethinkcode.views.ConsoleViews;
import za.co.wethinkcode.views.DisplayInterface;
import za.co.wethinkcode.views.GUIViews;

public class Controller {
	private Model model;
	private DisplayInterface Views;
	private List<Hero> Heroes;
	private GameMap mGameMap;
	private int action;
	private Hero player;
	private int battleOutcome = -1;

	public enum gameState {
		NEXT, START, SELECTION, CREATION, ERRORS, PLAY, RUN_FIGHT, FORCED_FIGHT, GAME_OVER, QUIT, LAST_LEVEL
	};

	private gameState currentState;

	public void getInput(int action) {
		this.action = action;
	}

	public int fight(Hero player, Hero Villain) {
		int outCome = -1;
		int heroHealth = player.getHeroHitPoints();
		int villainHealth = Villain.getHeroHitPoints();
		int heroAttack = player.getHeroAttack();
		int villainAttack = Villain.getHeroAttack();

		int idk;
		Random chance = new Random();
		while (true) {
			if (heroHealth <= 0 || villainHealth <= 0)
				break;
			if ((idk = chance.nextInt(5) % 2) == 0)
				villainHealth -= heroAttack - Villain.getHeroDefense();
			else
				heroHealth -= villainAttack - player.getHeroDefense();
		}
		if (heroHealth < 0) {
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
			if (Heroes.size() > 0 && Views.getAction() == 1) {
				Views.selectHero(Heroes);
				this.player = Views.getChosenOne();
			} else if (Views.getAction() == 2) {
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
							if (Views.getAction() == 1) {
								if ((battleOutcome = fight(player, AntiHeroFactory.newHero("AntiHero"))) == 0) {
									currentState = gameState.GAME_OVER;
									break;
								} else if (battleOutcome == 1) {
									Views.displayPlayerVictory();
								}
							} else if (Views.getAction() == 2) {
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
							if (Views.getAction() == 1) {
								if ((battleOutcome = fight(player, AntiHeroFactory.newHero("AntiHero"))) == 0) {
									currentState = gameState.GAME_OVER;
									break;
								} else if (battleOutcome == 1) {
									Views.displayPlayerVictory();
								}
							} else if (Views.getAction() == 2) {
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
							if (Views.getAction() == 1) {
								if ((battleOutcome = fight(player, AntiHeroFactory.newHero("AntiHero"))) == 0) {
									currentState = gameState.GAME_OVER;
									break;
								} else if (battleOutcome == 1) {
									Views.displayPlayerVictory();
								}
							} else if (Views.getAction() == 2) {
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
							if (Views.getAction() == 1) {
								if ((battleOutcome = fight(player, AntiHeroFactory.newHero("AntiHero"))) == 0) {
									currentState = gameState.GAME_OVER;
									break;
								} else if (battleOutcome == 1) {
									Views.displayPlayerVictory();
								}
							} else if (Views.getAction() == 2) {
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

	public Controller(Model theModel, String gameMode) {
		this.model = theModel;
		if (gameMode.equalsIgnoreCase("console")) {
			Views = new ConsoleViews();
			gameMode = "console";
			currentState = gameState.START;
			runGame();
			return;
		} else if (gameMode.equalsIgnoreCase("gui")) {
			Views = new GUIViews();
			Views.welcomeText();
			Views.communicator(new GUIButtons());
		} else {
			return;
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
			if (event.getActionCommand().equals("gimmeMap")){
				Views.clearScreen();
				((GUIViews) Views).makeMap(mGameMap = new GameMap(2));
			}
			if (event.getActionCommand().equals("ShowHeroStats")){
				Views.peasantStats(Views.getChosenOne());
			}
			if (event.getActionCommand().equals("confirmDbHero")) {
				Views.getChosenOne();
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
					System.out.println(pClass);
				} catch (IndexOutOfBoundsException e) {
					((GUIViews) Views).displayError("Please select a class from the list");
					pClass = null;
				}
			}
			if (event.getActionCommand().equals("saveNewHero")){
				try {
					if (pClass != null)
						model.addHero(pName, pClass);
					else if (pClass == null)
					((GUIViews) Views).displayError("Please select a class from the list");
				} catch (IllegalArgumentException e) {
					((GUIViews) Views).displayError(e.getMessage());
				}
				if (model.getErrors() != null) {
					Views.clearScreen();
					Views.displayErrors(model.getErrors());
					model.clearErrors();
				}
			}
			if (player != null){
				mGameMap = new GameMap(player.getHeroLevel());
				String move = null;
				if (event.getActionCommand().equals("n")) {
					move = "n";
					if (move.equals("n")) {
						if (mGameMap.metVillain('n')) {
							Views.encounterText();
							if (Views.getAction() == 1) {
								if ((battleOutcome = fight(player, AntiHeroFactory.newHero("AntiHero"))) == 0) {
									currentState = gameState.GAME_OVER;
									break;
								} else if (battleOutcome == 1) {
									Views.displayPlayerVictory();
								}
							} else if (Views.getAction() == 2) {
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
					} 
				}
			}
			// if (event.getActionCommand().equals("down"))
			// if (event.getActionCommand().equals("left"))
			// if (event.getActionCommand().equals("right"))
		}
	}

	
}