package za.co.wethinkcode.model;

import za.co.wethinkcode.model.heroes.*;
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
	public static EntityManagerFactory ENTITY_MANAGER_FACTORY;
	private Hero player;
	Set<ConstraintViolation<Hero>> constraintViolations = null;
	
	public	Hero getVillain(String antiType){
		return (AntiHeroFactory.newHero(antiType));
	}

	public Model(){
		try {
			ENTITY_MANAGER_FACTORY = Persistence.createEntityManagerFactory("za.co.wethinkcode.Swingy");			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
	}
	public  List<Hero>   getHeroesFromDB(){
		EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();
		try {
			em.getTransaction().begin();
			return  em.createQuery("SELECT h FROM Hero h", Hero.class).getResultList();
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			em.close();
		}
		return null;
	}

	public Set<ConstraintViolation<Hero>> getErrors(){
		return constraintViolations;
	}

	public void clearErrors() {
		constraintViolations.clear();
	}

	public void addHero(String name, String heroClass) {
		try {
			ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
			Validator validator = factory.getValidator();
			this.player  = HeroFactory.newHero(name, heroClass);
			constraintViolations = validator.validate( player );
			if (constraintViolations == null || !isEmpty(constraintViolations))
				return ;
			EntityManager entityManager = ENTITY_MANAGER_FACTORY.createEntityManager();
			entityManager.getTransaction().begin();
			entityManager.persist(player);
			entityManager.getTransaction().commit();
			entityManager.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public void  updateHero(Hero player){
		try {
			EntityManager entityManager = ENTITY_MANAGER_FACTORY.createEntityManager();
			entityManager.getTransaction().begin();
			entityManager.merge(player);
			entityManager.getTransaction().commit();
			entityManager.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	/**
	 * @return the player
	 */
	public Hero getPlayer() {
		return player;
	}

	public List<Hero> getHeroes()
	{
		return (getHeroesFromDB());
	}
}