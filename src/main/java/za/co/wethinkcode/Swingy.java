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

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import static org.hibernate.internal.util.collections.CollectionHelper.isEmpty;

public class Swingy {
	// public static EntityManagerFactory ENTITY_MANAGER_FACTORY =
	// Persistence.createEntityManagerFactory("za.co.wethinkcode.Swingy");
	public static void main(String[] args) {
		createDatabase();
		// List<Hero> heroes = getHeroesFromDB();
		// Hero player = heroes.get(0);
		// player.setHeroLevel(19);
		// player.setHeroExperience(player.getHeroExperience() + 20);
		// updateHero(player);
	}

	public static void connect() {
		Connection conn = null;
		try {
			String url = "jdbc:sqlite:/usr/bin/sqlite3";
			conn = DriverManager.getConnection(url);
			System.out.println("Connected to sqlite");
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException ex) {
				System.out.println(ex.getMessage());
			}
		}
	}

	public static void createDatabase() {
		Connection conn = null;
		try {
			String url = "jdbc:sqlite:heroes.db";
			conn = DriverManager.getConnection(url);
			if (conn != null)
				System.out.println("created a new database");
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	public static List<Hero> getHeroesFromDB() {
		Connection conn = null;
		List<Hero> heroes = null;
		// em.createQuery("SELECT h FROM Hero h", Hero.class).getResultList();
		// try{
		// }
		// EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();
		// try {
		// em.getTransaction().begin();
		// List<Hero> heroes = em.createQuery("SELECT h FROM Hero h",
		// Hero.class).getResultList();
		// return heroes;
		// } catch (HibernateException e) {
		// e.printStackTrace();
		// } finally {
		// em.close();
		// }
		return null;
	}

	public static void addHero(String name, String heroClass) {
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		Validator validator = factory.getValidator();
		Hero newHero = HeroFactory.newHero(name, heroClass);
		Set<ConstraintViolation<Hero>> constraintViolations = validator.validate(newHero);
		if (!isEmpty(constraintViolations)) {
			System.out.printf("%s %s\n", constraintViolations.iterator().next().getConstraintDescriptor(),
					constraintViolations.iterator().next().getMessage());
			return;
		}

		EntityManager entityManager = ENTITY_MANAGER_FACTORY.createEntityManager();
		entityManager.getTransaction().begin();
		entityManager.persist(newHero);
		entityManager.getTransaction().commit();
		entityManager.close();
	}

	public static void updateHero(Hero player) {
		EntityManager entityManager = ENTITY_MANAGER_FACTORY.createEntityManager();
		entityManager.getTransaction().begin();
		entityManager.merge(player);
		entityManager.getTransaction().commit();
		entityManager.close();
	}
}
