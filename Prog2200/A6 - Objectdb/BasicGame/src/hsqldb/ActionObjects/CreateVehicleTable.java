package hsqldb.ActionObjects;

import java.sql.Connection;
import java.sql.SQLException;

import hsqldb.DBActionObject;
import hsqldb.UpdateHandler;

public class CreateVehicleTable implements DBActionObject {
	
	private java.sql.Connection conn = null;
	private UpdateHandler UpdateH = null;
	
	private String stmt = "CREATE TABLE IF NOT EXISTS VEHICLES (id VARCHAR(20) NOT NULL, object BLOB NOT NULL, PRIMARY KEY(id));";
	
	@Override
	public void Action() {
		try {
			if(null == conn) 
				throw new SQLException("Connection not Available");
			if(this.UpdateH.getBuffer() != this.stmt)
				this.UpdateH.PushStmt(stmt);
			System.out.println(this.UpdateH.getBuffer());
			this.UpdateH.ExecBuffer();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void syncConnection(Connection conn) {
		this.conn = conn;
		this.UpdateH = new UpdateHandler(this.conn);
	}

}
