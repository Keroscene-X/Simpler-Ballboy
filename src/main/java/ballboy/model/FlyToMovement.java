package ballboy.model;

public class FlyToMovement implements MovementStrategy{
    @Override
    public void move(Enemy enemy, Hero hero, long tickCount) {
        double xOffset = hero.getXPos() - enemy.getXPos();
        double yOffset = hero.getYPos() - enemy.getYPos();
        if (xOffset > 0){
            enemy.setXVel(0.5);
        }
        else{
            enemy.setXVel(-0.5);
        }

        if (yOffset > 0){
            enemy.setYVel(-0.5);
        }
        else{
            enemy.setYVel(-1.5);
        }
    }
}
