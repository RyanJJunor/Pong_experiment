package sample;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.*;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.awt.*;

public class Main extends Application {

    boolean leftGoUp, leftGoDown, rightGoUp, rightGoDown;
    boolean release = false;

    @Override
    public void start(Stage primaryStage) throws Exception {

        Pane root = new Pane();

        Paddle paddle1 = new Paddle(1);
        Paddle paddle2 = new Paddle(2);

        Ball ball = new Ball(paddle1);


        root.getChildren().add(paddle1.getRect());
        root.getChildren().add(paddle2.getRect());
        root.getChildren().add(ball.getBall());


        root.setOnKeyPressed(new EventHandler<KeyEvent>() {

        @Override
        public void handle(KeyEvent event) {
            if (event.getCode() == KeyCode.W){
                leftGoUp = true;
            }
            if (event.getCode() == KeyCode.S){
                leftGoDown = true;
            }
            if (event.getCode() == KeyCode.UP){
                rightGoUp = true;
            }
            if (event.getCode() == KeyCode.DOWN){
                rightGoDown = true;
            }
            if (event.getCode() == KeyCode.SPACE){
                release = true;
            }
        }
    });

        root.setOnKeyReleased(new EventHandler<KeyEvent>() {

            @Override
            public void handle(KeyEvent event) {
                if (event.getCode() == KeyCode.W){
                    leftGoUp = false;
                }
                if (event.getCode() == KeyCode.S){
                    leftGoDown = false;
                }
                if (event.getCode() == KeyCode.UP){
                    rightGoUp = false;
                }
                if (event.getCode() == KeyCode.DOWN){
                    rightGoDown = false;
                }
                if (event.getCode() == KeyCode.SPACE){
                    //release = false;
                }
            }
        });


        root.setMaxSize(1280,720);
        root.setStyle("-fx-background-color: black; -fx-border-width: 5; -fx-border-color: white");
        primaryStage.setTitle("Pong");
        primaryStage.setScene(new Scene(root, 1280, 720));
        primaryStage.setResizable(false);
        primaryStage.show();
        root.requestFocus();


        AnimationTimer timer = new AnimationTimer() {
            @Override
            public void handle(long now) {


                if (leftGoUp) {
                    if ((paddle1.getRect().getTranslateY()) > -305) {
                        paddle1.getRect().setTranslateY(paddle1.getRect().getTranslateY() - 5);
                    }
                }
                if (leftGoDown) {
                    if ((paddle1.getRect().getTranslateY()) < 315) {
                        paddle1.getRect().setTranslateY(paddle1.getRect().getTranslateY() + 5);
                    }
                }
                if (rightGoUp) {
                    if ((paddle2.getRect().getTranslateY()) > -305) {
                        paddle2.getRect().setTranslateY(paddle2.getRect().getTranslateY() - 5);
                    }
                }
                if (rightGoDown) {
                    if ((paddle2.getRect().getTranslateY()) < 315) {
                        paddle2.getRect().setTranslateY(paddle2.getRect().getTranslateY() + 5);
                    }
                }

                if (!release) {
                    ball.getBall().setCenterY(ball.getPaddle().getRect().getTranslateY() + 360);
                    System.out.println(paddle2.getRect().getTranslateY()+305);
                }

                if (release) {

                    ball.moveBall();
                    System.out.println(ball.getBall().getCenterY());
                }

                if (ball.getBall().getCenterY() <= 10) {
                    ball.setMovementV(ball.getMovementV() * -1);
                }

                if (ball.getBall().getCenterY() >= 710) {
                    ball.setMovementV(ball.getMovementV() * -1);
                }

                if (ball.getBall().getCenterX() <= paddle1.getRect().getLayoutX()+39 && ball.getBall().getCenterY() <= paddle1.getRect().getTranslateY()+405 && ball.getBall().getCenterY() >= paddle1.getRect().getTranslateY()+305) {
                    ball.setMovementH(ball.getMovementH() * -1);
                }

                if (ball.getBall().getCenterX() >= paddle2.getRect().getLayoutX()-9 && ball.getBall().getCenterY() <= paddle2.getRect().getTranslateY()+405 && ball.getBall().getCenterY() >= paddle2.getRect().getTranslateY()+305) {
                    ball.setMovementH(ball.getMovementH() * -1);
                }


            }

        };

        timer.start();


    }

    public static void main(String[] args) {
        launch(args);
    }
}
