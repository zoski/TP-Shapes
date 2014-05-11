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
public class SRectangle extends Shape {
    private int width;
    private int height;
    private Point loc;

    public SRectangle(Point loc, int width, int height) {
        this.loc = loc;
        this.width = height;
        this.height = height;
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }
    
    @Override
    public Point getLoc(){
        return this.loc;
    }
    
    @Override
    public Rectangle getBounds() {
        Rectangle rect = new Rectangle();
        rect.x = this.loc.x - 1;
        rect.y = this.loc.y - 1;
        rect.width = this.width + 2;
        rect.height = this.height + 2;
        return rect;
    }

    @Override
    public void setLoc(Point loc) {
        this.loc = loc;
    }

    @Override
    public void translate(int dx, int dy) {
        this.loc.x += dx;
        this.loc.y += dy;
    }

    @Override
    public void accept(ShapeVisitor sv) {
        sv.visitRectangle(this);
    }
    
}
