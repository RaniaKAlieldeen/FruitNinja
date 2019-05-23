package Controller;

import Controller.GameEngine.Level;
import Player.Player;
import java.sql.Time;
import java.util.ArrayList;

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
import javafx.scene.control.Label;
import javafx.scene.control.Labeled;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Game extends Application {

	 static  Level level;
	public Player getPlayer() {
		return player;
	}



	public void setPlayer(Player player) {
		this.player = player;
	}

	static 	Timeline  timeline1 ;
	static 	Timeline  timeline ;
	static 	Timeline  timeline3 ;
	Player player = new Player();
	Stage s;
	Main game;
	ArrayList<Label> Alllabes;
	Group root = new Group();
	Image background = new Image(getClass().getResource("background.gif").toExternalForm());

	public static void main(String[] args) {
	
		launch(args);
	}



	public Game() {
	
		timeline1.play();
		timeline.play();
		timeline3.play();
		timeline3.setCycleCount(Animation.INDEFINITE);
		timeline1.setCycleCount(Animation.INDEFINITE);	
		timeline.setCycleCount(Animation.INDEFINITE);
	}	
	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub


		
		
		GameEngine.getInstance(level, player).setMYcounter();
		Alllabes = GameEngine.getInstance(level, player).CreateLabels();
		GameEngine.getInstance(level,player).EndGameFlag=1;
		GameEngine.getInstance(level, player).SelectNumberOfLives();
		
		
		
		Scene scene = new Scene(root, 1400, 1000);

		
		primaryStage.setScene(scene);
		Canvas canvas = new Canvas(1000, 1000);

	
		
		root.getChildren().addAll(Alllabes);
		root.getChildren().add(canvas);
		GraphicsContext gc = canvas.getGraphicsContext2D();
	
 timeline1 = new Timeline(new KeyFrame(new Duration(1000), ActionEvent -> {
			GameEngine.getInstance(level, player).setCounter(GameEngine.getInstance(level, player).getcounter() - 1);
			System.out.println(GameEngine.getInstance(level, player).getcounter());

			s = primaryStage;

		}));

		 timeline = new Timeline(new KeyFrame(new Duration(1000), ActionEvent -> {

			GameEngine.getInstance(level, player).createGameObject();

		}));
		timeline1.setCycleCount(Animation.INDEFINITE);

	

		timeline.setCycleCount(Animation.INDEFINITE);

		scene.setOnMouseClicked(new EventHandler<MouseEvent>() {
			public void handle(MouseEvent e) {

				GameEngine.getInstance(level, player).select(e);

			}
		});

new AnimationTimer(){

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
				GameEngine.getInstance(level, player).SetText(Alllabes);
				GameEngine.getInstance(level, player).Doclose(GameEngine.getInstance(level, player).endAll(),s);
			}
		}.start();

		 timeline3 = new Timeline(new KeyFrame(new Duration(10), ActionEvent -> {
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
				GameEngine.getInstance(level, player).SetText(Alllabes);
				GameEngine.getInstance(level, player).Doclose(GameEngine.getInstance(level, player).endAll(),s);
			}));
	
		primaryStage.show();
	}




	public ArrayList<Label> getAlllabes() {
		return Alllabes;
	}



	public void setAlllabes(ArrayList<Label> alllabes) {
		Alllabes = alllabes;
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
