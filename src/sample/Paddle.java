package sample;

import javafx.scene.shape.Rectangle;

/**
 * Created by Ryan on 08/06/2017.
 */
public class Paddle {

    int width = 30;
    int height = 100;
    private int xPos = 0;
    private int yPos = 0;
    public Rectangle rect = new Rectangle();


    public Paddle(int num){

        if (num == 1){

            setxPos(35);
            setyPos(310);
        }
        if (num == 2) {
            setxPos(1225);
            setyPos(310);
        }


        rect.scaleXProperty();
        rect.scaleYProperty();
        rect.setWidth(width);
        rect.setHeight(height);
        rect.setLayoutX(xPos);
        rect.setLayoutY(yPos);
        rect.setStyle("-fx-fill: white");

    }

    public int getxPos() {
        return xPos;
    }

    public void setxPos(int xPos) {
        this.xPos = xPos;
    }

    public int getyPos() {
        return yPos;
    }

    public void setyPos(int yPos) {
        this.yPos = yPos;
    }

    public Rectangle getRect() {
        return rect;
    }

    public void setRect(Rectangle rect) {
        this.rect = rect;
    }
}
