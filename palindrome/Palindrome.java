/*
   A program that accepts a string input from the user and determines if it is a palindrome

*/
/*
   Created by: Hunter Brochu
	collaborators/references: www.stackoverflow.com
*/
import javax.swing.JOptionPane;

public class Palindrome{
   //checks if a given entry is a palindrome and returns true or false
   public static Boolean checkEntry(){
      String originalEntry = JOptionPane.showInputDialog("Please enter a string to test whether it is a palindrome");
      String fixedEntry = originalEntry;
      Boolean palindrome = true;
      
      //removes all non alphanumeric characters
      fixedEntry = fixedEntry.replaceAll("^[^a-zA-Z0-9\\s]+|[^a-zA-Z0-9\\s]+$", "");
      //revises string to remove capitals for ease of comparison
      fixedEntry = fixedEntry.toLowerCase();

      //System.out.println(originalEntry);
      //System.out.println(fixedEntry);
      
      //searches the entry until it can determine the string is not a palindrome
      for(int i = 0; i < fixedEntry.length(); i++){
         if(fixedEntry.charAt(i) != fixedEntry.charAt(fixedEntry.length()-i-1)){
            i = fixedEntry.length();
            palindrome = false;
            System.out.println("Your entry " + '"' + originalEntry + '"' + " is not a palindrome");
         }
      }//end for loop
      //outputs if entry is a palindrome
      if(palindrome == true){
         System.out.println("Your entry " + '"' + originalEntry + '"' + " is a palindrome");
      }
      return palindrome; 
   }//end check function
   
	public static void main(String [] args){
      Boolean palindrome;
      palindrome = checkEntry();
      System.out.println(palindrome);
      
   }//end main
}//end class