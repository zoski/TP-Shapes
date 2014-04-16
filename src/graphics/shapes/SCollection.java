package graphics.shapes;

import java.awt.Point;
import java.awt.Rectangle;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

public class SCollection extends Shape{
	public Map<String, Shape>  collection;
	private Point loc;
	private final String ID="Collection";
	
	public SCollection (Point loc) {
		this.collection = new TreeMap<String, Shape>();
		this.loc=loc;
		System.out.println("Collection created...");
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
		this.translate(dx, dy);
	}
	@Override
	public Rectangle getBounds() {
		Iterator<Shape> i=this.collection.values().iterator() ;
		Rectangle bound = new Rectangle();
		bound = i.next().getBounds();//On place le getBound de la première forme de la map comme point de départ
		
		for (Iterator<Shape> j=collection.values().iterator() ; j.hasNext() ;){//on parcourt la Map
		   bound = j.next().getBounds().union(bound);	//On fait l'union succéssive de toute les shapes de la map
		}
		System.out.println("get bound de la collection " + bound);
		return bound;
	}
	
	@Override
	public void accept(ShapeVisitor v) {
		v.visitCollection(this);
	}
	
	public void add(Shape s) {
		collection.put(s.getID(), s);
	}
	
	public Map<String, Shape> getMap() {
		return this.collection;
	}
	
	@Override
	public String getID() {
		return this.ID;
	}
	
	public String toString() {
		StringBuffer tmp = new StringBuffer();
		tmp.append(this.getBounds());
		return (String)tmp.toString();
	}
	
	
	

	
	
	

}
