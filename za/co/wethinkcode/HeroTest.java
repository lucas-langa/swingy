package za.co.wethinkcode;

import za.co.wethinkcode.heroes.DamageHeroBuilder;
import za.co.wethinkcode.heroes.FlankHeroBuilder;
import za.co.wethinkcode.heroes.HeroEngineer;
import za.co.wethinkcode.heroes.TankHeroBuilder;
import za.co.wethinkcode.heroes.HeroBuilder;
import za.co.wethinkcode.heroes.Hero;

public class HeroTest {

	public static void main( String [] args ){
		HeroBuilder flanker = new FlankHeroBuilder();
		HeroEngineer heroEngineer = new HeroEngineer( flanker );
		heroEngineer.makeHero( "maeve" );
		Hero maeveFlank = heroEngineer.getHero();
		HeroBuilder tank = new TankHeroBuilder();
		heroEngineer = new HeroEngineer( tank );
		heroEngineer.makeHero( "Khan" );
		Hero khanHero = heroEngineer.getHero();
		
		HeroBuilder damage = new DamageHeroBuilder();
		heroEngineer = new HeroEngineer( damage );
		heroEngineer.makeHero( "Imani" );
		Hero lastWarder = heroEngineer.getHero();

		System.out.println( maeveFlank);
		System.out.println( khanHero );
		System.out.println( lastWarder );
	}
}