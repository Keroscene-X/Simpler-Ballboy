package ballboy.model;

public class StepFactory extends EntityFactory{
    @Override
    public Step createEntity(String image, double XPos, double YPos) {
        Step step = new Step(image,XPos,YPos);
        return step;
    }
}
