package ballboy.model;

import java.util.HashMap;
import java.util.Map;

public class MovementRegistry {
    private Map<String, MovementFactory> movement;

    public MovementRegistry(){
        movement = new HashMap<>();
        movement.put("leftright", new LeftRightMovementFactory());
        movement.put("flyto", new FlyToMovementFactory());
        movement.put("runaway", new RunAwayMovementFactory());
    }
    public void registerFactory(MovementFactory factory, String identifier) {
        movement.put(identifier,factory);
    }

    public MovementFactory getFactory(String identifier) {
        MovementFactory movementFactory = movement.get(identifier);
        return movementFactory;
    }
}
