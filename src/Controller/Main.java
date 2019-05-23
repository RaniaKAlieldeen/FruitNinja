



package Controller;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Main extends Application implements EventHandler<ActionEvent> {

     static  Stage s1;
    Image easyImage = new Image(getClass().getResource("Easy.jpg").toExternalForm());
    Image medImage = new Image(getClass().getResource("medium.jpg").toExternalForm());
    Image hardImage = new Image(getClass().getResource("hard.jpg").toExternalForm());
    Image arcadeImage = new Image(getClass().getResource("Arcade1.jpg").toExternalForm());
    Button Easy = new Button();
    Label backGround= new Label ();

    Button meduim = new Button();
    Button hard = new Button();
    Button arcade = new Button();

    @Override
    public  void start(Stage primaryStage) {
    	System.out.println("ana da5alt fel start ");
        Pane p = new Pane();
       
        
        int randomNumber = (int) (Math.random() * (5));

        Easy.setGraphic(new ImageView(easyImage));
        meduim.setGraphic(new ImageView(medImage));
        hard.setGraphic(new ImageView(hardImage));
        arcade.setGraphic(new ImageView(arcadeImage));
        actionlist();
        System.out.println("Ddd");

        ImageView Image = new ImageView(getClass().getResource("main0.gif").toExternalForm());
        Image Image1 = new Image(getClass().getResource("main0.gif").toExternalForm());
        

        Easy.setLayoutX(50);
        Easy.setLayoutY(100);
        meduim.setLayoutX(350);
        meduim.setLayoutY(100);
        hard.setLayoutX(650);
        hard.setLayoutY(100);
        arcade.setLayoutX(950);
        arcade.setLayoutY(100);

        p.getChildren().add(Image);
        p.getChildren().add(Easy);
        p.getChildren().add(meduim);
        p.getChildren().add(hard);
       p.getChildren().add(arcade);
        Scene scene = new Scene(p, Image1.getWidth(), Image1.getHeight());
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
                GameEngine.getInstance(game.getLevel(), game.getPlayer()).UpdateLevel();
                game.start(new Stage());

  
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
               GameEngine.getInstance(game.getLevel(), game.getPlayer()).UpdateLevel();
                game.start(new Stage());

                System.out.print("easy");
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
                GameEngine.getInstance(game.getLevel(), game.getPlayer()).UpdateLevel();
                game.start(new Stage());

                System.out.print("Hard");
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
                GameEngine.getInstance(game.getLevel(), game.getPlayer()).UpdateLevel();
                game.start(new Stage());

                System.out.print("arc");
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

        }
        
        
    }

    public  void actionlist() {

        Easy.setOnAction(this);
        meduim.setOnAction(this);
        hard.setOnAction(this);
        arcade.setOnAction(this);

    }


}