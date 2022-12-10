import java.util.*;

public class Day9_part2
{
    public static void ProcessMove(char move, int amount, Cord[] body, int head)
    {
        if (move == 'U')
            body[head].y += amount;
        else if (move == 'D')
            body[head].y -= amount;
        else if (move == 'L')
            body[head].x -= amount;
        else if (move == 'R')
            body[head].x += amount;
    }

    public static void MoveBody(Cord[] body, int head, int tail)
    {
        if (Math.abs(body[head].x - body[tail].x) <= 1 && Math.abs(body[head].y - body[tail].y) <= 1) return;

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
            if (move == "") break;
            int amount = Integer.parseInt(move.split(" ")[1]);

            for (int k = 0; k < amount; ++k)
            {
                ProcessMove(move.charAt(0), 1, body, 0);
                for (int i = 1; i < body.length; ++i)
                {                   
                    MoveBody(body, i - 1, i);
                        //     for (Cord c : body)
                        // System.out.println(c.x + "|" + c.y);  
                        // System.out.println("-");
                }
                // System.out.println("-------------------" + k); 
                positions.add(new Cord(body[9].x, body[9].y));
            }
        }

        // for (Cord c : positions)
        //     System.out.println(c.x + "|" + c.y);    
        System.out.println(positions.size());
    }
}