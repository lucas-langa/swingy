package za.co.wethinkcode;

import za.co.wethinkcode.heroes.HeroFactory;
import za.co.wethinkcode.heroes.Hero;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class HeroTest {
	private static final EntityManagerFactory ENTITY_MANAGER_FACTORY = Persistence.createEntityManagerFactory("Hero");
	public static void main( String [] args ){
		addHero( "lucas", "flank" );
		ENTITY_MANAGER_FACTORY.close();
	}

	public static void addHero( String name, String heroClass ) {
		EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();
		EntityTransaction et = null;

		try {
			et = em.getTransaction();
			et.begin();

			Hero uHero = HeroFactory.newHero( name, heroClass );
			em.persist( uHero );
			et.commit();
		} catch ( Exception ex ) {
			if ( et != null ) {
				et.rollback();
			}
			ex.printStackTrace();
		} finally {
			em.close();
		}
	}
}