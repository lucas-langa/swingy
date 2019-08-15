package za.co.wethinkcode.Enemy;

public interface EnemyBuilder {
    public void 		EnemyName( String name );
    public void 		buildEnemyClass();
    public void 		buildEnemyLevel();
    public void 		buildEnemyExperience();
    public void 		buildEnemyAttack();
    public void 		buildEnemyDefense();
    public void 		buildHitPoints();
    public Enemy 		getEnemy();
}

