package Controller1;

import Controller1.IGameActions;
import Objects.GameObject;
import Objects.GameObject;
import Objects.IGameObject;
import Objects.IGameObject;
import Objects.ObjectFactory;
import Objects.ObjectFactory;
import Player.Player;
import java.util.ArrayList;
import java.util.Random;
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
    public ArrayList<IGameObject> objects = new ArrayList<>();
    private Player player;
    private static Level level;

    public int setVelocity() {
        int delta;
        if (this.level == Level.EASY) {
            delta = 2;
        } else if (this.level == Level.MEDIUM) {
            delta = 5;
        } else {
            delta = 10;
        }

        return delta;

    }

    public static GameEngine getInstance(Level level, Player player) {
        if (engine == null) {
            engine = new GameEngine(level, player);
        }
        return engine;

    }

    private GameEngine(Level level, Player player) {
        // set whatever the game needs such as level player and so on
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

    public void render(GraphicsContext gc) {
        for (int i = 0; i < objects.size(); i++) {

            gc.drawImage(objects.get(i).getImage(), objects.get(i).getPositionX(), objects.get(i).getPositionY());

        }

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

                System.out.print("nn");

            }

        }
    }

    public void update() {
        for (int i = 0; i < objects.size(); i++) {

            objects.get(i).setPositionY(objects.get(i).getPositionY() + objects.get(i).getDeltay());
            objects.get(i).setPositionX(objects.get(i).getPositionX() + objects.get(i).getDeltax());
            objects.get(i).setDeltax(0);

            objects.get(i).setDeltay(0);
        }

    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    

    public void setLevel(Level level) {
        GameEngine.level = level;
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

    public void createRandObject() {
        range = 6;
        if (range > 5) {
            index = 0;
            factory = new ObjectFactory(o.get(index));
            test = ObjectFactory.getFruit();
        } else if (range > 7) {
            index = 1;
            factory = new ObjectFactory(o.get(index));
            test = ObjectFactory.getFruit();
        } else if (range > 8) {
            index = 2;
            factory = new ObjectFactory(o.get(index));
            test = ObjectFactory.getFruit();
        } else if (range > 3) {
            index = 3;
            factory = new ObjectFactory(o.get(index));
            test = ObjectFactory.getFruit();
        } else if (range > 10) {
            index = 4;
            factory = new ObjectFactory(o.get(index));
            test = ObjectFactory.getBomb();

        } else if (range > 15) {
            index = 5;
            factory = new ObjectFactory(o.get(index));
            test = ObjectFactory.getBomb();
        } else if (range > 25) {
            index = 6;
            factory = new ObjectFactory(o.get(index));
            test = ObjectFactory.getFruit();
        } else if (range > 30) {
            index = 7;
            factory = new ObjectFactory(o.get(index));
            test = ObjectFactory.getFruit();
        } else if (range > 40) {
            index = 8;
            factory = new ObjectFactory(o.get(index));
            test = ObjectFactory.getFruit();
        }

        // test = ObjectFactory.getFruit();
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

    }
    
    public static Level getLevel(){
        return level;
    }
    
}
