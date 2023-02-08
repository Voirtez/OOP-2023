package ie.tudublin;

public class Main
{

	public static void helloProcessing()
	{
		String[] a = {"MAIN"};
        processing.core.PApplet.runSketch( a, new HelloProcessing());
    }

	public static void bugZap()
	{
		String[] a = {"MAIN"};
        processing.core.PApplet.runSketch( a, new BugZap());
    }

	public static void Loops()
	{
		String[] a = {"MAIN"};
        processing.core.PApplet.runSketch( a, new Loops());
    }

	public static void ifExercise()
	{
		String[] a = {"MAIN"};
        processing.core.PApplet.runSketch( a, new ifExercise());
    }

	public static void loopExercise()
	{
		String[] a = {"MAIN"};
        processing.core.PApplet.runSketch( a, new loopExercise());
    }
	
	public static void main(String[] args)
	{
		loopExercise();
	}
	
}