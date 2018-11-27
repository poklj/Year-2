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
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
/**
 * This is the Main Class of your Game. You should only do initialization here.
 * Move your Logic into AppStates or Controls
 */
public class Main extends SimpleApplication {
    double Bounds = 1000;
    List<Vehicle> vehicles = new ArrayList<Vehicle>();
    List<Geometry> vics = new ArrayList<Geometry>();
    List<Geometry> trace = new ArrayList<Geometry>();
    Random r = new Random();
    private int track = 0;
    
    private enum vType{
        AIR, LAND
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
        flyCam.setMoveSpeed(1000); //Change the speed of the camera
        cam.setFrustumFar(10000);
        inputManager.addMapping("MakeAir", new KeyTrigger(KeyInput.KEY_T));
        inputManager.addMapping("MakeLand", new KeyTrigger(KeyInput.KEY_Y));
        inputManager.addMapping("Clear", new KeyTrigger(KeyInput.KEY_BACK));
        
        inputManager.addListener(actionListener, "MakeLand");
        inputManager.addListener(actionListener, "MakeAir");
        inputManager.addListener(actionListener, "Clear");
        
	for (int i=0; i != 3; i++) {
            vehicles.add(new LandVehicle("Car"+(track++ +1),"Land" ,Bounds, (double) r.nextInt(100),(double) r.nextInt(100), Steer.random(), (double) r.nextInt(360)));
            vehicles.add(new AirVehicle("Plane"+(track++ +1),"Air",Bounds, (double) r.nextInt(100), Steer.random(),Steer.random1(), (double) r.nextInt(360)));
                
        }
        for (int i=0; i != 6; i++){
           Box b = new Box(1, 1, 1);
           Geometry geom = new Geometry("Box", b); 
           Material mat = new Material(assetManager, "Common/MatDefs/Misc/Unshaded.j3md");
           mat.setColor("Color", ColorRGBA.Blue);
           geom.setMaterial(mat);
           rootNode.attachChild(geom);
           vics.add(geom);
        }
        
        
    }

    @Override
    public void simpleUpdate(float tpf) {
        for (Vehicle v: vehicles){
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
            
            for(Geometry g: vics){
                g.move((float)v.getVelocityX(),(float) v.getVelocityZ(),(float)v.getVelocityY());
                System.out.println(g.getWorldTransform());
            }
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
    }
    
    /**
     *
     * @param type
     */
    public void CreateVehicle(vType type){
        if(type == vType.LAND){
            vehicles.add(new LandVehicle("Car"+(track++ +1),"Land" ,Bounds, (double) r.nextInt(100),(double) r.nextInt(100), Steer.random(), (double) r.nextInt(360)));
            Box b = new Box(1, 1, 1);
            Geometry geom = new Geometry("Box", b); 
            Material mat = new Material(assetManager, "Common/MatDefs/Misc/Unshaded.j3md");
            mat.setColor("Color", ColorRGBA.Blue);
            geom.setMaterial(mat);
            rootNode.attachChild(geom);
            vics.add(geom);
        } else if (type == vType.AIR){
            vehicles.add(new AirVehicle("Plane"+(track++ +1),"Air",Bounds, (double) r.nextInt(100), Steer.random(),Steer.random1(), (double) r.nextInt(360)));
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
                CreateVehicle(vType.AIR);
            }
            if (name.equals("MakeLand") && !keyPressed){
                CreateVehicle(vType.LAND);
            }
            if (name.equals("Clear") && !keyPressed){
                ClearAll();
            }
        }
    };
    
    @Override
    public void simpleRender(RenderManager rm) {
        //TODO: add render code
    }
}
