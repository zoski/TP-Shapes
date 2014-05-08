package graphics.shapes.attributes;

public class SelectionAttributes extends Attribute 
{

	public static final String ID = "selection";
	private boolean selected;
	
	@Override
	public String getId() {
		return this.ID;
	}
	
	public SelectionAttributes()
	{
		this.selected = false;
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
