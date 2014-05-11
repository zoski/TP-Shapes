package graphics.shapes.attributes;

public class SelectionAttributes extends Attribute {

	public static final String ID = "selection";
	private boolean selected;

	@Override
	public String getId() {
		return SelectionAttributes.ID;
	}

	public SelectionAttributes() {
		this.selected = false;
	}

	public SelectionAttributes(boolean state) {
		this.selected = state;
	}

	public boolean isSelected() {
		return this.selected;
	}

	public void select() {
		this.selected = true;
	}

	public void unselect() {
		this.selected = false;
	}

	public void toogleSelection() {
		this.selected = !this.selected;
	}
}
