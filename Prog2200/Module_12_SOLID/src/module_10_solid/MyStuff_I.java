
package module_10_solid;


/*
 * 
 * Implement Print_all, Destructo.  
 * 
 * This class "Depends" on interfaces.
 * 
 * 
 */
public class MyStuff_I implements Print_All_I, Destructo_I {

    String myString = "hello from my string";

    public MyStuff_I() {
    }

    public void setMyStuff(String s) {
        this.myString = s;
    }

	
	public void printItAll() {
		//Bad idea to force method
		 System.out.println("my string = " + this.myString);		
	}
	

	@Override
	public void printAll() {
		 System.out.println("my string = " + this.myString);		
	}
	
    @Override
    public boolean destructMeathod() {
        this.myString = "";
        return true;
    }

}
