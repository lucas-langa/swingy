package za.co.wethinkcode.model.heroes;

public abstract class AntiHeroFactory {
	public static Hero newHero(String heroClass ) {
		Hero AntiHero = null;
		HeroEngineer heroEngineer = null;
		
		if (heroClass == "AntiHero")
		{
			heroEngineer = new HeroEngineer( new AntiHeroBuilder() );
			heroEngineer.makeHero("AntiHero");
			AntiHero = heroEngineer.getHero();
		}
		else if (heroClass == "DemonHero")
		{
			heroEngineer = new HeroEngineer( new DemonHeroBuilder() );
			heroEngineer.makeHero("DemonHero");
			AntiHero = heroEngineer.getHero();
		}
		else if (heroClass == "WarlockHero")
		{
			heroEngineer = new HeroEngineer( new WarlockHeroBuilder() );
			heroEngineer.makeHero("WarlockHero");
			AntiHero = heroEngineer.getHero();
		}
		return ( AntiHero );
	}
}