package za.co.wethinkcode.model.heroes;

public class AntiHeroBuilder implements HeroBuilder {
	public Hero hero;

	public 			AntiHeroBuilder( ) {
		this.hero = new Hero();
	}

	public void		buildHeroName( String name ) {
		this.hero.setHeroName( name );
	}

	public void 	buildHeroClass(  ) {
		this.hero.setHeroClass( "AntiHero" );
	}

	public void 	buildHeroLevel( ) {
		this.hero.setHeroLevel( 2 );
	}

	public void 	buildHeroExperience( ) {
		this.hero.setHeroExperience( 300 );
	}

	public void 	buildHeroAttack( ) {
		this.hero.setHeroAttack( 10 );
	}

	public void 	buildHeroDefense( ) {
		this.hero.setHeroDefense( 7 );
	}

	public void 	buildHitPoints( ) {
		this.hero.setHeroHitPoints( 300 );
	}

	public Hero 	getHero( ) {
		return ( this.hero );
	}
}