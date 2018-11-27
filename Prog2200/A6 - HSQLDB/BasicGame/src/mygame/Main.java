package mygame;

import com.jme3.app.SimpleApplication;
import com.jme3.input.KeyInput;
import com.jme3.material.Material;
import com.jme3.math.ColorRGBA;
import com.jme3.math.Vector3f;
import com.jme3.renderer.RenderManager;
import com.jme3.scene.Geometry;
import com.jme3.input.controls.KeyTrigger;
import com.jme3.input.controls.ActionListener;
import com.jme3.scene.shape.Box;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import hsqldb.*;
import hsqldb.ActionObjects.*;
/**
 * This is the Main Class of your Game. You should only do initialization here.
 * Move your Logic into AppStates or Controls
 * @author normenhansen
 */


/*
absolute fuck, I'm going to need to remake this entire thing, This is a mess of logic that doesn't need to be here
*/


/*
 * If you spawn Two things at the exact same time (Pressing the buttons together), it will exhibit the correct "destruction" behavior 
 * 
 */
public class Main extends SimpleApplication {
    double Bounds = 1000;
    List<Vehicle> vehicles = new ArrayList<>();
    List<Geometry> vics = new ArrayList<>();
    List<Geometry> trace = new ArrayList<>();
    
    Serial<Vehicle> vSerial = new Serial<>();
    Connection conn = new Connection();
    CreateVehicleTable cvt = new CreateVehicleTable();
    GrabFullArray gfa = new GrabFullArray();
    DropVehicleTable dvt = new DropVehicleTable();
    CreateVehicle cv = new CreateVehicle();
    
    Random r = new Random();
    private int track = 0;
    
    private enum vType{
        AIR, LAND, CYCLE, SAM
    }
    
    public static void main(String[] args) {
        Main app = new Main();
        app.start();
    }

    @Override
    public void simpleInitApp() {
	//LandVehicle Car1 = new LandVehicle("Car1", Bounds);
	//AirVehicle Plane1 = new AirVehicle("Plane1", Bounds);
	/*
	Car1.setGasPedal_percent(80);
	Plane1.setPropeller_Speed(60);
	Plane1.setSteeringWheelPosition(Steering_wheel.CENTER);
	Car1.setSteeringWheelPosition(Steering_wheel.LEFT);
	*/
    	
    	
    	
        flyCam.setMoveSpeed(60);
        cam.setFrustumFar(10000);
        inputManager.addMapping("MakeAir", new KeyTrigger(KeyInput.KEY_T));
		inputManager.addMapping("MakeLand", new KeyTrigger(KeyInput.KEY_Y));
        inputManager.addMapping("MakeCycle", new KeyTrigger(KeyInput.KEY_U));
        inputManager.addMapping("MakeSAM", new KeyTrigger(KeyInput.KEY_I));
        inputManager.addMapping("Clear", new KeyTrigger(KeyInput.KEY_BACK));
        
        inputManager.addMapping("playLEFT", new KeyTrigger(KeyInput.KEY_LEFT));
        inputManager.addMapping("playRIGHT", new KeyTrigger(KeyInput.KEY_RIGHT));
        inputManager.addMapping("playUP", new KeyTrigger(KeyInput.KEY_UP));
        inputManager.addMapping("playDown", new KeyTrigger(KeyInput.KEY_DOWN));
        
        inputManager.addListener(actionListener, "MakeLand");
        inputManager.addListener(actionListener, "MakeAir");
        inputManager.addListener(actionListener, "MakeSAM");
        inputManager.addListener(actionListener, "MakeCycle");
        inputManager.addListener(actionListener, "Clear");
        
        ResultSet gfaResult = null;
        conn.ExecuteActionObject(cvt);
        conn.ExecuteActionObject(gfa);
        gfaResult = gfa.getResult();
        
        
        try {
			while(gfaResult.next()) {
				Vehicle v = vSerial.deCodify(gfaResult.getBytes("object"));
				
				switch (v.getType()) {
				case "Land" :
					this.CreateVehicle(vType.LAND, v);
					break;
				case "Air" :
					this.CreateVehicle(vType.AIR, v);
					break;
				case "Motorcycle" :
					this.CreateVehicle(vType.CYCLE, v);
					break;
				case "SAM" :
					this.CreateVehicle(vType.SAM, v);
					break;
				}
				track++;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        
        
        
    }

    @Override
    public void simpleUpdate(float tpf) {
        for (Vehicle v: vehicles){
            if(v.getCrashed())
                continue;
            for(Vehicle i: vehicles){
                if(i.getCrashed())
                    continue;
                // Check once, do it twice if once to do possibly overridden methods (They might not crash!)
                if(v.checkCollide(i)){
                    i.checkCollide(v);
                    
                    
                    
                    if(v.getRepresented() == false || i.getRepresented() == false){
                        Box b = new Box(1,1,1);
                        Geometry geom = new Geometry("Box", b); 
                        Material mat = new Material(assetManager, "Common/MatDefs/Misc/Unshaded.j3md");
                        mat.setColor("Color", ColorRGBA.White);
                        geom.setMaterial(mat);
                        rootNode.attachChild(geom);
                        geom.move((float)v.getPositionX(), (float)v.getPositionZ() +1, (float)v.getPositionY() );
                        trace.add(geom);
                        if("Air".equals(v.getType())){
                            v.setRepresented(true);
                            v.setCrashedTrue();
                        }
                        if("Air".equals(i.getType())){
                            i.setRepresented(true);
                        }
                        if("Motorcycle".equals(v.getType())){
                            v.setCrashedTrue();
                        }
                        if("Motorcycle".equals(i.getType())){
                            i.setCrashedTrue();
                        }
                        if("SAM".equals(v.getType())){
                            v.setCrashedTrue();
                            i.setCrashedTrue();
                        }
                        if("SAM".equals(i.getType())){
                            v.setCrashedTrue();
                            i.setCrashedTrue();
                        }
                    }
                }
            }
            if (!v.getCrashed()){
            if("Land".equals(v.getType())){
                Box b = new Box(1, 1, 1);
                Geometry geom = new Geometry("Box", b); 
                Material mat = new Material(assetManager, "Common/MatDefs/Misc/Unshaded.j3md");
                mat.setColor("Color", ColorRGBA.Green);
                geom.setMaterial(mat);
                rootNode.attachChild(geom);
                geom.move((float)v.getPositionX(), (float)v.getPositionZ(), (float)v.getPositionY());
                trace.add(geom);
            } else if ("Air".equals(v.getType())){
                Box b = new Box(1, 1, 1);
                Geometry geom = new Geometry("Box", b); 
                Material mat = new Material(assetManager, "Common/MatDefs/Misc/Unshaded.j3md");
                mat.setColor("Color", ColorRGBA.Red);
                geom.setMaterial(mat);
                rootNode.attachChild(geom);
                geom.move((float)v.getPositionX(), (float)v.getPositionZ(), (float)v.getPositionY());
                trace.add(geom);
            } else if ("Motorcycle".equals(v.getType())){
                Box b = new Box(1, 1, 1);
                Geometry geom = new Geometry("Box", b); 
                Material mat = new Material(assetManager, "Common/MatDefs/Misc/Unshaded.j3md");
                mat.setColor("Color", ColorRGBA.Magenta);
                geom.setMaterial(mat);
                rootNode.attachChild(geom);
                geom.move((float)v.getPositionX(), (float)v.getPositionZ(), (float)v.getPositionY());
                trace.add(geom);
            } else if ("SAM".equals(v.getType())){
                Box b = new Box(1, 1, 1);
                Geometry geom = new Geometry("Box", b); 
                Material mat = new Material(assetManager, "Common/MatDefs/Misc/Unshaded.j3md");
                mat.setColor("Color", ColorRGBA.Blue);
                geom.setMaterial(mat);
                rootNode.attachChild(geom);
                geom.move((float)v.getPositionX(), (float)v.getPositionZ(), (float)v.getPositionY());
                trace.add(geom);
            } else {
                Box b = new Box(1, 1, 1);
                Geometry geom = new Geometry("Box", b); 
                Material mat = new Material(assetManager, "Common/MatDefs/Misc/Unshaded.j3md");
                mat.setColor("Color", ColorRGBA.Yellow);
                geom.setMaterial(mat);
                rootNode.attachChild(geom);
                geom.move((float)v.getPositionX(), (float)v.getPositionZ(), (float)v.getPositionY());
                trace.add(geom);
            }
            v.Update();
            //Change Blue "Header" Block
            for(Geometry g: vics){
                g.move((float)v.getPositionX(),(float) v.getPositionZ(),(float)v.getPositionY());
            }
            
            }
        }
//        if(!vehicles.isEmpty()){
//            for(Vehicle v : vehicles){
//                for(Geometry g : vics){
//                    CheckRemoveCrashed(v, g);
//                }
//            }
//        }
    }
    
    
    //Adding this anywhere Causes Concurrency error, Likely due to 
    public void CheckRemoveCrashed(Vehicle v, Geometry g){
        if(v.getCrashed()){
            vehicles.remove(v);
            g.removeFromParent();
            trace.remove(g);
            vics.remove(g);
        }
            
    }
    public void ClearAll(){
        for (Geometry g: vics){
            g.removeFromParent();
        }
        vics.clear();
        for (Geometry g: trace){
            g.removeFromParent();
        }
        trace.clear();
        vehicles.clear();
        this.track = 0;
    }
    
    /**
     * Create a Vehicle of a type, using the vType Enumeration
     * TODO: Split this up, This Function should be more factory like
     * @param type The Vehicle type (Enum)
     */
    public void CreateVehicle(vType type, Vehicle v){
        if(type == vType.LAND){
        	if(v==null)
        		vehicles.add(new LandVehicle("Car"+(track++ +1),"Land" ,Bounds, (double) r.nextInt(100),(double) r.nextInt(100), Steer.random(), (double) r.nextInt(360)));
        	else
        		vehicles.add(v);
        	Box b = new Box(1, 1, 1);
            Geometry geom = new Geometry("Box", b); 
            Material mat = new Material(assetManager, "Common/MatDefs/Misc/Unshaded.j3md");
            mat.setColor("Color", ColorRGBA.Blue);
            geom.setMaterial(mat);
            rootNode.attachChild(geom);
            vics.add(geom);
        } else if (type == vType.AIR){
        	if(v==null)
        		vehicles.add(new AirVehicle("Plane"+(track++ +1),"Air",Bounds, (double) r.nextInt(100), Steer.random(),Steer.random1(), (double) r.nextInt(360)));
        	else
        		vehicles.add(v);
        	Box b = new Box(1, 1, 1);
            Geometry geom = new Geometry("Box", b); 
            Material mat = new Material(assetManager, "Common/MatDefs/Misc/Unshaded.j3md");
            mat.setColor("Color", ColorRGBA.Blue);
            geom.setMaterial(mat);
            rootNode.attachChild(geom);
            vics.add(geom);
        } else if (type == vType.CYCLE){
        	if(v==null)
        		vehicles.add(new Motorcycle("Cycle"+(track++ +1),Steer.random(),(int) (double) r.nextInt(100), Bounds,r.nextInt(360)));
        	else
        		vehicles.add(v);
        	Box b = new Box(1, 1, 1);
            Geometry geom = new Geometry("Box", b); 
            Material mat = new Material(assetManager, "Common/MatDefs/Misc/Unshaded.j3md");
            mat.setColor("Color", ColorRGBA.Magenta);
            geom.setMaterial(mat);
            rootNode.attachChild(geom);
            vics.add(geom);
        } else if(type == vType.SAM){
        	if(v==null)
        		vehicles.add(new SAM("SAM"+(track++ +1),0,0,r.nextInt(360)));
        	else
        		vehicles.add(v);
            Box b = new Box(1, 1, 1);
            Geometry geom = new Geometry("Box", b); 
            Material mat = new Material(assetManager, "Common/MatDefs/Misc/Unshaded.j3md");
            mat.setColor("Color", ColorRGBA.Blue);
            geom.setMaterial(mat);
            rootNode.attachChild(geom);
            vics.add(geom);
        }
    }
    
    private final ActionListener actionListener = new ActionListener() {
        @Override
        public void onAction(String name, boolean keyPressed, float tpf) {
            if (name.equals("MakeAir") && !keyPressed){
                CreateVehicle(vType.AIR, null);
            }
            if (name.equals("MakeLand") && !keyPressed){
                CreateVehicle(vType.LAND, null);
            }
            if(name.equals("MakeCycle") && !keyPressed){
                CreateVehicle(vType.CYCLE, null);
            }
            if(name.equals("MakeSAM") && !keyPressed){
                CreateVehicle(vType.SAM, null);
            }
            if (name.equals("Clear") && !keyPressed){
                ClearAll();
            }
        }
    };
    
    @Override
    public void destroy() {
    	super.destroy();
    	conn.ExecuteActionObject(dvt);
    	conn.ExecuteActionObject(cvt);
    	for (Vehicle v : vehicles) {
    		String id = v.getVehicleName();
    		byte[] serObj =  vSerial.codify(v);
    		
    		
    		
    		cv.SyncID(id);
    		cv.SyncByteArray(serObj);
    		
    		conn.ExecuteActionObject(cv);
    	}
    }
    
    @Override
    public void simpleRender(RenderManager rm) {
        //TODO: add render code
    }
}
