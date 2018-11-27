package SQLite;


/**
 * Implement this if you're using a Statement buffer, This requires a Local scoped Statement variable
 * @author zach
 *
 */
public interface StatementBuffer {

	/**
	 * Push a String sql statement to the buffer
	 * @param stmt SQL string
	 * @return push success
	 */
	public boolean PushStmt(String stmt);
	/** 
	 * Get the buffer State
	 * @return Buffer
	 */
	public String getBuffer();
	
}
