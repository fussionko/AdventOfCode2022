import java.util.*;

public class Day5_part2
{
    public static String[] Move(String from, String to, int amount)
    {
        if (from.length() - amount < 0) amount = from.length();

        to += from.substring(from.length() - amount);
        from = from.substring(0, from.length() - amount);

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
        Scanner sc = new Scanner(System.in);

        ArrayList<String> containersRead = new ArrayList<String>();
        ArrayList<String> containers = new ArrayList<String>();
  
        while (sc.hasNextLine())
        {
            String tmp = sc.nextLine();
            if (tmp.charAt(1) == '1') break;
            containersRead.add(tmp);
        }
            
        for (int i = 1; i < containersRead.get(0).length(); i += 4)
        {
            String tmp = "";

            for (int j = containersRead.size() - 1; j >= 0; --j)
                tmp += containersRead.get(j).charAt(i);
                
            containers.add(tmp.replaceAll(" ", ""));
        }
        
        sc.nextLine();
        sc.useDelimiter("[^0-9]+");

        while (sc.hasNextInt())
        {
            int[] moves = {sc.nextInt(), sc.nextInt() - 1, sc.nextInt() - 1};
            String[] tmp = Move(containers.get(moves[1]), containers.get(moves[2]), moves[0]);
            containers.set(moves[1], tmp[0]);
            containers.set(moves[2], tmp[1]);
        }

        System.out.println(GetLastCrate(containers));
    }
}