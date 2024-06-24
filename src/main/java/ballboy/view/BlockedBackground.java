package ballboy.view;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;
import ballboy.model.GameEngine;

public class BlockedBackground implements BackgroundDrawer {
    private Rectangle sky;
    private Rectangle floor;
    private Pane pane;
    private GameEngine model;

    @Override
    public void draw(GameEngine model, Pane pane) {
        this.model = model;
        this.pane = pane;

        double width = model.getCurrentLevel().getLevelWidth();
        double height = model.getCurrentLevel().getLevelHeight();
        double floorHeight = model.getCurrentLevel().getFloorHeight();

        sky = new Rectangle(0, 0, width, floorHeight);
        sky.setFill(Paint.valueOf("LIGHTBLUE"));
        sky.setViewOrder(1000.0);

        floor = new Rectangle(0, floorHeight, width, height - floorHeight);
        floor.setFill(Paint.valueOf("LIGHTBLUE"));
        floor.setViewOrder(1000.0);

        pane.getChildren().addAll(sky, floor);
    }

    @Override
    public void update(double xViewportOffset, double yViewportOffset) {
        // do nothing since this is a static bg
    }
}
