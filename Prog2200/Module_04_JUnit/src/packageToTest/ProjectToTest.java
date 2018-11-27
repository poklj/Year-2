package packageToTest;

/**
 * Creates instance of IntegerManipulator(10) and demonstrates how each of its methods work.
 * 
 */
public class ProjectToTest {

	public static void main(String[] args) 
	{
		int i = 10;
		
		IntegerManipulator myIntMangler = new IntegerManipulator(i);
		
		int squaredInt;
		squaredInt = myIntMangler.ReturnSquaredInt();
		System.out.println("myIntManagler.ReturnSquaredInt() created with a "+i+" = "+
				squaredInt);
		
		int intPlusOne = myIntMangler.ReturnIntPlusOne();
		System.out.println("myIntManagler.ReturnIntPlusOne() created with a "+i+" = "+
				intPlusOne);
		
		String strLength = myIntMangler.ReturnLengthInt();
		System.out.println("myIntManagler.ReturnLengthInt() created with a "+i+" = "+
				strLength);
	}
}
