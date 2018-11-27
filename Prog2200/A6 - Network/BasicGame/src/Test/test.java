package Test;

import objectdb.*;

public class test {
	public static void main(String[] args) {
		ManageJDO jdo = new ManageJDO("test.odb");
		
		TestObject TO = new TestObject();
		
		jdo.saveNew(TO);
		jdo.dumpObjects(TestObject.class);
		
		jdo.deleteAllObjects(TestObject.class);
		jdo.dumpObjects(TestObject.class);
	}
}
