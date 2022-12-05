import java.util.*;

public class Day5_part1
{
    public static String[] Move(String from, String to, int amount)
    {
        //System.out.println("1 " + from + "|" + to + "|" + amount);
        if (from.length() - amount < 0) amount = from.length();
        to += from.substring(from.length() - amount);
        from = from.substring(0, from.length() - amount);

        //System.out.println("2 " + from + "|" + to + "|" + amount);

        return new String[] {from, to};
    }

    public static String GetLastCrate(ArrayList<String> crates)
    {
        String stack = "";
        for (String crate : crates)
            stack += crate.charAt(crate.length() - 1);
        return stack;
    }

    public static void main(String[] args)
    {
        ArrayList<String> crates = Day5_processData.ProcessCrates();
        ArrayList<int[]> moves = Day5_processData.ProcessMoves();

        for (int[] moveLine : moves)
        {
            String[] tmp = Move(crates.get(moveLine[1]), crates.get(moveLine[2]), moveLine[0]);
            crates.set(moveLine[1], tmp[0]);
            crates.set(moveLine[2], tmp[1]);
        }

        for (String c : crates)
          System.out.println(c);
        System.out.println(GetLastCrate(crates));

    }
}