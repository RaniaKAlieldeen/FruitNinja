package project;

import java.util.ArrayList;

import com.sun.org.apache.bcel.internal.generic.NEWARRAY;

import javafx.scene.canvas.GraphicsContext;

public class Controller{
private static Controller controller;	
ArrayList<String> o= new ArrayList<String>();
Factory factory;
int index;
int range;
Test test;

public Controller() {
	
	o.add("sprite");
	o.add("sprite2");
range =(int)(Math.random()*10);
if (range>5)
{
	index =0;
	factory=new Factory(o.get(index));
	

	
}else 
	
{	index =1;
factory=new Factory(o.get(index));
}

test=factory.getTest();
}



	public void render (GraphicsContext gc )
	{
        		
		gc.drawImage(test.getImage(), test.getPositionX(), test.getPositionY());
	}


void move ()


{ 

 test.addDeltaY( 4);


	
	
	
	
	
	
}
		
		
	
	
	
	
	
public static Controller getController() {
	if(controller==null) {
		synchronized (Controller.class) {
			Controller cont=controller;
			if(cont==null) {
				synchronized (Controller.class) {
					controller=new Controller();
					
				}	
			}	
		}
			
	}
	
	return controller;
	
}

public void update ()
{
	
	test.setPositionY(test.getPositionY()+test.getDeltay());
	test.setPositionX(test.getPositionX()+test.getDeltax());
	test.setDeltax(0);

	test.setDeltay(0);
}


}
