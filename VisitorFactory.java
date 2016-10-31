package dp_hw9;

public class VisitorFactory {
	public VisitorFactory(){}
	
	public ValueVisitor makeValueVisitor() throws Exception{
		return new ValueVisitor();
	}
	
	public InfixVisitor makeInfixVisitor() throws Exception{
		return new InfixVisitor();
	}
	
	public LispVisitor makeLispVisitor() throws Exception{
		return new LispVisitor();
	}
	
	public TextTreeVisitor makeTextTreeVisitor() throws Exception{
		return new TextTreeVisitor();
	}
}
