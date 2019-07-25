package za.co.wethinkcode.heroes;

public 	class HeroEngineer {

	private HeroBuilder heroBuilder;

	public HeroEngineer( HeroBuilder heroBuilder ) {
		this.heroBuilder = heroBuilder;
	}

	public Hero 		getHero() {
		return ( this.heroBuilder.getHero() );	
	}
	
	public void 		makeHero( String name ) {
		this.heroBuilder.buildHeroName( name );
		this.heroBuilder.buildHeroClass();
		this.heroBuilder.buildHeroLevel();
		this.heroBuilder.buildHeroExperience();
		this.heroBuilder.buildHeroAttack();
		this.heroBuilder.buildHeroDefense();
		this.heroBuilder.buildHitPoints();
	}
}