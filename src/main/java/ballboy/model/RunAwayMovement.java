package ballboy.model;

public class RunAwayMovement implements MovementStrategy{
    @Override
    public void move(Enemy enemy, Hero hero, long tickCount) {
        double xOffset = hero.getXPos() - enemy.getXPos();
        double yOffset = hero.getYPos() - enemy.getYPos();
        if((Math.abs(xOffset) <= 100)&&(Math.abs(yOffset) <= 100)){
            if(xOffset > 0){
                enemy.setXVel(-1.0);
            }
            else{
                enemy.setXVel(1.0);
            }
        }
        else{
            enemy.stop();
        }
    }
}
