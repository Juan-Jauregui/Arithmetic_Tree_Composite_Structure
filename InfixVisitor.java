package dp_hw9;
/* Visitor that gives ArithmeticComponent arithmetic trees a way to print themselves
 * in Infix format */
public class InfixVisitor implements Visitor{

	@Override //Visiting a NumberComponent leaf just returns its value.
	public String visitNumberComponent(NumberComponent nc) {
		return nc.toString();
	}

	public String visitPlusComponent(PlusComponent pc) throws Exception{
		if(pc.getNumChildren() < 2){
			throw new Exception("InsufficientChildrenException: Cannot evaluate; PlusComponent needs 2+ operands (children)");
		} else return this.base_visit(pc);
	}

	@Override
	public String visitMinusComponent(MinusComponent mc) throws Exception{
		if(mc.getNumChildren() < 2){
			throw new Exception("InsufficientChildrenException: Cannot evaluate; MinusComponent needs 2+ operands (children)");
		} else return this.base_visit(mc);
	}

	@Override
	public String visitTimesComponent(TimesComponent tc) throws Exception{
		if(tc.getNumChildren() < 2){
			throw new Exception("InsufficientChildrenException: Cannot evaluate; TimesComponent needs 2+ operands (children)");
		} else return this.base_visit(tc);
	}

	@Override
	public String visitDivideComponent(DivideComponent dc) throws Exception{
		if(dc.getNumChildren() != 2){
			throw new Exception("InvalidChildrenNumberException: Cannot evaluate; DivideComponent needs exactly 2 operands (children)");
		} else return this.base_visit(dc);
	}
	
	/* Visit is essentially the same for all non-leaf ArithmeticComponents */
	public String base_visit(ArithmeticComponent ac) throws Exception{
		if(ac.getNumChildren() < 2){
			throw new Exception("InsufficientChildrenException: Cannot evaluate; PlusComponent needs 2+ operands (children)");
		} else {
			Iter<Component> i = ac.makeIter();
			i.first();

			String s = "(" + doVisit(i) + " " + ac.toString() + " ";
			while(!(i.isDone())){
				i.next();
				s += doVisit(i);
				s += (i.isDone()) ?
						""
						: " " + ac.toString() + " ";
			}
			return s + ")";
		}
	}
	
	/* Helper function:
	 * Encapsulate the code to visit the current element in an Iter */
	private String doVisit(Iter<Component> i) throws Exception{
		return ((ArithmeticComponent)(i.currentItem())).letTheRightOneIn(this);
	}
}
