import java.util.*;

public class Day2_part1
{
    // X - rock - A
    // Y - paper - B
    // Z - scizzors - C
    public static Map<Character, Integer> ScoreMap = Map.of(
        'X', 1,
        'Y', 2,
        'Z', 3
    );

    public static int CalcScore(String round)
    {
        round = round.replace(" ", "");
        char[] plays = round.toCharArray();
        int score = 0;
        if (plays[0] + 23 == plays[1]) return 3 + ScoreMap.get(plays[1]);

        if (plays[0] == 'A' && plays[1] == 'Y') score = 6;
        if (plays[0] == 'B' && plays[1] == 'Z') score = 6;
        if (plays[0] == 'C' && plays[1] == 'X') score = 6;

        return score + ScoreMap.get(plays[1]);
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