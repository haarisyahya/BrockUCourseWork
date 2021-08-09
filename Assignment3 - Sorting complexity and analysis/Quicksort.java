package Assignment3;

/** This class sets up the quicksort sort algorithm.
  *
  * @author Haaris Yahya
  * @version 1.0 (06/28/2021)  
  */

public class Quicksort {
  
  /**
 * Quicksort algorithm.
 * @param a an array of Comparable items.
 */
  public static int[] quicksort(int[] a){
    quicksort(a, 0, a.length - 1);
    return a;
  }
  /**
 * Return median of left, center, and right.
 * Order these and hide the pivot.
 */
  private static int partition(int[]a , int left, int right){
    int center = (left + right)/2;
    if(a[center]<(a[left])){
      int tmp = a[center];
      a[left] = a[center];
      a[center] = tmp;
    }
    
    if(a[right]<(a[left])){
      int tmp = a[right];
      a[right] = a[left];
      a[left] = tmp;
    }
    
    if(a[right]<(a[center])){
      int tmp = a[right];
      a[right] = a[center];
      a[center] = tmp;
    }
    
    int temp = a[center];
    a[center] = a[right - 1];
    a[right - 1] = temp;
    
    return a[right - 1];
  }
  /**
 * Internal quicksort method that makes recursive calls.
 * Uses median-of-three partitioning and a cutoff of 10.
 * @param a an array of Comparable items.
 * @param left the left-most index of the subarray.
 * @param right the right-most index of the subarray.
 */
  static void quicksort(int[] a, int left, int right){
    if(left + 10 <= right){
      int pivot = partition(a, left, right);
      
      int i = left, j = right - 1;
      for(;;){
        while(a[++i]<(pivot)){}
        while(pivot<(a[--j])){}
        if(i < j){
          int tmp = a[i];
          a[i] = a[j];
          a[j] = tmp;
        } else
          break;
      }
      
      int tmp = a[i];
      a[i] = a[right - 1];
      a[right - 1] = tmp;
      
      quicksort(a, left, i - 1);
      quicksort(a, i + 1, right);
    }
    else
      for (int i = 1; i < a.length; i++) {
      int b = a[i];
      int j;
      for (j = i; j > 0 && b<(a[j-1]); j--)
        a[j] = a[j - 1];
      
      a[j] = b;
    }
  }
}
