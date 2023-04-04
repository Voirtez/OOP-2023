package ie.tudublin;

import ddf.minim.*;
import processing.core.PApplet;

public class Lyrics extends PApplet
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

    public void draw()
    {
        background(0);
        fill(255);

        if(ap.isPlaying())
        {
            float currentTime = ap.position();

            while(currentLine < timestamps.length - 1 && currentTime >= timestamps[currentLine + 1])
            {
                currentLine++;
            }

            textAlign(CENTER);
            textSize(32);
            text(lyrics[currentLine].replaceAll("\\(.*?\\) ?", ""), width / 2, height / 2);


        }
        else
        {
            isPlaying = false;
        }
    }
}
