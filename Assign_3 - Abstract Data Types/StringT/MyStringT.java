package StringT;

/** This class is an implementation of the StringT interface
  * @author Haaris Yahya
  * @version 1.0 (03/12/2021)       */

public class MyStringT implements StringT {
  
  // the char array
  private char string[];
  private int length;
  
  // the default constructor
  public MyStringT() {
    string = null;
    length = 0;
  }
  
  // the constructor that takes a string array
  public MyStringT(char arr[]) {
    if(arr != null) {
      string = new char[arr.length];
      for( int i=0; i<arr.length; i++ ){
        string[i] = arr[i];
      }
      length = arr.length;
    }        
  } 
  
  @Override 
  //This is the method that concatenates two strings
    public StringT ConCat(StringT S) {
    char concatArr[] = null; //Initializes the array
    
    if( string == null ) { // checks to see if it is empty
      if( S.Length() != 0 ) {
        concatArr = new char[S.Length()]; // new char array with the length of the param
        for( int i=0; i<S.Length(); i++ ){
          string[i] = S.CharAt(i); //sets char array to be character at the specified index in a string
        }
      }
    } else {
      concatArr = new char[length + S.Length()]; //defines a new char array which consists of the addition the length of the param and length variable
      int index=0;
      for( int i=0; i<string.length; i++ ){
        concatArr[index++] = string[i];
      }
      for( int i=0; i<S.Length(); i++ ){
        concatArr[index++] = S.CharAt(i);
      }
      string = concatArr; // sets the string equal to the char array defined above
    }
    StringT stringT = new MyStringT(concatArr);
    return stringT;
  }
  
  @Override
  //This is the method that returns a string from index 0 to but not including index i, it also throws the exceptioon that we have created the exception class for
    public StringT Before(int i) throws StringTException{
    if( i<0 || i>Length() ) //throws an exception if the index is less than 0 or more than the string length
      throw new StringTException();
    
    char beforeArr[] = new char[i];
    for(int j=0; j<i; j++ )
      beforeArr[j] = string[j];
    
    return new MyStringT(beforeArr);
  }
  
  @Override
  //This is the method that returns a string from i to the end of the string, it also throws the exception that we have an extra class for
    public StringT After(int i) throws StringTException{
    if( i<0 || i>Length() ) //throws an exception if index is less than 0 or more than the string length
      throw new StringTException();
    
    char beforeArr[] = new char[string.length - i + 1];
    int index = 0;
    for(int j=i; j<string.length; j++ )
      beforeArr[index++] = string[j];
    
    return new MyStringT(beforeArr);
  }
  
  @Override
  //This method simply returns the length of the string
    public int Length() {
    return length;
  }
  
  @Override
  //This method returns a clone of our string or 'this'
    public StringT Clone() {
    return new MyStringT(string);
  }
  
  @Override
  //This method returns the char index at i for this.
    public char CharAt(int i) {
    if( i<0 || i>Length() )
      return 0;
    return string[i];
  }
  
  @Override
  //This method returns a char array representation of 'this'.
    public char[] ToArray() {
    if( string == null )
      return null;
    
    char copyArr[] = new char[string.length];
    for( int i=0; i<string.length; i++ )
      copyArr[i] = string[i];
    
    return copyArr;
  }
  
  @Override
  //This method converts the chars in the string to uppercase
    public StringT toUpper() {
    if( string == null )
      return new MyStringT();
    
    char upperArr[] = new char[string.length];
    for( int i=0; i<string.length; i++ )
      upperArr[i] = Character.toUpperCase(string[i]);
    
    return new MyStringT(upperArr);
  }
  
  @Override
  //This method returns the index within this string of the first occurence of the specified char
    public int indexOf(char c) {
    
    for( int i=0; i<length; i++ )
      if( string[i] == c )
      return i;
    
    return -1;
  }
}
