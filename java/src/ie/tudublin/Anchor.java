package ie.tudublin;

import processing.core.PApplet;

public class Anchor extends PApplet
{
    private float x;
    private float y;
    private float size;
    
    public Anchor(float x, float y, float size)
    {
        this.x = x;
        this.y = y;
        this.size = size;
    }
    

    public void render(PApplet p)
    {
        p.stroke(0);
        p.strokeWeight(2);
        line(x, y, x, y + size);


    }
}
