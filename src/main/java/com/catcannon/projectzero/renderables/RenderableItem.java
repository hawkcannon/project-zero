package com.catcannon.projectzero.renderables;

public interface RenderableItem {
	public void update(int delayMs);
	public void render();
	public RenderableItem createAt(int x, int y, Object... options);
}
