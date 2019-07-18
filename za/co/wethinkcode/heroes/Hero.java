package za.co.wethinkcode.heroes;

public class Hero implements HeroStats {
	private String		heroName;
	private String		heroClass;
	private int			heroLevel;
	private int			heroExperience;
	private int			heroAttack;
	private int			heroDefense;
	private int			heroHitPoints;

	public void 		setHeroName( String name ){
		this.heroName = name;
	}

	public void 		setHeroClass( String heroClass ) {
		this.heroClass = heroClass;
	}

	public void 		setHeroLevel( int level ) {
		this.heroLevel = level;
	}

	public void 		setHeroExperience( int experience ) {
		this.heroExperience = experience;
	}

	public void 		setHeroAttack( int attack ) {
		this.heroAttack = attack;
	}

	public void 		setHeroDefense( int defense ) {
		this.heroDefense = defense;
	}

	public void 		setHitPoints( int hitPoints ) {
		this.heroHitPoints = hitPoints;
	}

	@Override
	public	String 		toString( ) {
		String things = " this level " + this.heroLevel + " so much xp " + this.heroExperience + " deals " + this.heroAttack + " much damage and has this many defense points " + this.heroDefense;
		return ( "Lo!,behold , i am " + this.heroName + " of class " + this.heroClass + " sitting at this health pool " + this.heroHitPoints + things );
	}
}