/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Objects;

import java.awt.image.BufferedImage;

/**
 *
 * @author Rania
 */
public interface IObjectFactory {
    final boolean SPECIAL = true;
    final boolean NORMAL = false;
    
    public boolean getType();
    
  
    
}
