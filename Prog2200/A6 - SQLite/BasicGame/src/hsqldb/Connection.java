package hsqldb;

import java.sql.DriverManager;

public class Connection {
	
	
	protected java.sql.Connection conn = null;
	public UpdateHandler UpdateH = null;
	public QueryHandler QueryH = null;
	
	
	
	public Connection() {
		 try {
		     Class.forName("org.hsqldb.jdbc.JDBCDriver" );
		     this.conn = DriverManager.getConnection("jdbc:hsqldb:hsql://localhost/hDB1", "SA", "");
		     
		     if (conn != null){
		            System.out.println("Connection created successfully");
		            this.UpdateH = new UpdateHandler(this.conn);
		            this.QueryH = new QueryHandler(this.conn);
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
