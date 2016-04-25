package parser.states.JMCC;

import parser.states.ParserException;
import parser.states.State;
import parser.states.JCTM.JCTM_1;
import parser.states.JCTM.JCTM_15;
import parser.states.JCTM.JCTM_16;
import parser.states.JCTM.JCTM_17;
import parser.states.JCTM.JCTM_18;
import parser.states.JCTM.JCTM_19;
import parser.states.JCTM.JCTM_27;
import parser.states.JCTM.JCTM_29;

/**
 * JMCC_31
 * State for EXP4
 * @author Daniel Breitigan
 *
 */
public class JMCC_31 extends State 
{

  //Shift EXP5
    @Override
    public void shiftEXP5() throws ParserException
    {
        changeToState(new JMCC_33());
    }
    
  //Shift EXP6
    @Override
    public void shiftEXP6() throws ParserException
    {
        changeToState(new JMCC_32());
    }
    
  //Shift EXP7
    @Override
    public void shiftEXP7() throws ParserException
    {
        changeToState(new JMCC_29());
    }
    
  //Shift True
    @Override
    public void shiftTrue() throws ParserException
    {
        changeToState(new JCTM_15());
    }
    
  //Shift New
    @Override
    public void shiftNew() throws ParserException
    {
        changeToState(new JCTM_19());
    }
    
  //Shift INTEGER_LITERAL
    @Override
    public void shiftIntegerLiteral() throws ParserException
    {
        changeToState(new JCTM_18());
    }
    
  //Shift Exclamation
    @Override
    public void shiftExclamation() throws ParserException
    {
        changeToState(new JCTM_27());
    }
    
  //Shift False
    @Override
    public void shiftFalse() throws ParserException
    {
        changeToState(new JCTM_16());
    }
    
  //Shift Id
    @Override
    public void shiftId() throws ParserException
    {
        changeToState(new JCTM_1());
    }
    
  //Shift Left Parenthesis
    @Override
    public void shiftLeftPara() throws ParserException
    {
        changeToState(new JCTM_29());
    }
    
  //Shift This
    @Override
    public void shiftThis() throws ParserException
    {
        changeToState(new JCTM_17());
    }
}
