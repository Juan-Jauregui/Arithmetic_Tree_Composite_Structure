package dp_hw9;
/* Visitor that gives ArithmeticComponent arithmetic trees a way to evaluate themselves */
public class ValueVisitor implements Visitor{
	
	@Override 
	/* Visiting a NumberComponent just returns its value  */
	public String visitNumberComponent(NumberComponent nc) {
		return nc.getValue() + "";
	}
	
	@Override
	/* Visiting a PlusComponent */
	public String visitPlusComponent(PlusComponent pc) throws Exception{
		if(pc.getNumChildren() < 2){
			throw new Exception("InsufficientChildrenException: Cannot evaluate; PlusComponent needs 2+ operands (children)");
		} else {
			Iter<Component> i = pc.makeIter();
			i.first();
			
			double sum = doVisit(i);
			while(!(i.isDone())){
				i.next();
				sum += doVisit(i);
			}
			return sum + "";
		}
	}

	@Override
	/* Visiting a MinusComponent */
	public String visitMinusComponent(MinusComponent mc) throws Exception{
		if(mc.getNumChildren() < 2){
			throw new Exception("InsufficientChildrenException: Cannot evaluate; MinusComponent needs 2+ operands (children)");
		} else {
			Iter<Component> i = mc.makeIter();
			i.first();
			
			double diff = doVisit(i);

			while(!(i.isDone())){
				i.next();
				diff -= doVisit(i);
			}
			return diff + "";
		}
	}

	@Override
	public String visitTimesComponent(TimesComponent tc) throws Exception{
		if(tc.getNumChildren() < 2){
			throw new Exception("InsufficientChildrenException: Cannot evaluate; TimesComponent needs 2+ operands (children)");
		} else {
			Iter<Component> i = tc.makeIter();
			i.first();
			
			double product = doVisit(i);

			while(!(i.isDone())){
				i.next();
				product = product * doVisit(i);
			}
			return product + "";
		}
	}

	@Override
	public String visitDivideComponent(DivideComponent dc) throws Exception{
		if(dc.getNumChildren() != 2){
			throw new Exception("InvalidChildrenNumberException: Cannot evaluate; DivideComponent needs exactly 2 operands (children)");
		} else {
			Iter<Component> i = dc.makeIter();
			i.first();
			
			double quotient = doVisit(i);
			i.next();
			quotient /= doVisit(i);
			
			return quotient + "";
		}
	}
	
	/* Helper function:
	 * Encapsulate the code to visit the current element in an Iter and evaluate it
	 * as a double */
	private double doVisit(Iter<Component> i) throws Exception{
		return Double.parseDouble(
				((ArithmeticComponent)(i.currentItem())).letTheRightOneIn(this)
			);
	}

}
