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

    YASC yasc;

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
            if(p.keyCode == PApplet.LEFT)
            {
                rot -= 0.1f;
            }

            if(p.keyCode == PApplet.RIGHT)
            {
                rot += 0.1f;
            }

            if(p.keyCode == PApplet.UP)
            {
                pos.x += forward.x * 2;
                pos.y += forward.y * 2;
            }

            if(p.keyCode == PApplet.DOWN)
            {
                pos.x -= forward.x * 2;
                pos.y -= forward.y * 2;
            }

            if(yasc.keys[' '])
            {
                PVector inFront = PVector.add(pos, PVector.mult(forward, 30));
                Bullet b = new Bullet(inFront.x, inFront.y, rot, c, p);
                
                ((YASC)p).bullets.add(b);
            }
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