package ie.tudublin;

import java.util.ArrayList;

import ddf.minim.AudioPlayer;
import ddf.minim.Minim;
import processing.core.PApplet;

public class Lyrics extends PApplet
{
    Minim m;
    AudioPlayer ap;
    ArrayList<String> lyrics;

    int currentLine = 0;
    int lineStartTime;

    public void settings()
    {
        fullScreen(SPAN);

    }

    public void setup()
    {
        m = new Minim(this);
        ap = m.loadFile("MobyDuck.wav");
        lyrics = new ArrayList<String>();
        loadLyrics();

        ap.play();
        lineStartTime = millis();
        
    }

    private void loadLyrics()
    {
        String[] lines = loadStrings("MobyDuck.txt");
        for(String line:lines)
        {
            lyrics.add(line);
        }
    }

    public void draw()
    {
        background(0);
        fill(255);
        textSize(32);
        textAlign(CENTER, CENTER);

        int elpaspedTime = millis() - lineStartTime;
        if (elpaspedTime > 5000)
        {
            currentLine ++;
            lineStartTime = millis();
        }

        if(currentLine < lyrics.size())
        {
            String currentLyric = lyrics.get(currentLine);
            text(currentLyric, width / 2, height / 2);
        }
        else
        {
            ap.pause();
        }
    }

}
