package ie.tudublin;

public class Main
{
	
	public static void lyrics()
	{
		String[] a = {"MAIN"};
        processing.core.PApplet.runSketch( a, new Lyrics());
    }

	public static void lyrics1()
	{
		String[] a = {"MAIN"};
        processing.core.PApplet.runSketch( a, new Lyrics1());
    }
	
	public static void main(String[] args)
	{

		lyrics1();	
	}
	
}