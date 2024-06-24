package ballboy.model;

import javafx.scene.image.Image;

public class mediumHeroFactory extends HeroFactory{
    @Override
    public mediumHero createEntity(String heroImage, double XPos, double YPos) {
        mediumHero mediumHero = new mediumHero(heroImage,XPos,YPos);
        return mediumHero;
    }
}
