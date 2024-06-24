package ballboy.model;

import javafx.scene.image.Image;

public class smallHero implements Hero{

    private Image heroImage;
    private double xPos;
    private double yPos;
    private double initialXPos;
    private double initialYPos;
    private double xVel = 0;
    private double yVel = 0;
    private double xAcc = 0;
    private double yAcc = 0;
    private static final double topSpeed = 2;
    private double GRAVITYACC = 0.03;
    private double GRAVITYVEL = 1;
    private static final double GRAVITY = -2;

    smallHero(String heroImage, double XPos, double YPos){
        this.heroImage = new Image(heroImage,30,30,true,true);
        this.xPos = XPos;
        this.yPos = YPos;
        this.initialXPos = XPos;
        this.initialYPos = YPos;
    }
    @Override
    public Image getImage() {
        return heroImage;
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
        return heroImage.getHeight();
    }

    @Override
    public double getWidth() {
        return heroImage.getWidth();
    }

    @Override
    public Layer getLayer() {
        return Layer.FOREGROUND;
    }

    @Override
    public void setXVel(double xVel){
        this.xVel = xVel;
    }

    @Override
    public void setYVel(double yVel){
        this.yVel = yVel;
    }

    @Override
    public void setXAcc(double xAcc) {
        this.xAcc = xAcc;
    }

    @Override
    public void setYAcc(double yAcc) {
        this.yAcc = yAcc;
    }

    @Override
    public void stop() {
        xAcc = 0;
        xVel = 0;
    }

    @Override
    public void setXPos(double xPos) {
        this.xPos = xPos;
    }

    @Override
    public void setYPos(double yPos) {
        this.yPos = yPos;
    }

    @Override
    public void invertAcc(){
        if (GRAVITYVEL > 0){
            GRAVITYVEL = GRAVITY;
        }
        else if(GRAVITYVEL < 0){
            GRAVITYVEL = -GRAVITYVEL;
        }
    }

    @Override
    public void reset(){
        this.xPos = initialXPos;
        this.yPos = initialYPos;
    }

    @Override
    public void tick() {
        if (Math.abs(xVel) >= topSpeed){
            xAcc = 0;
        }
        if (Math.abs(yVel) >= topSpeed){
            yAcc = 0;
        }
        GRAVITYVEL += GRAVITYACC;
        xVel += xAcc;
        yVel += yAcc;
        xPos += xVel;
        yPos += yVel + GRAVITYVEL;

    }
}
