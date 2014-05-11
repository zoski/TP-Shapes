package graphics.shapes;

import graphics.shapes.attributes.Attribute;
import graphics.shapes.attributes.SelectionAttributes;

import java.awt.Point;
import java.awt.Rectangle;
import java.util.Map;
import java.util.TreeMap;

public abstract class Shape {
	private Map<String, Attribute> attributes;
	Point location;

	public Shape() {
		this.attributes = new TreeMap<String, Attribute>();
	}

	public void addAttribute(Attribute a) {
		this.attributes.put(a.getId(), a);
	}

	public Attribute getAttribute(String id) {
		return (Attribute) this.attributes.get(id);
	}

	public void select() {
		SelectionAttributes sa = (SelectionAttributes) getAttribute(SelectionAttributes.ID);
		sa.select();
		System.out.println("We try to select");
	}

	public boolean isSelected() {
		SelectionAttributes sa = (SelectionAttributes) getAttribute(SelectionAttributes.ID);
		return sa.isSelected();
	}

	public abstract Point getLoc();

	public abstract void setLoc(Point p);

	public abstract void translate(int dx, int dy);

	public abstract Rectangle getBounds();

	public abstract void accept(ShapeVisitor v);

	public abstract String getID();

}
