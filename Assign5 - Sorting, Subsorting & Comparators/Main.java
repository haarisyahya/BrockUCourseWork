package Assign5;

/** This class implements the sorting algorithm and then uses an ASCIIDataFile and ASCIIOutputFile to 
  * open the correct gridfield file and write the output into a .txt file
  * 
  * @author     Haaris Yahya
  * @course     COSC 1P03
  * @assignment #5
  * @student Id 7054984
  * @version    1.0
  * @since      April 5th, 2021
  */

import BasicIO.*;                // for IO classes
import static BasicIO.Formats.*; // for field formats
import static java.lang.Math.*;  // for math constants and functions
import java.util.Scanner;        // for scanning the .txt files, reading the input


public class Main {
 
 // the method to read the grids, we use the Scanner class to do so.
 private static GridField[] readGridFields(ASCIIDataFile input) {
  
  int numGridFields = Integer.parseInt(input.readLine());
  input.readLine();
  
  GridField[] gridFields = new GridField[numGridFields];
  
  
  for( int index=0; index<numGridFields; index++ ) {
   
   Scanner dimensions = new Scanner(input.readLine());
   
   int width = dimensions.nextInt();
   int height = dimensions.nextInt();
   char c = 0;
   
   for( int i=0; i<height; i++ ) {
    String line = input.readLine();
    c = line.charAt(0);
   }
   
   // read the extra change in line
   input.readLine();
   
   GridField gridField = new GridField(width, height, c);
   gridFields[index] = gridField;
   
  }
 
  
  return gridFields;
 }
 
 /* This method is the actual sorting algorithm. The sorting algorithm used in this method is
  * the selection sort. The sort first sorts by width of the array, then by height and lastly
  * by lexicographical order. */
 private static void sort(GridField gridFields[], int size) {
  
  int smallPos; // position of smallest item
  GridField temp;
  int i,j;
     
     // the comparators, we initialize them in the reverse order that we sort them in.
     GridFieldComparatorByChar comparatorByChar = new GridFieldComparatorByChar();
     GridFieldComparatorByHeight comparatorByHeight = new GridFieldComparatorByHeight();
     GridFieldComparatorByWidth comparatorByWidth = new GridFieldComparatorByWidth();
    
     for( i=0; i<size-1; i++ ) {
         smallPos = i;
         for (j=i+1; j<size; j++){
          
          boolean condition = false;
          if( comparatorByWidth.compare( gridFields[j], gridFields[smallPos]) < 0 ) {
           condition = true;
          } else if ( comparatorByWidth.compare( gridFields[j], gridFields[smallPos]) > 0 ) {
           condition = false;
          } else {
           
           if( comparatorByHeight.compare( gridFields[j], gridFields[smallPos]) < 0 ) {
            condition = true;
           } else if ( comparatorByHeight.compare( gridFields[j], gridFields[smallPos]) > 0 ) {
            condition = false;
           } else {
            
            if( comparatorByChar.compare( gridFields[j], gridFields[smallPos]) < 0 ) {
             condition = true;
            } else if ( comparatorByChar.compare( gridFields[j], gridFields[smallPos]) > 0 ) {
             condition = false;
            } else {
             condition = false;
            }
           }
          }
          
          if (condition) {
           smallPos = j;
          } 
         }
      //instead of directly swapping gridFields[i] with gridFields[smallPos]:
      //store the current minimum object in temp variable
      //shift all elements from gridFields[i] to gridFields[smallPos - 1] once to the right
      //place gridFields[smallPos] at index i.
      temp = gridFields[smallPos]; 
      for(j = smallPos; j > i; j--){
       gridFields[j] = gridFields[j-1];
      }
      gridFields[i] = temp;
     }
 }
 
 //This method is written to write the characters in the array onto the output text file
 private static void print(GridField gridFields[], int size, ASCIIOutputFile output) {
  output.writeInt(size); //writes the number of arrays in the output file
  output.newLine();  //adds a new line for better readability
  output.newLine();
  
  for(int i=0; i<size; i++) {
   GridField gridField = gridFields[i];
   
   output.writeInt(gridFields[i].getWidth()); //writes the number of cols in the array in the file
   output.writeInt(gridFields[i].getHeight()); // writes the number of rows in the array in the file
   output.newLine();
   output.writeLine(gridField.toString()); //writes the characters in the array
  
   
  }
  output.close();
 } 
 
 /* The main method that inits an ASCIIDataFile and prints out the initial grid with the column size
  * and the row size along with the main character used in the array.  */
 public static void main(String[] args) {
   
  ASCIIDataFile input = new ASCIIDataFile();
  GridField[] gridFields = readGridFields(input);
  input.close();
  
  
  for( GridField field : gridFields )
    System.out.println( field.getWidth() + ", " + field.getHeight() + ", " + field.getC());
  System.out.println();
  
  sort(gridFields, gridFields.length);
  
 
  for( GridField field : gridFields )
   System.out.println( field.getWidth() + ", " + field.getHeight() + ", " + field.getC());
  System.out.println();
  
  
  //Prints the output into a new ASCIIOutputFile
  ASCIIOutputFile output = new ASCIIOutputFile();
  print(gridFields, gridFields.length, output);
  output.close();
  
  System.exit(0);
 }
}