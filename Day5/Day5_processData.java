import java.util.*;

public final class Day5_processData
{   
    public static Scanner sc = new Scanner(System.in);
    private Day5_processData(){};

    public static ArrayList<String> ProcessCrates()
    {
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
        

        return containers;
    }

    public static ArrayList<int[]> ProcessMoves()
    {
        Scanner sc = new Scanner(System.in);
        ArrayList<int[]> moves = new ArrayList<int[]>();

        sc.nextLine();
        sc.useDelimiter("[^0-9]+");

        while (sc.hasNextInt())
            moves.add(new int[] {sc.nextInt(), sc.nextInt() - 1, sc.nextInt() - 1});
        
        return moves;
    }
}