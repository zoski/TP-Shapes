package graphics.shapes.ui;

import graphics.shapes.Shape;
import graphics.ui.Controller;

import java.awt.Point;
import java.awt.event.MouseEvent;
import java.util.Iterator;

public class ShapesController extends Controller{

	public ShapesController(Object newModel) {
		super(newModel);
	}
	
	/* Il est nÃ©cessaire de redÃ©finir les actions voir pdf*/
	
	public void mousePressed(MouseEvent e)
	{
		System.out.println("mouse pressed");
		int x = e.getX();
		int y = e.getY();
		Shape s = this.getTarget(x, y);
		if(s != null)
		{
			//si on a une forme sous le click on selectionne la forme
		}
	}

	public void mouseReleased(MouseEvent e)	
	{
		System.out.println("mouse released");
	}

	public void mouseClicked(MouseEvent e) 
	{
		System.out.println("mouse clicked");
		int x = e.getX();
		int y = e.getY();
		Shape s = this.getTarget(x, y);
		if(s != null)
		{
			//si on a une forme sous le click on selectionne la forme
		}
	}
	
	public void mouseDragged(MouseEvent e)
	{
		System.out.println("mouse draged");
	}
	
	public Shape getTarget(int x, int y)
	{
		Point loc = new Point(x,y);
		for (Iterator<Shape> j=((SCollection)this.model).collection.values().iterator() ; j.hasNext() ;)//on parcours toutes les formes de la fenêtre
		{
			//on vérifie pour chaque forme si les coordonnées correspondent
			if(j.getBounds() == loc)
			{
				return j;
			}
		}
		//si après parcours des formes on trouve rien on retourne rien
		return null;
	}

}
