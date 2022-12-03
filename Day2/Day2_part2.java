import java.util.*;

public class Day2_part2
{
    public static Map<Character, Integer> ScoreMap = Map.of(
        'A', 1,
        'B', 2,
        'C', 3
    );

    public static int CalcScore(String round)
    {
        round = round.replace(" ", "");
        char[] plays = round.toCharArray();
        int score = 0;
        
        if (plays[1] == 'Y') return 3 + ScoreMap.get(plays[0]);

        if (plays[1] == 'X')
        {
            switch(plays[0])
            {
                case 'A' : score = 3; break;
                case 'B' : score = 1; break;
                case 'C' : score = 2;       
            }
        }
        else 
        {
            switch(plays[0])
            {
                case 'A' : score = 8; break;
                case 'B' : score = 9; break;
                case 'C' : score = 7;       
            }
        }

        return score;
    }

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        int score = 0;
        String round = null;
        
        while (sc.hasNextLine()) score += CalcScore(sc.nextLine());
        System.out.println(score);
    }
}