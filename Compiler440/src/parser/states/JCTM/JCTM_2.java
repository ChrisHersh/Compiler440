package parser.states.JCTM;

import parser.states.ParserException;
import parser.states.State;
import parser.states.JMCC.*;

/**
 * JCTM_2 State
 * @author Daniel Breitigan
 *
 */
public class JCTM_2 extends State
{
  //Shift EXP1
    @Override
    public void shiftEXP1() throws ParserException
    {
        changeToState(new JCTM_4());
    }
    
  //Shift EXP2
    @Override
    public void shiftEXP2() throws ParserException
    {
        changeToState(new JMCC_9());
    }
    
  //Shift EXP3
    @Override
    public void shiftEXP3() throws ParserException
    {
        changeToState(new JMCC_15());
    }
    
  //Shift EXP4
    @Override
    public void shiftEXP4() throws ParserException
    {
        changeToState(new JMCC_8());
    }
    
  //Shift EXP5
    @Override
    public void shiftEXP5() throws ParserException
    {
        changeToState(new JMCC_20());
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
        changeToState(new JMCC_33());
    }
    
  //Shift Id
    @Override
    public void shiftId() throws ParserException
    {
        changeToState(new JCTM_1());
    }
    
  //Shift INTEGER_LITERAL
    @Override
    public void shiftIntegerLiteral() throws ParserException
    {
        changeToState(new JCTM_18());
    }
    
  //Shift True
    @Override
    public void shiftTrue() throws ParserException
    {
        changeToState(new JCTM_15());
    }
    
  //Shift False
    @Override
    public void shiftFalse() throws ParserException
    {
        changeToState(new JCTM_16());
    }
    
  //Shift This
    @Override
    public void shiftThis() throws ParserException
    {
        changeToState(new JCTM_17());
    }
    
  //Shift New
    @Override
    public void shiftNew() throws ParserException
    {
        changeToState(new JCTM_19());
    }
    
  //Shift Exclamation
    @Override
    public void shiftExclamation() throws ParserException
    {
        changeToState(new JCTM_27());
    }
    
  //Shift Left Para
    @Override
    public void shiftLeftPara() throws ParserException
    {
        changeToState(new JCTM_29());
    }
}
