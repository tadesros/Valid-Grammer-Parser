# Valid-Grammer-Parser
Build a Descent Parser to check for Valid Grammer/Expression


This project was part of my Operating Systems class at Oakland University.  The purpose of this assignment was to create an object oriented program to test whether or not an expression is valid.  J Flex www.jflex.de was used to created a lexical analyzer.  The lexical analyzer reads input, matches the input against the regular expression determined by the specifications and runs an action based on the result.   J Flex creates the Lexer class based on the required specifications.  Once created an interface to open up a text input file to read in the expression and run the parser was completed. 

Valid members for this grammar include: 
Variables (alphanumeric)
Integers 
+  Addition 
- Subtraction
* Multiplication
 \ Division
(  Left Parenthesis
)  Right Parenthesis
 The parser checks to make sure that every part of the expression is a valid member of the grammar.  The parser also checks to make sure left and right parenthesis have matching pairs.  Other rules such as an operator cannot be followed by another i.e. */ is not allowed. 

Some example expressions (from test files) are below:
​variable + (23 + Ant) / Dog * 1234    This is a valid expression.  This expression contains everything from the grammar.
((This + 12345) + (5/Test)) * 12 - 12 + (2/2)  This is a valid expression.  Valid grammar and the parenthesis match in pairs.
 (A + Elephant * CAT / 232323) - (1 + A - 3 * (C / (Z + Z)))  This is a valid expression.  
(12 / B) + * (C + 12)  This is not a valid expression.  The problem is addition and multiplication operators are next to each other.  " " +* " is not allowed
(A + B) > C  This is not a valid expression.  In our grammar " > " is not defined. 
1244 / (A + B) * C & F  This is not a valid expression.  In our grammar " & " is not defined. ​
