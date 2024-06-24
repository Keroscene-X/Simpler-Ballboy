package ballboy.model;

import javafx.scene.image.Image;

public class Enemy implements Entity{

    private Image enemyImage;
    private double xPos;
    private double yPos;
    private double xVel = 0;
    private double yVel = 0;
    private double xAcc = 0;
    private double yAcc = 0;
    private static final double topSpeed = 3;
    private double GRAVITYACC = 0.03;
    private double GRAVITYVEL = 1;
    private static final double GRAVITY = -2;
    private MovementStrategy ms;

    Enemy(String enemyImage, double XPos, double YPos){
        this.enemyImage = new Image(enemyImage,30,30,true,true);
        this.xPos = XPos;
        this.yPos = YPos;
    }

    public void setMovementStrategy(MovementStrategy ms){
        this.ms =ms;
    }

    public void setXVel(double xVel) {
        this.xVel = xVel;
    }


    public void setYVel(double yVel) {
        this.yVel = yVel;
    }


    public void setXAcc(double xAcc) {
        this.xAcc = xAcc;
    }


    public void setYAcc(double yAcc) {
        this.yAcc  =yAcc;
    }


    public void setXPos(double xPos) {
        this.xPos = xPos;
    }


    public void setYPos(double yPos) {
        this.yPos = yPos;
    }

    @Override
    public Image getImage() {
        return enemyImage;
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
        return enemyImage.getHeight();
    }

    @Override
    public double getWidth() {
        return enemyImage.getWidth();
    }

    @Override
    public Layer getLayer() {
        return Layer.FOREGROUND;
    }

    public void stop(){
        this.xAcc = 0;
        this.xVel = 0;
        this.yAcc = 0;
        this.yVel = 0;
    }

    @Override
    public void tick() {
        xPos += xVel;
        yPos += yVel + GRAVITYVEL;
    }

    public void think(Hero hero,long tickCount) {
        ms.move(this,hero,tickCount);
    }
}
