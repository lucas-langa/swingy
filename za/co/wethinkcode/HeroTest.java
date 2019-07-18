package za.co.wethinkcode;

import za.co.wethinkcode.heroes.HeroFactory;
import za.co.wethinkcode.heroes.DamageHeroBuilder;
import za.co.wethinkcode.heroes.FlankHeroBuilder;
import za.co.wethinkcode.heroes.HeroEngineer;
import za.co.wethinkcode.heroes.TankHeroBuilder;
import za.co.wethinkcode.heroes.HeroBuilder;
import za.co.wethinkcode.heroes.Hero;

public class HeroTest {

	public static void main( String [] args ){
		Hero uHero = HeroFactory.newHero("lucas", "flank");
		Hero vHero = HeroFactory.newHero("mpho", "damage");
		Hero wHero = HeroFactory.newHero("kerane", "tank");
		System.out.println( uHero );
		System.out.println( vHero );
		System.out.println( wHero );
	}
}