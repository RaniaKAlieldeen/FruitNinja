
package Objects;

import java.awt.image.BufferedImage;
import java.util.Random;

import javafx.scene.image.Image;

/**
 *
 * @author Rania
 */
public class Banana extends GameObject {
    Random rand = new Random();
    //private Image Image = new Image(getClass().getResource("banana0.png").toExternalForm());
    public Banana(){
    	
        	   this.type = Type.NORMAL_FRUIT;
        setInitials("banana0.png", "banana1.png");
    }
    } 
    
  

