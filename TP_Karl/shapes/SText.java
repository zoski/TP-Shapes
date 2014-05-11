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
public class SText extends Shape {
    private String str;
    private Point loc;
    
    public SText(Point loc, String str) {
        this.loc = loc;
        this.str = str;
    }
    public String getText(){
        return this.str;
    }
    public void setText(String str){
        this.str = str;
    }

    @Override
    public Rectangle getBounds() {
        Rectangle bounds = new Rectangle();
        bounds.x = this.loc.x;
        bounds.y = this.loc.y;
        bounds.width = 100; //TODO : width et height sur les bounds de textes 
        bounds.height = 100;
        return bounds;
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
    public void translate(int dx, int dy) {
        this.loc.x += dx;
        this.loc.y += dy;
    }

    @Override
    public void accept(ShapeVisitor sv) {
        sv.visitText(this);
    }
    
}
