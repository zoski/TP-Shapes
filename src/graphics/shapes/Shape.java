package graphics.shapes;

import graphics.shapes.attributes.Attribute;

import java.awt.Point;
import java.awt.Rectangle;
import java.util.Map;
import java.util.TreeMap;

public abstract class Shape {
	private Map attributes;
	Point location;
	

	public Shape() {
		this.attributes = new TreeMap();
	}
	

	
	@SuppressWarnings("unchecked")
	public void addAttribute(Attribute a) {
		this.attributes.put(a.getId(),a);
	}
	
	public Attribute getAttribute(String id) {
		return (Attribute) this.attributes.get(id);
	}
	
	public abstract Point getLoc();
	public abstract void setLoc(Point p);	
	public abstract void translate(int dx, int dy);
	public abstract Rectangle getBounds();
	public abstract void accept(ShapeVisitor v);
	public abstract String getID();
	
}
