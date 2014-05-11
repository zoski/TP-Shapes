/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package graphics.shapes;

import java.awt.Point;
import java.awt.Rectangle;

/**
 *
 * @author Karl
 */
public class SCircle extends Shape {
    private Point loc;
    private int radius;
    
    public SCircle(Point loc, int radius) {
        this.loc = loc;
        this.radius = radius;
    }
    public int getRadius(){
        return this.radius;
    }
    public void setRadius(int radius){
        this.radius = radius;
    }
    
    @Override
    public Rectangle getBounds() {
        Rectangle bounds = new Rectangle();
        bounds.x = this.loc.x - 1;
        bounds.y = this.loc.y - 1;
        bounds.width = this.radius * 2 + 2;
        bounds.height = this.radius * 2 + 2;
        return bounds;
    }

    @Override
    public void translate(int dx, int dy) {
        this.loc.x += dx;
        this.loc.y += dy;
    }

    @Override
    public void setLoc(Point loc) {
        this.loc = loc;
    }

    @Override
    public Point getLoc() {
        return this.loc;
    }

    @Override
    public void accept(ShapeVisitor sv) {
        sv.visitCircle(this);
    }
    
}
