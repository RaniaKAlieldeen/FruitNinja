package Controller;



import java.io.ObjectInputStream.GetField;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Main 
extends Application implements EventHandler<ActionEvent>  {
	Stage s1;
	Image image =new Image(getClass().getResource("Easy.jpg").toExternalForm());
	Image image1 =new Image(getClass().getResource("medium.jpg").toExternalForm());
	Image image2 =new Image(getClass().getResource("hard.jpg").toExternalForm());
	Button Easy =new Button();
Image[] images = new Image[5];
ImageView[] imagesViews = new ImageView[5];

										
	Button meduim =new Button();
	Button hard =new Button();
	@Override
	public void  start(Stage primaryStage) {
		Pane p =new Pane();
		setImages();
		int randomNumber= (int)(Math.random() * (5));
		
		Easy.setGraphic(new ImageView(image));
		meduim.setGraphic(new ImageView(image1));
		hard.setGraphic(new ImageView(image2));
		actionlist();
	System.out.println("Ddd");

ImageView Image= new  ImageView(getClass().getResource("mainbackground.gif").toExternalForm());


Easy.setLayoutX(50);
Easy.setLayoutY(100);
meduim.setLayoutX(350);
		meduim.setLayoutY(100);
		hard.setLayoutX(650);
		hard.setLayoutY(100);
	
		p.getChildren().add(imagesViews[randomNumber]);
		p.getChildren().add(Easy);
		p.getChildren().add(meduim);
		p.getChildren().add(hard);
		Scene scene =new Scene (p,images[randomNumber].getWidth(),images[randomNumber].getHeight());
		primaryStage.setScene(scene);
		primaryStage.show();
		
		
		s1=primaryStage;
		
		
		
		
	}
	public static void  main (String[] args)
	{
		
		launch(args);
	}
	


	
	
	
	@Override
	public void handle(ActionEvent event) {
		if (event.getSource()==meduim)
		{
			s1.close();
			 Game game =new Game();
		try {
			
			game.start(new Stage());
			
			System.out.print("Ff");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

			
			
		}
		if (event.getSource()==Easy)
		{
			
			 s1.close();
			 Game game =new Game();
		try {
		
			game.start(new Stage());
			
			System.out.print("Ff");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
		}
		if (event.getSource()==hard)
		{
			
			 s1.close();
			 Game game =new Game();
		try {
			
			    
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
	
	
}
void setImages()
{
	
	
	
	images[0]=new Image(getClass().getResource("main1.gif").toExternalForm());
	images[1]=new Image(getClass().getResource("main3.gif").toExternalForm());
	images[2]=new Image(getClass().getResource("main4.gif").toExternalForm());
	images[3]=new Image(getClass().getResource("main5.gif").toExternalForm());
	images[4]=new Image(getClass().getResource("main5.gif").toExternalForm());
	imagesViews[0]=new ImageView(getClass().getResource("main1.gif").toExternalForm());
	imagesViews[1]=new ImageView(getClass().getResource("main3.gif").toExternalForm());
	imagesViews[2]=new ImageView(getClass().getResource("main4.gif").toExternalForm());
	imagesViews[3]=new ImageView(getClass().getResource("main5.gif").toExternalForm());
	imagesViews[4]=new ImageView(getClass().getResource("main5.gif").toExternalForm());
}
}


	