package SQLite;

public interface DBActionObject {
	public void Action();
	public void syncConnection(java.sql.Connection conn);
}
