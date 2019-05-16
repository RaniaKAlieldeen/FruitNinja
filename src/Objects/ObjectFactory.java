
package Objects;

import java.util.Random;

/**
 *
 * @author Rania
 */
public class ObjectFactory {
    
    
    Random rand = new Random();
    
    public IObjectFactory getFruit(){
        int x = rand.nextInt(3);
        
        switch(x){
            case 0:
                return new Apple();
            case 1:
                return new Orange();
            case 2:
                return new HappyBala7a();
            default:
                return null;
        }
    }
            
    
    public IObjectFactory getBomb() {
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
