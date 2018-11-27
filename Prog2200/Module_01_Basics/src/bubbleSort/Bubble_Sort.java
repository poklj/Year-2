/*
 * Two forms of Bubble sort
 */
package bubbleSort;

/**
 *
 * @author Russ
 */
public class Bubble_Sort {

    char[] chars;
    int swap_count;
    int loop_count;

    public Bubble_Sort(String theChars) {
        this.chars = new char[theChars.length()];
        this.chars = theChars.toCharArray();
        this.swap_count = 0;
        this.loop_count = 0;
    }

    /**
     * Bubble sort with 2 for loops
     */
    public void sort_1() {

        int i, j;
        char temp;

        for (i = 0; i < chars.length - 1; i++) {
            for (j = 0; j < chars.length - 1; j++) {
                if (chars[j] > chars[j + 1]) {
                    temp = chars[j];
                    chars[j] = chars[j + 1];
                    chars[j + 1] = temp;
                    swap_count++;
                }
                loop_count++;
            }
        }
    }

    /**
     * Bubble sort with 2 outer loop using a flag
     */
    public void sort_2() {

        int j;
        boolean flag = true;
        char temp;

        while (flag) {
            flag = false;
            for (j = 0; j < chars.length - 1; j++) {
                if (chars[j] > chars[j + 1]) {
                    temp = chars[j];
                    chars[j] = chars[j + 1];
                    chars[j + 1] = temp;
                    flag = true;
                    swap_count++;
                }
                loop_count++;
            }
        }
    }

    public void printAll() {
        System.out.println();
        System.out.print("swap_count=" + swap_count + "  loop_count= " + loop_count + "  chars = ");
        for (int i = 0; i < chars.length; i++) {
            System.out.print(chars[i]);
        }
        System.out.println();
    }

}
