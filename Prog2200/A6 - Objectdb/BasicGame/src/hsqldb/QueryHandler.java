package hsqldb;

import java.io.IOException;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class QueryHandler implements resultStmt {

	private java.sql.Connection conn = null;
	protected String stmtBuff = null;
	private Statement stmt = null;
	protected ResultSet resultBuff = null;
	
	/**
	 * Create a connection and load statements
	 * @param connection the SQL connection handed from the Connection base
	 */
	public QueryHandler(java.sql.Connection connection) {
		try {
			if(null == connection) {
				throw new IOException();
			} else{
				conn = connection;
				stmt = conn.createStatement();
			}
		}catch (IOException io) {
			io.printStackTrace();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public boolean PushStmt(String stmt) {
		boolean success = true;
		try {
			stmtBuff = stmt; 
		} catch (Exception e) {
			success = false;
			e.printStackTrace();
		}
		return success;
	}
	
	
	
	public ResultSet ExecBuffer() {
		try {
			this.resultBuff = stmt.executeQuery(stmtBuff);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return resultBuff;
	}
	
	public ResultSet iExec(String sql) {
		try {
			this.resultBuff = stmt.executeQuery(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return resultBuff;
	}

	@Override
	public String getBuffer() {
		return this.stmtBuff;
	}
	
}
