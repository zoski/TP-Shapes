package graphics.shapes;

public interface ShapeVisitor {

	void visitRectangle(SRectangle r);

	void visitCircle(SCircle c);

	void visitText(SText sText);

	void visitCollection(SCollection scollection);
}
