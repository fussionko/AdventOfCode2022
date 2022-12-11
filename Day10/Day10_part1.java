import java.util.*;

public class Day10_part1
{
    public static boolean CheckCycle(int cycle)
    {
        for (int i = 20; i <= 220; i += 40)
            if (cycle == i)
                return true;
        return false;
    }

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        int trackCycle = 0, x = 1, sum = 0;

        while (sc.hasNextLine())
        {
            String cycle = sc.nextLine();

            ++trackCycle;
            if (CheckCycle(trackCycle))
                sum += trackCycle * x;
                
            if (cycle.equals("noop")) 
                continue;
                
            ++trackCycle;    
            if (CheckCycle(trackCycle))
                sum += trackCycle * x;
            x += Integer.parseInt(cycle.split(" ")[1]);              
        }
        System.out.println(sum);
    }
}