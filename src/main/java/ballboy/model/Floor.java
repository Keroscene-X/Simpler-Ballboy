package ballboy.model;

import javafx.scene.image.Image;

public class Floor implements Entity{

    private Image floorImage;
    private double xPos;
    private double yPos;

    Floor(String floorImage, double xPos, double yPos){
        this.floorImage = new Image(floorImage,100,100,true,true);
        this.xPos = xPos;
        this.yPos = yPos;

    }
    @Override
    public Image getImage() {
        return floorImage;
    }

    @Override
    public double getXPos() {
        return xPos;
    }

    @Override
    public double getYPos() {
        return yPos;
    }

    @Override
    public double getHeight() {
        return floorImage.getHeight();
    }

    @Override
    public double getWidth() {
        return floorImage.getWidth();
    }

    @Override
    public Layer getLayer() {
        return Layer.FOREGROUND;
    }

    @Override
    public void tick() {

    }
}
