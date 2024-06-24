package ballboy.model;

import javafx.scene.image.Image;

public class Cloud implements Entity {

    private Image cloudImage;
    private double xPos;
    private double yPos;
    private String imagePath;

    Cloud(String cloudImage, double xPos, double yPos){
        this.cloudImage = new Image(cloudImage,50,50,true,true);
        this.xPos = xPos;
        this.yPos = yPos;
        imagePath = cloudImage;

    }
    @Override
    public Image getImage() {
        return cloudImage;
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
        return cloudImage.getHeight();
    }

    @Override
    public double getWidth() {
        return cloudImage.getWidth();
    }

    public void setWidth(double width){
        this.cloudImage = new Image(imagePath,width,getHeight(),false,true);
    }

    public void setHeight(double height){
        this.cloudImage = new Image(imagePath,getWidth(),height,false,true);
    }

    @Override
    public Layer getLayer() {
        return Layer.BACKGROUND;
    }

    @Override
    public void tick() {
        xPos += 0.1;
    }
}
