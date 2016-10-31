package dp_hw9;
public abstract class Component {

	public Component parent = null;
	private int numChildren = 0;

	public Component(){}
	
	/* Set the Component's parent. Used for add() and remove()*/
	protected void setParent(Component p){
		this.parent = p;
	}
	
	/* Access the component's parent. */
	public Component getParent(){
		return this.parent;
	}
	
	/* Template Method: Delegate the implementation of Component insertion/deletion 
	 * to subclasses, but certify that insertions know who their parent is
	 * (as all Components should) */
	public void add(Component c) throws Exception {
		this.doAdd(c);
		c.setParent(this);
		this.numChildren++;
	}
	public void remove(Component c) throws Exception {
		this.doRemove(c);
		c.setParent(null);
		this.numChildren--;
	}
	
	/* Template method overridable steps: */	
	public void doAdd(Component c) throws Exception {};
	public void doRemove(Component c) throws Exception {};
	
	/* Make every Component define an Iterator for itself. */
	public abstract Iter<Component> makeIter();
	
	/* Allow checking number of children */
	public int getNumChildren(){
		return this.numChildren;
	}
	
}
