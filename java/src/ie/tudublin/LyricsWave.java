package ie.tudublin;

import ddf.minim.*;
import processing.core.PApplet;

public class LyricsWave extends PApplet
{
    String songFileName = "MobyDuck.wav";
    String lyricsFileName = "MobyDuck.txt";

    Minim m;
    AudioPlayer ap;
    String[] lyrics;
    float[] timestamps;

    int currentLine = 0;
    boolean isPlaying = false;

    public void settings()
    {
        fullScreen(SPAN);
    }

    public void setup()
    {
        m = new Minim(this);
        ap = m.loadFile(songFileName, 1024);
        ap.play();

        lyrics = loadStrings(lyricsFileName);
        timestamps = new float[lyrics.length];

        for(int i = 0; i < lyrics.length; i++)
        {
            timestamps[i] = parseTimeStamp(lyrics[i]);
        }

        isPlaying = true;

    }

    private float parseTimeStamp(String line)
    {
        String timestampStr = line.substring(line.indexOf("(") + 1, line.indexOf(")"));
        String[] timestampParts = timestampStr.split(":");

        float minutes = Float.parseFloat(timestampParts[0]);
        float seconds = Float.parseFloat(timestampParts[1]);

        return minutes * 60 + seconds;
    }

    float xOffset = 0;
    float xIncrement = 0.1f;

    public void draw()
    {
        background(0);
        strokeWeight(2);
        noFill();

        beginShape();
        for(float x = 0; x < width; x += 10)
        {
            float y = height / 2 + sin(radians(x + xOffset)) * height / 45;
            vertex(x, y);

        }
        endShape();

        if(ap.isPlaying())
        {
            float currentTime = ap.position() / 1000.0f;

            while(currentLine < timestamps.length - 1 && currentTime >= timestamps[currentLine + 1])
            {
                currentLine++;
            }

            String currentLyric = lyrics[currentLine].replaceAll("\\(.*?\\) ?", "");

            fill(255);
            textAlign(LEFT, CENTER);
            textSize(32);
            float totalTextWidth = textWidth(currentLyric);
            float xStart = (width - totalTextWidth) / 2;

            for(int i = 0; i < currentLyric.length(); i++)
            {
                char currentChar = currentLyric.charAt(i);
                float x = xStart + i * 15;
                float y = height / 2 + sin(radians(x + xOffset)) * height / 45;
    
                pushMatrix();
                translate(x, y);
                text(currentChar, 0, 0);
                popMatrix();
    
            }


        }
        else
        {
            isPlaying = false;
        }

        xOffset += xIncrement;
    }
}
