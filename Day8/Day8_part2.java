import java.util.*;

public class Day8_part2
{
    public static int CalcView(List<String> treeHeights, int x, int y)
    {
        int view = 1, sum = 0;
        int height = treeHeights.get(y).charAt(x);

        for (int i = y + 1; i < treeHeights.size(); ++i)
        {
            if (treeHeights.get(i).charAt(x) >= height)
            {
                ++sum;
                break;
            }
            ++sum;
        }

        view *= sum;
        sum = 0;

        for (int i = y - 1; i >= 0; --i)
        {
            if (treeHeights.get(i).charAt(x) >= height)
            {
                ++sum;
                break;
            } 
            ++sum;
        }

        view *= sum;
        sum = 0;

        String temp = treeHeights.get(y);
        for (int i = x + 1; i < temp.length(); ++i)
        {
            if (temp.charAt(i) >= height)
            {
                ++sum;
                break;
            } 
            ++sum;
        }

        view *= sum;
        sum = 0;   

        for (int i = x - 1; i >= 0; --i)
        {
            if (temp.charAt(i) >= height) 
            {
                ++sum;
                break;
            }   
            ++sum;
        }

        return view * sum;
    }

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        List<String> treeHeights = new ArrayList<String>();

        while (sc.hasNextLine())
            treeHeights.add(sc.nextLine());
           

        Set<Integer> indices = new HashSet<Integer>();

        int length = treeHeights.get(0).length();

        int best;

        for (int i = 1; i < length - 1; ++i)
        {
            for (int j = 1; j < treeHeights.size() - 1; ++j)
            {
                int tmp = CalcView(treeHeights, i, j);
                if (tmp > best)
                    best = tmp;
                    
            }
        }

        System.out.println(best);
    }
}