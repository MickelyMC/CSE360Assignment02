/** CSE360 Assignment 02
 * 	This project is to practice using git and javadoc. 
 * <p>
 * This material may not be used without written permission from
 * the author, except by course instructors and/or graders. 
 * 
 * @author Ian Kelsey
 * @version 1.0
 * @since 2020-10-05
 * */
package cse360assignment02;
import java.util.ArrayList;

/**
 * <h1>AddingMachine</h1>
 * The AddingMachine program implements basic add and
 * subtract calculator functions.
*/
public class AddingMachine {
	
	//integer total value
	private int total;
	private ArrayList<String> memory = new ArrayList<String>();
  
  /**
   * Constructor
  */
  public AddingMachine () {
	  clear();
	  memory.add("myCalculator.set (0);");
	  //total = 0;  // not needed - included for clarity
	  //add '0' to memory
  }
  
  
  /**
  * Returns total value
 */
  public int getTotal () {
    return total;
  }
  
  
  /**
  * Add method adds parameter to the total
  * @param value Integer value to ad to the total
 */  
  public void add (int value) {
	  total += value;
	  //add 'value' and operation to memory
	  memory.add("myCalculator.add (" + value + ");");
  }
  
  
  /**
  * Subtract method subtracts parameter from the total
  * @param value Integer value to subtract from the total
 */
  public void subtract (int value) {
	  total -= value;
	  //add 'value' and operation to memory
	  memory.add("myCalculator.subtract (" + value + ");");
  }

  
  /**
  * toString method, returns a string representation of the operations used
 */
  public String toString () {
	  String toReturn = "";
	  
	  //print out memory
	  //for(String j : memory) {
	  //System.out.println(j);
	  //}
	  
	  if (memory.size() == 0) {
		  return "No Operations";
	  }
	  
	  
	  //Read and format memory for return String
	  for(String i : memory) {
		  if (i.contains("add")) {
			  //toReturn = toReturn + "+ " + i.charAt(18) + " "; <-- No support for double digits
			  toReturn = toReturn + "+ " + i.subSequence(18, i.indexOf(')')) + " ";
			  
		  }
		  else if (i.contains("subtract")) {
			  //toReturn = toReturn + "- " + i.charAt(23) + " "; <-- No support for double digits
			  toReturn = toReturn + "- " + i.subSequence(23, i.indexOf(')')) + " ";
			  
		  }
		  else if (i.contains("set")) {
			  toReturn = toReturn + "0 ";
		  }
	  }

	
	  return toReturn;
	  //return operations memory
  }

  
  /**
  * clear method
 */
  public void clear() {
	  memory.clear();
  }
  
  
  // Simple test program
  public static void main(String[] args) {
	  AddingMachine calc = new AddingMachine();
	  
	  System.out.println(calc.getTotal());
	  
	  calc.add(4);
	  calc.add(17);
	  calc.subtract(-3);
	  calc.subtract(13);
	  
	  System.out.println(calc.toString());
	  System.out.println(calc.getTotal());
	  
	  calc.clear();
	  System.out.println(calc.toString());
	  
  }
  
  
  
}
/*
 
A history of the transactions must be kept to be returned by the toString method. The history should start from the initial 0 value to the last input.

 The clear method should clear your "memory".
 
Use the normal operators for the operations (+, -).

There is no limit on the size of the String returned.



The format of the String should separate all operations and values with a space. For example:
myCalculator.add (4); 
myCalculator.subtract (2); 
myCalculator.add(5);

then the toString method should return
0 + 4 – 2 + 5

Add other variables as needed to the class. Any additional variables must be private. Make changes to the other methods if needed.
Update all documentations as needed
*/
