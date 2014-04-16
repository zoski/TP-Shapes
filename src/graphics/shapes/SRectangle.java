package graphics.shapes;

import java.awt.Point;
import java.awt.Rectangle;

public class SRectangle extends Shape {
	private Rectangle rect;
	private final  String ID="Rectangle";
	
	public SRectangle(Point p, int width, int height) {
		this.rect = new Rectangle(p.x, p.y ,width, height);
		System.out.println("Rectangle created...");
	}

	@Override
	public Point getLoc() {
		return this.rect.getLocation();
	}

	@Override
	public void setLoc(Point p) {
		this.rect.setLocation(p);
	}

	@Override
	public void translate(int dx, int dy) {
		this.rect.translate(dx, dy);
	}

	@Override
	public Rectangle getBounds() {
		return this.rect;
	}

	@Override
	public void accept(ShapeVisitor v) {
		v.visitRectangle(this);
	}

	@Override
	public String getID() {
		return this.ID;
	}


	
}
