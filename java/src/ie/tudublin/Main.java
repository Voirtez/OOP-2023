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

	public static void lyricswave2()
	{
		String[] a = {"MAIN"};
		processing.core.PApplet.runSketch( a, new LyricsWave2());
	}

	public static void lyricswave3()
	{
		String[] a = {"MAIN"};
		processing.core.PApplet.runSketch( a, new LyricsWave3());
	}

	public static void lyricswave4()
	{
		String[] a = {"MAIN"};
		processing.core.PApplet.runSketch( a, new LyricsWave4());
	}

	public static void main(String[] args)
	{

		lyricswave4();	
	}
	
}