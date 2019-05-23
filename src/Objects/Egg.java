package Objects;

import java.util.Random;

public class Egg extends GameObject {

    Random rand = new Random();

    public Egg() {
        this.type = Type.NORMAL_FRUIT;
        setInitials("egg0.png", "egg1.png");

    }

}
