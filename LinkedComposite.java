package dp_hw9;
public class LinkedComposite extends Component{
	private Node<Component> root = null;

	public Iter<Component> makeIter(){
		return new LinkedCompositeIterator(this);
	}

	/* Constructor which takes in an indeterminate number of Component
	 * children to start off the LinkedComposite */
	public LinkedComposite (Component... comps) throws Exception {
		for (int i = 0; i< comps.length; i++){
			this.add(comps[i]);

		}
	}
	/* Override: Specify the implementation of the addition step of add() */
	public void doAdd(Component c) throws Exception{
		if (this.root == null) this.root = new Node<Component>(c);
		else {
			Node<Component> n = this.root;
			while (n.next != null) n = n.next;
			n.next = new Node<Component>(c);
		}
	}

	/* Override: Specify the implementation of the removal step of remove() */
	public void doRemove(Component c) throws Exception{
		boolean found = false;
		Node<Component> n = root;

		if (c == n.getContents()){
			this.root = n.next;
			found = true;
		} else{
			while (n.next != null){
				if (c == n.next.getContents()){
					n.next = n.next.next;
					found = true;
					break;
				}
				n = n.next;
			}
		}

		if (!found) throw new Exception("Component not found; Not removed.");

	}

	public Node<Component> getRootNode(){
		return this.root;
	}
}

/* Node class to implement a simple singly-linked list */
class Node<C> {
	public Node<C> next = null;
	protected C contents = null;

	public Node(C c){
		this.contents = c;
	}

	public C getContents(){
		return this.contents;
	}

	public boolean hasNext(){
		return (this.next != null);
	}
}

//Inner Iterator class
class LinkedCompositeIterator extends ComponentIterator{
	private Node<Component> curNode;	/* Keep track of the current node itself */

	public LinkedCompositeIterator(LinkedComposite lc){
		super(lc);	/* Superclass constructor to initialize composite & current */
	}

	/* Sends the Iterator to the first Component in the Composite */
	public void first(){
		/* Set the current LinkedList NODE to the LinkedComposite's root node */
		this.curNode = ((LinkedComposite) this.composite).getRootNode();
		/* Set the current COMPONENT to the contents of the current node (unless it's null)*/
		this.current = (this.curNode != null) ? curNode.getContents() : null;
	}

	/* Returns the current Component */
	public Component currentItem(){
		return this.current;	/* Return the current Component */
	}

	/* Moves to the next Component and returns it */
	public void next(){
		if (!isDone()){
			/* Update the current node to the next node & this.current to its Component*/
			this.curNode = this.curNode.next;
			this.current = this.curNode.getContents();
		}
	}

	/* Returns whether or not there's a next element */
	public boolean isDone(){
		return !(this.curNode.hasNext());
	}
}
