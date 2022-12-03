import java.util.*;

public class Day3_part1
{
    public static int GetPriority(char item)
    {
        if (item <= 'z' && item >= 'a') return item - 'a' + 1;
        return item - 'A' + 27;
    }

    public static int ProcessRucksack(String rucksack)
    {
        String leftCompartment = rucksack.substring(0, rucksack.length() / 2);
        String rightCompartment = rucksack.substring(rucksack.length() / 2, rucksack.length());
        
        Set<Character> matchingItems = new HashSet<Character>();

        for (int i = 0; i < leftCompartment.length(); ++i)
            for (int j = 0; j < rightCompartment.length(); ++j)
                if (leftCompartment.charAt(i) == rightCompartment.charAt(j))
                    matchingItems.add(leftCompartment.charAt(i));
    
        int sum = 0;
        for (char item : matchingItems)
            sum += GetPriority(item);
        return sum;
    }

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        int prioritySum = 0;

        while (sc.hasNextLine())
            prioritySum += ProcessRucksack(sc.nextLine());
       
        System.out.println(prioritySum);
    }
}