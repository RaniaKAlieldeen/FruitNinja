package project;

import java.util.ArrayList;

import javafx.scene.image.Image;

public interface Test {
	 public double getDeltax() ;
	
	public void setDeltax(double deltax); 
	
	public double getDeltay() ;
	public void setDeltay(double deltay); 



	public double getIntialVelocity() ;
	
	public void setIntialVelocity(double intialVelocity); 
	public double getFallingVelocity() ;
	public void setFallingVelocity(double fallingVelocity); 
	public Image getImage();	
	public void setImage(Image image); 
	
	public double getPositionX() ;
	public void setPositionX(double positionX); 
	public double getPositionY() ;
	
	public void setPositionY(double positionY) ;
	public double getWidth() ;
	public void setWidth(double width);
	public double getHeight() ;
	public void setHeight(double height) ;
	
	public void addDeltaX(int x);
	public void addDeltaY(int Y);
	

	public int getMaxHeight();
	public int getFlagdirection() ;
	public void   setFlagdirection(int flagdirection) ;
	
	public ArrayList<Double> getDmX();

	public ArrayList<Double> getDmY() ;
		
		
	
}
