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

	public ShapesController(Object newModel) {
		super(newModel);
	}
	
	/* Il est necessaire de redefinir les actions voir pdf*/
	
	public void mousePressed(MouseEvent e)
	{
		System.out.println("mouse pressed");
		int x = e.getX();
		int y = e.getY();
		Shape s = this.getTarget();
		if(s != null)
		{
			//si on a une forme sous le click on selectionne la forme
		}
	}

	public void mouseReleased(MouseEvent e)	
	{
		System.out.println("mouse released");
	}

	public void mouseClicked(MouseEvent e) {
		int x = e.getX();int y = e.getY();
		System.out.println("mouse clicked at ("+ x +", " + y +")");
		
		Shape s = this.getTarget();
		if(s != null)
		{
			
		}
	}
	

	public void mouseDragged(MouseEvent e)
	{
		System.out.println("mouse draged");
	}
	
	public Shape getTarget() {
		/* Doit retourner la forme sur laquelle on clic ou rien */
		
		
		
		Shape s = null;
		
		
		return s;

//		for ( it=((Controller) this.model).getModel()collection.values().iterator() ; it.hasNext() ;)//on parcours toutes les formes de la fenetre
//			{
//				//on verifie pour chaque forme si les coordonnees correspondent
//				if(((Shape) it).getBounds().contains(new Point(x,y))) {
//					System.out.println("Forme trouve");
//					return it.;//si ca correspond bin on retourne la forme en question
//				}
//			}
//		return null;
	}
}
