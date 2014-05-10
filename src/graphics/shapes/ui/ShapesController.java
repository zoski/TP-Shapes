package graphics.shapes.ui;

import graphics.shapes.SCollection;
import graphics.shapes.Shape;
import graphics.ui.Controller;

import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.util.Iterator;

import graphics.shapes.ui.Editor;

public class ShapesController extends Controller{
	
	private Point clicLoc;

	public ShapesController(Object newModel) {
		super(newModel);
	}
	
	/* Il est necessaire de redefinir les actions voir pdf*/
	
	public void mousePressed(MouseEvent e)
	{
		System.out.println("mouse pressed");
		this.clicLoc = new Point(e.getX(),e.getY());
		Shape s = this.getTarget();
		if(s != null)
		{
			s.select();
		}
	}

	public void mouseReleased(MouseEvent e)	
	{
		System.out.println("mouse released");
	}

	public void mouseClicked(MouseEvent e) 
	{
		this.clicLoc = new Point(e.getX(),e.getY());
		Shape s = this.getTarget();
		if(s != null)
		{
			s.select();
		}
	}
	

	public void mouseDragged(MouseEvent e)
	{
		System.out.println("mouse draged");
	}
	
	public Shape getTargetArg(Shape r)
	{
		Shape s = null;
		
		//si la shape est une collection on parcours la collection et on rappelle getTarget()
		if(r instanceof SCollection)
		{
		Iterator<Shape> it = (((SCollection)r).getMap()).values().iterator();
		
			//on parcours la map
			while(it.hasNext())
			{
				s = getTargetArg(it.next());
			}
		}
		
		//quand c'est pas une collection on regarde si le clic est dans la forme
		if(r.getBounds().contains(this.clicLoc))
		{
			s = r;
		}
		
		return s;
	}
	
	public Shape getTarget() 
	{
		/* Doit retourner la forme sur laquelle on clic ou rien */
		return getTargetArg((Shape)super.getModel());
	}

}
