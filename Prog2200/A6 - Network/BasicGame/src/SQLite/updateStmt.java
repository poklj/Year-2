package SQLite;

public interface updateStmt extends StatementBuffer {

	/**
	 * Instantly Execute a Statement, Bypassing the buffer
	 * @param sql SQL String
	 * @return Result code
	 */
	public int iExec(String sql);
	/**
	 * Execute the Statement within the Buffer
	 * @return Result Code
	 */
	public int ExecBuffer();
}
