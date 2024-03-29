package Controller1;

import Controller1.GameEngine.Level;
import java.sql.Time;

import javafx.animation.Animation;
import javafx.animation.AnimationTimer;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Game extends Application {

    Level level = Level.HARD;
    int counter = 30;
    Image background = new Image(getClass().getResource("background.gif").toExternalForm());

    public static void main(String[] args) {

        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        // TODO Auto-generated method stub
        Group root = new Group();
        Scene scene = new Scene(root, 1000, 1000);

        primaryStage.setScene(scene);
        Canvas canvas = new Canvas(1000, 1000);
        root.getChildren().add(canvas);
        GraphicsContext gc = canvas.getGraphicsContext2D();

        Timeline timeline1 = new Timeline(new KeyFrame(new Duration(1000), ActionEvent -> {
            counter--;
            System.out.println(counter);

        }));
        ;
        Timeline timeline = new Timeline(new KeyFrame(new Duration(3000), ActionEvent -> {

            GameEngine.getInstance(level, null).createGameObject();

        }));
        timeline1.setCycleCount(Animation.INDEFINITE);

        timeline1.play();

        timeline.setCycleCount(Animation.INDEFINITE);

        scene.setOnMouseClicked(
                new EventHandler<MouseEvent>() {
            public void handle(MouseEvent e) {

                GameEngine.getInstance(level, null).select(e);

            }
        }
        );

        new AnimationTimer() {

            @Override
            public void handle(long arg0) {
                // TODO Auto-generated method stub
                gc.clearRect(0, 0, 1000, 1000);
                if (counter > 0) {
                    timeline.play();
                }
                if (counter < 0) {
                    timeline.stop();

                }
                setBackground(gc);
                GameEngine.getInstance(level, null).move();
                GameEngine.getInstance(level, null).update();
                GameEngine.getInstance(level, null).render(gc);

            }
        }.start();

        primaryStage.setScene(scene);

        primaryStage.show();
    }

    public void setBackground(GraphicsContext gc) {
        gc.drawImage(background, 0, 0);

    }
}
