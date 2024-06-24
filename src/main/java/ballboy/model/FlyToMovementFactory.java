package ballboy.model;

public class FlyToMovementFactory extends MovementFactory{
    @Override
    public FlyToMovement createMovement() {
        FlyToMovement flyTo = new FlyToMovement();
        return flyTo;
    }
}
