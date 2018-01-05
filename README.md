# Java Engine

This Engine is made with Java without any external libraries. It is very barebones
and I will be using it for smaller project of mine. For example, I use this engine
for this Genetic Algorithm project https://github.com/CorkScrewer/Smart-Rockets-G.A.

### What I have in the Engine right now

- Vector2f
- Application class that you can extend for your main window class.
	- This includes a update and render method that will run automatically when you create the Application class or its subclass.
	- The render method has as a parameter a Graphics object that is created behind the scenes.
	- It also includes an FPS counter and limiter. (You can change the FPS cap). The FPS counter automatically displays itself on the title
	of the window.
- Entity System.
- Images (EImage.java)
- Sprites (Sprite.java)
	
### Sample Project Example.

``` java
import java.awt.Color;
import java.awt.Graphics;

import com.engine.main.Application;
import com.engine.main.Vector;
import com.engine.render.EImage;
import com.engine.render.Sprite;

public class Sample extends Application {

	private static final long serialVersionUID = 1L; // Don't worry about this. The project will work without it.

	private EImage image;
	private Sprite sprite;
	private Vector pos;
	
	/**
	 * Creates the window and the application itself
	 * 
	 * @param width The width of the window
	 * @param height The height of the window
	 * @param title The title of the window
	 */
	public Sample(int width, int height, String title) {
		super(width, height, title);
		setMaxFPS(120); // Sets the fps cap to 120 (default is 60)
		
		pos = new Vector(0, 0); // Sets the default value of the Vector to (0, 0)
		image = new EImage("res/devilhead.png"); // Opens devilhead.png into an EImage (from my engine)
		
		sprite = new Sprite(image, pos); // Creates a sprite with the image and a Vector(2f)
		
		sprite.setWidth(sprite.getWidth() * 2); // Sets the width of the sprite to twice its size
		sprite.setHeight(sprite.getHeight() * 2); // Sets the height of the sprite to twice its size
	}

	/**
	 * Updates 120fps
	 */
	@Override
	public void update() {
		pos.add(new Vector(1f, 1f)); // Adds 1f to the position vector (not applied to sprite as yet)
		
		sprite.setPosition(pos); // Apply the position to the sprite's position.
	}

	@Override
	public void render(Graphics g) {
		/*
		 * Fills the entire screen to black
		 */
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, getWidth(), getHeight());

		/*
		 * Draws the sprite at its position vector
		 */
		sprite.render(g);
	}

	public static void main(String[] args) {
		// Creates and runs the game loop. (update and render)
		new Sample(900, 600, "Sample Project Using Engine");
	}
	
}

```