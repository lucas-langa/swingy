package za.co.wethinkcode.Controller;

import za.co.wethinkcode.views.ConsoleViews;
import za.co.wethinkcode.views.DisplayInterface;
import za.co.wethinkcode.GameMap;
import za.co.wethinkcode.MoveHero;
import za.co.wethinkcode.heroes.AntiHeroFactory;
import za.co.wethinkcode.heroes.Hero;
import za.co.wethinkcode.model.Model;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Controller {
	private Model model;
	private DisplayInterface Views;
	private String gameMode;
	private List<Hero> Heroes;
	private GameMap mGameMap;
	private int action;
	private Hero player;

	public enum gameState {
		NEXT, START, SELECTION, CREATION, ERRORS, PLAY, RUN_FIGHT, FORCED_FIGHT, GAME_OVER, QUIT, LAST_LEVEL
	};

	private enum creationStage {
		HERO_TYPE, NAME_PROMPT, CREATION_TYPE, STATS
	};

	private gameState currentState;

	public static void main(String[] args) {

		Model model = new Model();
		DisplayInterface Views = new ConsoleViews();
		Controller gamecontroller = new Controller(model, Views, "console");

	}

	public Controller(Model theModel, DisplayInterface theconsoleViews, String gameMode) {
		this.model = theModel;
		if (gameMode.equalsIgnoreCase("console")) {
			Views = theconsoleViews;
			gameMode = "console";
		} else if (gameMode.equalsIgnoreCase("gui")) {
			return;
		}
		currentState = gameState.START;
		runGame();
		model = theModel;
	}

	class ViewListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			e.getActionCommand().equals("UP");
		}
	}

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
		}
		return outCome;
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
			Scanner sc = new Scanner(System.in);
			String move = null;
			while (currentState == gameState.PLAY) {
				if (sc.hasNext()) {
					move = sc.nextLine();
					if (move.equals("n")) {
						if (mGameMap.metVillain('n'))
							Views.encounterText();
						if (Views.getAction() == 1) {
							if ((battleOutcome = fight(player, AntiHeroFactory.newHero("AntiHero"))) == 0) {
								currentState = gameState.GAME_OVER;
								break;
							} else if (battleOutcome == 1) {
								Views.displayPlayerVictory();
							}
						}
						MoveHero.moveUp(mGameMap.heroY, mGameMap.heroX, mGameMap);
					} else if (move.equals("s")) {
						if (mGameMap.metVillain('s'))
							Views.encounterText();
						if (Views.getAction() == 1) {
							if ((battleOutcome = fight(player, AntiHeroFactory.newHero("AntiHero"))) == 0) {
								currentState = gameState.GAME_OVER;
								break;
							} else if (battleOutcome == 1) {
								Views.displayPlayerVictory();
							}
						}
						MoveHero.moveDown(mGameMap.heroY, mGameMap.heroX, mGameMap);
					} else if (move.equals("w")) {
						if (mGameMap.metVillain('w'))
							Views.encounterText();
						if (Views.getAction() == 1) {
							if ((battleOutcome = fight(player, AntiHeroFactory.newHero("AntiHero"))) == 0) {
								currentState = gameState.GAME_OVER;
								break;
							} else if (battleOutcome == 1) {
								Views.displayPlayerVictory();
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
					if (player.getHeroLevel() == 5) {
						Views.displayVictoryScreen(this.player.getHeroName());
						currentState = gameState.GAME_OVER;
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
}