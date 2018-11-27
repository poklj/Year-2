
package module_10_solid;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * SOLID..."D"
 * the dependency inversion principle refers to a specific form of
 * decoupling where conventional dependency relationships established from
 * high-level, policy-setting modules to low-level, dependency modules are
 * inverted (i.e. reversed) for the purpose of rendering high-level modules
 * independent of the low-level module implementation details. The principle
 * states:
 *
 * A. High-level modules should not depend on low-level modules. Both should
 * depend on abstractions.
 *
 * B. Abstractions should not depend upon details. Details should depend
 * upon abstractions.
 *
 *
 * http://en.wikipedia.org/wiki/Dependency_inversion_principle
 */
public class Module_10_SOLID_D {

    
    public static void main(String[] args) {

        final EnhancedList_O_L a = new EnhancedList_O_L(5);
        final MyStuff_I b = new MyStuff_I();

        // dependency inversion principle: example of main depending on specific methods of building-block classes (bad)
        a.printAll();
        b.printItAll();
        
        // dependency inversion principle: Main depends on interface Destructo (good)
        a.destructMeathod();
        b.destructMeathod();

        a.printAll();   
        b.printItAll();

        /* dependency inversion principle:  printAll should be in 
         * 
         *   A.  in a base class, as abstract method; or
         * 
         *   B.  in an interface, either alone or with Destructo-method
         * 
         */
        

    }
}
