package Assign5;

/** This class displays the data type using getters and setters, they access and update the values of the
  * private variables.
  * 
  * @author     Haaris Yahya
  * @course     COSC 1P03
  * @assignment #5
  * @student Id 7054984
  * @version    1.0
  * @since      April 5th, 2021
  */                                                   

public class GridField
{
 private int width;
 private int height;
 private char c;
 
 
 public GridField(int width, int height, char c) {
  this.width = width;
  this.height = height;
  this.c = c;
 }

 public int getWidth() {
  return width;
 }

 public void setWidth(int width) {
  this.width = width;
 }

 public int getHeight() {
  return height;
 }

 public void setHeight(int height) {
  this.height = height;
 }

 public char getC() {
  return c;
 }

 public void setC(char c) {
  this.c = c;
 }
 
 //This method converts the characters in the gridfields text file into a String
 public String toString() {
  String string = "";
  
  for( int i=0; i<height; i++ ) {
   String row = "";
   for( int j=0; j<width; j++  )
    row += c;
   
   string += row + "\n";
  }
  return string;
 }
}