package com.catcannon.projectzero;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.catcannon.projectzero.exceptions.StructureException;
import com.catcannon.projectzero.renderables.Renderable;
import com.catcannon.projectzero.renderables.RenderableItem;

public class StateManager {
	List<RenderableItem> toRenderStatic = new ArrayList<RenderableItem>();
	List<RenderableItem> toRenderActors = new ArrayList<RenderableItem>();	
	
	List<Throwable> errors = new ArrayList<Throwable>();
	
	private static StateManager singleton = new StateManager();
	
	public static StateManager get(){
		return singleton;
	}
	
	public void throwException(Throwable e){
		errors.add(e);
	}
	
	public void checkForExceptions() throws Throwable {
		if(errors.isEmpty())
			return;
		else {
			Throwable e = errors.get(0);
			errors.remove(0);
			throw e;	
		}
	}
	
	public void clearAllRenderables(){
		toRenderStatic.clear();
		toRenderActors.clear();
	}
	
	public void addActor(RenderableItem actor){
		toRenderActors.add(actor);
	}
	
	public void updateInternalOrders(){
		Collections.sort(toRenderActors, new Comparator<RenderableItem>(){
			public int compare(RenderableItem arg0, RenderableItem arg1) {
				if(!arg0.getClass().isAnnotationPresent(Renderable.class) || !arg1.getClass().isAnnotationPresent(Renderable.class)){
					StructureException toThrow = new StructureException("either " + arg0.getClass().getName() + " or " + arg1.getClass().getName() + 
							" doesn't have the " + "@Renderable annotation");
					toThrow.fillInStackTrace();
					StateManager.get().throwException(toThrow);
				}
				boolean a = ((Renderable)(arg0.getClass().getAnnotation(Renderable.class))).isLit();
				boolean b = ((Renderable)(arg1.getClass().getAnnotation(Renderable.class))).isLit();
				
				return (!(a ^ b) ? 0 : (a ? 1 : 0) - (b ? 1 : 0)); // If a = b, returns 0. If a && !b, returns 1, If !a && b, returns -1.
																   // Basically, sorts the list, ascending, by whether it's lit or not.
			}
		});
	}
	
	public void render(){
		for(RenderableItem staticItem : toRenderStatic){
			if(staticItem.getClass().isAnnotationPresent(Renderable.class) && ((Renderable)(staticItem.getClass().getAnnotation(Renderable.class))).isLit()){
				staticItem.render();
			}
		}
	}
}
