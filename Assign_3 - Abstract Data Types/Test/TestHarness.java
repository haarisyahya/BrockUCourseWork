package Test;


/** This class is a test harness written to demonstrate the effectiveness of the StringT package.
  * This class prints all the functions written under the StringT data type on the console
  * Output of the console is also saved as TestHarnessOutput(.txt file) in the Test folder
  * @author Haaris Yahya
  * @version 1.0 (03/12/2021)     
  */

import StringT.*; //imports our jar file in the Assign_3 folder
import StringT.StringTException; //imports the exception

public class TestHarness {
  //This method is basically checks to see if the length of the string is 0, if it is then it prints nothing. If it is not, it returns a character array representation.
  static void print(StringT string) {
    if( string.Length() == 0 )
      System.out.println();
    else
    {
      for( char c : string.ToArray() )
        System.out.print(c);
      System.out.println();
     
     
    }
  }
  
  
//The main method
  public static void main(String[] args) {
    
    // creates an empty string
    MyStringT emptyString = new MyStringT();
    System.out.print(  "Empty string        : ");
    print(emptyString);
    
    // a string with text
    char arr1[] = {'B', 'a', 't', 'm', 'a', 'n' };
    MyStringT string1 = new MyStringT(arr1);
    System.out.print(  "String1             : ");
    print(string1);
    
    
    //Displays the clone of the above char array (I could not make it work and it only returns the place in memory :( )
    System.out.println("Clone               : " + string1.Clone().ToArray());
    
    
    //Displays the empty string and first string's length
    System.out.println("Empty string length : " + emptyString.Length());
    System.out.println("String1 length      : " + string1.Length());
    
    
    //This is to catch any exceptions that arise when using the Before or After function, in the cas
    System.out.print(  "String1 before(3)   : ");
    try {
      print(string1.Before(3));
    } catch( StringTException ste ) {
      System.out.println(ste);
    }
    
    System.out.print(  "String1 after(3)    : ");
    try {
      print(string1.After(3));
    } catch( StringTException ste ) {
      System.out.println(ste);
      
    }
    
    
    // Prints the index of the char from the first string onto the console
    System.out.println("IndexOf 'a' string1 : " + string1.indexOf('a'));
    System.out.println("IndexOf 's' string1 : " + string1.indexOf('s')); // prints -1 in the console as the char does not exist in the char array
    System.out.println("IndexOf 'n' string1 : " + string1.indexOf('n'));
    
    //Gives us String1 in uppercase
    System.out.print( "Uppercase String1   : ");
    print(string1.toUpper());
    
    //second string with text
    char arr2[] = {'S', 'u', 'p', 'e', 'r', 'm', 'a', 'n'};
    MyStringT string2 = new MyStringT(arr2);
    System.out.print(  "String2             : ");
    print(string2);
    
    //empty third string 
    char arr3[] = {' '};
    MyStringT space = new MyStringT(arr3);
    System.out.print(  "String3             : ");
    print(space);
    
    // Displays the concatenated strings, adds two strings together (string1 and string2)
    StringT s4 = string1.ConCat(space);
    s4 = s4.ConCat(string2);
    System.out.print(  "String1+String2     : ");
    print(s4);
  } 
}
