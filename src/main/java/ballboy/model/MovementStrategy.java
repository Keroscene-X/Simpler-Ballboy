package ballboy.model;

public interface MovementStrategy {

    void move(Enemy enemy, Hero hero, long tickCount);
}
