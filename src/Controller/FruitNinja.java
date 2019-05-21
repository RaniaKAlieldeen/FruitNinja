package Controller;

import Controller.GameEngine.Level;
import Objects.GameObject;
import Player.Player;

/**
 *
 * @author Rania
 */
public class FruitNinja {

    public static void main(String[] args) {

        Player player = new Player();
        GameEngine e = GameEngine.getInstance(Level.HARD, player);
        GameObject o = e.createGameObject();
        System.out.println("object is: " + o.getType() + " of class: " + o.getClass()); 
        o.move(0);


    }

}
