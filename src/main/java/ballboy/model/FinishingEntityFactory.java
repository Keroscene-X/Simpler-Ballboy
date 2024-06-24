package ballboy.model;

public class FinishingEntityFactory extends EntityFactory{
    @Override
    public FinishingEntity createEntity(String image, double XPos, double YPos) {
        FinishingEntity finishingentity = new FinishingEntity(image,XPos,YPos);
        return finishingentity;
    }
}
