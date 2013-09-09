package com.catcannon.projectzero.renderables.statics;

import org.lwjgl.opengl.GL11;

import com.catcannon.projectzero.renderables.Renderable;
import com.catcannon.projectzero.renderables.RenderableItem;

@Renderable(isLit = false)
public class Floor implements RenderableItem {
	private int x = 0,
			    y = 0,
				width = 0,
				height = 0;
	
	public Floor(int x, int y, int width, int height){
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}
	
	public RenderableItem createAt(int x, int y, Object... options) {
		if(options.length != 2){
			return null; // Must have width and height as options
		}
		return new Floor(x, y, (Integer) options[0], (Integer) options[1]);
	}
	
	public void render() {
		GL11.glBegin(GL11.GL_QUADS);
			GL11.glVertex2f(x, y);
			GL11.glVertex2f(x + width, y);
			GL11.glVertex2f(x, y + height);
			GL11.glVertex2f(x + width, y + height);
		GL11.glEnd();
	}

	public void update(int delayMs) {
		return;
	}
}
