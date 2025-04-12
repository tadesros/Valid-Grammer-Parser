
package javaapplication1;
/*******************************
 *Class:  DescentParser
 *This class examines whether or not a grammer is valid.
 *********************************************************/
import java.io.File;
import java.io.FileReader;
import java.io.BufferedReader;

public class DescentParser {
          //Constants 
            /* Token Values */
     private static final int VAR    = 1;
	 private static final int INT    = 2;
	 private static final int PLUS   = 3;
	 private static final int MINUS  = 4;
	 private static final int MULT   = 5;
	 private static final int DIV    = 6;
	 private static final int LPAR   = 7;
	 private static final int RPAR   = 8;
         private static final int INVALID = -2;
         private static final int END    = -1;
         
         //Member Variables.
           private int CurrentToken = 0;
           private boolean VallidExpression = false;
           private Lexer Lex;
    
    
    //Constructor
 DescentParser(String Fname) throws Exception
{                
 //Create Lexer
   Lex = new Lexer(new FileReader(Fname));     
 }//End of Contructor
 
 
 /*############Function StartParse############
 This function start the parsing process and
 *return the result.  true if it's a valid
 *expression, false if not.
 *#######################################*/
 public boolean StartParse() throws Exception
 {
     //Get first token
       CurrentToken = Lex.yylex();
       
       //Start Parsing Process and return result
         return Exp();
         
 } // END of Function StartParse
     
/*************Function Match***********************
 Input: Integer Representing the Token to be matched
        Return: True if matches, False if not
        If True then Read in the next Token
*****************************************************/
private boolean match(int Token) throws Exception
  {
     //Check 
       if(CurrentToken == Token)          
         {
            //Advance to the next token
              CurrentToken = Lex.yylex();
                        
            //Return True
              return true;               
         }
       else
          {
            return false;
          }
}/*****************End of Function Match********************/

// @@@@@@@@@@@@@@@@@@@@@Parsing Functions@@@@@@@@@@@@@@@@@@@
  
//@@@@@@@@@@@@@@@@Function: Parse EXP@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@         
  private boolean Exp() throws Exception
 {
       
     
     //Enter Switch Statement for checking Values
       switch (CurrentToken)
        {
           case VAR:            
           case INT:
           case LPAR:
             return ((Term()) && (RestExp())); 
           
           default:
               
               //None Return False
                 return false;   
                 
       }//end of switch statement
       
     
 }//@@@@@@@@@@@@@@@@@@@@@@@@end of Function EXP@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
  
 //@@@@@@@@@@@@@@@@@@@@Function: Parse RestExp@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@        
  private boolean RestExp() throws Exception
 {
       
     
     //Enter Switch Statement for checking Values
       switch (CurrentToken)
        {
           case RPAR:            
               
            //Do nothing just return true
             return true;        
            
             
           case PLUS:
             
             return (   (match(PLUS)) && ((Term()) && (RestExp())   ) );
            
             
           case MINUS:
               
               return (   (match(MINUS)) && ((Term()) && (RestExp())   ) );
            
           case END:
               
               return true;
           
           default:
               
               //SOMETHING ELSE               
                 return false;             
       }//end of switch statement
       
     
 }//@@@@@@@@@@@@@@@@@@@@@@end of Function RestExp@@@@@@@@@@@@@@@@@@@@@@
  
//@@@@@@@@@@@@@@@@@@Function: Parse Term@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@         
  private boolean Term()  throws Exception
 {
       
     
     //Enter Switch Statement for checking Values
       switch (CurrentToken)
        {
           case VAR:            
           case INT:
           case LPAR:
               
             return ((Factor()) && (RestTerm()));               
               
           
           default:
               
               //None Return False
                 return false;   
                 
       }//end of switch statement       
     
 }//@@@@@@@@@@@@@@@@@@@@@end of Function Term@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@ 
  
  
//@@@@@@@@@@@@@@@@@@@@@@Function: Parse RestTerm@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@         
  private boolean RestTerm() throws Exception
 {
       
     
     //Enter Switch Statement for checking Values
       switch (CurrentToken)
        {
           case RPAR:                 
           case PLUS:
           case MINUS:
               
                return true;      
           
            
           case MULT:
               
                  return ((match(MULT)) && (Factor()) && (RestTerm()));
               
           case DIV:               
               return ((match(DIV)) && (Factor()) && (RestTerm()));               
                
           case END:
               //Do Nothing
               return true;          
           
           default:               
               //None Return False
                 return false;             
       }//end of switch statement
       
     
 }//@@@@@@@@@@@@@@@end of Function RestTerm@@@@@@@@@@@@@@@@@@@@@  

//@@@@@@@@@@@@@@@@@@Function: Parse Factor@@@@@@@@@@@@@@@@@@@@@@@@@@         
  private boolean Factor() throws Exception
 {
       
     
     //Enter Switch Statement for checking Values
       switch (CurrentToken)
        {
           case VAR:  
               
               
               
             return (match(VAR));        
            
             
           case INT:
             
             return (match(INT));
            
             
           case LPAR:
               
               return (match(LPAR) && Exp() && match(RPAR));            
           
           default:
               
               //None Return False
                 return false;             
       }//end of switch statement
       
     
 }//@@@@@@@@@@@@@@@@@@@@@@end of Function Factor@@@@@@@@@@@@@@@@@@@@@@@@@@  
 
}//%%%%%%%%%%%%%%%%%%%%%%%%%end of class Descent Parser%%%%%%%%%%%%%%%%%%%%%%%%%
