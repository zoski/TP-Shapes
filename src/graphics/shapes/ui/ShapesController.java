package graphics.shapes.ui;

import graphics.shapes.SCollection;
import graphics.shapes.Shape;
import graphics.ui.Controller;

import java.awt.Point;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.util.Iterator;

public class ShapesController extends Controller {

	private Point clicLoc;
	private boolean isShift;

	public ShapesController(Object newModel) {
		super(newModel);
	}

	public void mousePressed(MouseEvent e) {
		System.out.println("mouse pressed");
		this.clicLoc = new Point(e.getX(), e.getY());
		Shape s = this.getTarget(clicLoc);
		if (s != null) {
			System.out.println("Shape found :" + s + "is selected");
			if (!shiftDown()) {
				Iterator<Shape> i = ((SCollection) super.getModel()).getMap().values().iterator();
				while (i.hasNext()) {
					i.next().unSelect();
				}
			}
			s.select();
			if (s.isSelected()) {
				System.out.println("shape selected");
			}
			this.getView().updateUI();
		} else {/* On parcourt le model et on déselect toutes les shape */
			Iterator<Shape> it = (((SCollection) super.getModel()).getMap())
					.values().iterator();

			// on parcours la map
			while (it.hasNext()) {
				it.next().unSelect();
			}
			this.getView().updateUI();
		}
	}

	public void mouseReleased(MouseEvent e) {
		System.out.println("mouse released");
	}

	public void mouseClicked(MouseEvent e) {
		this.clicLoc = new Point(e.getX(), e.getY());
		Shape s = this.getTarget(clicLoc);
		
		
		if (s != null) {/*si 'y a une forme on la select*/
			if (!shiftDown()) {
				Iterator<Shape> i = ((SCollection) super.getModel()).getMap().values().iterator();
				while (i.hasNext()) {
					i.next().unSelect();
				}
			}
			s.select();
			this.getView().updateUI();
		} 
		else {/* si'y a pas de formes on deselect tout */
			
			Iterator<Shape> it = (((SCollection) super.getModel()).getMap())
					.values().iterator();

			// on parcours la map
			while (it.hasNext()) {
				it.next().unSelect();
			}
			this.getView().updateUI();
		}
	}

	public void mouseDragged(MouseEvent e) {
		int x = e.getX();
		int y = e.getY();
		System.out.println("mouse dragged");
		Shape s = getTarget(clicLoc);

		if ((s != null) && s.isSelected()) {
			translateSelected(x - this.clicLoc.x, y - this.clicLoc.y);
			this.getView().updateUI();
			this.clicLoc = new Point(e.getX(), e.getY());
		}
	}

	private Shape getTarget(Point pos) {
		for (Iterator<Shape> it = ((SCollection) this.getModel()).iterator(); it.hasNext();) {
			Shape pointer = it.next();
			if (pointer.getBounds().contains(pos)) {
				return pointer;
			}
		}
		return null;
	}

	public boolean shiftDown() {
		isShift = true;
		return isShift;
	}

	public void keyTyped(KeyEvent evt) {
		shiftDown();
		System.out.println("touche tapee");
	}

	public void keyPressed(KeyEvent evt) {
		shiftDown();
		System.out.println("touche pressee");
	}

	public void keyReleased(KeyEvent evt) {
		isShift = false;
	}

	public void translateSelected(int x, int y) {
		Iterator<Shape> it = (((SCollection) super.getModel()).getMap()).values().iterator();
		while (it.hasNext()) {
			if (it.next().isSelected()) {
				it.next().translate(x, y);
			}
		}
		Shape s = getTarget(clicLoc);
		s.translate(x, y);
	}

}
