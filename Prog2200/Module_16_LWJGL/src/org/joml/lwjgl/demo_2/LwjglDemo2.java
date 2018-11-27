package org.joml.lwjgl.demo_2;

import org.joml.Matrix4f;
import org.lwjgl.BufferUtils;
import org.lwjgl.glfw.*;
import org.lwjgl.opengl.*;

import java.nio.FloatBuffer;

import javax.swing.JFrame;

import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.system.MemoryUtil.*;

public class LwjglDemo2 {
	GLFWErrorCallback errorCallback;
	GLFWKeyCallback keyCallback;
	GLFWFramebufferSizeCallback fbCallback;

	long window;
	int width = 600;
	int height = 480;

	// JOML matrices
	Matrix4f projMatrix = new Matrix4f();
	Matrix4f viewMatrix = new Matrix4f();

	// FloatBuffer for transferring matrices to OpenGL
	FloatBuffer fb = BufferUtils.createFloatBuffer(16);

	void run() {
		try {
			init();
			loop();

			glfwDestroyWindow(window);
			keyCallback.free();
		} finally {
			glfwTerminate();
			errorCallback.free();
			System.exit(0);
		}
	}

	void init() {
		glfwSetErrorCallback(errorCallback = GLFWErrorCallback.createPrint(System.err));
		if (!glfwInit())
			throw new IllegalStateException("Unable to initialize GLFW");

		// Configure our window
		glfwDefaultWindowHints();
		glfwWindowHint(GLFW_VISIBLE, GLFW_FALSE);
		glfwWindowHint(GLFW_RESIZABLE, GLFW_TRUE);

		window = glfwCreateWindow(width, height, "Hello World!", NULL, NULL);
		if (window == NULL)
			throw new RuntimeException("Failed to create the GLFW window");

		glfwSetKeyCallback(window, keyCallback = new GLFWKeyCallback() {
			@Override
			public void invoke(long window, int key, int scancode, int action, int mods) {
				if (key == GLFW_KEY_ESCAPE && action == GLFW_RELEASE)
					glfwSetWindowShouldClose(window, true);
			}
		});
		glfwSetFramebufferSizeCallback(window, fbCallback = new GLFWFramebufferSizeCallback() {
			@Override
			public void invoke(long window, int w, int h) {
				if (w > 0 && h > 0) {
					width = w;
					height = h;
				}
			}
		});

		GLFWVidMode vidmode = glfwGetVideoMode(glfwGetPrimaryMonitor());
		glfwSetWindowPos(window, (vidmode.width() - width) / 2, (vidmode.height() - height) / 2);

		glfwMakeContextCurrent(window);
		glfwSwapInterval(0);
		glfwShowWindow(window);
	}

	// Create some cubes
	Cube2 c0 = new Cube2();
	Cube2 c1 = new Cube2(1.0f,0f,0.005f,0.0001f,0.003f,0.001f,0f,0f,0f,0.0001f,0.0001f,0.005f);
	Cube2 c2 = new Cube2(0f,0f,1.0f,0.002f,0.0008f,0.001f,0f,0f,0f,0.0001f,0.0001f,0.01f);
	Cube2 c3 = new Cube2(RND(3),RND(3),RND(3),RND(0.01f),RND(0.01f),RND(0.01f),0f,0f,0f,RND(0.01f),RND(0.01f),RND(0.01f));
	Cube2 c4 = new Cube2(RND(3),RND(3),RND(3),RND(0.01f),RND(0.01f),RND(0.01f),0f,0f,0f,RND(0.01f),RND(0.01f),RND(0.01f));
	Cube2 c5 = new Cube2(RND(3),RND(3),RND(3),RND(0.01f),RND(0.01f),RND(0.01f),0f,0f,0f,RND(0.01f),RND(0.01f),RND(0.01f));

	private float RND(float max) {
		return max*(float)Math.random();
	}
	
	void loop() {
		
		GL.createCapabilities();

		// Set the clear color
		glClearColor(0.6f, 0.7f, 0.8f, 1.0f);
		// Enable depth testing
		glEnable(GL_DEPTH_TEST);
		glEnable(GL_CULL_FACE);

		// Remember the current time.
		long firstTime = System.nanoTime();

		while (!glfwWindowShouldClose(window)) {
			// Build time difference between this and first time.
			long thisTime = System.nanoTime();
			float diff = (thisTime - firstTime) / 1E9f;
			
			// Make the viewport always fill the whole window.
			glViewport(0, 0, width, height);

			// Build the projection matrix. Watch out here for integer division
			// when computing the aspect ratio!
			projMatrix.setPerspective((float) Math.toRadians(40), (float) width / height, 0.01f, 100.0f);
			glMatrixMode(GL_PROJECTION);
			glLoadMatrixf(projMatrix.get(fb));

			// Set lookat view matrix
			viewMatrix.setLookAt(0.0f+diff, 4.0f+diff, 10.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f);
			glMatrixMode(GL_MODELVIEW);
			glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);

			// draw cube
			c0.draw3D(viewMatrix, fb);
			c1.draw3D(viewMatrix, fb);
			c2.draw3D(viewMatrix, fb);
			c3.draw3D(viewMatrix, fb);
			c4.draw3D(viewMatrix, fb);
			c5.draw3D(viewMatrix, fb);

			glfwSwapBuffers(window);
			glfwPollEvents();
			
			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {
		new LwjglDemo2().run();
	}
}