package Assign5;
import java.util.Comparator;

// Trivial implementation of a simple comparator.
public class GridFieldComparatorByWidth implements Comparator<GridField> {

 /*Simply compares two arguments and compares the difference between the two arguments, in
  * this case it is the width of the array.
  */
 @Override
 public int compare(GridField arg0, GridField arg1) {
  return arg0.getWidth() - arg1.getWidth();
 }
 
}

               
               