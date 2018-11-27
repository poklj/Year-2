package packageToTest;

import java.lang.ArithmeticException;

/**
 * Contains 3 methods which manipulate the int passed in the constructor on creation.
 * 
 */
public class IntegerManipulator {

    public int i;

    /**
     * assigns int to class variable
     * @param i
     *  
     */
    public IntegerManipulator(int i) {
        this.i = i;
    }

    /**
     * Squares the int variable
     * @return int
     */
    public int ReturnSquaredInt() {
        return (i * i);
    }

    /**
     * Adds 1 to the int variable
     * @return int
     */
    public int ReturnIntPlusOne() {
        if (i == Integer.MAX_VALUE) {
            throw new ArithmeticException();
        }
        return (i + 1);
    }

    /**
     * returns the length of the int variable
     * @return String
     */
    public String ReturnLengthInt() {
        Integer myInt = new Integer(i);
        Integer intReturn = new Integer(myInt.toString().length());
        return intReturn.toString();
    }
}
