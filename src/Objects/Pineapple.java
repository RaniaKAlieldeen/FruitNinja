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
     //private Image Image = new Image(getClass().getResource("pineapple0.png").toExternalForm()); 

    public Pineapple(){
        this.type = Type.NORMAL_FRUIT;
       	 
        setInitials("pineapple0.png", "pineapple1.png");
    }
    }
   
