/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package graphics.shapes;

import graphics.shapes.attributes.ColorAttributes;
import graphics.shapes.attributes.FontAttributes;
import graphics.shapes.attributes.SelectionAttributes;


/**
 *
 * @author Karl
 */
public interface ShapeVisitor {
    public abstract void visitRectangle(SRectangle rectangle);
    public abstract void visitCircle(SCircle circle);
    public abstract void visitCollection(SCollection collection);
    public abstract void visitText(SText text);
    
    public abstract void pencilColor(ColorAttributes color);
    public abstract void pencilFont(FontAttributes font);
    public abstract void pencilSelection(SelectionAttributes selection);
}
