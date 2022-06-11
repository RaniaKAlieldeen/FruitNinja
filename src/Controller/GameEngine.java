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
    private int counter;
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
        //lives = 3;
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
        int x;
        if (o.getType() == Type.SPECIAL_BOMB) {
            lives = 0;
            System.out.println("GAME LOST! LOSER...");
            exit();
        } else if (o.getType() == Type.NORMAL_BOMB && lives > 0 && player.getArcadeHighScore() != 0) {
            //lives--;
            x = 1;
            switch (level) {
                case EASY:
                    lives--;
                    //  player.setEasyHighScore(player.getEasyHighScore() +x);
                    System.out.println("live is : " + lives);
                    break;
                case MEDIUM:
                    lives--;
                    // player.setMedHighScore(player.getMedHighScore() + x);
                    System.out.println("score is : " + lives);
                    break;
                case HARD:
                    lives--;
                    //player.setHardHighScore(player.getHardHighScore() + x);
                    System.out.println("score is : " + lives);
                    break;
                case ARCADE:
                    player.setArcadehScore(player.getArcadeHighScore() - x);
                    System.out.println("score is : " + player.getArcadeHighScore());
                    break;
                default:
                    System.out.println("fi moshkelllaaaaaaaaaaaaaaaaa");
            }

        } else if (o.getType() == Type.SPECIAL_FRUIT) {
            x = 5;

            switch (level) {
                case EASY:
                    player.setEasyHighScore(player.getEasyHighScore() + x);
                    System.out.println("score is : " + player.getEasyHighScore());
                    break;
                case MEDIUM:
                    player.setMedHighScore(player.getMedHighScore() + x);
                    System.out.println("score is : " + player.getMedHighScore());
                    break;
                case HARD:
                    player.setHardHighScore(player.getHardHighScore() + x);
                    System.out.println("score is : " + player.getHardHighScore());
                    break;
                case ARCADE:
                    player.setHardHighScore(player.getArcadeHighScore() + x);
                    System.out.println("score is : " + player.getArcadeHighScore());
                    break;
                default:
                    System.out.println("fi moshkelllaaaaaaaaaaaaaaaaa");
            }
        } else if (o.getType() == Type.NORMAL_FRUIT) {
            x = 1;

            switch (level) {
                case EASY:
                    player.setEasyHighScore(player.getEasyHighScore() + x);
                    System.out.println("score is : " + player.getEasyHighScore());
                    break;
                case MEDIUM:
                    player.setMedHighScore(player.getMedHighScore() + x);
                    System.out.println("score is : " + player.getMedHighScore());
                    break;
                case HARD:
                    player.setHardHighScore(player.getHardHighScore() + x);
                    System.out.println("score is : " + player.getHardHighScore());
                    break;
                case ARCADE:
                    player.setArcadehScore(player.getArcadeHighScore() + x);
                    System.out.println("score is : " + player.getArcadeHighScore());
                    break;
                default:
                    System.out.println("fi moshkelllaaaaaaaaaaaaaaaaa");
            }
        } else {
            endGame();
        }

    }

    public void render(GraphicsContext gc) {
        for (int i = 0; i < objects.size(); i++) {

            if (objects.get(i).getSliced() == false) {
                gc.drawImage(objects.get(i).images[0], objects.get(i).getPositionX(), objects.get(i).getPositionY());
            } else {
                gc.drawImage(objects.get(i).images[1], objects.get(i).getPositionX(), objects.get(i).getPositionY());

            }
            {
                missedFruits(objects.get(i));
                o.remove(i);
            }
        }

    }

    public void missedFruits(GameObject o) {

        if (o.getPositionY() > 1100 && lives != 0 && o.getSliced() == false) {
            if (o.getPositionY() > 1100 && lives != 0) {
                lives--;
                System.out.println("oops u missed a fruit ");
                endGame();

            }
        }

    }

    public void endGame() {
        if (lives <= 0) {
            exit();
        }
    }

    public int setVelocity() {
        int delta;
        if (this.level == Level.EASY) {
            delta = 1;
        } else if (this.level == Level.MEDIUM) {
            delta = 5;
        } else if (this.level == Level.ARCADE) {
            delta = 1;
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

    public void SelectNumberOfLives() {
        switch (level) {
            case EASY:
            case MEDIUM:
            case HARD:
                setLives(3);
                System.out.println("score is : " + player.getEasyHighScore());
                break;

            case ARCADE:
                setLives(7000000);
                //System.out.println("score is : " + );
                break;
            default:
                System.out.println("fi moshkelllaaaaaaaaaaaaaaaaa");
        }

    }

    public Player getPlayer() {
        return player;
    }

    public void setLives(int lives) {
        this.lives = lives;
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

        switch (level) {
            case EASY:
            case MEDIUM:
            case HARD:
                counter = 1000000;
                break;
            case ARCADE:
                counter = 30;

                break;
            default:

        }

    }
}
