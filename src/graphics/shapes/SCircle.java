package graphics.shapes;

import java.awt.Point;
import java.awt.Rectangle;

public class SCircle extends Shape {
	private int radius;
	private Point loc; // point en haut à gauche
	private final String ID = "Circle";

	public SCircle(Point loc, int radius) {
		this.loc = loc;
		this.radius = radius;
		System.out.println("Circle created...");
	}

	@Override
	public Point getLoc() {
		return this.loc;
	}

	@Override
	public void setLoc(Point p) {
		this.loc = p;
	}

	@Override
	public void translate(int dx, int dy) {
		this.loc.translate(dx, dy);

	}

	@Override
	public Rectangle getBounds() {
		return new Rectangle(loc.x, loc.y, radius * 2, radius * 2);
	}

	@Override
	public void accept(ShapeVisitor v) {
		v.visitCircle(this);
	}

	@Override
	public String getID() {
		return this.ID;
	}

}
