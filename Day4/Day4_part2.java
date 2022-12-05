import java.util.*;

public class Day4_part2
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        int contain = 0;
        while (sc.hasNextLine())
        {
            String[] pairs = sc.nextLine().split("[-,]");
            
            if (Integer.parseInt(pairs[1]) < Integer.parseInt(pairs[2]) || 
                Integer.parseInt(pairs[0]) > Integer.parseInt(pairs[3])) continue;
            ++contain;
        }

        System.out.println(contain);
    }
}