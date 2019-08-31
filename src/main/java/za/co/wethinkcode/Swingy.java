package za.co.wethinkcode;

import za.co.wethinkcode.heroes.Hero;
import za.co.wethinkcode.heroes.HeroFactory;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Set;

import static org.hibernate.internal.util.collections.CollectionHelper.isEmpty;


public class Swingy {
	    public static EntityManagerFactory ENTITY_MANAGER_FACTORY = Persistence.createEntityManagerFactory("za.co.wethinkcode.Swingy");
	public static void main(String[] args) {
		addHero("lucas", "flank");
	}

	public static void addHero(String name, String heroClass) {
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		Validator validator = factory.getValidator();
		Hero newHero = HeroFactory.newHero(name, heroClass);
		Set<ConstraintViolation<Hero>> constraintViolations = validator.validate( newHero );
		if (!isEmpty(constraintViolations))
			System.out.printf( "not  null %s\n", constraintViolations.iterator().next().getMessage());
		EntityManager entityManager = ENTITY_MANAGER_FACTORY.createEntityManager();
		entityManager.getTransaction().begin();
		entityManager.persist(newHero);
		entityManager.getTransaction().commit();
		entityManager.close();
	}
}