package ie.tudublin;

import processing.core.PApplet;

public class loopExercise extends PApplet
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

	public void draw()
	{	
        noStroke();

        // 10 colour pallete
        /*
        for(int i = 0; i < 10; i++)
        {
            fill(i * 25, 255, 255);
            rect(i * 50, 0, 50, 500);
        }
        */

        
        // 10 diagonal squares in colour pallete
        /*
        for(int i = 0; i < 10; i++)
        {
            fill(i * 25, 255, 255);
            rect(i * 50, i * 50, 50, 50);
        }
         */

        // circle that changes size and colour as it radiates outwards
        /*
        for(int i = 10; i > 0; i--)
        {
            fill(i * 25, 255, 255);
            ellipse(250, 250, i * 50, i * 50);

        }
        */

        // line of cirlces that change colour
        /*
        for(int i = 0; i <= 10; i++)
        {
            fill(i * 25, 255, 255);
            ellipse(i * 50 + 25, 250, 50, 50);
        }
        */

        // grid of circles that change colour diagonally
        for(int i = 0; i < 10; i++)
        {
            for(int j = 0; j < 10; j++)
            {
                fill(i * 25, 255, 255);
                ellipse(i * 50 + 25, j * 50 + 25, 50, 50);

            }
        }

        // blue and dark blue checkerboard
        /*
        for(int i = 0; i < 10; i++)
        {
            for(int j = 0; j < 10; j++)
            {
                if((i + j) % 2 == 0)
                {
                    fill(0, 0, 150);
                }
                else
                {
                    fill(0, 0, 255);
                }
                rect(i * 50, j * 50, 50, 50);
            }
        }
        */
	}
}
