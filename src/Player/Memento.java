
package Player;

import java.util.ArrayList;

/**
 *
 * @author Rania
 */
public class Memento {
    
     private Player player;
     ArrayList<Memento> Mementos = new ArrayList<>();
    private int lives;
    private  int score;
     
     public Memento(int score, int lives, Player player){
         this.lives = lives;
         this.player = player;
         this.score = score;
     
     }
     
     public static Memento StoreInMemento(int score, int lives, Player player){
         return new Memento(score, lives, player);
     }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getLives() {
        return lives;
    }

    public void setLives(int lives) {
        this.lives = lives;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }
     
     
    
}
