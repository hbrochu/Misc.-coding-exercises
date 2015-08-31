/*
   A program that will accept a text file and count the number of keys recieved and output
   the sum of each different key recieved.

*/
/*
   Created By: Hunter Brochu
	collaborators/references: none
*/

import java.io.*;
import java.util.*;
import javax.swing.JOptionPane;

public class key_reader{
   //global lists for key values and names
   //program accepts only ten different key 
   private static List<Integer> keyValues = new ArrayList<>();
   private static List<String> keyNames = new ArrayList<String>();
   
   public static BufferedReader inFile(String keys)throws IOException{
		BufferedReader inFile = new BufferedReader(new FileReader(keys));

		
		return inFile;
	}//end inFile
   
   //reads each line of the input file and uses that to determine how many types of 
   //keys there are and sums those of the same type
   public static void keyCalculator(BufferedReader inFile)throws IOException{
      String key;
      StringBuilder name = new StringBuilder();
      StringBuilder tempKeyValue = new StringBuilder();
      int keyValue;
      Boolean divider = false;
      Boolean endRun = false;

      
      do{
         key = inFile.readLine(); //reads a single key
         //System.out.println(key);
         //finds the comma that splits each key
         if(key == null){
            endRun = true;
         }
         if(endRun == false){
            for(int i = 0; i < key.length(); i++){

               if(key.charAt(i) == ',' && endRun == false){
                  divider = true;
               
               }
               //constructs name field of key
               else if(divider == false && endRun == false){
                  name.append(key.charAt(i));
               }
               //constructs values for each key given
               else if(divider == true && endRun == false){
                  tempKeyValue.append(key.charAt(i));
               }   
            }//end key reader loop
            //System.out.println(name.toString());
            //adds names and key values to their respective lists
            keyNames.add(name.toString());
            keyValues.add(Integer.parseInt(tempKeyValue.toString()));
            //resets temp variables
            name = new StringBuilder();
            tempKeyValue = new StringBuilder();
            divider = false;
      
         }//end if null   
      }while(endRun == false);   
   }//end keyCalculator
   
   //sums key values with the same names
   public static void sumKeys(){
      int tempValue;

      for(int i = 0; i < keyNames.size(); i++){
         for(int x = 0; x < keyNames.size(); x++){
            if((keyNames.get(i).equals(keyNames.get(x))) && (i != x)){
               tempValue = keyValues.get(i) + keyValues.get(x);
               keyValues.remove(x);
               keyNames.remove(x);
               keyValues.set(i, tempValue);
               
            
            }//end if              
         }
      }//end for loop
      System.out.println(keyNames);
      System.out.println(keyValues);
   }//end sumKeys
   
   //method for printing the final calculated key combinations
   public static void printOutput(){
      for(int i = 0; i < keyNames.size(); i++){
         System.out.println("The total for " + keyNames.get(i) + " is " + keyValues.get(i));
         
      }//end for loops
   }//end printOutput
   
	public static void main(String [] args)throws IOException{
      //Gets the file name that contains the keys for computing
      String keys = JOptionPane.showInputDialog("What is the name of the file containing the input keys?");

      
      //buffered reader for inFile
      BufferedReader inFile = inFile(keys);
      //builds lists of all key names and their values
      keyCalculator(inFile);
      //System.out.println(keyNames);
      sumKeys();
      printOutput();
      
   
   }//end main
}//end class