package dp_hw9;

public class VisitorTester {
	public static void main(String[] args) throws Exception{
		ComponentFactory CF = new ComponentFactory();
		VisitorFactory VF = new VisitorFactory();
		
		ValueVisitor vv = VF.makeValueVisitor();
		InfixVisitor iv = VF.makeInfixVisitor();
		LispVisitor lv = VF.makeLispVisitor();
		TextTreeVisitor tv = VF.makeTextTreeVisitor();

		NumberComponent num1 = CF.makeNumberComponent(3);
		NumberComponent num2 = CF.makeNumberComponent(5);
		NumberComponent num3 = CF.makeNumberComponent(7);
		
		PlusComponent pc = CF.makePlusComponent(num1, num2, num3);
		
		NumberComponent num4 = CF.makeNumberComponent(15);
		NumberComponent num5 = CF.makeNumberComponent(17);
		
		MinusComponent mc = CF.makeMinusComponent(num4, num5);

		TimesComponent tc = CF.makeTimesComponent(pc, mc);
		
		DivideComponent dc = CF.makeDivideComponent(tc,CF.makeNumberComponent(5));
		
		System.out.println("Infix Visitor: " + dc.letTheRightOneIn(iv) + "\n");
		System.out.println("Lisp Visitor: " + dc.letTheRightOneIn(lv) + "\n");
		System.out.println("Value Visitor: " + dc.letTheRightOneIn(vv) + "\n");
		System.out.println("Text Tree Visitor:\n" + dc.letTheRightOneIn(tv) 
				+ "\n----------------------------------\n\n");
		
		/* -------------------Tree from Homework 1-------------------------------------- */
		NumberComponent one = CF.makeNumberComponent(1);
		NumberComponent three = CF.makeNumberComponent(3);
		NumberComponent two = CF.makeNumberComponent(2);
		NumberComponent nine = CF.makeNumberComponent(9);
		NumberComponent eleven = CF.makeNumberComponent(11);
		
		tc = CF.makeTimesComponent(nine, eleven);
		pc = CF.makePlusComponent(three, two, tc);
		dc =  CF.makeDivideComponent(one,pc);
		
		System.out.println("Infix Visitor: " + dc.letTheRightOneIn(iv) + "\n");
		System.out.println("Lisp Visitor: " + dc.letTheRightOneIn(lv) + "\n");
		System.out.println("Value Visitor: " + dc.letTheRightOneIn(vv) + "\n");
		System.out.println("Text Tree Visitor:\n" + dc.letTheRightOneIn(tv) + "\n");
	}
}
