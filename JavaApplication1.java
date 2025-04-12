/*

This file utilizes and tests the descent parser class. 
The first task is to create an instance of the Descent Parser class.   
  The user is then prompted for the path to the input file.  
  The input file is opened and the Parsing process begins.  
  Once parsing is completed the result is displayed and the user is asked if they want to run the program again. 
  */

package javaapplication1;

/**
 *
 * @author Tom
 */
import java.io.*;


public class JavaApplication1 {

        
public static void main(String args[]) throws Exception 
{
    String filename = null;
    
    //Create Descent Parser Object      
      DescentParser DParser;
    //Boolean to store result
      boolean ParsingResult;
      
    //String done
      String done = null;
     
     //Open up standard input.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
   do
   {
      
    //Prompt User to enter the Path for the INput file
      System.out.print("\nEnter the path to your input file and hit enter: ");
        
       //Read the path from the command line use catch & try
         try
            {
                filename = br.readLine();
             } 
            catch (IOException ioe) 
            {
                System.out.println("\n\nIO error reading the filename Now exiting!");
                System.exit(1);
            }
                
            System.out.println("\n\n File located at: " + filename);   
   
    //Create Parser
      DParser = new DescentParser(filename);  
      
    //Run Parser
      ParsingResult =  DParser.StartParse();
      
    //Print out Results
      System.out.println("\n Result from parsing is: " + ParsingResult);
      
    //Print out prompt to try again.
      System.out.println("\nIf you would like to run again enter Y: ");
       try
            {
                done = br.readLine();
             } 
            catch (IOException ioe) 
            {
                System.out.println("\n\nIO error reading your choice Now exiting!");
                System.exit(1);
            }
            
   }while(done.equals("Y"));     
     
}

}
    


