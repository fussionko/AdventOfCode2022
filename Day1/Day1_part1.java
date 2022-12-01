import java.util.Scanner;

public class Day1_part1
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        int maxCalories = 0;
        String calories = null;

        while (sc.hasNextLine())
        {
            int currentCalories = 0;
            while (sc.hasNextLine() && !(calories = sc.nextLine()).isEmpty()) currentCalories += Integer.parseInt(calories);
            if (currentCalories > maxCalories) maxCalories = currentCalories;
        }

        System.out.println(maxCalories);
    }
}