package ballboy.model;

import javafx.scene.image.Image;

public class largeHeroFactory extends HeroFactory{
    @Override
    public largeHero createEntity(String heroImage, double XPos, double YPos) {
        largeHero largeHero = new largeHero(heroImage,XPos,YPos);
        return largeHero;
    }
}
