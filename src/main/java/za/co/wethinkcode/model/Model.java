package za.co.wethinkcode.model;

import za.co.wethinkcode.heroes.Hero;
import za.co.wethinkcode.heroes.HeroFactory;
import java.util.List;
import java.util.Set;
import javax.persistence.EntityManagerFactory;
import org.hibernate.HibernateException;
import javax.persistence.EntityManager;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import javax.persistence.Persistence;
import javax.validation.ConstraintViolation;
import static org.hibernate.internal.util.collections.CollectionHelper.isEmpty;

public class Model {
	public static EntityManagerFactory ENTITY_MANAGER_FACTORY = Persistence.createEntityManagerFactory("za.co.wethinkcode.Swingy");
	private List<Hero> heroes;

	public  List<Hero>   getHeroesFromDB(){
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

	public void addHero(String name, String heroClass) {
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

	public void  updateHero(Hero player){
		EntityManager entityManager = ENTITY_MANAGER_FACTORY.createEntityManager();
		entityManager.getTransaction().begin();
		entityManager.merge(player);
		entityManager.getTransaction().commit();
		entityManager.close();
	}
}