package dp_hw9;
/* Implements the Iter interface to define operations for an iterator over a Component/
 * Composite aggregate */
public abstract class ComponentIterator implements Iter<Component> {
	protected Component composite;				/* Define a Composite to iterate over */
	protected Component current;					/* Define a current Composite element */

	public ComponentIterator(Component c){
		this.composite = c;							/* Set this Iterator's Composite to given Composite */
		this.first();									/* Start the Iterator at the first element */
	}

	public abstract void first();					/* Return the iterator to the first Component in the Composite */
	public abstract Component currentItem();	/* Returns the current Component */
	public abstract void next(); 					/* Advances the iterator to the next Component in the Composite */
	public abstract boolean isDone();			/* Returns whether or not the Composite has no more elements */
}
