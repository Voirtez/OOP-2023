package ie.tudublin;

public class Cat
{
    String name;

    public int numLives = 9;

    public void setName(String name)
    {
        this.name = name;

    }
    public Cat()
    {

    }

    public Cat(String name)
    {

    }

    public void speak()
    {
        System.out.println("Meow");
    }

    public void kill()
    {
        this.numLives = this.numLives - 1;

        if(this.numLives > 0)
        {
            System.out.println("Ouch");

        }
        else
        {
            System.out.println("Dead");

        }
    }

    
}