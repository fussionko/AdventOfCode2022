import java.util.*;

public class Day3_part2
{
    public static int GetPriority(char item)
    {
        if (item <= 'z' && item >= 'a') return item - 'a' + 1;
        return item - 'A' + 27;
    }

    public static int ProcessRucksack(String[] rucksacks)
    {
        Set<Character> matchingItems = new HashSet<Character>();

        for (int i = 0; i < rucksacks[0].length(); ++i)
            if (rucksacks[1].indexOf(rucksacks[0].charAt(i)) != -1 && rucksacks[2].indexOf(rucksacks[0].charAt(i)) != -1)
                matchingItems.add(rucksacks[0].charAt(i));
    
        int sum = 0;
        for (char item : matchingItems)
            sum += GetPriority(item);
        return sum;
    }

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        int prioritySum = 0, i = 0;
        String[] rucksacks = new String[3];

        while (sc.hasNextLine())
        {
            rucksacks[i++] = sc.nextLine();
            if (i == 3)
            {
                prioritySum += ProcessRucksack(rucksacks);
                i = 0;
            }
        }
            
       
        System.out.println(prioritySum);
    }
}