package ie.tudublin;

import ddf.minim.*;
import processing.core.PApplet;

public class LyricsWave2 extends PApplet
{
    String songFileName = "MobyDuck.wav";
    String lyricsFileName = "MobyDuck.txt";

    Minim m;
    AudioPlayer ap;
    String[] lyrics;
    int[] timestamps;

    int currentLine = 0;
    boolean isPlaying = false;

    public void settings()
    {
        fullScreen();
    }

    public void setup()
    {
        m = new Minim(this);
        ap = m.loadFile(songFileName, 1024);
        ap.play();

        lyrics = loadStrings(lyricsFileName);
        timestamps = new int[lyrics.length];

        for(int i = 0; i < lyrics.length; i++)
        {
            timestamps[i] = parseTimeStamp(lyrics[i]);
        }

        isPlaying = true;

    }

    private int parseTimeStamp(String line)
    {
        int timestamp = Integer.parseInt(line.substring(line.indexOf("(") + 1, line.indexOf(")")));
        return timestamp;
    }

    float xOffset = 0;
    float xIncrement = 0.1f;
    float scrollSpeed = 0.1f;
    float charSpacing = 15;

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
            float currentTime = ap.position();
    
            while(currentLine < timestamps.length - 1 && currentTime >= timestamps[currentLine + 1])
            {
                currentLine++;
            }
    
            String currentLyric = lyrics[currentLine].replaceAll("\\(.*?\\) ?", "");
            int currentLyricLength = currentLyric.length();
    
            fill(255);
            textAlign(LEFT, CENTER);
            textSize(32);
            float totalTextWidth = textWidth(currentLyric);
            float xStart = width - scrollSpeed * (currentTime - timestamps[currentLine]) - totalTextWidth;
    
            for(int i = 0; i < currentLyricLength; i++)
            {
                char currentChar = currentLyric.charAt(i);
                float x = xStart + i * charSpacing;
                float y = height / 2 + sin(radians(x + xOffset)) * height / 45;
        
                pushMatrix();
                translate(x, y);
                text(currentChar, 0, 0);
                popMatrix();
            }
    
            if (currentTime >= timestamps[currentLine] + (totalTextWidth + scrollSpeed * currentLyricLength) / scrollSpeed) {
              currentLine++;
            }
        }
    
        else
        {
            isPlaying = false;
        }
    
        xOffset += xIncrement;
    }
}