package ie.tudublin;

public class Main
{
	
	public static void lyrics()
	{
		String[] a = {"MAIN"};
        processing.core.PApplet.runSketch( a, new Lyrics());
    }

	public static void wave()
	{
		String[] a = {"MAIN"};
		processing.core.PApplet.runSketch( a, new Wave());
	}

	public static void lyricswave()
	{
		String[] a = {"MAIN"};
		processing.core.PApplet.runSketch( a, new LyricsWave());
	}

	public static void main(String[] args)
	{

		lyricswave();	
	}
	
}