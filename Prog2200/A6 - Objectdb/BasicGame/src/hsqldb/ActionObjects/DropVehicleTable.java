package hsqldb.ActionObjects;

import java.sql.Connection;

import hsqldb.DBActionObject;
import hsqldb.UpdateHandler;

public class DropVehicleTable implements DBActionObject {

	private java.sql.Connection conn = null;
	private UpdateHandler UpdateH = null;
	@Override
	public void Action() {
		this.UpdateH.iExec("Drop table Vehicles");
	}

	@Override
	public void syncConnection(Connection conn) {
		this.conn = conn;
		this.UpdateH = new UpdateHandler(this.conn);
	}

}
