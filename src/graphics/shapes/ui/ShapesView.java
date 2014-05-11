package graphics.shapes.ui;

import java.awt.Graphics;
import java.awt.Graphics2D;

import graphics.shapes.Shape;
import graphics.ui.Controller;
import graphics.ui.View;

public class ShapesView extends View {

	private ShapeDraftman draftman;

	public ShapesView(Shape model) {
		super(model);
		this.draftman = new ShapeDraftman();
	}

	protected void paintComponent(Graphics g) {
		// permet de representer la vue
		super.paintComponent(g);
		System.out.println("Actualisation...");

		this.draftman.setGraphics((Graphics2D) g);

		Shape model = (Shape) this.getModel();
		if (model == null)
			return;

		model.accept(this.draftman);
	}

	@Override
	public Controller defaultController(Object model) {
		return new ShapesController(model);
	}
	
	
}
