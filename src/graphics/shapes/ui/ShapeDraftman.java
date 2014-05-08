package graphics.shapes.ui;

import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import java.util.Iterator;
import java.util.Map;

import graphics.shapes.SCircle;
import graphics.shapes.SCollection;
import graphics.shapes.SRectangle;
import graphics.shapes.SText;
import graphics.shapes.Shape;
import graphics.shapes.ShapeVisitor;
import graphics.shapes.attributes.ColorAttributes;
import graphics.shapes.attributes.FontAttributes;
import graphics.shapes.attributes.SelectionAttributes;

public class ShapeDraftman implements ShapeVisitor {
	
	private static final ColorAttributes DEFAULT_COLOR_ATTRIBUTES = new ColorAttributes();
	private static final FontAttributes DEFAULT_FONT_ATTRIBUTES = new FontAttributes();
	private Graphics2D g;
	
	public void setGraphics(Graphics2D g) {
		this.g=g;
	}

	@Override
	public void visitRectangle(SRectangle r) {
	
		System.out.println("Je dessine un rectangle\n" + r.getBounds());
		
		//Dessine
		Rectangle rect = r.getBounds();
		ColorAttributes ca = (ColorAttributes) r.getAttribute(ColorAttributes.ID);
		SelectionAttributes sa = (SelectionAttributes) r.getAttribute(SelectionAttributes.ID);
		if(sa.isSelected()){
			g.drawRect(r.getLoc().x, r.getLoc().y, 5, 5);
			g.drawRect(r.getLoc().x-r.getBounds().height, r.getLoc().y+r.getBounds().width, 5, 5);
		}
		/* Verifions si il y  des attributs */
		if(ca==null) ca = DEFAULT_COLOR_ATTRIBUTES; /* S'il n'y en a† pas on met ceux du constructeur par defaut */
		
		/* S'il y a on applique */
		if(ca.filled) {		//Remplissage
			g.setColor(ca.filledColor);
			g.fillRect(rect.x, rect.y, rect.width, rect.height);
		}
		
		if(ca.stroked) {	//Contours
			g.setColor(ca.strokedColor);
			g.drawRect(rect.x, rect.y, rect.width, rect.height);
		}
		
		/* On dessine le contour apr√®s le fonds*/
//		g.setColor(Color.RED);//on change la couleur de dessin
//		g.drawRect(rect.x, rect.y, rect.width, rect.height);
//		g.setColor(Color.BLUE);
//		g.fillRect(rect.x+1, rect.y+1, rect.width-1, rect.height-1);
		
	}

	@Override
	public void visitCircle(SCircle c) {
		Rectangle rect = c.getBounds();
		ColorAttributes ca = (ColorAttributes) c.getAttribute(ColorAttributes.ID);
		/* Verifions si il y  des attributs */
		if(ca==null) ca = DEFAULT_COLOR_ATTRIBUTES; /* S'il n'y en a pas on met ceux du constructeur par defaut */
		
		/* S'il y a on applique */
		if(ca.filled) {
			g.setColor(ca.filledColor);
			g.fillOval(rect.x, rect.y, rect.width, rect.height);
		}
		
		if(ca.stroked) {
			g.setColor(ca.strokedColor);
			g.drawOval(rect.x, rect.y, rect.width, rect.height);
		}
	}

	public void visitText(SText t) {
		Rectangle rect = t.getBounds();
		rect.translate(0, -rect.width/2);
		ColorAttributes ca = (ColorAttributes) t.getAttribute(ColorAttributes.ID);
		Point loc = t.getLoc(); 
		
		/* Verifions si il y  des attributs */
		if(ca==null) ca = DEFAULT_COLOR_ATTRIBUTES;
		
		FontAttributes fa = (FontAttributes) t.getAttribute(FontAttributes.ID);
		if(fa==null) fa = DEFAULT_FONT_ATTRIBUTES;
		
		if(ca.filled) {
			g.setColor(ca.filledColor);
			g.fillRect(rect.x, rect.y, rect.width, rect.height);
		}
		
		if(ca.stroked) {
			g.setColor(ca.strokedColor);
			g.drawRect(rect.x, rect.y, rect.width, rect.height);
		}
		
		SelectionAttributes sa = (SelectionAttributes) t.getAttribute(SelectionAttributes.ID);
		if(sa.isSelected()){
			g.drawRect(t.getLoc().x, t.getLoc().y, 5, 5);
			g.drawRect(t.getLoc().x-t.getBounds().height, t.getLoc().y+t.getBounds().width, 5, 5);
		}
		
		g.setFont(fa.font);
		g.setColor(fa.fontColor);
		g.drawString(t.getText(), loc.x, loc.y);
	}

	@Override
	public void visitCollection(SCollection co) {
		Map<String, Shape> tmp = co.getMap();
		
		if(tmp.isEmpty()) {//collection vide on ne fait rien			
		}
		else { 
			for (Iterator<Shape> i = tmp.values().iterator() ; i.hasNext() ;){//on parcourt la Map
			    i.next().accept(this);	//chaque shape de la collection accepte la visite du shapedraftman
			}
		}	
	}
}
