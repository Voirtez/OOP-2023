package ie.tudublin;

public class Main 
{
    public static void main(String[] args)
    {
        System.out.println("Hello World");

        Cat ginger = new Cat("Ginger");
        
        while(ginger.numLives > 0)
        {
            ginger.kill();
        }
    }
}