package ballboy.model;

public interface Hero extends Entity {
    void setXVel(double xVel);

    void setYVel(double yVel);

    void setXAcc(double xAcc);
    void setYAcc(double yAcc);
    void stop();

    void setXPos(double xPos);
    void setYPos(double yPos);
    void invertAcc();
    void reset();
}
