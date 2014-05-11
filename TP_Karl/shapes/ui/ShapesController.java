/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package graphics.shapes.ui;

import graphics.shapes.SCollection;
import graphics.shapes.Shape;
import graphics.shapes.attributes.Attributes;
import graphics.shapes.attributes.SelectionAttributes;
import graphics.ui.Controller;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.util.Iterator;

/**
 *
 * @author Karl
 */
class ShapesController extends Controller {

    public ShapesController(Object model) {
        super(model);
    }
    
    private Shape getTarget(Point pos){
        for(Iterator<Shape> it = ((SCollection) this.getModel()).iterator(); it.hasNext();){
            Shape pointer = it.next();
            if(pointer.getBounds().contains(pos)){
                return pointer;
            }
        }
        return null;
    }
    
    @Override
    public void mouseClicked(MouseEvent e){
        Shape toToggle;
        if((toToggle = this.getTarget(e.getPoint())) != null){
            ((SelectionAttributes) toToggle.getAttributes(Attributes.SELECTION)).toggle();
        }
        this.getView().repaint();
    }
}