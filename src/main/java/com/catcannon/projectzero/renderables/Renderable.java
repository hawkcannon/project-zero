package com.catcannon.projectzero.renderables;

/**
 * Annotate a class with this if it can be rendered with LWJGL.
 *
 */
public @interface Renderable {
	public boolean isLit();
}
