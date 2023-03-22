package ie.tudublin;

import processing.core.PApplet;

import ddf.minim.*;
import java.util.concurrent.TimeUnit;

public class Lyrics1 extends PApplet
{
    Minim minim;
    AudioPlayer player;
    String[] lines;
    long startTime;

    public void settings()
    {
        fullScreen(SPAN);
    }

    public void setup()
    {
        textSize(20);

        String[] linesTemp = loadStrings("MobyDuck.txt");
        lines = new String[linesTemp.length];
        System.arraycopy(linesTemp, 0, lines, 0, linesTemp.length);

        minim = new Minim(this);
        player = minim.loadFile("MobyDuck.wav");
        player.play();

        String[] parts = split(lines[0], "(");
        startTime = TimeUnit.SECONDS.toMillis(Integer.parseInt(parts[1].split(":")[0]) * 60 + Integer.parseInt(parts[1].split(":")[1]));
    }

    public void draw()
    {
        background(0);

        long elapsedTime = player.position();

        int lineIndex = 0;
        
        while(lineIndex < lines.length - 1 && getTimeStamp(lines[lineIndex + 1]) <= elapsedTime)
        {
            lineIndex ++;
        }

        textAlign(CENTER, CENTER);
        text(lines[lineIndex].split(")")[1], width / 2, height / 2);
    }

    long getTimeStamp(String line)
    {
        String[] parts = split(lines[0], "(");
        if (parts.length >= 2) 
        {
            String[] timeParts = parts[1].split(":");
            if (timeParts.length >= 2)
            {
                startTime = TimeUnit.SECONDS.toMillis(Integer.parseInt(timeParts[0]) * 60 + Integer.parseInt(timeParts[1]));
            }
            else 
            {
                // handle the case where the timestamp doesn't have minutes and seconds
                startTime = 0;
            }
        }
        else
        {
            // handle the case where the first line doesn't contain a timestamp
            startTime = 0;
        }
        
        return startTime;
    }

    public void stop()
    {
        player.close();
        minim.stop();
        super.stop();
    }
}
