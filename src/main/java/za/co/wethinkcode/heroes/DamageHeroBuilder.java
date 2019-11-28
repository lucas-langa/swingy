package za.co.wethinkcode.heroes;

public class DamageHeroBuilder implements HeroBuilder {
	public Hero hero;

	public 			DamageHeroBuilder( ) {
		this.hero = new Hero();
	}

	public void		buildHeroName( String name ) {
		this.hero.setHeroName( name );
	}

	public void 	buildHeroClass(  ) {
		this.hero.setHeroClass( "Damage" );
	}

	public void 	buildHeroLevel( ) {
		this.hero.setHeroLevel( 0 );
	}

	public void 	buildHeroExperience( ) {
		this.hero.setHeroExperience( 0 );
	}

	public void 	buildHeroAttack( ) {
		this.hero.setHeroAttack( 13 );
	}

	public void 	buildHeroDefense( ) {
		this.hero.setHeroDefense( 8 );
	}

	public void 	buildHitPoints( ) {
		this.hero.setHeroHitPoints( 115 );
	}

	public Hero 	getHero( ) {
		return ( this.hero );
	}

}