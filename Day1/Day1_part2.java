import java.util.Scanner;

public class Day1_part2
{
    static void Swap(int[] array, int swap0, int swap1)
    {
        int temp = array[swap0];
        array[swap0] = array[swap1];
        array[swap1] = temp;
    }

    static void SortArray(int[] array)
    {
        if (array[0] > array[1]) Swap(array, 0, 1);
        if (array[1] > array[2]) Swap(array, 1, 2);
        if (array[0] > array[1]) Swap(array, 0, 1);
    }

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        int[] maxCaloriesArray = new int[3];
        String calories = null;

        while (sc.hasNextLine())
        {
            int currentCalories = 0;
            while (sc.hasNextLine() && !(calories = sc.nextLine()).isEmpty()) currentCalories += Integer.parseInt(calories);
            if (currentCalories > maxCaloriesArray[0])
            {
                maxCaloriesArray[0] = currentCalories;
                SortArray(maxCaloriesArray);
            }
        }

        System.out.println((maxCaloriesArray[0] + maxCaloriesArray[1] + maxCaloriesArray[2]));
    }
}