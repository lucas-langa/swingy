package za.co.wethinkcode.Enemies;

public class WeakEnemyBuilder implements EnemyBuilder {
    public Enemy enemy;

    public   WeakEnemyBuilder() {
        this.Enemy = new Enemy();
    }

    public void		buildEnemyName( String name ) {
        this.Enemy.setEnemyName( name );
    }

    public void 	buildEnemyClass(  ) {
        this.Enemy.setEnemyClass( "Villain" );
    }

    public void 	buildEnemyLevel( ) {
        this.Enemy.setEnemyLevel( 20 );
    }

    public void 	buildEnemyExperience( ) {
        this.Enemy.setEnemyExperience( 30 );
    }

    public void 	buildEnemyAttack( ) {
        this.Enemy.setEnemyAttack( 17 );
    }

    public void 	buildEnemyDefense( ) {
        this.Enemy.setEnemyDefense( 25 );
    }

    public void 	buildHitPoints( ) {
        this.Enemy.setHitPoints( 200 );
    }

    public Enemy 	getEnemy( ) {
        return ( this.Enemy );
    }
}
