package za.co.wethinkcode.heroes;

public class DemonHeroBuilder implements HeroBuilder {
	public Hero hero;

	public 			DemonHeroBuilder( ) {
		this.hero = new Hero();
	}

	public void		buildHeroName( String name ) {
		this.hero.setHeroName( name );
	}

	public void 	buildHeroClass(  ) {
		this.hero.setHeroClass( "DemonHero" );
	}

	public void 	buildHeroLevel( ) {
		this.hero.setHeroLevel( 7 );
	}

	public void 	buildHeroExperience( ) {
		this.hero.setHeroExperience( 2000 );
	}

	public void 	buildHeroAttack( ) {
		this.hero.setHeroAttack( 60 );
	}

	public void 	buildHeroDefense( ) {
		this.hero.setHeroDefense( 50 );
	}

	public void 	buildHitPoints( ) {
		this.hero.setHeroHitPoints( 600 );
	}

	public Hero 	getHero( ) {
		return ( this.hero );
	}
}