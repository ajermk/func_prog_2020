package imperativeSolution;

import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        int input = 0;
        boolean quitCheck = false;
        Scanner sc= new Scanner(System.in);

        System.out.println("Enter a positive integer to check whether it is perfect, abundant or deficient:");

        if( sc.hasNextInt() )
        {
            input = sc.nextInt();

            if (input < 0)
            {
                System.out.println("Not a positive int.");
                quitCheck = true;
            }
        }
        else
        {
            System.out.println("Input-output error.");
            quitCheck = true;
        }
        sc.close();

        if(quitCheck)
            return;

        System.out.println(input + " is " + PerfectNumber.process(input) + " number.");
        return;
    }

}
