package com.catcannon.projectzero.main;

import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.lwjgl.opengl.GL11;

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
		GL11.glClear(GL11.GL_COLOR_BUFFER_BIT | GL11.GL_DEPTH_BUFFER_BIT);
		
		
		
		Display.update();
	}
	
	public void stop(){
		Display.destroy();
	}
}
