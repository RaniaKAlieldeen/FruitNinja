package Objects;

import java.awt.image.BufferedImage;

import java.util.ArrayList;
import javafx.scene.image.Image;

/**
 *
 * @author Rania
 */
public interface IGameObject {

    public enum Type{
    SPECIAL_FRUIT,NORMAL_FRUIT,SPECIAL_BOMB,NORMAL_BOMB;
    }
    public Type getType();

    public int getDeltax();

    public void setDeltax(int deltax);

    public int getDeltay();

    public void setDeltay(int deltay);

    public double getIntialVelocity();

    public void setIntialVelocity(double intialVelocity);

    public double getFallingVelocity();

    public void setFallingVelocity(double fallingVelocity);

    public Image getImage();

    public void setImage(Image image);

    public int getPositionX();

    public void setPositionX(int positionX);

    public int getPositionY();

    public void setPositionY(int positionY);

    public double getWidth();

    public void setWidth(double width);

    public double getHeight();

    public void setHeight(double height);

   // public void addDeltaX();

   // public void addDeltaY();
    public void addDeltaX(int x);
	public void addDeltaY(int Y);

    public double getMaxHeight();
    
    public void setMaxHeight(double maxHeight);

    public int getFlagdirection();

    public void setFlagdirection(int flagdirection);

    public ArrayList<Double> getDmX();

    public ArrayList<Double> getDmY();

    public BufferedImage[] getImages(String filename);

    public int getInitialVelocity();

    public Boolean isSliced();

    public Boolean hasMovedOffScreen();

    public void slice();

    public int getStyle() ;
	public void setStyle(int style) ;



}
