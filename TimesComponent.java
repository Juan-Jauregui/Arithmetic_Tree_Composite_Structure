package dp_hw9;

public class TimesComponent extends ArithmeticComponent{

	public TimesComponent(Component... comps) throws Exception {
		super(comps);
	}
	
	public String letTheRightOneIn(Visitor v) throws Exception{
		return v.visitTimesComponent(this);
	}
	
	/* Override toString() to return a representation of "times" */
	public String toString(){
		return ("*");
	}
}
