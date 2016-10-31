package dp_hw9;
/* TO-DO: This whole class */
public class TextTreeVisitor implements Visitor{
	/* Helper function:
	 * Encapsulate the code to visit the current element in an Iter */
	private String doVisit(Iter<Component> i) throws Exception{
		return ((ArithmeticComponent)(i.currentItem())).letTheRightOneIn(this);
	}
	
	@Override
	public String visitNumberComponent(NumberComponent nc) throws Exception {
		return "[" + nc + "]";
	}
	
	public String visitPlusComponent(PlusComponent pc) throws Exception{
		return this.base_visit(pc);
	}

	@Override
	public String visitMinusComponent(MinusComponent mc) throws Exception{
		return this.base_visit(mc);
	}

	@Override
	public String visitTimesComponent(TimesComponent tc) throws Exception{
		return this.base_visit(tc);
	}

	@Override
	public String visitDivideComponent(DivideComponent dc) throws Exception{
		return this.base_visit(dc);
	}

	public String base_visit(ArithmeticComponent ac) throws Exception{
		return "how did this get here i am not good with computer";
	}
}
