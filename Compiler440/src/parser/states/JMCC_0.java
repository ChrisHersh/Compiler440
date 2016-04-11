package parser.states;

/**
 * 
 * @author Chris Hersh
 *
 */
public class JMCC_0 extends State {

	@Override
	public void shiftEXP1() throws ParserException {
		changeToState(new JMCC_1());
	}
	
	@Override
	public void shiftEXP2() throws ParserException {
		changeToState(new JMCC_9());
	}
	
	@Override
	public void shiftEXP3() throws ParserException {
		changeToState(new JMCC_15());
	}
	
	@Override
	public void shiftEXP4() throws ParserException {
		changeToState(new JMCC_8());
	}
	
	@Override
	public void shiftEXP5() throws ParserException {
		changeToState(new JMCC_20());
	}
	
	@Override
	public void shiftEXP6() throws ParserException {
		changeToState(new JMCC_32());
	}
	@Override
	
	public void shiftEXP7() throws ParserException {
		changeToState(new JMCC_32());
	}
	
	@Override
	public void shiftThis() throws ParserException {
		changeToState(new JCTM_17());
	}
	
	@Override
	public void shiftLeftBrace() throws ParserException {
		changeToState(new JCTM_29());
	}
	
	@Override
	public void shiftId() throws ParserException {
		changeToState(new JCTM_1());
	}
	
	@Override
	public void shiftFalse() throws ParserException {
		changeToState(new JCTM_16());
	}
	
	@Override
	public void shiftNot() throws ParserException {
		changeToState(new JCTM_16());
	}
	
	@Override
	public void shiftIntegerLiteral() throws ParserException {
		changeToState(new JCTM_18());
	}
	
	@Override
	public void shiftNew() throws ParserException {
		changeToState(new JCTM_19());
	}
	
	@Override
	public void shiftTrue() throws ParserException {
		changeToState(new JCTM_15());
	}
}
