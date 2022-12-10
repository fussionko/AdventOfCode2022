import java.util.*;

public class Day9_part2
{
    public static void MoveBody(Cord[] body, int head, int tail)
    {
        if (Math.abs(body[head].x - body[tail].x) <= 1 && Math.abs(body[head].y - body[tail].y) <= 1) 
            return;

        if (Math.abs(body[head].x - body[tail].x) > 1 && Math.abs(body[head].y - body[tail].y) > 1)
        {
            body[tail].x = body[tail].x > body[head].x ? body[tail].x - 1 : body[tail].x + 1;
            body[tail].y = body[tail].y > body[head].y ? body[tail].y - 1 : body[tail].y + 1;
        }
        else if (Math.abs(body[head].x - body[tail].x) > 1)
        {
            body[tail].x = body[tail].x > body[head].x ? body[tail].x - 1 : body[tail].x + 1;
            body[tail].y = body[head].y;
        }
        else
        {
            body[tail].y = body[tail].y > body[head].y ? body[tail].y - 1 : body[tail].y + 1;
            body[tail].x = body[head].x;
        }
    }

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        Cord[] body = new Cord[10];

        for (int i = 0; i < body.length; ++i)
            body[i] = new Cord(0, 0);

        Set<Cord> positions = new HashSet<Cord>();

        while (sc.hasNextLine())
        {
            String move = sc.nextLine();
            int amount = Integer.parseInt(move.split(" ")[1]);

            for (int k = 0; k < amount; ++k)
            {
                switch (move.charAt(0))
                {
                    case ('U'): ++body[0].y; break;
                    case ('D'): --body[0].y; break;
                    case ('L'): --body[0].x; break;
                    case ('R'): ++body[0].x; break;
                }

                for (int i = 1; i < body.length; ++i)             
                    MoveBody(body, i - 1, i);

                positions.add(new Cord(body[9].x, body[9].y));
            }
        }

        System.out.println(positions.size());
    }
}