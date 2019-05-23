
package Player;

import java.util.ArrayList;

/**
 *
 * @author Rania
 */
public class Memento{
    private int lives;
    private  int score;
    private String name;
    private int[] high_score = new int[4];

    public void setEasyHighScore(int score) {
        this.high_score[0] = score;
    }

    public void setMedHighScore(int score) {
        this.high_score[1] = score;
    }

    public void setHardHighScore(int score) {
        this.high_score[2] = score;
    }

    public int getEasyHighScore() {
        return high_score[0];
    }

    public int getMedHighScore() {
        return high_score[1];
    }

    public int getHardHighScore() {
        return high_score[2];
    }
    public void setArcadehScore(int score) {
        this.high_score[3] = score;
    }
    public int getArcadeHighScore() {
        return high_score[3];
    }




    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name=name;
    }
     
     public Memento(){

         this.high_score[0] = 0;
         this.high_score[1] = 0;
         this.high_score[2] = 0;
         this.high_score[3] = 0;
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


     
    
}
