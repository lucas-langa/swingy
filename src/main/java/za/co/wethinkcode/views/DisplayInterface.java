package za.co.wethinkcode.views;

import javax.validation.ConstraintViolation;

import java.util.List;
import java.util.Set;
import za.co.wethinkcode.heroes.Hero;

public interface DisplayInterface
{
	void	welcomeText();
	void	newHeroClass();
	void	newHeroName();
	void 	displayErrors(Set<ConstraintViolation<Hero>> thingsGoneWrong);
	void	encounterText();
	void 	displayMap(int[][] map, int size);
	void 	peasantStats(Hero peasant);
	void 	selectHero(List<Hero> heroes);
	void 	divisionExample();
	void 	fightSim();
	void 	clearScreen();
}