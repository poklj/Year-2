package SQLite;

import java.sql.Array;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import SQLite.ActionObjects.*;

public class Test {

	public static void main(String[] args) {
		Connection conn = new Connection();
		CreateVehicleTable cTB = new CreateVehicleTable();
		
		CreateVehicle cV = new CreateVehicle();
		GrabFullArray gfa = new GrabFullArray();
		DropVehicleTable dVt = new DropVehicleTable();
		
		conn.ExecuteActionObject(dVt);
		
		conn.ExecuteActionObject(cTB);
		
		int Id = 0;
		
		Serial<TestObject> ts = new Serial<>();
		TestObject SerObject = new TestObject();
		
		byte[] b = ts.codify(SerObject);
		
		cV.SyncByteArray(b);
		cV.SyncID(""+Id++);
		
		conn.ExecuteActionObject(cV);
		
		conn.ExecuteActionObject(gfa);
		
		ResultSet gfaR = gfa.getResult();
		List<TestObject> Jaffa = new ArrayList<>();
		
		try {
			while(gfaR.next()) {
				Jaffa.add(ts.deCodify(gfaR.getBytes("Object")));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		for(TestObject aa : Jaffa) {
			System.out.println(aa.a);
			System.out.println(aa.b);
			System.out.println(aa.c);
		}
		//Drop the table before testing
		conn.ExecuteActionObject(dVt);
		System.out.println("Destroyed table");
		
	}

}
