package graphics.shapes.ui;

import graphics.shapes.Shape;
import graphics.ui.Controller;

import java.awt.event.MouseEvent;

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
		int x = e.getX();
		int y = e.getY();
		System.out.println("mouse clicked at ("+ x +", " + y +")");
		
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
	
	public Shape getTarget(int x, int y) {
		Shape s ;
		
		
		
		
		return s;
//		for (Iterator<Shape> j=((SCollection)this.model).collection.values().iterator() ; j.hasNext() ;)//on parcours toutes les formes de la fenetre
//		{
//			//on verifie pour chaque forme si les coordonnees correspondent
//			if(j.getBounds() == loc)
//			{
//				return j;//si ca correspond bin on retourne la forme en question
//			}
//		}
//		//si apres parcours des formes on trouve rien on retourne rien
//		return null;
	}

}
