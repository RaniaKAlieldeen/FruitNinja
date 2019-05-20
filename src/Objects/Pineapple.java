/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Objects;

import java.awt.image.BufferedImage;
import java.util.Random;

import javafx.scene.image.Image;

/**
 *
 * @author user
 */
public class Pineapple extends GameObject {
    
    
    
     Random rand = new Random();
     private Image Image = new Image(getClass().getResource("pineapple0.png").toExternalForm()); 

    public Pineapple(){
        this.type = Type.NORMAL_FRUIT;
        setPositionY(1000);
        
        setPositionX((int)(Math.random() * (900 + 1)));//assuming the width of the window is 900
        setHeight(Image.getHeight());
        setWidth(Image.getWidth());
        setMaxHeight((int)(Math.random() * ((900 - 500) + 1)) + 500);
        choicStyle(getPositionX());
        images[0]=new Image(getClass().getResource("pineapple0.png").toExternalForm());
        images[1]=new Image(getClass().getResource("pineapple1.png").toExternalForm());
    }
   
    public BufferedImage[] getImages(){
        return super.getImages("pineapple");
    }
    public Image getImage() {
		return Image;
	}


	public void setImage(Image image) {
		Image = image;
	}    
}
