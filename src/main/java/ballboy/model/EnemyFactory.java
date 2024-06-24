package ballboy.model;

public class EnemyFactory extends EntityFactory{
    @Override
    public Enemy createEntity(String enemyImage, double XPos, double YPos) {
        Enemy enemy = new Enemy(enemyImage,XPos,YPos);
        return enemy;
    }
}
