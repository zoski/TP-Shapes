package graphics.shapes.ui;

import graphics.ui.Controller;

import java.awt.event.MouseEvent;

public class ShapesController extends Controller{

	public ShapesController(Object newModel) {
		super(newModel);
	}
	
	/* Il est nécessaire de redéfinir les actions voir pdf*/
	
	public void mousePressed(MouseEvent e){
		System.out.println("mouse pressed");
	}

	public void mouseReleased(MouseEvent e)	{
		System.out.println("mouse released");
	}

	public void mouseClicked(MouseEvent e) {
		System.out.println("mouse clicked");
	}
	
	public void mouseDragged(MouseEvent evt){
		System.out.println("mouse draged");
	}

}
