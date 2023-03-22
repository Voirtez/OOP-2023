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
        float shankLength = size * 1.5f;
        float shankWidth = size / 4;
        float flukeLength = size * 0.8f;
        float flukeWidth = size / 2;
        float flukeAngle = PI / 4;
        float palmLength = size * 0.4f;
        float palmWidth = size / 4;
      
        // Draw the shank
        p.line(x, y, x, y + shankLength);
        p.line(x - shankWidth/2, y + shankLength, x + shankWidth/2, y + shankLength);
      
        // Draw the flukes
        p.pushMatrix();
        p.translate(x, y + shankLength);
        p.rotate(-flukeAngle);
        p.line(0, 0, flukeLength, 0);
        p.line(flukeLength, 0, flukeLength - flukeWidth * PApplet.sin(flukeAngle), flukeWidth * PApplet.cos(flukeAngle));
        p.popMatrix();
        
        p.pushMatrix();
        p.translate(x, y + shankLength);
        p.rotate(flukeAngle);
        p.line(0, 0, flukeLength, 0);
        p.line(flukeLength, 0, flukeLength - flukeWidth * PApplet.sin(flukeAngle), -flukeWidth * PApplet.cos(flukeAngle));
        p.popMatrix();
        
        // Draw the palms
        p.line(x - palmWidth/2, y + shankLength + palmLength, x + palmWidth/2, y + shankLength + palmLength);
        p.line(x, y + shankLength + palmLength, x, y + shankLength + palmLength + palmWidth);
    }
}
