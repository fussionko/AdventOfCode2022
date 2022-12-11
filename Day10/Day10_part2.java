import java.util.*;

public class Day10_part2
{
    public static void Draw(char[][] crc, int cycle, int spritePos)
    {
        int check = cycle;
        cycle = (cycle - 1) % 40;
        char draw = cycle >= spritePos && cycle <= spritePos + 2 ? '#' : '.';
        if (check <= 40)
            crc[0][cycle] = draw;
        else if (check <= 80)
            crc[1][cycle] = draw;
        else if (check <= 120)
            crc[2][cycle] = draw;
        else if (check <= 160)
            crc[3][cycle] = draw;
        else if (check <= 200)
            crc[4][cycle] = draw;
        else
            crc[5][cycle] = draw;
    }

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        int trackCycle = 0, spritePos = 0;
        char[][] crc = new char[6][40];

        while (sc.hasNextLine())
        {
            String cycle = sc.nextLine();
            
            ++trackCycle;
            Draw(crc, trackCycle, spritePos);

            if (cycle.equals("noop")) 
                continue;
            
            ++trackCycle;
            Draw(crc, trackCycle, spritePos);
            spritePos += Integer.parseInt(cycle.split(" ")[1]);              
        }
        
        for (char[] row : crc)
        {
            for (char column : row)
                System.out.print(column);
            System.out.println();
        }
    }
}