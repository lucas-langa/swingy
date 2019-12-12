package za.co.wethinkcode.model.heroes;

public class WarlockHeroBuilder implements HeroBuilder {
	public Hero hero;

	public 			WarlockHeroBuilder( ) {
		this.hero = new Hero();
	}

	public void		buildHeroName( String name ) {
		this.hero.setHeroName( name );
	}

	public void 	buildHeroClass(  ) {
		this.hero.setHeroClass( "WarlockHero" );
	}

	public void 	buildHeroLevel( ) {
		this.hero.setHeroLevel( 10 );
	}

	public void 	buildHeroExperience( ) {
		this.hero.setHeroExperience( 3000 );
	}

	public void 	buildHeroAttack( ) {
		this.hero.setHeroAttack( 140 );
	}

	public void 	buildHeroDefense( ) {
		this.hero.setHeroDefense( 100 );
	}

	public void 	buildHitPoints( ) {
		this.hero.setHeroHitPoints( 1150 );
	}

	public Hero 	getHero( ) {
		return ( this.hero );
	}
}