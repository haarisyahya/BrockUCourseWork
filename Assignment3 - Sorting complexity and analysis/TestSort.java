package Assignment3;

import java.util.*;

/** This class sets up the testing methods for the algorithms using 5 different cases.
  *
  * @author Haaris Yahya
  * @version 1.0 (06/28/2021)  
  */

public class TestSort{
  Scanner input;
  double start,end, time;
  
  // Test sort method that sets up the input, sets up the array and the cases
  public TestSort(){
    int size;
    int[]  array;
    input = new Scanner( System.in );
    
    for(;;){
      int choice;
      System.out.print("Enter any number other than 0 to start: ");
      choice = input.nextInt();
      
      if (choice == 0) break;
      System.out.print("Enter the number of integer elements (Array's Size):");
      size = input.nextInt();
      array = new int[size];
      System.out.print("Enter 'random' for random values:");
      String s = input.next();
      switch (s){
        case "random" :
          for(int i = 0;i<array.length;i++){
          int random = (int )(Math.random() * 10000);
          array[i]=random;
        }
          System.out.println();
          sort(array);
          break;
        default:
          System.out.println("invaid value");
          break;
      }
    }
    input.close();
  }
  /** This method sets up different sorts to be tested while calculating the
    * time they take to complete, when that is done, they are printed onto the console
    */
  private void sort(int [] array){
    Heapsort a;
    a=new Heapsort();
    
    for(;;){
      System.out.print("Please choose a sorting method: '1' for InsertionSort; '2 'for HeapSort;"+
                       " '3' for RadixSort; '4' for Quicksort; '5' for MergeSort; '0' to end: ");
      int n = input.nextInt();
      if (n==0) break;
      switch(n){
        case 1:
          System.out.print("InsertionSort: ");
          start = System.currentTimeMillis();
          Insertionsort.insertionsort(array);
          end = System.currentTimeMillis();
          time = ((end - start)/1000);
          
           for(int i = 0;i<array.length;i++){
            System.out.print(array[i]+" ");
          }
          System.out.println(); 
          System.out.println("time of operation: "+ time+" s ");
          break;
        case 2:
          System.out.print("HeapSort: ");
          start = System.currentTimeMillis();
          Heapsort.heapsort(array);
          end = System.currentTimeMillis();
          time = ((end - start)/1000);
          
          for(int i = 0;i<array.length;i++){
            System.out.print(array[i]+" ");
          }
          System.out.println(); 
          System.out.println("time of operation: "+ time+" s ");
          break;
        case 3:
          System.out.print("RadixSort: "); 
          start = System.currentTimeMillis();
          Radixsort.radixsort(array,array.length);
          end = System.currentTimeMillis();
          time = ((end - start)/1000);
          
          for(int i = 0;i<array.length;i++){
            System.out.print(array[i]+" ");
          }
          System.out.println();
          System.out.println("time of operation: "+ time+" s ");
          break;
        case 4:
          System.out.print("QuickSort: "); 
          start = System.currentTimeMillis();
          Quicksort.quicksort(array);
          end = System.currentTimeMillis();
          time = ((end - start)/1000);
           for(int i = 0;i<array.length;i++){
            System.out.print(array[i]+" ");
          }
          System.out.println();
          System.out.println("time of operation: "+ time+" s ");
          break;
        case 5:
          System.out.print("MergeSort: ");   
          start = System.currentTimeMillis();
          Mergesort.mergesort(array);
          end = System.currentTimeMillis();
          time = ((end - start)/1000);
          for(int i = 0;i<array.length;i++){
            System.out.print(array[i]+" ");
          }
          System.out.println();
          System.out.println("time of operation: "+ time+" s ");
          break;
        default:
          System.out.print("invalid sort"); 
          break;
      }
    }
  }
  // main method
  public static void main(String[] args){ TestSort t = new TestSort();}
  
}


