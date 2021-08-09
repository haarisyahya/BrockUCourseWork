package Assignment3;
import java.io.*;
import java.util.*;

/** This class sets up the radix sort algorithm.
  *
  * @author Haaris Yahya
  * @version 1.0 (06/28/2021)  
  */
public class Radixsort{
  
   
  // The main function to that sorts arr[] of size n using Radix Sort
    static void radixsort(int a[], int n)
  {
    
    int m = retMax(a, n);   

    for (int exp = 1; m / exp > 0; exp *= 10)
      countingSort(a, n, exp);
  }

  
  // method to get the largest value from the array
  static int retMax(int a[], int n)
  {
    int mx = a[0];
    for (int i = 1; i < n; i++)
      if (a[i] > mx)
      mx = a[i];
    return mx;
  }
 //use the counting sort to sort the elements in the basis of significant places
 static void countingSort(int a[], int n, int exp)
  {
    int output[] = new int[n]; // output array
    int i;
    int count[] = new int[10];
    Arrays.fill(count, 0);
    
    for (i = 0; i < n; i++)
      count[(a[i] / exp) % 10]++;
    
    
    for (i = 1; i < 10; i++)
      count[i] += count[i - 1];
    
    //place the elements in sorted order
    for (i = n - 1; i >= 0; i--) {
      output[count[(a[i] / exp) % 10] - 1] = a[i];
      count[(a[i] / exp) % 10]--;
    }
    
   
    for (i = 0; i < n; i++)
      a[i] = output[i];
  }
}