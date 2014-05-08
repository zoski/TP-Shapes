package graphics.shapes.attributes;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.font.FontRenderContext;
import java.awt.image.BufferedImage;

public class FontAttributes extends Attribute{
	public static final String ID = "font";
	public Font font;
	public Color fontColor;
	
	//j'instancie une image memoire afin de recuperer son graphics
	public static final Graphics2D DEFAULT_GRAPHICS = (Graphics2D) new BufferedImage(1, 1, BufferedImage.TYPE_INT_ARGB).getGraphics();
	
	 
	public FontAttributes() {
		this.font = new Font("Dialog", Font.PLAIN, 11);
		this.fontColor = Color.BLACK;
	}
	
	public FontAttributes(Font font, Color fontColor) {
		this.font = font;
		this.fontColor = fontColor;
	}
	
	public Rectangle getBounds(String s) {
		//TODO Le rectangle recupere est a  la bonne taille mais au coordonnee 0,0 il faut le deplacer avec translate.
		FontRenderContext frc = DEFAULT_GRAPHICS.getFontRenderContext();
		Rectangle bound = font.getStringBounds(s, frc).getBounds();
		return bound;
	}
	
	@Override
	public String getId() {
		return ID;
	}
	

}
