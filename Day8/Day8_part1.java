import java.util.*;

public class Day8_part1
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        List<String> treeHeights = new ArrayList<String>();

        while (sc.hasNextLine())
            treeHeights.add(sc.nextLine());

        Set<Integer> indices = new HashSet<Integer>();

        int length = treeHeights.get(0).length();

        for (int i = 1; i < treeHeights.size() - 1; ++i)
        {
            String field = treeHeights.get(i);
            char currentMax = field.charAt(0);

            for (int j = 1; j < length - 1; ++j)
                if (field.charAt(j) > currentMax)
                {
                    indices.add(length * i + j);
                    currentMax = field.charAt(j);
                }   

            currentMax = field.charAt(length - 1);
            for (int j = length - 2; j > 0; --j)
                if (field.charAt(j) > currentMax)
                {
                    indices.add(length * i + j);
                    currentMax = field.charAt(j);
                }
        }

        for (int i = 1; i < length - 1; ++i)
        {
            char currentMax = treeHeights.get(0).charAt(i);
            for (int j = 1; j < treeHeights.size(); ++j)
            {
                String heights = treeHeights.get(j);
                if (heights.charAt(i) > currentMax)
                {
                    indices.add(length * j + i);
                    currentMax = heights.charAt(i);
                }
            }
            currentMax = treeHeights.get(treeHeights.size() - 1).charAt(i);
            for (int j = treeHeights.size() - 2; j > 0; --j)
            {
                String heights = treeHeights.get(j);
                if (heights.charAt(i) > currentMax)
                {
                    indices.add(length * j + i);
                    currentMax = heights.charAt(i);
                }
            }
        }
        
        System.out.println((indices.size() + length * 2 + (treeHeights.size() - 2) * 2));
    }
}