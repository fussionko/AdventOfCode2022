import java.util.*;

public class Day7_part1
{

    public static int FillData(Node currentDir)
    {
        if (currentDir.children.size() == 0) return currentDir.data;
        for (Node dir : currentDir.children)
            currentDir.data += FillData(dir);
        
        return currentDir.data;
    }    

    public static int SumLower(Node currentDir)
    {
        int current = 0;

        for (Node dir : currentDir.children)
            if (dir.data <= 100000)
                current += dir.data + SumLower(dir);
            else 
                current += SumLower(dir);

        return current;
    }

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        Node head = new Node();
        head.data = 0;
        head.name = "/";
        head.parent = head;
        head.children = new ArrayList<Node>();
        Node currentDir = head;

        while (sc.hasNextLine())
        {
            String command = sc.nextLine();
            
            if (command.equals("$ cd /")) 
            {
                currentDir = head;
            }   
            else if (command.contains("dir"))
            {
                Node dir = new Node();
                dir.data = 0;
                dir.name = command.split(" ")[1];
                dir.parent = currentDir;
                dir.children = new ArrayList<Node>();
                currentDir.children.add(dir);
            }
            else if (command.equals("$ cd .."))
            {
                currentDir = currentDir.parent;
            }
            else if (command.contains("$ cd"))
            {       
                String compare = command.split(" ")[2];
                for (Node children : currentDir.children)
                    if (children.name.equals(compare))
                        currentDir = children;
            }
            else if (command.matches(".*\\d.*"))
            {
                
                currentDir.data += Integer.parseInt(command.split(" ")[0]);
            }
        }
        
        FillData(head);
        
        PrintTree(head);
        System.out.println(SumLower(head));

    }
}