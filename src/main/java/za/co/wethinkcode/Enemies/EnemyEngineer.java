package za.co.wethinkcode.Enemies;

public class EnemyEngineer {
    private EnemyBuilder EnemyBuilder;

    public EnemyEngineer( EnemyBuilder EnemyBuilder ) {
        this.EnemyBuilder = EnemyBuilder;
    }

    public Enemy 		getEnemy() {
        return ( this.EnemyBuilder.getEnemy() );
    }

    public void 		makeEnemy( String name ) {
        this.EnemyBuilder.buildEnemyName( name );
        this.EnemyBuilder.buildEnemyClass();
        this.EnemyBuilder.buildEnemyLevel();
        this.EnemyBuilder.buildEnemyExperience();
        this.EnemyBuilder.buildEnemyAttack();
        this.EnemyBuilder.buildEnemyDefense();
        this.EnemyBuilder.buildHitPoints();
    }
}
