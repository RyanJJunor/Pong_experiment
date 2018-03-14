package sample;

import javafx.scene.shape.Circle;

/**
 * Created by Ryan on 08/06/2017.
 */
public class Ball {

    int radius = 10;
    private Circle ball = new Circle();
    private double movementV = 4.2;
    private double movementH = 4.2;
    private Paddle paddle;
    private int rndm;

    Ball(Paddle paddle){

        this.paddle = paddle;

        rndm = (int) (Math.random()*2) +1;

        if (getPaddle().getRect().getLayoutX() < 70){

            getBall().setRadius(radius);
            getBall().setCenterX(paddle.getRect().getLayoutX()+40);
            getBall().setCenterY(paddle.getRect().getLayoutY()+50);

        }
        else{
            getBall().setRadius(radius);
            getBall().setCenterX(paddle.getRect().getLayoutX()-10);
            getBall().setCenterY(paddle.getRect().getLayoutY()+50);
        }



        ball.setStyle("-fx-fill: white;");
    }

    public Circle getBall() {
        return ball;
    }

    public void setBall(Circle ball) {
        this.ball = ball;
    }

    public void moveBall(){



        if (rndm == 1){
            ball.setCenterX(ball.getCenterX()+ getMovementH());
            ball.setCenterY(ball.getCenterY()+ getMovementV());
        }
        else{
            ball.setCenterX(ball.getCenterX()+ getMovementH());
            ball.setCenterY(ball.getCenterY()+ -getMovementV());
        }

    }

    public double getMovementV() {
        return movementV;
    }

    public void setMovementV(double movementV) {
        this.movementV = movementV;
    }

    public double getMovementH() {
        return movementH;
    }

    public void setMovementH(double movementH) {
        this.movementH = movementH;
    }

    public Paddle getPaddle() {
        return paddle;
    }

    public void setPaddle(Paddle paddle) {
        this.paddle = paddle;
    }
}
