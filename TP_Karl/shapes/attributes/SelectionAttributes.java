/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package graphics.shapes.attributes;

import graphics.shapes.ShapeVisitor;
import java.awt.Point;

/**
 *
 * @author Karl
 */
public class SelectionAttributes extends Attributes {    
    boolean selected;
    
    public SelectionAttributes(){
        super(Attributes.SELECTION);
        this.selected = false;
    }
    public boolean isSelected(){
        return this.selected;
    }
    public void select(){
        this.selected = true;
    }
    public void unselect(){
        this.selected = false;
    }
    public void toggle(){
        this.selected = !selected;
    }
    
    @Override
    public void accept(ShapeVisitor sv) {
        sv.pencilSelection(this);
    }
}
