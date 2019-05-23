
package Objects;

import java.awt.image.BufferedImage;
import java.util.Random;

import javafx.scene.image.Image;


/**
 *
 * @author Rania
 */
public class AngryBala7a extends GameObject {
    
    Random rand = new Random();
    public AngryBala7a(){
    	   this.type = Type.SPECIAL_BOMB;
        setInitials("AngryBala7a.png", "AngryBala7a1.png");
    }
}
