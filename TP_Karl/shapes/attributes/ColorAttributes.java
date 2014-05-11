/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package graphics.shapes.attributes;

import graphics.shapes.ShapeVisitor;
import java.awt.Color;

/**
 *
 * @author Karl
 */
public class ColorAttributes extends Attributes {
    private boolean filled;
    private boolean stroked;
    private Color filledColor;
    private Color strokedColor;
    
    public ColorAttributes(boolean filled, boolean stroked, Color filledColor, Color strokedColor){
        super(Attributes.COLOR);
        this.filled = filled;
        this.stroked = stroked;
        this.filledColor = filledColor;
        this.strokedColor = strokedColor;
    }
    public boolean isFilled(){
        return this.filled;
    }
    public void fill(Color filledColor){
        this.filled = true;
        this.filledColor = filledColor;
    }
    public void unfill(){
        this.filled = false;
    }
    public boolean isStroked(){
        return this.stroked;
    }
    public void stroke(Color strokedColor){
        this.stroked = true;
        this.strokedColor = strokedColor;
    }
    public void unstoke(){
        this.stroked = false;
    }
    public Color getFilledColor() {
        return filledColor;
    }
    public Color getStrokedColor() {
        return strokedColor;
    }

    @Override
    public void accept(ShapeVisitor sv) {
        sv.pencilColor(this);
    }
}
