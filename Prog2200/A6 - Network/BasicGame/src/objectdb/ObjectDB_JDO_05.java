package objectdb;

import java.awt.Color;
import java.util.List;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 JDO OOP Sample 
 - Abstract class Shape 
 - derived Triangle, Square ==> getExtent "include instances of subclasses" = TRUE
 - "GetUsingFDO" made more OO...does not know what it is saving 
 - Transient area field inside Shape class 
 - java.awt.Color added to Package.jdo to save color
 - Color doesn't enhance or save properly (check log under objectDB.jar)

 */
public class ObjectDB_JDO_05 {

    static Random R = new Random();

    static public int RND() {
        return R.nextInt(100);
    }

    public static void main(String[] args) {

        // Got logs complaining I didn't "Enhance"
        com.objectdb.Enhancer.enhance("objectdb_jdo_05.Shape");
        com.objectdb.Enhancer.enhance("objectdb_jdo_05.Triangle");
        com.objectdb.Enhancer.enhance("objectdb_jdo_05.Square");
        //com.objectdb.Enhancer.enhance("java.awt.Color");

        ManageJDO g = new ManageJDO("Shapes.odb");

        // Make Triangle record
        Triangle t1 = new Triangle();
        t1.setX1(RND());
        t1.setY1(RND());
        t1.setX2(RND());
        t1.setY2(RND());
        t1.setX3(RND());
        t1.setY3(RND());
        //t1.setC(Color.red);
        g.saveNew(t1);

        Square s1 = new Square();
        s1.setX1(RND());
        s1.setX1(RND());
        s1.setY1(RND());
        s1.setX2(RND());
        s1.setY2(RND());
        //s1.setC(Color.BLUE);
        g.saveNew(s1);

        g.dumpObjects(Shape.class);   // open and dump data
        g.dumpObjects(Triangle.class);   // open and dump data
        g.dumpObjects(Square.class);   // open and dump data

        List<Object> results;
        results = g.getObjects(Shape.class);
        for (Object t : results) {
            Thread t2 = (Thread) t;
            t2.start();
        }

        g.close();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException ex) {
            Logger.getLogger(ObjectDB_JDO_05.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
