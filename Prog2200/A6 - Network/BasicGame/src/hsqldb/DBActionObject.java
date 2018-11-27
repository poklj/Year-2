package hsqldb;

public interface DBActionObject {
	public void Action();
	public void syncConnection(java.sql.Connection conn);
}
