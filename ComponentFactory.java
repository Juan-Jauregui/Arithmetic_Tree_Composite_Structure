package dp_hw9;
/* Easy centralization of Component creation */
public class ComponentFactory {
	public ComponentFactory(){}
	
	public NumberComponent makeNumberComponent(double val) throws Exception{
		return new NumberComponent(val);
	}
	
	public PlusComponent makePlusComponent(Component... c) throws Exception{
		return new PlusComponent(c);
	}	
	
	public MinusComponent makeMinusComponent(Component... c) throws Exception{
		return new MinusComponent(c);
	}	
	
	public TimesComponent makeTimesComponent(Component... c) throws Exception{
		return new TimesComponent(c);
	}	
	
	public DivideComponent makeDivideComponent(Component... c) throws Exception{
		return new DivideComponent(c);
	}
}