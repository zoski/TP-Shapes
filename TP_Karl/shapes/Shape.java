/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package graphics.shapes;

import graphics.shapes.attributes.Attributes;
import java.awt.Point;
import java.awt.Rectangle;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;

/**
 *
 * @author Karl
 */
public abstract class Shape {
    private HashMap<String, Attributes> attributes = new HashMap<>();
    
    public void addAttributes(Attributes attributes){
        this.attributes.put(attributes.getId(), attributes);
    }
    public Attributes getAttributes(String id){
        return this.attributes.get(id);
    }
    public Iterator<Entry<String, Attributes>> getAttributesIterator(){
        return this.attributes.entrySet().iterator();
    }
    public abstract void translate(int dx, int dy);
    public abstract void setLoc(Point loc);
    public abstract Point getLoc();
    public abstract Rectangle getBounds();
    public abstract void accept(ShapeVisitor sv);
}
