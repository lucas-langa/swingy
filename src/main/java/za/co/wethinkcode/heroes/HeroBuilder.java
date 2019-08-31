package za.co.wethinkcode.heroes;

public interface HeroBuilder {
	public void 		buildHeroName( String name );
	public void 		buildHeroClass();
	public void 		buildHeroLevel();
	public void 		buildHeroExperience();
	public void 		buildHeroAttack();
	public void 		buildHeroDefense();
	public void 		buildHitPoints();
	public Hero 		getHero();
}

