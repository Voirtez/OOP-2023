package ie.tudublin;

import processing.core.PApplet;

public class drawAnchor extends PApplet
{
    public void settings()
    {
        size(500, 500);
    }

    public void setup()
    {
        colorMode(HSB);
    }

    public void draw()
    {
        float x = width / 2;
        float y = height / 2;
        float size = 100;

        background(0);
        noFill();
        stroke(255, 255, 255);
        strokeWeight(2);
        line(x, y, x, y + size);
        line(x - size / 4, y + size / 3, x + size / 4, y + size / 3);

        circle(x, y - size / 8, size / 4);

        arc(x, y + size / 2, size, size, 0, PI);

        line(x - size / 2, y + size / 2, x - size / 4, y + 75);
        line(x - size / 2, y + size / 2, x - 75, y + 75);

        line(x + size / 2, y + size / 2, x + size / 4, y + 75);
        line(x + size / 2, y + size / 2, x + 75, y + 75);



    }
}
