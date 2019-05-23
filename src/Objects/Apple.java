
package Objects;

import java.util.Random;


/**
 *
 * @author Rania
 */
public class Apple extends GameObject {

    Random rand = new Random();
    //private Image Image = new Image(getClass().getResource("apple0.png").toExternalForm()); 
    public Apple(){
      
        	   this.type = Type.NORMAL_FRUIT;
        setInitials("apple0.png", "apple1.png");
    }
    }
    

  

