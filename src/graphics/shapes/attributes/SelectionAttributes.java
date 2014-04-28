package graphics.shapes.attributes;

public class SelectionAttributes extends Attribute 
{

	public static final String ID = "selection";
	private boolean selected;
	
	@Override
	public String getId() {
		// TODO Auto-generated method stub
		return this.ID;
	}
	
	public boolean isSelected()
	{
		return this.selected;
	}
	
	public void select()
	{
		this.selected = true;
	}
	
	public void unselect()
	{
		this.selected = false;
	}
	
	public void toogleSelection()
	{
		this.selected = !this.selected;
	}
}
