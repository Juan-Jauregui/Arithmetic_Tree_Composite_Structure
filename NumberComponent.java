package dp_hw9;

public class NumberComponent extends ArithmeticComponent{
	private double value;
	
	public NumberComponent(double val) throws Exception {
		this.value = val;
	}
	
	public String letTheRightOneIn(Visitor v) throws Exception{
		return v.visitNumberComponent(this); 
	}
	
	public double getValue() {
		return this.value;
	}

	/* Override add() to disable it (Number is Leaf-esque) */
	public void add(Component c) throws Exception{
		throw new Exception("TriedAddingChildToLeafException");
	}
	/* Override remove() to disable it (Number is Leaf-esque) */
	public void remove(Component c) throws Exception{
		throw new Exception("TriedRemovingChildFromLeafException");
	}
	
	/* Override toString() to return a representation of the Number */
	public String toString(){
		return (this.getValue() + "");
	}
}
