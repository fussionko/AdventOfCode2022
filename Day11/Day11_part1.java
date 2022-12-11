import java.util.*;

public class Day11_part1
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        List<Monkey> monkeys = new ArrayList<Monkey>();
        
        while (sc.hasNextLine())
        {
            sc.nextLine();
            Monkey monkey = new Monkey();

            String[] items = sc.nextLine().split(":")[1].replaceAll(" ", "").split(",");
            for (String item : items)
                monkey.startingItems.add(Long.parseLong(item));

            String function = sc.nextLine();
            if (function.contains("+"))
                monkey.operation = (x) -> x + Long.parseLong(function.split("\\+")[1].replaceAll(" ", ""));
            else if (function.contains("-"))
                monkey.operation = (x) -> x - Long.parseLong(function.split("\\-")[1].replaceAll(" ", ""));
            else if (function.contains("old * old"))
                monkey.operation = (x) -> x * x;
            else if (function.contains("*"))
                monkey.operation = (x) -> x * Long.parseLong(function.split("\\*")[1].replaceAll(" ", ""));
        
            int divisible = Integer.parseInt(sc.nextLine().split("by")[1].replaceAll(" ", ""));
            int first = Integer.parseInt(sc.nextLine().split("monkey")[1].replaceAll(" ", ""));
            int second = Integer.parseInt(sc.nextLine().split("monkey")[1].replaceAll(" ", ""));
            monkey.test = (x) -> x % divisible == 0 ? first : second;

            monkeys.add(monkey);
            if (sc.hasNextLine()) sc.nextLine();
        }

        long[] inspections = new long[monkeys.size()];
        for (int i = 0; i < 20; ++i)
            for (int j = 0; j < monkeys.size(); ++j)
                while (monkeys.get(j).startingItems.size() > 0)
                {
                    long item = monkeys.get(j).startingItems.remove();
                    
                    item = monkeys.get(j).operation.apply(item) / 3;
                    monkeys.get(monkeys.get(j).test.apply(item)).startingItems.add(item);
                    ++inspections[j];
                }

        long[] maxInscpections = {inspections[0], inspections[1]};
        for (int i = 2; i < inspections.length; ++i)
            if (inspections[i] > maxInscpections[0] || inspections[i] > maxInscpections[1])
            {
                if (maxInscpections[1] > maxInscpections[0]) maxInscpections[0] = inspections[i];
                else maxInscpections[1] = inspections[i];
            }     

        System.out.println(maxInscpections[0] * maxInscpections[1]);
    }
}