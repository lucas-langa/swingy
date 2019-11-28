package za.co.wethinkcode;

import za.co.wethinkcode.heroes.Hero;
import za.co.wethinkcode.heroes.HeroFactory;
import za.co.wethinkcode.model.Model;
import za.co.wethinkcode.views.ConsoleViews;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.List;
import java.util.Set;
// import org.hibernate.HibernateException;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import static org.hibernate.internal.util.collections.CollectionHelper.isEmpty;

public class Swingy {
	public static EntityManagerFactory ENTITY_MANAGER_FACTORY =
	Persistence.createEntityManagerFactory("za.co.wethinkcode.Swingy");
	public static void main(String[] args) {
		ConsoleViews viewConsole = new ConsoleViews();
		Model heroModel = new Model();
		// createDatabase();
		// createTable();
		heroModel.addHero("miley", "flank");
		// List<Hero> heroes = heroModel.getHeroes();
		// viewConsole.listHeroes(heroes);
		// try{
		// 	viewConsole.selectHero(heroes);
		// } catch(MotherOfException MOE){
		// 	System.out.println(MOE.getMessage());
		// }
		// Hero player = heroes.get(0);
		// player.setHeroLevel(19);
		// player.setHeroExperience(player.getHeroExperience() + 20);
		// updateHero(player);
	}

	public void addHero(String name, String heroClass) {
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		Validator validator = factory.getValidator();
		Hero newHero = HeroFactory.newHero(name, heroClass);
		Set<ConstraintViolation<Hero>> constraintViolations = validator.validate( newHero );
		if (!isEmpty(constraintViolations))
		{
				System.out.printf("%s %s\n", constraintViolations.iterator().next().getMessage());
				return ;
		}

		EntityManager entityManager = ENTITY_MANAGER_FACTORY.createEntityManager();
		entityManager.getTransaction().begin();
		entityManager.persist(newHero);
		entityManager.getTransaction().commit();
		entityManager.close();
	}
}
