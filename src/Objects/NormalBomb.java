
package Objects;

import java.awt.image.BufferedImage;
import java.util.Random;

import javafx.scene.image.Image;


/**
 *
 * @author Rania
 */
public class NormalBomb extends GameObject{
    Random rand = new Random();
    //private Image Image = new Image(getClass().getResource("bomb0.png").toExternalForm()); 
    public NormalBomb(){
    	   this.type = Type.NORMAL_BOMB;
        setInitials("bomb0.png", "bomb1.png");
    }
    }
    
   
  
 
    