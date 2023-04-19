package ie.tudublin;

import java.util.ArrayList;

import ddf.minim.*;
import processing.core.PApplet;

public class LyricsWave4 extends PApplet
{
    String songFileName = "MobyDuck.wav";
    String lyricsFileName = "MobyDuck.txt";

    Minim m;
    AudioPlayer ap;
    String[] lyrics;

    ArrayList<LyricLine> lyricLines = new ArrayList<LyricLine>();
    ArrayList<Character> characters = new ArrayList<Character>();

    public void settings()
    {
        fullScreen();
    }

    public void setup()
    {
        colorMode(HSB);
        m = new Minim(this);
        ap = m.loadFile(songFileName, 1024);
        ap.play();

        lyrics = loadStrings(lyricsFileName);

    }

    public int parseTimeStamp(String line)
    {
        int timestamp = Integer.parseInt(line.substring(line.indexOf("(") + 1, line.indexOf(")")));
        return timestamp;

    }

    public void draw()
    {
        background(0);

        //stroke(255);
        noStroke();
        line(0, height / 2, width, height / 2);

        // parse lyrics from file
        // separate timestamp and lyrics
        // create a new LyricLine object
        // add it to the lyricLine ArrayList
        // split the lyrics into characters
        // create a new Character object
        // add it to the characters ArrayList
        // draw the characters starting on the right and scrolling left
        // remove the characters from the array when they reach the left of the screen
    }

}
