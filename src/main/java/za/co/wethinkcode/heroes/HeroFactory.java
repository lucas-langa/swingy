package za.co.wethinkcode.heroes;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

// @Entity
public abstract class HeroFactory {
	public static Hero newHero( @NotNull @NotBlank String name, @NotNull @NotBlank String heroClass ) {
		Hero userHero = null;
		HeroEngineer heroEngineer = null;
		if (heroClass == "flank" ) {
			heroEngineer = new HeroEngineer( new FlankHeroBuilder() );
			heroEngineer.makeHero( name );
			userHero = heroEngineer.getHero();
		} else if (heroClass == "damage" ) {
			heroEngineer = new HeroEngineer( new DamageHeroBuilder() );
			heroEngineer.makeHero( name );
			userHero = heroEngineer.getHero();
		} else if (heroClass == "tank") {
			heroEngineer = new HeroEngineer( new TankHeroBuilder() );
			heroEngineer.makeHero( name );
			userHero = heroEngineer.getHero();
		}
		return ( userHero );
	}
}