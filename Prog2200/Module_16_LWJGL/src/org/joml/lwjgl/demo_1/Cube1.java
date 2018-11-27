package org.joml.lwjgl.demo_1;


import org.joml.Matrix4f;
import java.nio.FloatBuffer;
import static org.lwjgl.opengl.GL11.*;

public class Cube1 {

	// Position
	float x;
	float y;
	float z;
	
	// Velocity
	float dx;
	float dy;
	float dz;
	
	// rotation
	float rx;
	float ry;
	float rz;
	
	// rotation velocity
	float drx;
	float dry;
	float drz;
	
	Matrix4f modelMatrix = new Matrix4f();
	Matrix4f modelViewMatrix = new Matrix4f();
	
	/**
	 * Basic Constructor
	 */
	public Cube1() {
		this.x = 0.0f;
		this.y = 0.0f;
		this.z = 0.0f;
		
		this.dx = 0.0f;
		this.dy = 0.0f;
		this.dz = 0.0f;
				
		this.rx = 0.0f;
		this.ry = 0.0f;
		this.rz = 0.0f;
		
		this.drx = 0.0f;
		this.dry = 0.0f;
		this.drz = 0.0f;
	}
	
/**
 * Constructor allows defining all attributes 
 * @param x
 * @param y
 * @param z
 * @param dx
 * @param dy
 * @param dz
 * @param rx
 * @param ry
 * @param rz
 * @param drx
 * @param dry
 * @param drz
 */
	public Cube1(float x, float y, float z, float dx, float dy, float dz,float rx, float ry, float rz, float drx, float dry, float drz) {
		this.x = x;
		this.y = y;
		this.z = z;
		
		this.dx = dx;
		this.dy = dy;
		this.dz = dz;
				
		this.rx = rx;
		this.ry = ry;
		this.rz = rz;
		
		this.drx = drx;
		this.dry = dry;
		this.drz = drz;
	}
	

	void renderCube() {
		glBegin(GL_QUADS);
		glColor3f(0.0f, 0.0f, 0.2f);
		glVertex3f(0.5f, -0.5f, -0.5f);
		glVertex3f(-0.5f, -0.5f, -0.5f);
		glVertex3f(-0.5f, 0.5f, -0.5f);
		glVertex3f(0.5f, 0.5f, -0.5f);
		glColor3f(0.0f, 0.0f, 1.0f);
		glVertex3f(0.5f, -0.5f, 0.5f);
		glVertex3f(0.5f, 0.5f, 0.5f);
		glVertex3f(-0.5f, 0.5f, 0.5f);
		glVertex3f(-0.5f, -0.5f, 0.5f);
		glColor3f(1.0f, 0.0f, 0.0f);
		glVertex3f(0.5f, -0.5f, -0.5f);
		glVertex3f(0.5f, 0.5f, -0.5f);
		glVertex3f(0.5f, 0.5f, 0.5f);
		glVertex3f(0.5f, -0.5f, 0.5f);
		glColor3f(0.2f, 0.0f, 0.0f);
		glVertex3f(-0.5f, -0.5f, 0.5f);
		glVertex3f(-0.5f, 0.5f, 0.5f);
		glVertex3f(-0.5f, 0.5f, -0.5f);
		glVertex3f(-0.5f, -0.5f, -0.5f);
		glColor3f(0.0f, 1.0f, 0.0f);
		glVertex3f(0.5f, 0.5f, 0.5f);
		glVertex3f(0.5f, 0.5f, -0.5f);
		glVertex3f(-0.5f, 0.5f, -0.5f);
		glVertex3f(-0.5f, 0.5f, 0.5f);
		glColor3f(0.0f, 0.2f, 0.0f);
		glVertex3f(0.5f, -0.5f, -0.5f);
		glVertex3f(0.5f, -0.5f, 0.5f);
		glVertex3f(-0.5f, -0.5f, 0.5f);
		glVertex3f(-0.5f, -0.5f, -0.5f);
		glEnd();
	}

	
	
	public void draw3D(Matrix4f viewMatrix, FloatBuffer fb) {
		
		modelMatrix.translation(x, y, z).rotateXYZ(rx, ry, rz);
		
		glLoadMatrixf(viewMatrix.mul(modelMatrix, modelViewMatrix).get(fb));
		
		renderCube();
		
	}


	// Outside walls
	float max = 4.0f;
	
	public void move() {
		// Translate (move sideways)
		this.x = this.x + this.dx;
		this.y = this.y + this.dy;
		this.z = this.z + this.dz;

		// Rotate (spin)
		this.rx = this.rx + this.drx;
		this.ry = this.ry + this.dry;
		this.rz = this.rz + this.drz;
		
		// Rebound back inside wall
		if (Math.abs(this.x) > Math.abs(max)) {
			this.dx = -this.dx;
		}
		
		if (Math.abs(this.y) > Math.abs(max)) {
			this.dy = -this.dy;
		}
		
		if (Math.abs(this.z) > Math.abs(max)) {
			this.dz = -this.dz;
		}
		
	}
	
}
