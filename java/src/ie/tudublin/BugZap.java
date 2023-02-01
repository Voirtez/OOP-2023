package ie.tudublin;

import processing.core.PApplet;

public class BugZap extends PApplet
{

	public void settings()
	{
		size(1000, 1000);

	}

	float playerX = 450;
	float playerY = 900;
	float playerWidth = 100;


	public void playerDraw(float x, float y, float w)
	{
		float h = w / 4;
		strokeWeight(h);
		stroke(255);
		line(x, y, x+w, y);

	}

	public void bugDraw(float x1, float y1, float x2, float y2, float x3, float y3)
	{
		strokeWeight(1);
		triangle(x1, y2, x2, y2, x3, y3);

	}

	public void setup()
	{

		
	}

	public void keyPressed()
	{
		if (keyCode == LEFT)
		{
			System.out.println("Left arrow pressed");
			playerX = playerX - 20;

			if(playerX < 0)
			{
				playerX = 0;

			}
		}
		if (keyCode == RIGHT)
		{
			System.out.println("Right arrow pressed");
			playerX = playerX + 20;

			if(playerX > 900)
			{
				playerX = 900;

			}
		}
		if (key == ' ')
		{
			System.out.println("SPACE key pressed");
			strokeWeight(1);
			stroke(255);
			line(playerX+50, playerY, playerX+50, 0);
		}
	}


	public void draw()
	{			
		float tX = random(100, 900);
		float tY = random(100, 900);

		background(0);
		
		playerDraw(playerX, playerY, playerWidth);

		if ((frameCount % 10) == 0)
		{	
			bugDraw(tX-50, tY-50, tX+50, tY-50, tX, tY);
		}

	}	
}
