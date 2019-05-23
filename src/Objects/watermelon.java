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
public class watermelon extends GameObject {

    Random rand = new Random();

    public watermelon() {
        this.type = Type.NORMAL_FRUIT;
        setInitials("bati2.png", "bati0.png");
    }
}
