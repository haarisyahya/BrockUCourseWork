package Assignment3;

/** This class sets up the insertion sort algorithm.
  *
  * @author Haaris Yahya
  * @version 1.0 (06/28/2021)  
  */

public class Insertionsort {
  
  /** Simple insertion sort
  * @param a an array of Comparable items.
  */
  public static int[] insertionsort(int[] a) {
    for (int i = 1; i < a.length; i++) {
      int b = a[i];
      int j;
      for (j = i; j > 0 && b<(a[j-1]); j--)
        a[j] = a[j - 1];
      
      a[j] = b;
    }
    return a;
  }
}