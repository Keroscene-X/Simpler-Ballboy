package ballboy.model;

public class RunAwayMovementFactory extends MovementFactory{
    @Override
    public RunAwayMovement createMovement() {
        RunAwayMovement runaway = new RunAwayMovement();
        return runaway;
    }
}
