/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package graphics.shapes.ui;

import graphics.shapes.SCollection;
import graphics.shapes.ShapeDraftman;
import graphics.ui.Controller;
import graphics.ui.View;
import java.awt.Graphics;

/**
 *
 * @author Karl
 */
public class ShapesView extends View{
    public ShapesView(Object model){
        super(model);
    }
    
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        
        ShapeDraftman sdm = new ShapeDraftman(g);
        
        SCollection model = (SCollection) this.getModel();
        model.accept(sdm);
    }
    
    @Override
    public Controller defaultController(Object model)
    {
            return new ShapesController(this.getModel());
    }
}
