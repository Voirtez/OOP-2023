package ie.tudublin;

import processing.data.Table;
import processing.data.TableRow;

import java.util.ArrayList;

import processing.core.PApplet;

public class StarMap extends PApplet
{
	public void settings()
	{
		size(800, 800);
	}
	

	public void setup()
	{
		colorMode(HSB);
		background(0);
		
		smooth();
		loadStars();
		printStars();

	}


	public void drawGrid()
	{
		stroke(200, 255, 255);
		float border = 50.0f;

		int count = 10;
		float gap = (width - (border * 2.0f)) / (float) count;
		for(int i = -5 ; i <= 5 ; i ++)
		{
			float x = border + (gap * (i + 5));
			line(x, border, x, height - border);
			line(border, x, width - border, x);

			fill(200, 255, 255);
			textSize(11);
			text(i, x, border-20);
			text(i, border-30, x);

		}
	}

	public void printStars()
	{
		for(Star s:stars)
		{
			System.out.println(s);

		}
	}

	
	public void drawStars()
	{
		for(Star s:stars)
		{
			float x = map(s.getxG(), -5, 5, 50, width-50);
			float y = map(s.getyG(), -5, 5, 50, height-50);
			
			stroke(255, 255, 255);
			noFill();
			circle(x, y, s.getAbsMag());

			stroke(50, 255, 255);
			line(x-5, y, x+5, y);
			line(x, y-5, x, y+5);

		}
	}
	

	ArrayList<Star> stars = new ArrayList<Star>();
	
	void loadStars()
 	{
 		Table table = loadTable("HabHYG15ly.csv", "header");
 		for(TableRow r:table.rows())
 		{
 			Star s = new Star(r);
			stars.add(s);

 		}
 	}




		
	public void draw()
	{	
		strokeWeight(1);		

		drawGrid();
		drawStars();
	}
}
