
package module_10_solid;

/**
 * 
 * SOLID..."D" (Take 2) the dependency inversion principle refers to a specific
 * form of decoupling where conventional dependency relationships established
 * from high-level, policy-setting modules to low-level, dependency modules are
 * inverted (i.e. reversed) for the purpose of rendering high-level modules
 * independent of the low-level module implementation details. The principle
 * states:
 *
 * A. High-level modules should not depend on low-level modules. Both should
 * depend on abstractions.
 *
 * B. Abstractions should not depend upon details. Details should depend upon
 * abstractions.
 *
 *
 * http://en.wikipedia.org/wiki/Dependency_inversion_principle
 * 
 * 
 * dependency inversion principle: each animal class implements (depends on)
 * this interface, which defines what happens when colliding with another
 * animal.  Which means you could say....
 * 
 *  for every Bunny...
 *   for every Animal...
 *    if (Bunny and Animal are close) then
 *       animal.collide(bunny);
 *    
 * ...and it calls the collide of whatever animal type "animal" happens to be.
 * if a is a bird, calls bird's collide.
 * 
 * ...each animal type implements the CollideWithAnimals interface, so 
 * each type has a defined way to collide this other animals.
 * 
 * ...Inside Animal, or inside Bird or Moose, collide can separate who collides with who (include
 * animal as parameter if needed)
 * 	// Code Moose collide depending on which animal
	public void collide(Animal a) {  //Moose do not collide with anything but Moose
		if (a instanceof Bird) {}
		if (a instanceof Bunny) {}
		if (a instanceof Moose) {a.do_normal_collide(this);}
		if (a instanceof Turtle) {}	
	}
	
 */
public interface CollideWithAnimals_D {

	void collideWithTurtle();

	void collideWithBunny();

	void collideWithBird();

	void collideWithMoose();

}
