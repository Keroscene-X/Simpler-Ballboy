package ballboy.model;

import javafx.scene.image.Image;

public class Step implements Entity{

    private Image stepImage;
    private double xPos;
    private double yPos;
    private String imagePath;

    Step(String stepImage, double xPos, double yPos){
        this.stepImage = new Image(stepImage,50,50,true,true);
        imagePath = stepImage;
        this.xPos = xPos;
        this.yPos = yPos;

    }
    @Override
    public Image getImage() {
        return stepImage;
    }

    @Override
    public double getXPos() {
        return xPos-30;
    }

    @Override
    public double getYPos() {
        return yPos;
    }

    @Override
    public double getHeight() {
        return stepImage.getHeight();
    }

    @Override
    public double getWidth() {
        return stepImage.getWidth();
    }

    @Override
    public Layer getLayer() {
        return Layer.FOREGROUND;
    }

    public void setWidth(double width){
        this.stepImage = new Image(imagePath,width,getHeight(),false,true);
    }
    public void setHeight(double height){
        this.stepImage = new Image(imagePath,getWidth(),height,false,true);
    }

    @Override
    public void tick() {

    }
}
