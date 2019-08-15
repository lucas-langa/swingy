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
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.SQLException;

public class Swingy {

	public static void main(String[] args) {
        EntityManagerFactory ENTITY_MANAGER_FACTORY = Persistence.createEntityManagerFactory("za.co.wethinkcode.Swingy");
		ValidatorFactory factory =                                         Validation.buildDefaultValidatorFactory();
		Validator validator = factory.getValidator();

        Client client = new Client();
        client.setId(11);
        client.setName("bi");

		Set<ConstraintViolation<Client>> constraintViolations = validator.validate( client );
		if (!isEmpty(constraintViolations))
			System.out.printf( "not  null %s\n", constraintViolations.iterator().next().getMessage());
        Bank bank = new Bank();
        bank.setName("wethinkcode B");

        EntityManager entityManager = ENTITY_MANAGER_FACTORY.createEntityManager();

        entityManager.getTransaction().begin();

        entityManager.persist(client);
        entityManager.persist(bank);

        entityManager.getTransaction().commit();

        entityManager.close();
//		addHero("lucas", "flank");
	}

	public static void addHero(String name, String heroClass) {

	}
}