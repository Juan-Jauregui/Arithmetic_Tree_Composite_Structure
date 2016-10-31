package dp_hw9;
/* Uses my LinkedList Composite implementation from a previous homework to create
 * the arithmetic tree structure. */
public abstract class ArithmeticComponent extends LinkedComposite{

	public ArithmeticComponent(Component... comps) throws Exception {
		super(comps);
	}

	/* Support for Visitor objects: Essentially just acceptVisitor().
	 * In observance of Halloween, I've renamed it after the best vampire movie ever made. */
	public abstract String letTheRightOneIn(Visitor v) throws Exception;
}
