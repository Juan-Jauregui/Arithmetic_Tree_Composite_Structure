package dp_hw9;
/* Extends ArithmeticComponent to represent division */
public class DivideComponent extends ArithmeticComponent{

	public DivideComponent(Component... comps) throws Exception {
		super(comps);
	}

	public String letTheRightOneIn(Visitor v) throws Exception {
		return v.visitDivideComponent(this);
	}

	/* Override toString() to return a representation of "division" */
	public String toString(){
		return ("/");
	}
}
