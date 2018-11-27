package SQLite.ActionObjects;

import java.sql.Connection;
import java.sql.ResultSet;

import SQLite.DBActionObject;
import SQLite.QueryHandler;
import SQLite.UpdateHandler;

public class GrabFullArray implements DBActionObject {

	private java.sql.Connection conn = null;
	private QueryHandler QueryH = null;
	public String stmt = "Select * from vehicles;";
	private ResultSet result = null;
	
	@Override
	public void Action() {
		if(this.QueryH.getBuffer() != this.stmt)
			this.QueryH.PushStmt(stmt);
		result = this.QueryH.ExecBuffer();
	}

	@Override
	public void syncConnection(Connection conn) {
		this.conn = conn;
		this.QueryH = new QueryHandler(this.conn);
	}
	
	public ResultSet getResult() {
		return this.result;
	}
}
