package ballboy.model;

import java.util.HashMap;
import java.util.Map;

public class EntityRegistry {
    private Map<String, EntityFactory> factories;

    public EntityRegistry(){
        factories = new HashMap<>();
        factories.put("small",new smallHeroFactory());
        factories.put("cloud", new CloudFactory());
        factories.put("floor", new FloorFactory());
        factories.put("medium", new mediumHeroFactory());
        factories.put("large", new largeHeroFactory());
        factories.put("step", new StepFactory());
        factories.put("finishing", new FinishingEntityFactory());
        factories.put("enemy", new EnemyFactory());
    }
    public void registerFactory(EntityFactory factory, String identifier) {
        factories.put(identifier,factory);
    }

    public EntityFactory getFactory(String identifier) {
        EntityFactory entityFactory = factories.get(identifier);
        return entityFactory;
    }
}
