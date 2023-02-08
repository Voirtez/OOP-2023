package ie.tudublin;

import processing.core.PApplet;

public class ifExercise extends PApplet
{
    public void settings()
	{
		size(500, 500);
	}

	public void setup()
    {

	}

	public void draw()
	{	
        background(0);

        // rectangle that changes colour when the mouse is on it
        rect(200, 200, 100, 50);
        if(mouseX > 200 && mouseX < 300 && mouseY > 200 && mouseY < 250)
        {
            fill(255, 0, 0);
            
        }
        else
        {
            fill(0, 255, 255);

        }

        
        /* 
        stroke(255);
        line(250, 0, 250, 500);
        noStroke();
         
        if(mouseX > 250) 
        {
            fill(255, 0, 0);
            rect(mouseX-50, mouseY-25, 100, 50);
        }
        else
        {
            fill(0, 255, 255);
            rect(mouseX-50, mouseY-25, 100, 50);
        }
        */
	}
}