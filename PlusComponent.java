package dp_hw9;

public class PlusComponent extends ArithmeticComponent{

	public PlusComponent(Component... comps) throws Exception {
		super(comps);
	}
	
	public String letTheRightOneIn(Visitor v) throws Exception{
		return v.visitPlusComponent(this);
	}
	
	/* Override toString() to return a representation of "plus" */
	public String toString(){
		return ("+");
	}
}
