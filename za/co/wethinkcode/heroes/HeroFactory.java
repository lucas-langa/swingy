package za.co.wethinkcode.heroes;

public abstract class HeroFactory {
	public static Hero newHero( String name, String heroClass ) {
		Hero userHero = null;
		HeroEngineer heroEngineer = null;
		if ( !name.isEmpty() && heroClass == "flank" ) {
			heroEngineer = new HeroEngineer( new FlankHeroBuilder() );
			heroEngineer.makeHero( name );
			userHero = heroEngineer.getHero();
		} else if ( !name.isEmpty() && heroClass == "damage" ) {
			heroEngineer = new HeroEngineer( new DamageHeroBuilder() );
			heroEngineer.makeHero( name );
			userHero = heroEngineer.getHero();
		} else if ( !name.isEmpty() && heroClass == "tank") {
			heroEngineer = new HeroEngineer( new TankHeroBuilder() );
			heroEngineer.makeHero( name );
			userHero = heroEngineer.getHero();
		}
		return ( userHero );
	}
}