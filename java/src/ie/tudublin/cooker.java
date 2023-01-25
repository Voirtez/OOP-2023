package ie.tudublin;

import java.util.Scanner;

import javax.lang.model.util.ElementScanner14;

public class cooker
{
    public static void main(String[] args)
    {
        int eggsAmount;
        int eggsMin = 1;
        int milkAmount;
        int milkMin = 200; // milliliter
        int flourAmount;
        int flourMin = 100; // grams

        System.out.println("Hello Norbert!");
        System.out.println("Blinmaker is starting up..");
        System.out.println("How many eggs you have?");

        Scanner userInput;

        userInput = new Scanner(System.in);
        eggsAmount = userInput.nextInt();
        //System.out.println("You have " + eggsAmount + " eggs");

        System.out.println("How much milk you have?");
        userInput = new Scanner(System.in);
        milkAmount = userInput.nextInt();
        //System.out.println("You have " + milkAmount + "ml milk");

        System.out.println("How much flour you have?");
        userInput = new Scanner(System.in);
        flourAmount = userInput.nextInt();
        //System.out.println("You have " + flourAmount + "g flour");

        // main code here

        if(eggsAmount < eggsMin || milkAmount < milkMin || flourAmount < flourMin)
        {
            System.out.println("No blin today :(");

        }
        else
        {
            // calculations

            flourAmount = flourAmount / flourMin;
            //System.out.println("You have " + flourAmount + " protions of flour");

            milkAmount = milkAmount / milkMin;
            //System.out.println("You have " + milkAmount + " protions of milk");

            // find smalles number of all 3
            int smallest;

            if(eggsAmount <= milkAmount && milkAmount <= flourAmount)
            {
                smallest = eggsAmount;

            } // end else
            else if(milkAmount <= flourAmount && milkAmount <= eggsAmount)
            {
                smallest = milkAmount;

            } // end else if
            else
            {
                smallest = flourAmount;

            } // end else

            System.out.println(" "); // every protion makes 4 blins
            System.out.println("You can make " + smallest*4 + " portions of blins");
            System.out.println(" ");
            System.out.println("You will need " + smallest*eggsMin + " eggs");
            System.out.println("You will need " + smallest*flourMin + "g flour");
            System.out.println("You will need " + smallest*milkMin + "ml milk");

            System.out.println(" ");
            System.out.println("Blinmaker shutting down..");


        }

    }
}