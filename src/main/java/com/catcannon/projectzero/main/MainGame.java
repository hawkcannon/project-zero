package com.catcannon.projectzero.main;

import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;

/**
 * Placeholder, for now.
 *
 */
public class MainGame {
	public static void main(String[] args){
		MainGame game = new MainGame();
		
		try {
			game.start();
			
			while(!Display.isCloseRequested()){
				game.update();
			}
			
			game.stop();
		} catch (LWJGLException e) {
			e.printStackTrace();
		}
		
	}
	
	public void start() throws LWJGLException{
		Display.setDisplayMode(new DisplayMode(800, 600));
		Display.create();
		
		while(!Display.isCloseRequested()){
			Display.update();
		}		
	}
	
	public void update(){
		
		Display.update();
	}
	
	public void stop(){
		Display.destroy();
	}
}
