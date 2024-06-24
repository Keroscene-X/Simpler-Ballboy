package ballboy.model;

public class FloorFactory extends EntityFactory{
    @Override
    public Floor createEntity(String image, double XPos, double YPos) {
        Floor floor = new Floor(image,XPos,YPos);
        return floor;
    }
}
