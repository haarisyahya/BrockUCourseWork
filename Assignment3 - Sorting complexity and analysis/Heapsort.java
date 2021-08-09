package Assignment3;

/** This class sets up the heapsort algorithm.
  *
  * @author Haaris Yahya
  * @version 1.0 (06/28/2021)  
  */
public class Heapsort{
  
  /** Internal method for heapsort, it returns the index of the left child
    * @param i is the index of an item in the heap
    */
  static int leftChild(int i){
    return 2*i + 1;
  }
  
  // Standard heapsort method
  // @param a an array of Comparable items. 
  public static int[] heapsort(int[] a){
    for(int i = a.length/2 - 1; i >= 0; i--)
      help(a, i, a.length);
    for(int j = a.length - 1; j > 0; j--){
      int tmp = a[0];
      a[0] = a[j];
      a[j] = tmp;
      help(a, 0, j);
    }
    return a;
  }
  
  /**Internal method for heapsort 
    * @param a an array of comparable items
    * @int i the position from which to percolate down.
    * @int n the logical size of the binary heap
    */
  private  static void help(int[] a, int i, int n){
    int child;
    int tmp;
    for(tmp = a[i]; leftChild(i) < n; i = child){
      child = leftChild(i);
      if(child != n -1 && a[child]<(a[child + 1]))
        child++;
      if(tmp<a[child])
        a[i] = a[child];
      else
        break;
    }
    a[i] = tmp;
  }
}

