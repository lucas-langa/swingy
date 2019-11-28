package za.co.wethinkcode.views;

import javax.validation.ConstraintViolation;

import za.co.wethinkcode.heroes.Hero;

import java.util.List;
import java.util.Set;
import java.awt.event.ActionListener;

public interface DisplayInterface {
	public void welcomeText();

	public void newHeroClass();

	public void newHeroName();

	public void displayErrors(Set<ConstraintViolation<Hero>> thingsGoneWrong);

	public void encounterText();

	public void displayMap(int[][] map, int size);

	public void peasantStats(Hero peasant);

	public void selectHero(List<Hero> heroes);

	public void divisionExample();

	public void fightSim();

	public void clearScreen();

	public void communicator(ActionListener ActionListener);
}