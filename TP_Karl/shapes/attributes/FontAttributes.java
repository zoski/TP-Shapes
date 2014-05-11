/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package graphics.shapes.attributes;

import graphics.shapes.ShapeVisitor;
import java.awt.Color;
import java.awt.Font;

/**
 *
 * @author Karl
 */
public class FontAttributes extends Attributes {
    private Font font;
    private Color fontColor;
    
    public FontAttributes(){
        super(Attributes.FONT);
    }
    public FontAttributes(Font font, Color fontColor){
        this();
        this.font = font;
        this.fontColor = fontColor;
    }
    public Font getFont(){
        return this.font;
    }
    public Color getColor(){
        return this.fontColor;
    }
    public void setFont(Font font){
        this.font = font;
    }
    public void setColor(Color fontColor){
        this.fontColor = fontColor;
    }
    
    @Override
    public void accept(ShapeVisitor sv) {
        sv.pencilFont(this);
    }
}
