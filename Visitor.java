package dp_hw9;

public interface Visitor {
	public String visitNumberComponent(NumberComponent nc) throws Exception;
	public String visitPlusComponent(PlusComponent pc) throws Exception;
	public String visitMinusComponent(MinusComponent mc) throws Exception;
	public String visitTimesComponent(TimesComponent tc) throws Exception;
	public String visitDivideComponent(DivideComponent dc) throws Exception;
}
