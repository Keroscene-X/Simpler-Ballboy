package ballboy.model;

import javafx.scene.image.Image;

public abstract class EntityFactory {
    public abstract Entity createEntity(String image, double XPos, double YPos);
}
