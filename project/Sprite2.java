package project;

import java.util.ArrayList;

import javafx.scene.image.Image;

public class Sprite2 implements Test {
	 private Image Image = new Image(getClass().getResource("farmer3.png").toExternalForm());;
	 private double  positionX;
	 private double  positionY;
	 private double width;
	 private double height;
	 private double deltax;
	 public int getFlagdirection() {
		return flagdirection;
	}
	public void setFlagdirection(int flagdirection) {
		this.flagdirection = flagdirection;
	}


	private double deltay;
	 public double getDeltax() {
		return deltax;
	}
	public void setDeltax(double deltax) {
		this.deltax = deltax;
	}
	public double getDeltay() {
		return deltay;
	}
	public void setDeltay(double deltay) {
		this.deltay = deltay;
	}


	private double intialVelocity;
	 private double fallingVelocity;
	public  int flagdirection=1;
	public double getIntialVelocity() {
		return intialVelocity;
	}
	public void setIntialVelocity(double intialVelocity) {
		this.intialVelocity = intialVelocity;
	}
	public double getFallingVelocity() {
		return fallingVelocity;
	}
	public void setFallingVelocity(double fallingVelocity) {
		this.fallingVelocity = fallingVelocity;
	}
	public Image getImage() {
		return Image;
	}
	public void setImage(Image image) {
		Image = image;
	}
	public double getPositionX() {
		return positionX;
	}
	public void setPositionX(double positionX) {
		this.positionX = positionX;
	}
	public double getPositionY() {
		return positionY;
	}
	
	public void setPositionY(double positionY) {
		this.positionY = positionY;
	}
	public double getWidth() {
		return width;
	}
	public void setWidth(double width) {
		this.width = width;
	}
	public double getHeight() {
		return height;
	}
	public void setHeight(double height) {
		this.height = height;
	}
	public Sprite2() {
	
	
		this.positionX = 150;
		this.positionY = 150;
		this.width = Image.getWidth();
		this.height = Image.getHeight();
	}
	
	
	public void addDeltaX(int x)
	{
		
		this.deltax=x;
		
	}
	public void addDeltaY(int Y)
	{
		
		this.deltay=Y;
		
	}

	public int getMaxHeight()
	{
		
		
		
		
		return 500;
	}

	
	public ArrayList<Double> getDmX() {
		ArrayList<Double> array = new ArrayList<Double>();

		for (double i = getPositionX(); i < getWidth() + getPositionX(); i++) {
			array.add(i);

		}
		return array;

	}

	public ArrayList<Double> getDmY() {
		ArrayList<Double> array = new ArrayList<Double>();

		for (double i = getPositionY(); i < getHeight() + getPositionY(); i++) {
			array.add(i);

		}
		return array;

	
}

		
		
	
	
	
	
}
	
	
	
	
	
	

