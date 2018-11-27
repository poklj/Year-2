package hsqldb.ActionObjects;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Serial<Type> {
	
	public byte[] codify(Type obj) {
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		
		try {
			ObjectOutputStream out = new ObjectOutputStream(bos);
			out.writeObject(obj);
			out.close();
		}catch (IOException e2) {
			e2.printStackTrace();
		}
		byte[] objectBytes = bos.toByteArray();
		
		return objectBytes;
	}
	
	@SuppressWarnings("unchecked")
	public Type deCodify(byte[] obj) {
		ByteArrayInputStream bis = new ByteArrayInputStream(obj);
		
		Type rIn = null;
		try {
			ObjectInputStream in = new ObjectInputStream(bis);
			rIn = (Type) in.readObject();
			in.close();
		} catch (IOException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return rIn;
	}
}
