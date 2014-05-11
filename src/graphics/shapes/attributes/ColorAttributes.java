package graphics.shapes.attributes;

import java.awt.Color;

public class ColorAttributes extends Attribute {

	public final static String ID = "colors";
	public Color strokedColor;
	public Color filledColor;
	public boolean filled;
	public boolean stroked;

	/* Contructeurs */
	public ColorAttributes() {
		this.strokedColor = Color.BLACK;
		this.filledColor = Color.WHITE;
		this.stroked = true;
		this.filled = false;
	}

	public ColorAttributes(boolean strocked, boolean filled,
			Color strockedColor, Color filledColor) {
		this.strokedColor = strockedColor;
		this.filledColor = filledColor;
		this.stroked = strocked;
		this.filled = filled;
	}

	@Override
	public String getId() {
		return ID;
	}

}
