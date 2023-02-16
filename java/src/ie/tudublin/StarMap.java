package ie.tudublin;

import processing.data.Table;
import processing.data.TableRow;

import java.util.ArrayList;

import processing.core.PApplet;

public class StarMap extends PApplet
{
	public void settings()
	{
		size(1000, 1000);
	}
	
	public void setup()
	{
		colorMode(RGB);
		background(0);
		
		smooth();
		loadStars();
		printStars();

	}


	// method to draw grid lines
	public void drawGrid()
	{
		stroke(0, 255, 255);
		float border = 50.0f;

		for(int i = -5 ; i <= 5 ; i ++)
		{
			float x = map(i, -5, 5, border, width - border);
			line(x, border, x, height - border);
			line(border, x, width - border, x);

			fill(0, 255, 255);
			textSize(11);
			textAlign(CENTER, CENTER);
			text(i, x, border-20);
			text(i, border-30, x);

		}
	}

	// method to draw stars
	public void drawStars()
	{
		for(Star s:stars)
		{
			float x = map(s.getxG(), -5, 5, 50, width-50);
			float y = map(s.getyG(), -5, 5, 50, height-50);
			
			stroke(255, 0, 0);
			noFill();
			circle(x, y, s.getAbsMag());

			stroke(255, 255, 0);
			line(x-5, y, x+5, y);
			line(x, y-5, x, y+5);

			fill(255);
			textAlign(LEFT, CENTER);
			text(s.getDisplayName(), x + 5, y + 5);

		}
	}

	// ArrayList to store star information
	ArrayList<Star> stars = new ArrayList<Star>();
	
	// method to load star information from the csv file
	void loadStars()
 	{
 		Table table = loadTable("HabHYG15ly.csv", "header");
 		for(TableRow r:table.rows())
 		{
 			Star s = new Star(r);
			stars.add(s);

 		}
 	}

	// method to display star information in the console
	public void printStars()
	{
		for(Star s:stars)
		{
			System.out.println(s);
 
		}
	}

	// method to draw a line between two clicked stars
	public void drawLine()
	{
		if(mousePressed)
		{
			stroke(255, 255, 0);
			line(mouseX, mouseY, pmouseX, pmouseY);
		}
	}

	public void draw()
	{	
		strokeWeight(1);		

		drawGrid();
		drawStars();
		drawLine();
	}
}
