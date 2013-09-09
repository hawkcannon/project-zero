package com.catcannon.projectzero.exceptions;

/**
 * Should be thrown when a class has an invalid structure (a RenderableItem not having the @Renderable annotation, for instance).
 *
 */
public class StructureException extends Exception {
	public StructureException(String string) {
		super(string);
	}

	private static final long serialVersionUID = 1L;

}
