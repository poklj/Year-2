package SQLite;

import java.sql.ResultSet;

public interface resultStmt extends StatementBuffer {

	
	/**
	 * Instantly Execute a Statement, Bypassing the buffer
	 * @param sql SQL String
	 * @return The query Result
	 */
	public ResultSet iExec(String sql);
	
	/**
	 * Execute the Statement within the Buffer
	 * @return The query Result
	 */
	public ResultSet ExecBuffer();
}
