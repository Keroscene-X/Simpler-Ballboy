package ballboy.model;

public class LeftRightMovementFactory extends MovementFactory{
    @Override
    public LeftRightMovement createMovement() {
        LeftRightMovement leftRight = new LeftRightMovement();
        return leftRight;
    }
}
