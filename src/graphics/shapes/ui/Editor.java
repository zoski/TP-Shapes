package graphics.shapes.ui;

import graphics.shapes.*;
import graphics.shapes.attributes.ColorAttributes;
import graphics.shapes.attributes.SelectionAttributes;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;

import javax.swing.JFrame;

public class Editor extends JFrame {
	ShapesView sview;
	SCollection model = new SCollection(new Point(10, 10));

	/*
	 * TODO SCollection avec rect.union done 
	 * TODO Controleur 
	 * TODO Rajouter un point permettant de gerer le deplacement 
	 * TODO Attributs de selection 
	 * TODO getTarget() dit s'il y à une forme (r�f�rence) ou rien s'il n'y à rien
	 * TODO Finir le draftman
	 */

	public Editor() {
		super("Shapes Editor");

		this.addWindowListener(new java.awt.event.WindowAdapter() {
			public void windowClosing(java.awt.event.WindowEvent evt) {
				System.exit(0);
			}
		});

		this.buildModel();

		this.sview = new ShapesView(this.model);
		this.sview.setPreferredSize(new Dimension(450, 450));
		this.getContentPane().add(this.sview, java.awt.BorderLayout.CENTER);
	}

	private void buildModel() {
		SText st = new SText(new Point(60, 30), "Hello");
		st.addAttribute(new ColorAttributes(true, true, Color.BLUE, Color.RED));
		st.addAttribute(new SelectionAttributes());
		this.model.add(st);

		SRectangle sr = new SRectangle(new Point(70, 60), 20, 30);
		sr.addAttribute(new ColorAttributes(true, true, Color.BLUE, Color.YELLOW));
		sr.addAttribute(new SelectionAttributes(true));
		this.model.add(sr);
		//
		// SCircle sc = new SCircle(new Point(20,80), 20);
		// sc.addAttribute(new ColorAttributes(true, true, Color.GREEN,
		// Color.CYAN));
		// this.model.add(sc);
		//
		System.out.println(model);

		// this.model = new SCollection();
		// this.model.addAttributes(new SelectionAttributes());
		//
		// SRectangle r = new SRectangle(new Point(10,10),20,30);
		// r.addAttributes(new
		// ColorAttributes(true,false,Color.BLUE,Color.BLUE));
		// r.addAttributes(new SelectionAttributes());
		// this.model.add(r);
		//
		SCircle c = new SCircle(new Point(100, 100), 10);
		c.addAttribute(new ColorAttributes(false, true, Color.BLUE, Color.BLUE));
		c.addAttribute(new SelectionAttributes());
		this.model.add(c);
		//
		// SText t= new SText(new Point(100,100),"hello");
		// t.addAttributes(new
		// ColorAttributes(true,true,Color.YELLOW,Color.BLUE));
		// t.addAttributes(new FontAttributes());
		// t.addAttributes(new SelectionAttributes());
		// this.model.add(t);
		//
		SCollection sc = new SCollection(new Point(20, 20));
		// sc.addAttributes(new SelectionAttributes());
		SRectangle r = new SRectangle(new Point(20, 30), 30, 30);
		r.addAttribute(new ColorAttributes(true, true, Color.RED, Color.BLUE));
		r.addAttribute(new SelectionAttributes());
		sc.add(r);
		SCircle c2 = new SCircle(new Point(150, 100), 50);
		c2.addAttribute(new ColorAttributes(true, true, Color.RED, Color.DARK_GRAY));
		c2.addAttribute(new SelectionAttributes());
		sc.add(c2);
		this.model.add(sc);
	}

	public static void main(String[] args) {
		Editor self = new Editor();
		self.pack();				/*Optimise la taille de la fenetre*/
		self.setVisible(true);		/* affiche la fenetre */
	}
}
