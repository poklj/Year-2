package SQLite;

import java.io.IOException;
import java.sql.Statement;

public class UpdateHandler implements updateStmt {

	private java.sql.Connection conn = null;
	protected String stmtBuff = null;
	private Statement stmt = null;
	
	public UpdateHandler(java.sql.Connection connection) {
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
	
	public int iExec(String sql) {
		int result = 0;
		try {
			stmt.executeUpdate(sql);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public String getBuffer() {
		return this.stmtBuff;
	}
	
	public int ExecBuffer() {
		int result = 0;
		try {
			result = stmt.executeUpdate(this.stmtBuff);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
}
