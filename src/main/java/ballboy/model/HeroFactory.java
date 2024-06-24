package ballboy.model;

public abstract class HeroFactory extends EntityFactory {
    @Override
    public abstract Hero createEntity(String heroImage, double XPos, double YPos);
}
