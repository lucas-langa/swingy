package za.co.wethinkcode;

import org.hibernate.*;
import za.co.wethinkcode.heroes.Hero;
import za.co.wethinkcode.heroes.HeroFactory;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.List;
import java.util.Set;
import org.hibernate.HibernateException;

import static org.hibernate.internal.util.collections.CollectionHelper.isEmpty;


public class Swingy {
	    public static EntityManagerFactory ENTITY_MANAGER_FACTORY = Persistence.createEntityManagerFactory("za.co.wethinkcode.Swingy");
	public static void main(String[] args) {
		List<Hero> heroes = getHeroesFromDB();
		Hero player = heroes.get(0);
		player.setHeroLevel(19);
		player.setHeroExperience(player.getHeroExperience() + 20);
		updateHero(player);
	}

	public static List<Hero>   getHeroesFromDB(){
		EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();
		try {
			em.getTransaction().begin();
			List<Hero> heroes = em.createQuery("SELECT h FROM Hero h", Hero.class).getResultList();
			return heroes;
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			em.close();
		}
		return null;
	}

	public static void addHero(String name, String heroClass) {
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		Validator validator = factory.getValidator();
		Hero newHero = HeroFactory.newHero(name, heroClass);
		Set<ConstraintViolation<Hero>> constraintViolations = validator.validate( newHero );
		if (!isEmpty(constraintViolations))
		{
				System.out.printf( "%s %s\n", constraintViolations.iterator().next().getConstraintDescriptor(),
						constraintViolations.iterator().next().getMessage());
				return ;
		}

		EntityManager entityManager = ENTITY_MANAGER_FACTORY.createEntityManager();
		entityManager.getTransaction().begin();
		entityManager.persist(newHero);
		entityManager.getTransaction().commit();
		entityManager.close();
	}

	public static void  updateHero(Hero player){
		EntityManager entityManager = ENTITY_MANAGER_FACTORY.createEntityManager();
		entityManager.getTransaction().begin();
		entityManager.merge(player);
		entityManager.getTransaction().commit();
		entityManager.close();
	}
}