package Assign5;
import java.util.Comparator;

// Trivial implementation of a simple comparator.
public class GridFieldComparatorByChar implements Comparator<GridField> {

 /*Simply compares the difference between the two arguments, in this case using the compareTo
  * method for Strings.
  */ 
 @Override
 public int compare(GridField arg0, GridField arg1) {
  return ("" + arg0.getC()).compareTo("" + arg1.getC());
 }
 
}