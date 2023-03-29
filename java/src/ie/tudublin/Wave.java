package ie.tudublin;

import processing.core.PApplet;

public class Wave extends PApplet
{
    public void settings()
    {
        fullScreen(SPAN);

    }

    public void setup()
    {
        colorMode(RGB);

    }

    float xOffset = 0;
    float xIncrement = 0.1f;
    String textToFollow = "Text to Follow";

    public void draw()
    {
        background(0);
        stroke(255);
        strokeWeight(2);
        noFill();

        beginShape();
        for(float x = 0; x < width; x += 10)
        {
            float y = height / 2 + sin(radians(x + xOffset)) * height / 45;
            vertex(x, y);

        }
        endShape();

        textSize(20);
        textAlign(LEFT, CENTER);
        float totalTextWidth = textWidth(textToFollow);
        float startingX = (width - totalTextWidth) / 2;
        for(int i = 0; i < textToFollow.length(); i++)
        {
            char c = textToFollow.charAt(i);
            float x = startingX + i * 15;
            float y = height / 2 + sin(radians(x + xOffset)) * height / 45;

            pushMatrix();
            translate(x, y);
            text(c, 0, 0);
            popMatrix();

        }

        xOffset += xIncrement;
    }
}
