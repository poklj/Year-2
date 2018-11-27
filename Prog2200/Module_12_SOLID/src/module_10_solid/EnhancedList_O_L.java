
package module_10_solid;

/*
 * 
 * SOLID..."O"
 * the open/closed principle states "software entities (classes, 
 * modules, functions, etc.) should be open for extension, but 
 * closed for modification";[1] that is, such an entity can 
 * allow its behavior to be modified without altering its 
 * source code. (i.e. don't need to override everything in the base class!)
 * 
 * http://en.wikipedia.org/wiki/Open/closed_principle
 * 
 *  Don't modify NormalList, instead, extend it.
 * 
 * 
 * SOLID..."L"
 * Liskov substitution principle is a principle in object-oriented 
 * programming. It states that, in a computer program, if S is a 
 * subtype of T, then objects of type T may be replaced with 
 * objects of type S (i.e., objects of type S may be substituted 
 * for objects of type T) without altering any of the desirable 
 * properties of that program (correctness, task performed, etc.)
 * 
 * http://en.wikipedia.org/wiki/Liskov_substitution_principle
 * 
 * If turtle is of type animal, you can use either turtle 
 * or animal interchangeably. That is, extend animal in a 
 * way that keeps subtypes animal-like.
 * 
 * 
 * 
 * Liskov substitution principle: EnhancedList is still list-like,
 * and list methods still work on it.  ...plus DestructMeathod.
 */
public class EnhancedList_O_L extends NormalList_S implements Destructo_I {

	public EnhancedList_O_L(int size) {
		super(size);
	}

	public void reSize(int newSize) {
		this.destructMeathod();
		this.reSize(newSize);
	}

	@Override
	public boolean destructMeathod() {
		data.clear();
		return true; // could add exception handling with return of false
	}
}
