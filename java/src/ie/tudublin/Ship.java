package ie.tudublin;

import processing.core.PApplet;
import processing.core.PVector;

public class Ship
{
    private PVector pos;
    private float rot;
    private int c;
    private float size;
    private PApplet p;
    private float halfSize;

    public Ship(float x, float y, float size, int c, PApplet p)
    {
        pos = new PVector(x, y);
        this.size = size;
        this.c = c;
        this.p = p;
        halfSize = size / 2;
    }

    public void move()
    {
        if (p.keyPressed)
        {
            if(p.keyCode == PApplet.LEFT)
            {
                pos.x--;
            }

            if(p.keyCode == PApplet.RIGHT)
            {
                pos.x++;
            }

            if(p.keyCode == PApplet.UP)
            {
                pos.y--;
            }

            if(p.keyCode == PApplet.DOWN)
            {
                pos.y++;
            }
        }
    }

    public void render()
    {
        p.stroke(c, 255, 255);
        p.line(pos.x - halfSize, pos.y + halfSize, pos.x, pos.y - halfSize);
        p.line(pos.x, pos.y - halfSize, pos.x + halfSize, pos.y + halfSize);
        p.line(pos.x + halfSize, pos.y + halfSize, pos.x, pos.y);
        p.line(pos.x, pos.y, pos.x - halfSize, pos.y + halfSize);


    }
    
    // Getters
    public PVector getPos()
    {
        return pos;
    }

    public float getRot() 
    {
        return rot;
    }

    public int getC()
    {
        return c;
    }

    public float getSize()
    {
        return size;
    }

    // Setters
    public void setPos(PVector pos)
    {
        this.pos = pos;
    }

    public void setRot(float rot)
    {
        this.rot = rot;
    }

    public void setC(int c)
    {
        this.c = c;
    }

    public void setSize(float size)
    {
        this.size = size;
    }


    

}