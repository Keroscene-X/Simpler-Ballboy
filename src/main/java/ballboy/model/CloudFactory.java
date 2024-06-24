package ballboy.model;

public class CloudFactory extends EntityFactory{
    @Override
    public Cloud createEntity(String image, double XPos, double YPos) {
        Cloud cloud = new Cloud(image,XPos,YPos);
        return cloud;
    }
}
