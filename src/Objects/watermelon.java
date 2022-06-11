/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Objects;

import java.awt.image.BufferedImage;
import java.util.Random;

import Controller1.GameEngine;
import javafx.scene.image.Image;

/**
 *
 * @author user
 */
public class watermelon extends GameObject {
	 private Image Image = new Image(getClass().getResource("bati2.png").toExternalForm()); 
     Random rand = new Random();
    public watermelon(){
        this.type = IGameObject.Type.NORMAL_FRUIT;
        setPositionY(1000);
       
        setPositionX((int)(Math.random() * (900 + 1)));//assuming the width of the window is 900
        setHeight(Image.getHeight());
        setWidth(Image.getWidth());
        setMaxHeight((int)(Math.random() * ((900 - 500) + 1)) + 500);
        choicStyle(getPositionX());
        images[0]=new Image(getClass().getResource("bati2.png").toExternalForm());
        images[1]=new Image(getClass().getResource("bati0.png").toExternalForm());
    }

   
    public BufferedImage[] getImages(){
        return super.getImages("bati");
    }
    public Image getImage() {
		return Image;
	}

   
	public void setImage(Image image) {
		Image = image;
	}
    
    
    
}
