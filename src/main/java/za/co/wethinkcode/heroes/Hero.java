package za.co.wethinkcode.heroes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;


@Entity
@Table( name = "heroes" )
public class Hero implements Serializable, HeroStats {

	private static final long 		serialVersionUID = 1L;

    @Id
    @Column(name="id")
    private Integer id;

    @Size(min = 3, max = 15)
	@Column( name = "heroName")
	private String					heroName;

	@Column( name = "heroClass")
	private String					heroClass;
	@Column( name = "heroLevel")
	private int						heroLevel;
	@Column( name= "heroExperience")
	private int						heroExperience;
	@Column( name = "heroAttack")
	private int						heroAttack;
	@Column( name="heroDefense" )
	private int						heroDefense;
	@Column( name = "heroHitPoints" )
	private int						heroHitPoints;

	public void setId(Integer id) { this.id = id;}

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

	@NotNull
	public Integer getId() {
		return id;
	}

	@Override
	public	String 		toString( ) {
		String things = " this level " + this.getHeroLevel() + " so much xp " + this.getHeroExperience() + " deals " + this.getHeroAttack() + " much damage and has this many defense points " + this.getHeroDefense();
		return ( "Lo!,behold , i am " + this.getHeroName() + " of class " + this.getHeroClass() + " sitting at this health pool " + this.getHeroHitPoints() + things );
	}

	@NotNull
	public String getHeroName() {
		return heroName;
	}
	@NotNull
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