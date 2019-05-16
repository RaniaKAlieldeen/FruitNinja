package project;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.stage.Stage;

public class Game extends Application {
 
 
	public static void main(String[] args)
	{
		
		launch(args);
	}
	@Override
	public    void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
	Group root =new Group();
		 Scene scene=new Scene(root,1000,1000);

			
			primaryStage.setScene(scene);
			Canvas canvas =new Canvas(1000,1000);
			root.getChildren().add(canvas);
			GraphicsContext gc =canvas.getGraphicsContext2D();
	
		
			;
			
			
			new AnimationTimer() {

				@Override
				public void handle(long arg0) {
					// TODO Auto-generated method stub
					gc.clearRect(0, 0, 1000, 1000);
					Controller.getController().move();
					Controller.getController().update();
					Controller.getController().render(gc);	
		
					System.out.println(Controller.getController().factory.getTest().getPositionY());


		
				
				
		
			   
		
				

		
					
				}
			}.start();

				
			primaryStage.setScene(scene);

				
				primaryStage.show();}
	
	

}
