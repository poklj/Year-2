package SQLite;

import java.io.File;
import java.nio.file.Paths;
import java.sql.DriverManager;



public class Connection {
	
	
	protected java.sql.Connection conn = null;
	
	
	
	public Connection() {
		 try {
		     Class.forName("org.sqlite.JDBC" );
		     new File(Paths.get("")+"/Database").mkdirs();
		     this.conn = DriverManager.getConnection("jdbc:sqlite:"+Paths.get("")+"/Database/Lite.db");
		     
		     if (conn != null){
		            System.out.println("Connection created successfully");
		     }else {
		            System.out.println("Problem with creating connection");
		     }
		 } catch (Exception e) {
		     System.err.println("ERROR: failed to load HSQLDB JDBC driver.");
		     e.printStackTrace();
		     return;
		 }
	}
	
	public void ExecuteActionObject(DBActionObject obj) {
		obj.syncConnection(this.conn);
		obj.Action();
	}
}
