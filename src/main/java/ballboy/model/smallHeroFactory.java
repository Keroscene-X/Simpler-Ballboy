package ballboy.model;

import javafx.scene.image.Image;

public class smallHeroFactory extends HeroFactory{
    @Override
    public smallHero createEntity(String heroImage, double XPos, double YPos) {
        smallHero smallHero = new smallHero(heroImage,XPos,YPos);
        return smallHero;
    }
}
