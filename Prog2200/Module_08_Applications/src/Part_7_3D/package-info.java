/**
 * 
 * This package samples how classes and inheritance can be used. If you want to
 * draw a 3D shape, it's easier to use these classes (or some library like this)
 * instead of trying to code it all up yourself.
 * 
 * <P>
 * 
 * <img src="Class_Diagram.jpg" alt="Class Diagram"/>
 * 
 * <P>
 * <P>
 * The MyWire and Cube classes are examples of shapes, which use shapeBase as a
 * means to easily create a new 3D shape.
 * <P>
 * 
 * The DrawHere class sets up a location (screen) to draw the shapes onto, and
 * sets up the list of shapes to draw.
 * <P>
 * 
 * You can use shapeBase and create your own 3D shapes, and add the setup steps
 * to DrawHere, then let them spin and move across the screen.
 * 
 * <P>
 * <img src="screen.jpg" alt="Screen"/>
 * <P>
 * <P>
 * The 3D shapes are expected to have point ranges less than 1, and have
 * locations up to about 10. This varies based on how you want your shapes to
 * look. Each shape has it's own rotation, so it appears to tumble over itself.
 * The screen is seen exactly down the z-axis, and so movement along the z-axis
 * is not seen. Depth perception is not factored.
 * 
 * @author Russ
 *
 *         P.S. Don't forget that to create JavaDocs, you'll need to set
 *         "Package" scope, and set VM Options to "-Xdoclint:none".
 *
 */
package Part_7_3D;