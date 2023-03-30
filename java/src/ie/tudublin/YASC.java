package ie.tudublin;

import java.util.ArrayList;

import processing.core.PApplet;
import processing.core.PVector;

public class YASC extends PApplet
{

	Ship ship;
	Ship ship1;

	public boolean[] keys = new boolean[1024];

	public void keyPressed()
	{
		keys[keyCode] = true;
	}

	public void keyReleased()
	{
		keys[keyCode] = false;
	}

	// Generic
	ArrayList<Bullet> bullets = new ArrayList<Bullet>();

	public void settings()
	{
		size(500, 500);
	}

	public void setup()
	{
		colorMode(HSB);
		ship = new Ship(width / 2, height / 2, 50, 70, this);
		ship1 = new Ship(100, 50, 80, 6, this);
		
	}
	
	
	public void draw()
	{	
		background(0);
		ship.render();
		ship.move();

		//ship1.render();
		//ship1.move();

		for(int i = bullets.size() - 1; i >= 0; i--)
		{
			Bullet b = bullets.get(i);
			b.render();
			b.move();
		}

		fill(255);
		text("Bullets : " + bullets.size(), 50, 50);

	}
}
