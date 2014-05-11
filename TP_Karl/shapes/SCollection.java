/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package graphics.shapes;

import java.awt.Point;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author Karl
 */
public class SCollection extends Shape {
    private ArrayList<Shape> shapes;
    private Point loc;
    
    public SCollection(){
        this.shapes = new ArrayList<>();
    }
    
    public void add(Shape shape){
        this.shapes.add(shape);
        if(this.loc == null){
            this.loc = shape.getLoc();
        }
        if(this.loc.x > shape.getLoc().x){
            this.loc.x = shape.getLoc().x;
        }
        if(this.loc.y > shape.getLoc().y){
            this.loc.y = shape.getLoc().y;
        }
    }
    public Iterator<Shape> iterator(){
        return this.shapes.iterator();
    }
    @Override
    public Rectangle getBounds() {
        int x = this.loc.x;
        int y = this.loc.y;
        int dx = 0;
        int dy = 0;
        Shape current;
        Rectangle currentBound;
        for(Iterator<Shape> it = this.iterator(); it.hasNext();){
            current = it.next();
            currentBound = current.getBounds();
            if(x + dx < currentBound.x + currentBound.width){
                dx = currentBound.x + currentBound.width;
            }
            if(y + dy < currentBound.y + currentBound.height){
                dy = currentBound.y + currentBound.height;
            }
        }
        Rectangle bounds = new Rectangle();
        bounds.x = x;
        bounds.y = y;
        bounds.width = dx - x;
        bounds.height = dy - y;
        return bounds;
    }

    @Override
    public void setLoc(Point loc) {
        int dx = loc.x - this.loc.x;
        int dy = loc.y - this.loc.y;
        this.loc = loc;
        Shape current;
        for(Iterator<Shape> it = this.iterator(); it.hasNext();){
            current = it.next();
            current.translate(dx, dy);
        }
    }

    @Override
    public Point getLoc() {
        return (this.loc == null)?(new Point(0,0)):(this.loc);
    }

    @Override
    public void translate(int dx, int dy) {
        this.loc.x += dx;
        this.loc.y += dy;
        for(Iterator<Shape> it = this.iterator(); it.hasNext();){
            it.next().translate(dx, dy);
        }
    }

    @Override
    public void accept(ShapeVisitor sv) {
        sv.visitCollection(this);
    }
    
}
