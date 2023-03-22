package ie.tudublin;

import processing.core.PApplet;
import processing.core.PVector;

public class Ship
{
    private PVector pos;
    private PVector forward;
    private float rot;
    private int c;
    private float size;
    private PApplet p;
    private float halfSize;

    public Ship(float x, float y, float size, int c, PApplet p)
    {
        pos = new PVector(x, y);
        forward = new PVector(0, -1);
        this.size = size;
        this.c = c;
        this.p = p;
        halfSize = size / 2;
    }

    public void move()
    {
        forward.x = PApplet.sin(rot);
        forward.y = -PApplet.cos(rot);

        if(p.keyPressed)
        {
            if(p.key == 'a')
            {
                rot -= 0.1f;
            }

            if(p.key == 'd')
            {
                rot += 0.1f;
            }

            if(p.key == 'w')
            {
                pos.x += forward.x * 2;
                pos.y += forward.y * 2;
            }

            if(p.key == 's')
            {
                pos.x -= forward.x * 2;
                pos.y -= forward.y * 2;
            }
        }
    }


    public int count = 25;
    
    // Shoots a beam from the ship's nose
    public void shoot()
    {
        if(p.keyPressed)
        {
            if(p.key == ' ')
            {
                count += 2;
                
            }

        }

        if(p.key != ' ' || ! p.keyPressed)
        {
            if(count > 25)
            {
                count -= 2;

            }
        }

        if(count > 25)
        {
            p.stroke(255, 255, 255);
            p.line(pos.x + (forward.x * 25), pos.y + (forward.y * 25), pos.x + (forward.x * count) , pos.y + (forward.y * count));

        }
        

    }

    public void render()
    {
        p.pushMatrix();
        p.translate(pos.x, pos.y);
        p.rotate(rot);
        p.stroke(c, 255, 255);
        p.line(-halfSize, halfSize, 0, -halfSize);
        p.line(0, -halfSize, halfSize, halfSize);
        p.line(halfSize, halfSize, 0, 0);
        p.line(0, 0, -halfSize, halfSize);
        p.popMatrix();
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