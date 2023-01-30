package ie.tudublin;

import processing.core.PApplet;

public class HelloProcessing extends PApplet
{

	public void settings()
	{
		size(500, 500);
	}

	public void setup()
	{
		colorMode(HSB);
		background(0);
		
	}

	int x = 0;

	public void draw()
	{	
		//background(0);
		fill(random(255), 255, 255);
		circle(x, height / 2, random(0, width));
		x++;
	}
}
