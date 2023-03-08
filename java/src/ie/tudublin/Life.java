package ie.tudublin;

import processing.core.PApplet;

public class Life extends PApplet
{

	LifeBoard board;

	public void settings()
	{

		//size(500, 500);
		fullScreen();

	}

	public void setup()
	{
		frameRate(165);
		colorMode(RGB);
		background(0);
		board = new LifeBoard(1000, this);
		board.randomise();

	}

	public void draw()
	{	
		background(0);
		board.render();
		board.applyRules();
		
	}
}
