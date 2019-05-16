
package Objects;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

/**
 *
 * @author Rania
 */
public abstract class Bombs implements IObjectFactory{

    boolean type;
    @Override
    public boolean getType() {
        return this.type;
    }

    @Override
    public BufferedImage[] getImages(String filename) {
        BufferedImage f[] = new BufferedImage[2];

        for (int i = 0; i < f.length; i++) {

            try {
                f[i] = ImageIO.read(new File(String.format(filename + i + ".png")));
            } catch (IOException ex) {
                System.out.println("No Image Found");
            }

        }

        return f;
    }

    
    
}
