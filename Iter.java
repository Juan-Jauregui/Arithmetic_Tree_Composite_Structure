package dp_hw9;
public interface Iter<T> {
	public void first();		/* Return the Iterator to the first member in the T */
	public T currentItem();	/* Returns the current element selected by the Iterator */
	public void next();		/* Moves the iterator to the next element in the T */
	public boolean isDone();/* Returns whether or not there's a next element in the T*/
}
