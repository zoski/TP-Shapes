/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package graphics.shapes;

import graphics.shapes.attributes.Attributes;
import graphics.shapes.attributes.ColorAttributes;
import graphics.shapes.attributes.FontAttributes;
import graphics.shapes.attributes.SelectionAttributes;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
import java.util.Iterator;
import java.util.Map.Entry;

/**
 *
 * @author Karl
 */
public class ShapeDraftman implements ShapeVisitor{
    private Graphics g;
    private Shape currentShape;
    
    public ShapeDraftman(Graphics g){
        this.g = g;
    }
    
    @Override
    public void visitRectangle(SRectangle rect) {
        this.currentShape = rect;
        this.scanAttributes(rect);
        this.g.drawRect(rect.getLoc().x, rect.getLoc().y, rect.getWidth(), rect.getHeight());
    }

    @Override
    public void visitCircle(SCircle circle) {
        this.currentShape = circle;
        this.scanAttributes(circle);
        this.g.drawOval(circle.getLoc().x, circle.getLoc().y, circle.getRadius() * 2, circle.getRadius() * 2);
    }

    @Override
    public void visitCollection(SCollection collection) {
        this.currentShape = collection;
        for(Iterator<Shape> it = collection.iterator(); it.hasNext(); ){
            it.next().accept(this);
        }
    }

    @Override
    public void visitText(SText text) {
        this.currentShape = text;
        this.scanAttributes(text);
        this.g.drawString(text.getText(), text.getLoc().x, text.getLoc().y);
    }
    
    private void scanAttributes(Shape s){
        for(Iterator<Entry<String, Attributes>> it = s.getAttributesIterator(); it.hasNext();){
            ((Attributes) it.next().getValue()).accept(this);
        }
    }
    
    @Override
    public void pencilColor(ColorAttributes ca){
        if(ca.isFilled()){
            this.g.setColor(ca.getFilledColor());
            if(this.currentShape instanceof SRectangle){
                SRectangle s = (SRectangle) this.currentShape;
                this.g.fillRect(s.getLoc().x+1, s.getLoc().y+1, s.getWidth()-1, s.getHeight()-1);
            }
            else if(this.currentShape instanceof SCircle){
                SCircle s = (SCircle) this.currentShape;
                this.g.fillOval(s.getLoc().x, s.getLoc().y, s.getRadius() * 2, s.getRadius() * 2);
            }
        }
        if(ca.isStroked()){
            this.g.setColor(ca.getStrokedColor());            
        }
    }
    
    @Override
    public void pencilFont(FontAttributes fa){
        this.g.setFont(fa.getFont());
    }
    
    @Override
    public void pencilSelection(SelectionAttributes sa){
        if(sa.isSelected()){
            Rectangle bounds = this.currentShape.getBounds();
            int size = 2;
            this.g.setColor(Color.BLACK);  
            this.g.drawRect(bounds.x - size, bounds.y - size, size, size);
            this.g.drawRect(bounds.x + bounds.width, bounds.y + bounds.height, size, size);
        }
    }
}
