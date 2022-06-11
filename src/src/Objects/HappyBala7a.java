
package Objects;

import java.awt.image.BufferedImage;
import java.util.Random;

import javafx.scene.image.Image;



/**
 *
 * @author Rania
 */
public class HappyBala7a extends GameObject{
	private Image Image = new Image(getClass().getResource("happyBala7a0.png").toExternalForm()); 
    Random rand = new Random();
    public HappyBala7a(){
        this.type = Type.SPECIAL_FRUIT;
       
        setPositionY(1000);
        setPositionX((int)(Math.random() * (900 + 1)));//assuming the width of the window is 900
       
        setHeight(Image.getHeight());
        setWidth(Image.getWidth());
        choicStyle(getPositionX());
        images[0]=new Image(getClass().getResource("happyBala7a0.png").toExternalForm());
        images[1]=new Image(getClass().getResource("happyBala7a1.png").toExternalForm());
    }   
    
    public BufferedImage[] getImages(){
        return super.getImages("happyBala7a");
    }

   

    public Image getImage() {
		return Image;
	}


	public void setImage(Image image) {
		Image = image;
	}    
    
}
