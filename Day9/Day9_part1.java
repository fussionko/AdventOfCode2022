import java.util.*;

public class Day9_part1
{
    public static void ProcessMove(char move, int amount, Cord head)
    {
        if (move == 'U')
            head.y += amount;
        else if (move == 'D')
            head.y -= amount;
        else if (move == 'L')
            head.x -= amount;
        else if (move == 'R')
            head.x += amount;
    }

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        Cord head = new Cord(0, 0); 
        Cord tail = new Cord(0, 0);

        Set<Cord> positions = new HashSet<Cord>();

        while (sc.hasNextLine())
        {
            String move = sc.nextLine();
            int amount = Integer.parseInt(move.split(" ")[1]);

            switch (move.charAt(0))
            {
                case ('U'): head.y += amount; break;
                case ('D'): head.y -= amount; break;
                case ('L'): head.x -= amount; break;
                case ('R'): head.x += amount; break;
            }

            if (head.Distance(tail) > 1)
            {
                for (int x = tail.x + 1; x < head.x; ++x)
                {
                    positions.add(new Cord(x, head.y));
                    tail.x = x;
                    tail.y = head.y;
                }
                    
                for (int x = tail.x - 1; head.x < x; --x)
                {
                    positions.add(new Cord(x, head.y));
                    tail.x = x;
                    tail.y = head.y;
                }
                for (int y = tail.y + 1; y < head.y; ++y)
                {
                    positions.add(new Cord(head.x, y));
                    tail.x = head.x;
                    tail.y = y;
                }
                for (int y = tail.y - 1; head.y < y; --y)
                {
                    positions.add(new Cord(head.x, y));
                    tail.x = head.x;
                    tail.y = y;
                }
            }
        }

        System.out.println(positions.size() + 1);
    }
}