package graphics.shapes;

import graphics.shapes.attributes.FontAttributes;

import java.awt.Point;
import java.awt.Rectangle;

public class SText extends Shape{
	private Point loc;
	private String text;
	private FontAttributes fa;
	private final  String ID="Text";
	
	public SText(Point loc, String text) {
		this.loc = loc;
		this.text= text;
		this.fa = new FontAttributes();
		System.out.println("Text created...");
	}

	@Override
	public Point getLoc() {
		return this.loc;
	}

	@Override
	public void setLoc(Point loc) {
		this.loc=loc;
	}

	@Override
	public void translate(int dx, int dy) {
		this.loc.translate(dx, dy);
	}

	@Override
	public Rectangle getBounds() {	//c'est la merde
		return new Rectangle(loc.x, loc.y, fa.getBounds(this.text).width,fa.getBounds(this.text).height);
	}

	@Override
	public void accept(ShapeVisitor v) {
		v.visitText(this);
	}

	public String getText() {
		return this.text;
	}

	@Override
	public String getID() {
		return this.ID;
	}

}
