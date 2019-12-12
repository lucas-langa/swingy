package za.co.wethinkcode.model.heroes;

public class FlankHeroBuilder implements HeroBuilder {
	public Hero hero;

	public 			FlankHeroBuilder( ) {
		this.hero = new Hero();
	}

	public void		buildHeroName( String name ) {
		this.hero.setHeroName( name );
	}

	public void 	buildHeroClass(  ) {
		this.hero.setHeroClass( "Flank" );
	}

	public void 	buildHeroLevel( ) {
		this.hero.setHeroLevel( 0 );
	}

	public void 	buildHeroExperience( ) {
		this.hero.setHeroExperience( 0 );
	}

	public void 	buildHeroAttack( ) {
		this.hero.setHeroAttack( 15 );
	}

	public void 	buildHeroDefense( ) {
		this.hero.setHeroDefense( 6 );
	}

	public void 	buildHitPoints( ) {
		this.hero.setHeroHitPoints( 100 );
	}

	public Hero 	getHero( ) {
		return ( this.hero );
	}
}