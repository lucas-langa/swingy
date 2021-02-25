package za.co.wethinkcode.views;

import javax.validation.ConstraintViolation;

import za.co.wethinkcode.GameMap;
import za.co.wethinkcode.model.heroes.Hero;

import java.util.List;
import java.util.Set;
import java.awt.event.ActionListener;

public interface DisplayInterface {
	public void forceNewHero(boolean force);

	public void welcomeText();

	public void displayPlayerVictory();

	public void displayBattleLoss(int health);

	public void newHeroClass();

	public void newHeroName();

	public void displayErrors(Set<ConstraintViolation<Hero>> thingsGoneWrong);

	public void encounterText();

	public void displayMap(GameMap map);

	public void peasantStats(Hero peasant);

	public void selectHero(List<Hero> heroes);

	public void fightSim();

	public void gameOver();

	public void clearScreen();

	public void displayEscapeFailure();

	public void displayEscapeSuccess();

	public void communicator(ActionListener ActionListener);

	public String getPlayerClass();

	public String getPlayerName();

	public Hero getChosenOne();
	
	public void displayVictoryScreen(String heroName);

	public void newGameView();

}