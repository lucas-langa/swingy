package za.co.wethinkcode.model.heroes;

public class TankHeroBuilder implements HeroBuilder {
	public Hero hero;

	public 			TankHeroBuilder( ) {
		this.hero = new Hero();
	}

	public void		buildHeroName( String name ) {
		this.hero.setHeroName( name );
	}

	public void 	buildHeroClass(  ) {
		this.hero.setHeroClass( "Tank" );
	}

	public void 	buildHeroLevel( ) {
		this.hero.setHeroLevel( 0 );
	}

	public void 	buildHeroExperience( ) {
		this.hero.setHeroExperience( 0 );
	}

	public void 	buildHeroAttack( ) {
		this.hero.setHeroAttack( 7 );
	}

	public void 	buildHeroDefense( ) {
		this.hero.setHeroDefense( 15 );
	}

	public void 	buildHitPoints( ) {
		this.hero.setHeroHitPoints( 200 );
	}

	public Hero 	getHero( ) {
		return ( this.hero );
	}
}