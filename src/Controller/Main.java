package Controller;

import java.awt.Button;
import java.awt.Image;
import java.awt.event.ActionEvent;

import javax.swing.text.html.ImageView;

import org.graalvm.compiler.phases.common.NodeCounterPhase.Stage;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;

public class Main extends Application implements EventHandler<ActionEvent> {

    Stage s1;
    Image easyImage = new Image(getClass().getResource("Easy.jpg").toExternalForm());
    Image medImage = new Image(getClass().getResource("medium.jpg").toExternalForm());
    Image hardImage = new Image(getClass().getResource("hard.jpg").toExternalForm());
    Image arcadeImage = new Image(getClass().getResource("Arcade1.jpg").toExternalForm());
    Button Easy = new Button();
    Image[] images = new Image[5];
    ImageView[] imagesViews = new ImageView[5];

    Button meduim = new Button();
    Button hard = new Button();
    Button arcade = new Button();

    @Override
    public void start(Stage primaryStage) {
        Pane p = new Pane();
        setImages();
        int randomNumber = (int) (Math.random() * (5));

        Easy.setGraphic(new ImageView(easyImage));
        meduim.setGraphic(new ImageView(medImage));
        hard.setGraphic(new ImageView(hardImage));
        arcade.setGraphic(new ImageView(arcadeImage));
        actionlist();
        System.out.println("Ddd");

        ImageView Image = new ImageView(getClass().getResource("mainbackground.gif").toExternalForm());

        Easy.setLayoutX(50);
        Easy.setLayoutY(100);
        meduim.setLayoutX(350);
        meduim.setLayoutY(100);
        hard.setLayoutX(650);
        hard.setLayoutY(100);
        arcade.setLayoutX(950);
        arcade.setLayoutY(100);

        p.getChildren().add(imagesViews[randomNumber]);
        p.getChildren().add(Easy);
        p.getChildren().add(meduim);
        p.getChildren().add(hard);
       p.getChildren().add(arcade);
        Scene scene = new Scene(p, images[randomNumber].getWidth(), images[randomNumber].getHeight());
        primaryStage.setScene(scene);
        primaryStage.show();

        s1 = primaryStage;

    }

    public static void main(String[] args) {

        launch(args);
    }

    @Override
    public void handle(ActionEvent event) {
        if (event.getSource() == meduim) {
            s1.close();
            Game game = new Game();
            try {
                game.setLevel(GameEngine.Level.MEDIUM);
                game.start(new Stage());

                System.out.print("Ff");
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

        }
        if (event.getSource() == Easy) {

            s1.close();
            Game game = new Game();
            try {
                game.setLevel(GameEngine.Level.EASY);
                game.start(new Stage());

                System.out.print("Ff");
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

        }
        if (event.getSource() == hard) {

            s1.close();
            Game game = new Game();
            try {
                game.setLevel(GameEngine.Level.HARD);
                game.start(new Stage());

                System.out.print("Ff");
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

        }
        
              if (event.getSource() == arcade) {
            s1.close();
            Game game = new Game();
            try {
                game.setLevel(GameEngine.Level.ARCADE);
                game.start(new Stage());

                System.out.print("Ff");
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

        }
        
        
    }

    void actionlist() {

        Easy.setOnAction(this);
        meduim.setOnAction(this);
        hard.setOnAction(this);
        arcade.setOnAction(this);

    }

    void setImages() {

        images[0] = new Image(getClass().getResource("main1.gif").toExternalForm());
        images[1] = new Image(getClass().getResource("main3.gif").toExternalForm());
        images[2] = new Image(getClass().getResource("main4.gif").toExternalForm());
        images[3] = new Image(getClass().getResource("main5.gif").toExternalForm());
        images[4] = new Image(getClass().getResource("main5.gif").toExternalForm());
        imagesViews[0] = new ImageView(getClass().getResource("main1.gif").toExternalForm());
        imagesViews[1] = new ImageView(getClass().getResource("main3.gif").toExternalForm());
        imagesViews[2] = new ImageView(getClass().getResource("main4.gif").toExternalForm());
        imagesViews[3] = new ImageView(getClass().getResource("main5.gif").toExternalForm());
        imagesViews[4] = new ImageView(getClass().getResource("main5.gif").toExternalForm());
    }
}
