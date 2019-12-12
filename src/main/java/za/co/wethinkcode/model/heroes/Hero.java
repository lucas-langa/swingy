package za.co.wethinkcode.model.heroes;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import java.io.Serializable;

@Entity
@Table(name = "heroes")
public class Hero implements Serializable, HeroStats {

	private static final long 		serialVersionUID = 1L;

    // @Id
	// public Long getId() { return id; }
	public void setId(Integer heroID) { this.heroID = heroID;}
	/*useless*/
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="heroID")
    private Integer heroID;

	@NotNull(message = "hero name Should not be null")
    @Size(message = "hero name should be at least 3 characters long",min = 3, max = 15)
	@NotBlank(message = "You cannot have a blank hero name")
	private String					heroName;
	@NotNull(message = "hero class can't be null, Not funny ")
	@NotBlank(message = "hero class Should not be blank")
	private String					heroClass;
	private int						heroLevel;
	private int						heroExperience;
	private int						heroAttack;
	private int						heroDefense;
	private int						heroHitPoints;


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

	public void 		setHeroHitPoints( int hitPoints ) {
		this.heroHitPoints = hitPoints;
	}

	
	public Integer getId() {
		return heroID;
	}

	@Override
	public	String 		toString( ) {
		String things = " this level " + this.getHeroLevel() + " so much xp " + this.getHeroExperience() + " deals " + this.getHeroAttack() + " much damage and has this many defense points " + this.getHeroDefense();
		return ( "Lo!,behold , i am " + this.getHeroName() + " of class " + this.getHeroClass() + " sitting at this health pool " + this.getHeroHitPoints() + things );
	}

	public String getHeroName() {
		return heroName;
	}

	public String getHeroClass() {
		return heroClass;
	}

	public int getHeroLevel() {
		return heroLevel;
	}

	public int getHeroExperience() {
		return heroExperience;
	}

	public int getHeroAttack() {
		return heroAttack;
	}

	public int getHeroDefense() {
		return heroDefense;
	}

	public int getHeroHitPoints() {
		return heroHitPoints;
	}
}
