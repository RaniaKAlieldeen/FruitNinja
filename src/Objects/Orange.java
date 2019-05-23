
package Objects;

import java.awt.image.BufferedImage;
import java.util.Random;

import javafx.scene.image.Image;


public class Orange extends GameObject{
    Random rand = new Random();
    //private Image Image = new Image(getClass().getResource("orange0.png").toExternalForm()); 
    public Orange(){
       	   this.type = Type.NORMAL_FRUIT;
        setInitials("orange0.png", "orange1.png");
    }
        
    }
    

   

  