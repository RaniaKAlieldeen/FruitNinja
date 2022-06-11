
package Objects;

import java.util.Random;

/**
 *
 * @author Rania
 */
public class ObjectFactory {
    GameObject test;
    String name;
    public ObjectFactory(String name) {
		this.name=name;
		
	}
    static Random rand = new Random();
    
    public static GameObject getFruit(){
        int x = rand.nextInt(6);
        
        switch(x){
            case 0:
                return new Apple();
            case 1:
                return new Orange();
            case 2:
                return new HappyBala7a();
            case 3:
                return new Pineapple();
              case 4:
                return new Egg();
               case 5:
                return new Banana();
            default:
                return null;
        }
    }
            
    
    public static GameObject getBomb() {
        int x = rand.nextInt(2);
        
        switch(x){
            case 0:
                return new NormalBomb();
            case 1:
                return new AngryBala7a();
            default:
                return null;
        }
        
    }
    
    
}
