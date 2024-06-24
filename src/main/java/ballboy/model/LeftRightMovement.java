package ballboy.model;

public class LeftRightMovement implements MovementStrategy{
    @Override
    public void move(Enemy enemy, Hero hero, long tickCount) {
        int count = (int) (tickCount / 300);
        if (count%2 != 0){
            enemy.setXVel(0.5);
        }
        else {
            enemy.setXVel(-0.5);
        }
    }
}
