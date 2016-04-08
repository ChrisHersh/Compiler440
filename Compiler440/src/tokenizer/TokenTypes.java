package tokenizer;

/**
 * Enum for the various types of tokens
 * @author Chris Hersh
 *
 */
@SuppressWarnings("javadoc")
public enum TokenTypes
{
    //Terminals
    //Single comment
    SLComment,
    
    //Multi line comment
    MLComment,
    
    // Parenthesis and braces
    LBrace,
    RBrace,
    LBracket,
    RBracket,
    LPara,
    RPara,
    
    //keywords
    Int,
    Boolean,
    If,
    While,
    Void,
    Main,
    Class,
    Static,
    Extends,
    New,
    Public,
    Else,
    Return,
    SystemOutPrintln,
    Length,
    This,
    True,
    False,
    
    //Symbols
    Comma,
    And,
    Or,
    Equals,
    GtEquals,
    LtEquals,
    NotEquals,
    SemiColon,
    Plus, 
    Minus,
    Mult,
    Assignment,
    Period,
    Gt,
    Lt,
    Not,
    Epsilon,
    
    //Integer
    IntNum,
    
    //ID
    Id,
    
    //Junk
    Junk,
    
    //Non-Terminals
    PROG,
    CLASS_DECL_L,
    MAIN_CLASS,
    MAIN_METHOD,
    CLASS_DECL,
    M_METH_BODY,
    VAR_DECL_L,
    METH_DECL_L,
    VAR_DECL,
    METHOD_DECL,
    METH_BODY,
    FORMAL_L,
    FORMAL_R,
    TYPE,
    STMT,
    STMT_P,
    EXP1,
    EXP2,
    EXP3,
    EXP4,
    EXP5,
    EXP6,
    EXP7,
    OP1,
    OP2,
    OP3,
    OP4,
    OP5,
    OP6,
    EXP_L,
    EXP_R,
}
