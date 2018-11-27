
public class Math_example {

    public static void main(String[] args) {
    	
    	int i = 23;
    	
        // displaying min and max values for different variable types
        System.out.println("Integer MAX_VALUE: " + Integer.MAX_VALUE);
        System.out.println("Integer MIN_VALUE: " + Integer.MIN_VALUE);
        System.out.println("Long MAX_VALUE: " + Long.MAX_VALUE);
        System.out.println("Long MIN_VALUE: " + Long.MIN_VALUE);
        System.out.println("Double MAX_VALUE: " + Double.MAX_VALUE);
        System.out.println("Double MIN_VALUE: " + Double.MIN_VALUE);
        System.out.println("Byte MAX_VALUE: " + Byte.MAX_VALUE);
        System.out.println("Byte MIN_VALUE: " + Byte.MIN_VALUE);
        System.out.println("Float MAX_VALUE: " + Float.MAX_VALUE);
        System.out.println("Float MIN_VALUE: " + Float.MIN_VALUE);
        System.out.println("Character MAX_VALUE: " + Character.MAX_VALUE);
        System.out.println("Character MIN_VALUE: " + Character.MIN_VALUE);

        for (double d = 0.0; d < 3.14; d = d + 0.1) {
            System.out.println("d=" + d + "   cos=" + Math.cos(d));
            System.out.println("random1=" + (int)(50*Math.random()));
            System.out.println("random2=" + 50*(int)Math.random() );
        }

        // Math package
        System.out.println("PI=" + Math.PI);

        // Casting
        System.out.println(" PI - 1 = " + (Math.PI - 1));
        System.out.println(" PI - 1 = " + ((int) Math.PI - 1));

    }
}
