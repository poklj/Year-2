
package module_10_solid;

/*
 * SOLID..."I"
 * The interface-segregation principle (ISP) states that no client 
 * should be forced to depend on methods it does not use.[1] ISP 
 * splits interfaces which are very large into smaller and more 
 * specific ones so that clients will only have to know about 
 * the methods that are of interest to them. Such shrunken 
 * interfaces are also called role interfaces.
 * 
 * Note how keyListener only handles keys, mouseListener only handles mouse.
 * 
 * http://en.wikipedia.org/wiki/Interface_segregation_principle
 * 
 * 
 */
public interface Print_All_I {
    
    // public boolean destructMeathod();

    // interface-segregation principle: Do not put both these methods in the same interface....just plain silly
    public void printAll();
    
}
