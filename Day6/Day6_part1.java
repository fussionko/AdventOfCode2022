import java.util.*;

public class Day6_part1
{
    public static boolean CheckSequence(Queue<Character> sequence)
    {
        Set<Character> tmp = new HashSet<Character>(sequence);
        if (tmp.size() < 4) return false;
        return true;
    }

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        Queue<Character> sequence = new LinkedList<Character>();

        String scrambledData = sc.nextLine();

        int marker = 0;
        while (marker < 3)
            sequence.add(scrambledData.charAt(marker++));


        while (marker < scrambledData.length())
        {
            sequence.add(scrambledData.charAt(marker++));
            if (CheckSequence(sequence)) break;
            sequence.remove();
        }

        for (Character c : sequence)
            System.out.print(c);
        System.out.println();
        System.out.println(marker);
    }
}