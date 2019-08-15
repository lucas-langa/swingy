package za.co.wethinkcode.Enemies;

public interface EnemyBuilder {
    public void 		buildEnemyName( String name );
    public void 		buildEnemyClass();
    public void 		buildEnemyLevel();
    public void 		buildEnemyExperience();
    public void 		buildEnemyAttack();
    public void 		buildEnemyDefense();
    public void 		buildHitPoints();
    public Enemy 		getEnemy();
}

