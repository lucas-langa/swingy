package za.co.wethinkcode.model.heroes;

public interface HeroStats {
	public void 		setHeroName( String name );
	public void 		setHeroClass( String heroClass );
	public void 		setHeroLevel( int level );
	public void 		setHeroExperience( int experience );
	public void 		setHeroAttack( int attack);
	public void 		setHeroDefense( int defense );
	public void 		setHeroHitPoints( int hitPoints );
}