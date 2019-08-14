package za.co.wethinkcode.heroes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;


@Entity
@Table( name = "heroes" )
public class Hero implements Serializable, HeroStats {
	private static final long 		serialVersionUID = 1L;

    @Id
    @Column(name="id")
    private Integer id;

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }
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