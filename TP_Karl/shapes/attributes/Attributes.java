/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package graphics.shapes.attributes;

import graphics.shapes.ShapeDraftman;
import graphics.shapes.ShapeVisitor;

/**
 *
 * @author Karl
 */
public abstract class Attributes {
    public static final String COLOR = "ColorAttribute";
    public static final String SELECTION = "SelectionAttribute";
    public static final String FONT = "FontAttribute";
    
    private String id;
    
    protected Attributes(String id){
        this.id = id;
    }
    public String getId(){
        return this.id;
    }
    public abstract void accept(ShapeVisitor sv);
}
