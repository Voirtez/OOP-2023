package ie.tudublin;

import processing.core.PApplet;

public class Life extends PApplet
{

	LifeBoard board;

	public void settings()
	{

		size(500, 500);

	}

	public void setup()
	{
		frameRate(5);
		colorMode(RGB);
		background(0);
		board = new LifeBoard(50, this);
		board.randomise();

	}

	public void draw()
	{	
		background(0);
		board.render();
		board.applyRules();
		
	}
}
