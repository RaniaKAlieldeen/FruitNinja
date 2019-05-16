package project;

import java.util.Random;

public class Factory {
	Test test;
	String name;
	public Factory(String name) {
		this.name=name;
		
	}
	public Test getTest() {
		if(name.equalsIgnoreCase("sprite")) {
			
			
			return new Sprite();
			
		}else if(name.equalsIgnoreCase("sprite2")) {
			
			
			
			return new Sprite2();
			
		}		
		
		return null;
		
	}
	
	
}
