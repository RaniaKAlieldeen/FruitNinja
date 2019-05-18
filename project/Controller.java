package project;

import java.util.ArrayList;

import com.sun.org.apache.bcel.internal.generic.NEWARRAY;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.MouseEvent;

public class Controller{
private static Controller controller;	
ArrayList<String> o= new ArrayList<String>();
Factory factory;
int index;
int range;
Test test;
private int counter;
public ArrayList<Test> objects=new ArrayList<Test>();

public Controller() {
	
	o.add("sprite");
	o.add("sprite2");

}



	public void render (GraphicsContext gc )
	{
		for(int i=0;i<objects.size();i++) {
			
			
		
        		
		gc.drawImage(objects.get(i).getImage(), objects.get(i).getPositionX(), objects.get(i).getPositionY());
		
		}
		
	}


void move ()


{ 
 for(int i=0;i<objects.size();i++) {
	objects.get(i).addDeltaY( 4);
 }
	
}
public void select(MouseEvent e) {
	for(int i=0;i<objects.size();i++) {
	if (objects.get(i).getDmX().contains(e.getX()) && objects.get(i).getDmY().contains(e.getY())) {
		
		System.out.print("nn");
		
	
	}
		
}
}	
		
	
	
	
	
	
public static Controller getController1() {
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
	for(int i=0;i<objects.size();i++) {
	
		objects.get(i).setPositionY(objects.get(i).getPositionY()+objects.get(i).getDeltay());
		objects.get(i).setPositionX(objects.get(i).getPositionX()+objects.get(i).getDeltax());
		objects.get(i).setDeltax(0);

		objects.get(i).setDeltay(0);
	}
	
	
}

public void createRandObject() {
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
	
	objects.add(test);
	
	
	
	
}
	
	
	public int getcounter() {
		
		return counter;
		
	}

public void setCounter(int counter) {
	
	this.counter=counter;
	
	
}


}
