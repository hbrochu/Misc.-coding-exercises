/*Created and designed by Hunter Brochu for VIP technical exercise.

This program asks the user to input a list of single digit numbers followed by commas and sorts them into pairs that when added
equal 10. It then prompts the user to input 1, 2, or 3 to recieve different outputs of the created pairs.

*/
import javax.swing.JOptionPane;
import java.io.*;
import java.util.*;

public class SumToTen{

	
   
   
   public static void main(String [] args){
      String inputValueString = JOptionPane.showInputDialog("Please enter each number you wish to sum followed by a comma");
      List<Integer> givenValues = new ArrayList<>();
      //now skips over the commas
      for(int i = 0; i < inputValueString.length();){
         char X = inputValueString.charAt(i);
         int intChar = Character.getNumericValue(X);
         System.out.println(intChar);
         givenValues.add(intChar);
         i = i+2;
      }
      System.out.println(inputValueString);
      System.out.println(givenValues);
      
      /*Now determines which integers add to 10 and makes them a pair*/
      List<Integer> pairsOfTen = new ArrayList<>();
      for(int i = 0; i < givenValues.size(); i++){
         for(int x = 0; x < givenValues.size(); x++){
            if(((givenValues.get(i) + givenValues.get(x)) == 10) && ((i-x) != 0)){
               pairsOfTen.add(givenValues.get(i));
               pairsOfTen.add(givenValues.get(x));
            }
         }
      }
      System.out.println(pairsOfTen);
      

      /*Now sorts the sums of 10 then outputs the desired pairs*/
      boolean ending = true;
      
      String choiceOfAdding = JOptionPane.showInputDialog("Please enter 1 to output all pairs, 2 to output unique pairs once, 3 to output the same combo pair only once");
      if(Integer.parseInt(choiceOfAdding) == 1){
         for(int i = 0; i < pairsOfTen.size();){
            System.out.print("[" + pairsOfTen.get(i) + "," + pairsOfTen.get(i+1) + "]");
            i = i+2;
         }            
         System.out.print("\n");
      }
      if(Integer.parseInt(choiceOfAdding) == 2){         
         for(int i = 0; i < pairsOfTen.size();){
            for(int x = i+2; x < pairsOfTen.size();){
               if((pairsOfTen.get(i) == pairsOfTen.get(x)) && (pairsOfTen.get(i+1) == pairsOfTen.get(x+1))){
                  pairsOfTen.remove(x+1);
                  pairsOfTen.remove(x);
                  x = x-2;
               }
               x = x+2;
            }            
            System.out.print("[" + pairsOfTen.get(i) + "," + pairsOfTen.get(i+1) + "]");
            i = i+2;
         }
         System.out.print("\n");
      }
      if(Integer.parseInt(choiceOfAdding) == 3){         
         for(int i = 0; i < pairsOfTen.size();){
            for(int x = i+2; x < pairsOfTen.size();){
               if(((pairsOfTen.get(i) == pairsOfTen.get(x)) && (pairsOfTen.get(i+1) == pairsOfTen.get(x+1))) || ((pairsOfTen.get(i) == pairsOfTen.get(x+1)) && (pairsOfTen.get(i+1) == pairsOfTen.get(x)))){
                  pairsOfTen.remove(x+1);
                  pairsOfTen.remove(x);
                  x = x-2;
               }
               x = x+2;
            }            
            System.out.print("[" + pairsOfTen.get(i) + "," + pairsOfTen.get(i+1) + "]");
            i = i+2;
         }
         System.out.print("\n");
      }
   }
}