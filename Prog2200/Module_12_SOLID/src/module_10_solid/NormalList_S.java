
package module_10_solid;

import java.util.ArrayList;
import java.util.List;


/*
 * 
 * SOLID..."S"
 * 
 * the single responsibility principle states that every class 
 * should have a single responsibility, and that responsibility 
 * should be entirely encapsulated by the class. All its 
 * services should be narrowly aligned with that responsibility.
 * 
 * http://en.wikipedia.org/wiki/Single_responsibility_principle
 * 
 * 
 */
public class NormalList_S implements Print_All_I{

    // Make a set out of the array given
    protected List<Double> data = new ArrayList<>();

    public NormalList_S(int size) {
        this.makeList(size);
    }

    protected void makeList(int size) {
        for (int i = 0; i < size; i++) {
            boolean success = data.add(Math.random());
        }
    }

    public boolean Add(Double d) {
        boolean success = data.add(d);
        return success;
    }

    public void printAll() {
        // print out the array

        for (Double d : data) {
            System.out.print(" " + d);
        }
        System.out.println();
    }
}
