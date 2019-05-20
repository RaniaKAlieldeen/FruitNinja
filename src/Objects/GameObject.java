/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Objects;


import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javafx.scene.image.Image;
import javax.imageio.ImageIO;
import javax.swing.text.Position; 


/**
 *
 * @author Rania
 */
public abstract class GameObject implements IGameObject {

    Type type;
    private  int Style ;
    public int getStyle() {
		return Style;
	}
	public void setStyle(int style) {
		Style = style;
	}

	private int deltax;
    private int deltay;

    private int positionX;
    private int positionY;
    private double width;
    private double height;
    private boolean sliced;
    
    private double maxHeight;
    
    private double intialVelocity;
    private double fallingVelocity;
    public int flagdirection = 1;

    @Override
    public Type getType() {
        return this.type;
    }
    @Override
    public BufferedImage[] getImages(String filename) {
        BufferedImage f[] = new BufferedImage[2];

        for (int i = 0; i < f.length; i++) {

            try {
                f[i] = ImageIO.read(new File(String.format(filename + i + ".png")));
            } catch (IOException ex) {
                System.out.println("No Image Found");
            }

        }

        return f;
    }
    @Override
    public int getDeltax() {
        return deltax;
    }
    @Override
    public void setDeltax(int deltax) {
        this.deltax = deltax;
    }
    @Override
    public int getDeltay() {
        return deltay;
    }
    @Override
    public void setDeltay(int deltay) {
        this.deltay = deltay;
    }
    @Override
    public int getFlagdirection() {
        return flagdirection;
    }
    @Override
    public void setFlagdirection(int flagdirection) {
        this.flagdirection = flagdirection;
    }
    @Override
    public double getIntialVelocity() {
        return intialVelocity;
    }
    @Override
    public void setIntialVelocity(double intialVelocity) {
        this.intialVelocity = intialVelocity;
    }
    @Override
    public double getFallingVelocity() {
        return fallingVelocity;
    }
    @Override
    public void setFallingVelocity(double fallingVelocity) {
        this.fallingVelocity = fallingVelocity;
    }

    @Override
    public int getPositionX() {
        return positionX;
    }
    @Override
    public void setPositionX(int positionX) {
        this.positionX = positionX;
    }
    @Override
    public int getPositionY() {
        return positionY;
    }
    @Override
    public void setPositionY(int positionY) {
        this.positionY = positionY;
    }
    @Override
    public double getWidth() {
        return width;
    }
    @Override
    public void setWidth(double width) {
        this.width = width;
    }
    @Override
    public double getHeight() {
        return height;
    }
    @Override
    public void setHeight(double height) {
        this.height = height;
    }
    @Override
    public void addDeltaX(int x) {

        this.positionX += this.deltax;

    }
    @Override
    public void addDeltaY(int y) {

        this.positionY += this.deltay;

    }
    @Override
    public double getMaxHeight() {

        return maxHeight;
    }
    
    @Override
    public void setMaxHeight(double maxHeight){
        this.maxHeight = maxHeight;
    }
    
    @Override
    public ArrayList<Double> getDmX() {
        ArrayList<Double> array = new ArrayList<>();

        for (double i = getPositionX(); i < getWidth() + getPositionX(); i++) {
            array.add(i);

        }
        return array;

    }
    @Override
    public ArrayList<Double> getDmY() {
        ArrayList<Double> array = new ArrayList<>();

        for (double i = getPositionY(); i < getHeight() + getPositionY(); i++) {
            array.add(i);

        }
        return array;

    }
    @Override
    public int getInitialVelocity() {
        return 1;
    }

    @Override
    public Boolean isSliced() {
        return sliced;
    }

    @Override
    public Boolean hasMovedOffScreen() {
        //msh 3aref
        boolean msh_3aref = false;
        return msh_3aref;
    }

    @Override
    public void slice() {
        //msh 3aref bardo
    }

public void  choicStyle(int positionX)

{
	
	if (positionX<200)
		 setStyle(1);
	
	else if (positionX<500)
		setStyle(2);
		else 
			setStyle(3);
    

}}
