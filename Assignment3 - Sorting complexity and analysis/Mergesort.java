package Assignment3;

/** This class sets up the merge sort algorithm.
  *
  * @author Haaris Yahya
  * @version 1.0 (06/28/2021)  
  */
public class Mergesort {
 
 /** Mergesort algorithm.
  * @param a an array of Comparable items.
  */
  public static int[] mergesort(int[] a){
    int[] tmp = new int[a.length];
    mergesort(a, tmp, 0, a.length - 1);
    return a;
  }
   /**
 * Internal method that makes recursive calls.
 * @param a an array of Comparable items.
 * @param tmpArray an array to place the merged result.
 * @param left the left-most index of the subarray.
 * @param right the right-most index of the subarray.
 */
  public static void mergesort(int[] a, int[] tmp, int left, int right){
    if(left < right){
      int center  = (left+right)/2;
      mergesort(a, tmp, left, center);
      mergesort(a, tmp, center + 1,right);
      merge(a, tmp, left, center + 1, right);
    }
  }
  
  /**
 * Internal method that merges two sorted halves of a subarray.
 * @param a an array of Comparable items.
 * @param tmpArray an array to place the merged result.
 * @param leftPos the left-most index of the subarray.
 * @param rightPos the index of the start of the second half.
 * @param rightEnd the right-most index of the subarray.
 */
  public static void merge(int[] a, int[] tmp, int lefttail, int righttail, int rightEnd){
    int leftEnd = righttail - 1;
    int tmpPos = lefttail;
    int numElements = rightEnd - lefttail + 1;
    
    while(lefttail <= leftEnd && righttail <= rightEnd){
      if(a[lefttail]<(a[righttail]))
        tmp[tmpPos++] = a[lefttail++];
      else
        tmp[tmpPos++] = a[righttail++];
    }
    
    while(lefttail <= leftEnd)
      tmp[tmpPos++] = a[lefttail++];
    while(righttail <= rightEnd)
      tmp[tmpPos++] = a[righttail++];
    
    for(int i = 0; i < numElements; i++, rightEnd--)
      a[rightEnd] = tmp[rightEnd];
  }
}