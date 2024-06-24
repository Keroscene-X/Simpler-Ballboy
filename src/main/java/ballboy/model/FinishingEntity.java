package ballboy.model;

import javafx.scene.image.Image;

public class FinishingEntity implements Entity {

    private Image entityImage;
    private double xPos;
    private double yPos;
    private String imagePath;

    FinishingEntity(String entityImage, double xPos, double yPos){
        this.entityImage = new Image(entityImage,50,50,true,true);
        this.xPos = xPos;
        this.yPos = yPos;
        imagePath = entityImage;

    }
    @Override
    public Image getImage() {
        return entityImage;
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
        return entityImage.getHeight();
    }

    @Override
    public double getWidth() {
        return entityImage.getWidth();
    }

    public void setWidth(double width){
        this.entityImage = new Image(imagePath,width,getHeight(),false,true);
    }

    public void setHeight(double height){
        this.entityImage = new Image(imagePath,getWidth(),height,false,true);
    }

    @Override
    public Layer getLayer() {
        return Layer.FOREGROUND;
    }

    @Override
    public void tick() {
    }
}
