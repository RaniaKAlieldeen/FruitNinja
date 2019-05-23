package Player;

/**
 *
 * @author Rania
 */
public class Player{
    Memento memento=new Memento();

    public void setEasyHighScore(int score) {
        memento.setEasyHighScore(score);
    }

    public void setMedHighScore(int score) {
        memento.setMedHighScore(score);
    }

    public void setHardHighScore(int score) {
        memento.setHardHighScore(score);
    }
    
    public int getEasyHighScore() {
        return memento.getEasyHighScore();
    }

    public int getMedHighScore() {
        return memento.getMedHighScore();
    }

    public int getHardHighScore() {
        return memento.getHardHighScore();
    }
 public void setArcadehScore(int score) {
        memento.setArcadehScore(score);
    }   
   public int getArcadeHighScore() {
       return memento.getArcadeHighScore();
    }
    public Player() {


    }
public String getName(){   
 return memento.getName();
}
public void setName(String name){   
  memento.setName(name);
}
}