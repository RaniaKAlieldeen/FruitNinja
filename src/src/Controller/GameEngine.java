package Controller;

import Objects.GameObject;
import Objects.GameObject;
import Objects.IGameObject;
import Objects.IGameObject;
import static Objects.IGameObject.Type;
import Objects.ObjectFactory;
import Objects.ObjectFactory;
import Player.Player;
import java.util.ArrayList;
import java.util.Random;
import static javafx.application.Platform.exit;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;

public class GameEngine implements IGameActions {

    public enum Level {
        EASY, MEDIUM, HARD, ARCADE;
    }

    private static GameEngine engine;
    ArrayList<String> o = new ArrayList<>();
    ObjectFactory factory;
    int index;
    int range;
 
    
    GameObject test;
    private int counter=0;
    public ArrayList<GameObject> objects = new ArrayList<>();
    private Player player;
    private Level level;
    private int lives;

    public static GameEngine getInstance(Level level, Player player) {
        if (engine == null) {
            engine = new GameEngine(level, player);
        }
        return engine;

    }


    private GameEngine(Level level, Player player) {
        // set whatever the game needs such as level player and so on
        lives = 30;
        setLevel(level);
        setPlayer(player);
        o.add("Banana");
        o.add("Apple");
        o.add("Orange");
        o.add("HappyBal7a");
        o.add("NormalBombs");
        o.add("AngryBal7a");
        o.add("bati");
        o.add("egg");
        o.add("Pineapple");

        // to be continued....
    }

    public void updateScore(GameObject o) {
        int score = 1;
        if (o.getType() == Type.SPECIAL_BOMB) {
            lives = 0;

            endGame();
        } else if (o.getType() == Type.NORMAL_BOMB && lives > 0) {
            lives--;
            endGame();
        } else {
            if (o.getType() == Type.SPECIAL_FRUIT) {
                score = 5;
            }
            switch (level) {
                case EASY:
                    player.setEasyHighScore(player.getEasyHighScore() + score);
                    System.out.println("score is : " + player.getEasyHighScore());
                    break;
                case MEDIUM:
                    player.setMedHighScore(player.getMedHighScore() + score);
                    System.out.println("score is : " + player.getMedHighScore());
                    break;
                case HARD:
                    player.setHardHighScore(player.getHardHighScore() + score);
                    System.out.println("score is : " + player.getHardHighScore());
                    break;
                default:
                    System.out.println("fi moshkelllaaaaaaaaaaaaaaaaa");
            }

        }
    }

    public void render(GraphicsContext gc) {
        for (int i = 0; i < objects.size(); i++) {

            if (objects.get(i).getSliced() == false) {
                gc.drawImage(objects.get(i).images[0], objects.get(i).getPositionX(), objects.get(i).getPositionY());
            } else {
                gc.drawImage(objects.get(i).images[1], objects.get(i).getPositionX(), objects.get(i).getPositionY());

            }
            missedFruits(objects.get(i),i);
        }

    }

    public void missedFruits(GameObject o,int i) {
        if (o.getType() == Type.NORMAL_FRUIT) {
            if (o.getPositionY() > 1100 && lives != 0 && o.getSliced() == false) {
               
            
                 
            	lives--;
            	System.out.print(lives);
                System.out.println("oop"
                		+ "s u missed a fruit ");
                      objects.remove(i);
                   
                endGame();

            }
        }

    }

    public void endGame() {
        if (lives <= 0) {
            System.out.println("GAME LOST! LOSER...");
            exit();
        }
       
    }

    public int setVelocity() {
        int delta;
        if (this.level == Level.EASY) {
            delta = 1;
        } else if (this.level == Level.MEDIUM) {
            delta = 5;
        } else {
            delta = 10;
        }

        return delta;

    }

    public void move() {

        int x = setVelocity();

        for (int i = 0; i < objects.size(); i++) {
            if (objects.get(i).getStyle() == 2) {
                if (objects.get(i).getPositionY() >= objects.get(i).getHeight()
                        && objects.get(i).getFlagdirection() == 1) {
                    objects.get(i).setDeltay(-x);
                } else {

                    objects.get(i).setFlagdirection(0);

                    objects.get(i).setDeltay(x);

                }
            }
        }

        for (int i = 0; i < objects.size(); i++) {
            if (objects.get(i).getStyle() == 1) {
                if (objects.get(i).getPositionY() >= objects.get(i).getHeight()
                        && objects.get(i).getFlagdirection() == 1) {
                    if (objects.get(i).getPositionX() > 910 || objects.get(i).getPositionX() < 10) {
                        objects.get(i).setDeltay(-x);
                    } else {
                        objects.get(i).setDeltay(-x);
                        objects.get(i).setDeltax(x);
                    }
                } else {

                    if (objects.get(i).getPositionX() > 910 || objects.get(i).getPositionX() < 10) {

                        objects.get(i).setFlagdirection(0);
                        objects.get(i).setDeltay(x);
                    } else {
                        objects.get(i).setFlagdirection(0);

                        objects.get(i).setDeltay(x);

                        objects.get(i).setDeltax(x);
                    }

                }
            }
        }
        for (int i = 0; i < objects.size(); i++) {
            if (objects.get(i).getStyle() == 3) {
                if (objects.get(i).getPositionY() >= objects.get(i).getHeight()
                        && objects.get(i).getFlagdirection() == 1) {

                    if (objects.get(i).getPositionX() > 910 || objects.get(i).getPositionX() < 10) {
                        objects.get(i).setDeltay(-x);
                    } else {
                        objects.get(i).setDeltay(-x);
                        objects.get(i).setDeltax(-x);
                    }
                } else {
                    if (objects.get(i).getPositionX() > 910 || objects.get(i).getPositionX() < 10) {
                        objects.get(i).setFlagdirection(0);
                        objects.get(i).setDeltay(x);
                    } else {
                        objects.get(i).setFlagdirection(0);

                        objects.get(i).setDeltay(x);

                        objects.get(i).setDeltax(-x);
                    }
                }
            }
        }

    }

    public void select(MouseEvent e) {
        for (int i = 0; i < objects.size(); i++) {
            if (objects.get(i).getDmX().contains(e.getX()) && objects.get(i).getDmY().contains(e.getY())) {

                objects.get(i).setSliced(true);
                updateScore(objects.get(i));

            }
        }
    }

    public void update() {
        for (int i = 0; i < objects.size(); i++) {

            objects.get(i).setPositionY(objects.get(i).getPositionY() + objects.get(i).getDeltay());
            objects.get(i).setPositionX(objects.get(i).getPositionX() + objects.get(i).getDeltax());
            objects.get(i).setDeltax(0);

        }

    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public Level getLevel() {
        return level;
    }

    public void setLevel(Level level) {
        this.level = level;
    }

    @Override
    public void createGameObject() {
    	

        Random rand = new Random();
        switch (level) {
            case EASY:// chances of bomb 20%
                if (rand.nextInt(10) <= 7) {
                    test = ObjectFactory.getFruit();
                } else {
                    test = ObjectFactory.getBomb();
                }
                break;
            case MEDIUM:
            case ARCADE:// chances of bomb 30%
                if (rand.nextInt(10) <= 6) {
                    test = ObjectFactory.getFruit();
                } else {
                    test = ObjectFactory.getBomb();
                }
                break;
            case HARD:// chances of bomb 40%
                if (rand.nextInt(10) <= 5) {
                    test = ObjectFactory.getFruit();
                } else {
                    test = ObjectFactory.getBomb();
                }
                break;
            default:
                test = null;
                break;
        }
        objects.add(test);

    }

     public void setMYcounter()
    {
    	
         switch (level) {
         case EASY:// chances of bomb 20%
            setCounter(5000);
             break;
         case MEDIUM:
        	 setCounter(5000);
        	 break;
         case ARCADE:// chances of bomb 30%
        	 setCounter(30);
             break;
         case HARD:// chances of bomb 40%
        	 setCounter(5000);
             break;
         default:
            
             break;
     }

    	
    	
    	
    	
    }
     
     
     public ArrayList<Label> CreateLabels()
    { 
    	 
    	 ArrayList<Label> Labels = new   ArrayList<Label>() ;
    	Label Score = new Label();
    	Label Lives = new Label ();
    	Label Times = new Label ();
    	 Score.setTranslateX(1100);
    	 Score.setTranslateY(10);
    	 Lives.setTranslateX(1200);
    	 Lives.setTranslateY(10);
    	Times.setTranslateX(1300);
    	Times.setTranslateY(10);
    	
    	Labels.add(Score);
    	Labels.add(Lives);
    	Labels.add(Times);
    	
    	return  Labels  ;
    }
	  public void  SetText (ArrayList<Label> Labels)
	 { 
		switch (level)  
	 
	 {case EASY:
         Labels.get(0).setText(String.valueOf(player.getEasyHighScore()));
         Labels.get(1).setText(String.valueOf(lives));
         Labels.get(2).setText(String.valueOf(getcounter()));
         
         
       
          break;
      case MEDIUM:
    	  Labels.get(0).setText(String.valueOf(player.getMedHighScore()));
          Labels.get(1).setText(String.valueOf(lives));
          Labels.get(2).setText(String.valueOf(getcounter()));
          
          break;
      case HARD:
    	  Labels.get(0).setText(String.valueOf(player.getHardHighScore()));
          Labels.get(1).setText(String.valueOf(lives));
          Labels.get(2).setText(String.valueOf(getcounter()));
		default:
			break;
		 
		 
		 
		 
		 
	 }}
	
    @Override
    public void updateObjectsLocations() {
    }

    @Override
    public void sliceObjects() {
        // button click action ? change photo to sliced ?
    }

    @Override
    public void ResetGame() {
        // start new game of same level, reset the lives and score
    }

    public int getcounter() {
        return counter;
    }

    public void setCounter(int counter) {
        this.counter = counter;
    }
}
