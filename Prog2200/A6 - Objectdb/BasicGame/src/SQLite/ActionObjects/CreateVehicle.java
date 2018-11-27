package SQLite.ActionObjects;

import java.sql.Connection;
import java.util.Map;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import SQLite.ByteAObject;
import SQLite.DBActionObject;
import SQLite.IdentifyableObject;
import SQLite.UpdateHandler;

public class CreateVehicle implements DBActionObject, ByteAObject, IdentifyableObject {

	private java.sql.Connection conn = null;
	private UpdateHandler UpdateH = null;
	
	private String ID = "";
	private byte[] ObjectByteArray = null;
	private String stmt = "INSERT INTO vehicles(id, object) values (?,?);";
	
	private PreparedStatement pstmt = null;
	
	@Override
	public void Action() {
		try {
			pstmt = conn.prepareStatement(stmt);
			pstmt.setString(1, ID);
			pstmt.setBytes(2, ObjectByteArray);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}

	@Override
	public void syncConnection(Connection conn) {
		this.conn = conn;
		this.UpdateH = new UpdateHandler(this.conn);
	}

	@Override
	public void SyncByteArray(byte[] Object) {
		this.ObjectByteArray = Object;
	}

	@Override
	public void SyncID(String id) {
		this.ID = id;
	}
}
