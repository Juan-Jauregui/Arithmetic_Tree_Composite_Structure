package dp_hw9;

public class MinusComponent extends ArithmeticComponent{

	public MinusComponent(Component... comps) throws Exception {
		super(comps);
	}
	
	public String letTheRightOneIn(Visitor v) throws Exception{
		return v.visitMinusComponent(this);
	}
	
	/* Override toString() to return a representation of "minus" */
	public String toString(){
		return ("-");
	}
}
