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
	private int[][] map;
	private int x, y;
	private int heroY, heroX;
	private Hero player;

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
				System.out.printf("%s %s\n", constraintViolations.iterator().next().getConstraintDescriptor(),
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

	public 	void 	 getHeroPos(){
		for (int i = 0;i < this.y ;i++){
			for (int j = 0; j < this.x;j++)
			{
				if (map[i][j] == 'h'){
					heroX = j;
					heroY = i;
					return ;
				}
			}
		}
	}

	private	void    createGameMap()
	{
		int heroLevel = this.player.getHeroLevel();
		this.y = (heroLevel - 1) * 5 + 10 - (heroLevel % 2);
		this.x = this.y;
		this.map = new int[this.y][this.x];
		populateMap(this.y, this.x);
		int pos = getMapMid();
		heroY = pos;
		heroX = pos;
		this.map[pos][pos] = 'h';
	}

	public boolean checkEdge(){
		getHeroPos();
		if (heroX == 0 || heroY == 0 || heroX == map.length - 1 || heroY == map[heroX].length - 1)
			return true;
		return false;
	}

	private void    populateMap( final int y, final int x ) {
		for (int i = 0; i < y;i++){
			for (int j = 0; j < x; j++){
				map[i][j] = '*';
			}
		}
	}

	public int getMapMid() {
		if (this.x % 2 == 0)
			return  (this.x / 2);
		return (this.x / 2 + 1);
	}

	public int[][] getMap()
	{
		return this.map;
	}

	public void setMap()
	{
		createGameMap();
	}
}