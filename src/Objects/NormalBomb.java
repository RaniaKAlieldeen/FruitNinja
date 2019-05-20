
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
    private Image Image = new Image(getClass().getResource("bomb00.png").toExternalForm()); 
    public NormalBomb(){
        this.type = Type.NORMAL_BOMB;
    
        setPositionX((int)(Math.random() * (900 + 1)));//assuming the width of the window is 900
        setPositionY(1000);
        setHeight(Image.getHeight());
        setWidth(Image.getWidth());
        setMaxHeight((int)(Math.random() * ((900 - 500) + 1)) + 500);
        choicStyle(getPositionX());
        images[0]=new Image(getClass().getResource("bomb0.png").toExternalForm());
        images[1]=new Image(getClass().getResource("bomb1.png").toExternalForm());
    }
    
   
  
 
    public Image getImage() {
		return Image;
	}


	public void setImage(Image image) {
		Image = image;
	}    
}
