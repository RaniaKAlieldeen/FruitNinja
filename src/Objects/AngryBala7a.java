
package Objects;

import java.awt.image.BufferedImage;
import java.util.Random;

import javafx.scene.image.Image;


/**
 *
 * @author Rania
 */
public class AngryBala7a extends GameObject {
    private Image Image = new Image(getClass().getResource("egg0.png").toExternalForm()); 
    Random rand = new Random();
    public AngryBala7a(){
    	 setPositionY(1000);
    	  
         setPositionX((int)(Math.random() * (900 + 1)));//assuming the width of the window is 900
        this.type = Type.SPECIAL_BOMB;
       setHeight(Image.getHeight());
       setWidth(Image.getWidth());
       setMaxHeight((int)(Math.random() * ((900 - 500) + 1)) + 500);

       choicStyle(getPositionX());
        
        
    }

    public BufferedImage[] getImages(){
        return super.getImages("AngryBala7a");
    }
    public Image getImage() {
		return Image;
	}


	public void setImage(Image image) {
		Image = image;
	}


}
