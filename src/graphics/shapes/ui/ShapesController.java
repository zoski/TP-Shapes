package graphics.shapes.ui;

import graphics.shapes.SCollection;
import graphics.shapes.Shape;
import graphics.ui.Controller;

import java.awt.Point;
import java.awt.event.MouseEvent;
import java.util.Iterator;

public class ShapesController extends Controller {

	private Point clicLoc;

	public ShapesController(Object newModel) {
		super(newModel);
	}

	public void mousePressed(MouseEvent e) {
		System.out.println("mouse pressed");
		this.clicLoc = new Point(e.getX(), e.getY());
		Shape s = this.getTarget();
		if (s != null) {
			System.out.println("Shape found :" + s + "is selected");
			s.select();
			if (s.isSelected()){
				System.out.println("shape selected");
			}
			this.getView().updateUI();
		}
	}

	public void mouseReleased(MouseEvent e) {
		System.out.println("mouse released");
	}

	public void mouseClicked(MouseEvent e) {
		this.clicLoc = new Point(e.getX(), e.getY());
		Shape s = this.getTarget();
		if (s != null) {
			System.out.println("Shape detected");
			s.select();
			if (s.isSelected()){
				System.out.println("shape selected");
			}
			this.getView().updateUI();
		}
	}

	public void mouseDragged(MouseEvent e) {
		int x = e.getX();
		int y = e.getY();
		System.out.println("mouse dragged");
		Shape s = getTarget();
		if ((s != null) && s.isSelected()) {
			translateSelected(x-this.clicLoc.x, y-this.clicLoc.y);
			this.getView().updateUI();
			this.clicLoc = new Point(e.getX(),e.getY());
		}
	}

	public Shape getTargetArg(Shape r) {
		Shape s = null;

		// si la shape est une collection on parcours la collection et on
		// rappelle getTarget()
		if (r instanceof SCollection) {
			Iterator<Shape> it = (((SCollection) r).getMap()).values().iterator();

			// on parcours la map
			while (it.hasNext()) {
				s = getTargetArg(it.next());
			}
		}

		/* si c'est pas une collection on regarde si le clic est dans la forme */
		else if (r.getBounds().contains(this.clicLoc)) {
			System.out.println("Shape found");
			s = r;
		}

		return s;
	}

	public Shape getTarget() {
		/* Doit retourner la forme sur laquelle on clic ou rien */
		return getTargetArg((Shape) super.getModel());
	}

	public void translateSelected(int x, int y) {
		Shape s = getTarget();
		s.translate(x, y);
	}
	

	

}
