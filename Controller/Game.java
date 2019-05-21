package Controller;

import Controller.GameEngine.Level;
import Player.Player;
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

    private Level level;
  
    Image background = new Image(getClass().getResource("background.gif").toExternalForm());

    public static void main(String[] args) {

        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        // TODO Auto-generated method stub
    	
        Player player =  new Player();
        Group root = new Group();
        Scene scene = new Scene(root, 1000, 1000);
        GameEngine.getInstance(level, player).setMYcounter();
        primaryStage.setScene(scene);
        Canvas canvas = new Canvas(1000, 1000);
        root.getChildren().add(canvas);
        GraphicsContext gc = canvas.getGraphicsContext2D();

        Timeline timeline1 = new Timeline(new KeyFrame(new Duration(1000), ActionEvent -> {
        	GameEngine.getInstance(level, player).setCounter(GameEngine.getInstance(level, player).getcounter()-1);
            System.out.println(GameEngine.getInstance(level, player).getcounter());

        }));
        
        Timeline timeline = new Timeline(new KeyFrame(new Duration(7000), ActionEvent -> {

            GameEngine.getInstance(level, player).createGameObject();

        }));
        timeline1.setCycleCount(Animation.INDEFINITE);

        timeline1.play();

        timeline.setCycleCount(Animation.INDEFINITE);

        scene.setOnMouseClicked(
                new EventHandler<MouseEvent>() {
            public void handle(MouseEvent e) {

                GameEngine.getInstance(level, player).select(e);

            }
        }
        );

        new AnimationTimer() {

            @Override
            public void handle(long arg0) {
                // TODO Auto-generated method stub
                gc.clearRect(0, 0, 1000, 1000);
                if (GameEngine.getInstance(level, player).getcounter() > 0) {
                    timeline.play();
                }
                if (GameEngine.getInstance(level, player).getcounter() < 0) {
                    timeline.stop();

                }
                setBackground(gc);
                GameEngine.getInstance(level, player).move();
                GameEngine.getInstance(level, player).update();
                GameEngine.getInstance(level, player).render(gc);

            }
        }.start();

        primaryStage.setScene(scene);

        primaryStage.show();
    }

    public void setBackground(GraphicsContext gc) {
        gc.drawImage(background, 0, 0);

    }

    public Level getLevel() {
        return level;
    }

    public void setLevel(Level level) {
        this.level = level;
    }
    
    
}
